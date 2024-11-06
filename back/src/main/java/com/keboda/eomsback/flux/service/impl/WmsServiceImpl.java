package com.keboda.eomsback.flux.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.flux.mapper.WmsMapper;
import com.keboda.eomsback.flux.pojo.*;
import com.keboda.eomsback.flux.service.IWmsService;
import com.keboda.eomsback.utils.DateUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@DS("fluxWms")
public class WmsServiceImpl implements IWmsService {

    @Resource
    private WmsMapper wmsMapper;

    @Override
    public RobotsStatus selectRobotsStatusByKey(Integer id) {
        return wmsMapper.selectRobotsStatusByKey(id);
    }

    @Override
    @Transactional
    public void insertRobotsStatusSelective(RobotsStatus robotsStatus) {
        wmsMapper.insertRobotsStatusSelective(robotsStatus);
    }

    @Override
    @Transactional
    public void updateRobotsStatusSelective(RobotsStatus robotsStatus) {
        wmsMapper.updateRobotsStatusSelective(robotsStatus);
    }

    @Override
    public Page<InvLotLocId> invLotLocIdListPageHelper(SearchVo searchVo) {
        return wmsMapper.invLotLocIdListPageHelper(searchVo);
    }

    /**
     * 库存锁定/解锁
     * @param invLotLocIdList
     * @param status
     */
    @Override
    @Transactional
    public void lock(List<InvLotLocId> invLotLocIdList, String status) {
        for (InvLotLocId invLotLocId : invLotLocIdList) {

            //检查数据库记录及状态
            InvLotLocId inv = wmsMapper.selectInvLotLocIdByKey(invLotLocId.getLocationid(), invLotLocId.getLotnum(), invLotLocId.getTraceid());
            if (inv == null) throw new RuntimeException("栈板：" + invLotLocId.getTraceid() + "对应的库存记录不存在");
            if (status.equals(inv.getLotatt08()))
                throw new RuntimeException("栈板：" + invLotLocId.getTraceid() + "目标状态与源状态冲突");

            BigDecimal oneWeight = inv.getGrossweight().divide(inv.getQty(), RoundingMode.HALF_UP);//一份的重量

            //检查分配数量
            if (inv.getAsqtyavailed().compareTo(invLotLocId.getIqty()) < 0)
                throw new RuntimeException("栈板：" + invLotLocId.getTraceid() + "可用数量不足");

            //检查是否有活动的拣货任务
            Integer count = wmsMapper.selectAsrsCount(inv.getLocationid(), inv.getTraceid());
            if (count != 0)
                throw new RuntimeException("栈板：" + invLotLocId.getTraceid() + "目标记录有未完成的拣选任务，不能更改状态");

            //查找调整单，状态为00，调整完后数量是否大于锁定数量
            BigDecimal qty = wmsMapper.checkQty(inv.getLocationid(), inv.getLotnum(), inv.getTraceid());
            if (qty != null && qty.compareTo(invLotLocId.getIqty()) < 0)
                throw new RuntimeException("栈板：" + invLotLocId.getTraceid() + "有尚未完成的库存调整任务，且调整后数量少于" + status + "数量");

            //寻找相反状态的记录，没有就新增并返回
            Map<String, InvLotAtt> map = selectMapByKeyLotnumStatus(invLotLocId.getLotnum(),status);

            //更新inv_lot_loc_id源记录数量
            this.mergeQty(inv,BigDecimal.ZERO.subtract(invLotLocId.getIqty()),oneWeight);

            //更新目标数量
            inv.setLotnum(map.get(status).getLotnum());

            this.mergeQty(inv,invLotLocId.getIqty(),oneWeight);

            //更新inv_lot记录
            String[] arr = {map.get("ZC").getLotnum(),map.get("SD").getLotnum()};
            updateQtyBykey(arr);
        }
    }

    //检查对象是否存在并更新数量，毛重，版本号
    private void mergeQty(InvLotLocId invLotLocId,BigDecimal qty,BigDecimal oneWeight){

        InvLotLocId inv = wmsMapper.selectInvLotLocIdByKey(invLotLocId.getLocationid(),invLotLocId.getLotnum(),invLotLocId.getTraceid());
        if(inv == null){
            inv = invLotLocId;
            inv.setQty(BigDecimal.ZERO);
            inv.setQtyallocated(BigDecimal.ZERO);
            inv.setQtyrpin(BigDecimal.ZERO);
            inv.setQtyrpout(BigDecimal.ZERO);
            inv.setQtymvin(BigDecimal.ZERO);
            inv.setQtymvout(BigDecimal.ZERO);
            inv.setQtyonhold(BigDecimal.ZERO);
            inv.setGrossweight(BigDecimal.ZERO);
            inv.setQtypa(BigDecimal.ZERO);
            inv.setCurrentversion(100);
            inv.setOprseqflag(DateUtils.format(new Date(),DateUtils.FORMAT_NO_MILLISECOND) + "RA127000000001[KEBODA]");
            inv.setAddwho("KEBODA");
            inv.setAddtime(new Date());
            inv.setInloctime(new Date());
            wmsMapper.insertInvLotLocIdSelective(inv);
        }

        inv.setQty(inv.getQty().add( qty ) );
        inv.setGrossweight(inv.getQty().multiply(oneWeight).setScale(3, RoundingMode.HALF_UP));
        inv.setEdittime(new Date());
        inv.setEditwho("KEBODA");
        wmsMapper.updateInvLotLocIdQty(inv);

    }

    private Map<String, InvLotAtt> selectMapByKeyLotnumStatus(String lotnum, String status) {

        HashMap<String, InvLotAtt> map = new HashMap<>();
        InvLotAtt origin = wmsMapper.selectInvLotAttByKey(lotnum);
        map.put(origin.getLotatt08(),origin);
        origin.setLotatt08(status);
        InvLotAtt total = wmsMapper.selectOtherStatus(origin);

        if(total == null){
            String code = getCode("lotnum");//得到新批次

            total = origin;
            total.setLotnum(code);
            total.setCurrentversion(100);
            total.setOprseqflag(DateUtils.format(new Date(),DateUtils.FORMAT_NO_MILLISECOND) + "RA127000000001[KEBODA]");
            total.setAddwho("KEBODA");
            total.setAddtime(new Date());
            total.setEditwho(null);
            total.setEdittime(null);
            wmsMapper.insertInvLotAttSelective(total);
        }
        map.put(status,total);
        return map;
    }


    private String getCode(String itype) {

        Idsequence seq = wmsMapper.selectIdsequenceByKey(itype);
        Integer sequence = Integer.valueOf(seq.getIdsequence());
        sequence += 1;
        StringBuilder sb = new StringBuilder();
        sb.append(sequence);

        while(sb.length() < seq.getLength()){
            sb.insert(0,0);
        }

        if(seq.getDateformat() != null) sb.insert(0,DateUtils.parse(new Date().toString(),seq.getDateformat()));
        sb.insert(0,seq.getPrefix());

        wmsMapper.updateSequence(itype);

        return sb.toString();
    }


    private void updateQtyBykey(String[] arr) {
        for (String lotnum : arr) {

            InvLot invLot = wmsMapper.selectInvLotByKey(lotnum);
            if(invLot == null) {

                invLot = new InvLot();
                invLot.setOrganizationid("*");
                invLot.setWarehouseid("*");
                invLot.setCustomerid("*");
                invLot.setSku("*");
                invLot.setLotnum(lotnum);
                invLot.setQty(BigDecimal.ZERO);
                invLot.setQtyallocated(BigDecimal.ZERO);
                invLot.setQtypreallocated(BigDecimal.ZERO);
                invLot.setQtyonhold(BigDecimal.ZERO);
                invLot.setGrossweight(BigDecimal.ZERO);
                invLot.setNetweight(BigDecimal.ZERO);
                invLot.setCubic(BigDecimal.ZERO);
                invLot.setPrice(BigDecimal.ZERO);
                invLot.setCurrentversion(100);
                invLot.setOprseqflag(DateUtils.format(new Date(),DateUtils.FORMAT_NO_MILLISECOND) + "RA127000000001[KEBODA]");
                invLot.setAddwho("KEBODA");
                invLot.setAddtime(new Date());
                wmsMapper.insertInvLotSelective(invLot);
            }

            invLot.setEdittime(new Date());
            invLot.setEditwho("KEBODA");
            wmsMapper.updateInvLotQty(invLot);
        }
    }
}
