package com.keboda.eomsback.produce.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileAppender;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.produce.mapper.*;
import com.keboda.eomsback.produce.pojo.*;
import com.keboda.eomsback.produce.pojo.vo.SfbModify;
import com.keboda.eomsback.produce.pojo.vo.SfbStatusVo;
import com.keboda.eomsback.produce.service.ISfbService;
import com.keboda.eomsback.stock.service.ITlfService;
import com.keboda.eomsback.system.mapper.SmaFileMapper;
import com.keboda.eomsback.utils.DateUtils;
import com.keboda.eomsback.utils.IPUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class SfbServiceImpl implements ISfbService {

    @Resource
    private SfbFileMapper sfbFileMapper;
    @Resource
    private SfaFileMapper sfaFileMapper;
    @Resource
    private SfpFileMapper sfpFileMapper;
    @Resource
    private ShbFileMapper shbFileMapper;
    @Resource
    private QcfFileMapper qcfFileMapper;
    @Resource
    private SfuFileMapper sfuFileMapper;
    @Resource
    private ITlfService iTlfService;
    @Resource
    private EcmFileMapper ecmFileMapper;


    @Override
    public List<SfbFile> searchSfbList(SearchVo searchVo) {
        return sfbFileMapper.searchSfbList(searchVo);
    }

    @Override
    public SfbStatusVo searchSfbStatus(SearchVo searchVo) throws RuntimeException {

        SfbFile sfb = sfbFileMapper.searchSfb(searchVo);
        if (sfb == null) throw new RuntimeException("查询不到对应工单信息");

        List<SfpFile> sfp = sfpFileMapper.searchSfpList(searchVo);
        if(sfp.size() > 0){
            BigDecimal sfpqty = BigDecimal.ZERO;
            for (SfpFile file : sfp) {
                if(file.getTlf907().equals("发料")){
                    sfpqty = sfpqty.add(file.getSfq03());
                }else{
                    sfpqty = sfpqty.subtract(file.getSfq03());
                }
            }
            SfpFile sum = new SfpFile();
            sum.setSfp01("合计");
            sum.setSfq03(sfpqty);
            sfp.add(sum);
        }

        List<ShbFile> shb = shbFileMapper.searchShbList(searchVo);

        if(shb.size() > 0){
            BigDecimal shbqty = BigDecimal.ZERO;
            for (ShbFile file : shb) {
                shbqty = shbqty.add(file.getShb111());
            }
            ShbFile sum = new ShbFile();
            sum.setShb01("合计");
            sum.setShb111(shbqty);
            shb.add(sum);
        }

        List<QcfFile> qcf = qcfFileMapper.searchQcfList(searchVo);
        if(qcf.size() > 0){
            BigDecimal qty1 = BigDecimal.ZERO;
            BigDecimal qty2 = BigDecimal.ZERO;
            for (QcfFile file : qcf) {
                qty1 = qty1.add(file.getQcf22());
                qty2 = qty2.add(file.getQcf091());
            }
            QcfFile sum = new QcfFile();
            sum.setQcf01("合计");
            sum.setQcf22(qty1);
            sum.setQcf091(qty2);
            qcf.add(sum);
        }

        List<SfuFile> sfu = sfuFileMapper.searchSfuList(searchVo);
        if(sfu.size() > 0){
            BigDecimal qty = BigDecimal.ZERO;
            for (SfuFile file : sfu) {
                if(file.getTlf907().equals("入库")){
                    qty = qty.add(file.getSfv09());
                }else{
                    qty = qty.subtract(file.getSfv09());
                }
            }
            SfuFile sum = new SfuFile();
            sum.setSfu01("合计");
            sum.setSfv09(qty);
            sfu.add(sum);
        }

        return SfbStatusVo.builder().sfb(sfb).sfp(sfp).shb(shb).qcf(qcf).sfu(sfu).build();
    }

    @Override
    public Page<SfbFile> searchSfbListPageHelper(SearchVo searchVo) {
        return sfbFileMapper.searchSfbListPageHelper(searchVo);
    }

    @Override
    @Transactional
    public void modifySfbDate(SfbModify sfbModify, HttpServletRequest request) {

        Date ddate = DateUtils.parseDate( DateUtils.formatDate(sfbModify.getDdate()));

        File file = FileUtil.file("C:/PerfLogs/eoms-modifySfbDate.log");
        FileAppender appender = new FileAppender(file, 16, true);

        for (SfbFile sfbFile : sfbModify.getSfbArr()) {

            SearchVo searchVo = new SearchVo();
            searchVo.setCentre(sfbFile.getCentre());
            searchVo.setCode(sfbFile.getSfb01());
            SfbFile sfb = sfbFileMapper.searchSfb(searchVo);
            if (sfb == null) throw new RuntimeException("查询不到对应工单信息");

            //工单日期修改
            if (
                    //(sfb.getSfb81() != null && ((sfbModify.getFlag() ? sfb.getSfb81().compareTo(ddate) < 0: sfb.getSfb81().compareTo(ddate) > 0)))
                    //(sfb.getSfb13() != null && (sfbModify.getFlag() ? sfb.getSfb13().compareTo(ddate) < 0 : sfb.getSfb13().compareTo(ddate) > 0))
                    (sfb.getSfb15() != null && (sfbModify.getFlag() ? sfb.getSfb15().compareTo(ddate) < 0 : sfb.getSfb15().compareTo(ddate) > 0))
                    //(sfb.getSfb25() != null && (sfbModify.getFlag() ? sfb.getSfb25().compareTo(ddate) < 0 : sfb.getSfb25().compareTo(ddate) > 0))
                    || (sfb.getSfb36() != null && (sfbModify.getFlag() ? sfb.getSfb36().compareTo(ddate) < 0 : sfb.getSfb36().compareTo(ddate) > 0))
                    || (sfb.getSfb38() != null && (sfbModify.getFlag() ? sfb.getSfb38().compareTo(ddate) < 0 : sfb.getSfb38().compareTo(ddate) > 0))
                    || (sfb.getSfb37() != null && (sfbModify.getFlag() ? sfb.getSfb37().compareTo(ddate) < 0 : sfb.getSfb37().compareTo(ddate) > 0))
            ) sfbFileMapper.updateDate(sfb, sfbFile.getCentre(), ddate, sfbModify.getFlag());

            //发料日期修改
            List<SfpFile> sfpArr = sfpFileMapper.searchSfpList(searchVo);
            if (sfpArr.size() > 0) {
                for (SfpFile sfp : sfpArr) {
                    if ((sfp.getSfp02() != null && (sfbModify.getFlag() ? sfp.getSfp02().compareTo(ddate) < 0 : sfp.getSfp02().compareTo(ddate) > 0))
                            || (sfp.getSfp03() != null && (sfbModify.getFlag() ?  sfp.getSfp03().compareTo(ddate) < 0 : sfp.getSfp03().compareTo(ddate) > 0))
                    ) {
                        sfpFileMapper.updateDate(sfp, sfbFile.getCentre(), ddate, sfbModify.getFlag());
                    }
                    //发料异动记录
                    if (sfp.getTlf06() != null && ((sfbModify.getFlag() ? sfp.getTlf06().compareTo(ddate) < 0 : sfp.getTlf06().compareTo(ddate) > 0))) {
                        if(sfp.getTlf907().equals("发料")) iTlfService.alterByCode(sfbFile.getCentre(), sfp.getSfp01(), null,"-1", ddate,null,null);
                        else iTlfService.alterByCode(sfbFile.getCentre(),null, sfp.getSfp01(),"1",ddate,null,null);
                    }
                }
            }

            //报工日期修改
            List<ShbFile> shbArr = shbFileMapper.searchShbList(searchVo);
            if (shbArr.size() > 0) {
                for (ShbFile shb : shbArr) {
                    if ((shb.getShb02() != null && (sfbModify.getFlag() ?  shb.getShb02().compareTo(ddate) < 0 : shb.getShb02().compareTo(ddate) > 0))
                            || (shb.getShb03() != null && (sfbModify.getFlag() ? shb.getShb03().compareTo(ddate) < 0 : shb.getShb03().compareTo(ddate) > 0))
                            || (shb.getShb32() != null && (sfbModify.getFlag() ? shb.getShb32().compareTo(ddate) < 0 : shb.getShb32().compareTo(ddate) > 0))
                    ) {
                        shbFileMapper.updateDate(shb, sfbFile.getCentre(), ddate, sfbModify.getFlag());
                    }
                }
            }

            // FQC日期修改
            List<QcfFile> qcfArr = qcfFileMapper.searchQcfList(searchVo);
            if (qcfArr.size() > 0) {
                for (QcfFile qcf : qcfArr) {
                    if ((qcf.getQcf04() != null && (sfbModify.getFlag() ? qcf.getQcf04().compareTo(ddate) < 0 : qcf.getQcf04().compareTo(ddate) > 0))
                            || (qcf.getQcf15() != null && (sfbModify.getFlag() ? qcf.getQcf15().compareTo(ddate) < 0 : qcf.getQcf15().compareTo(ddate) > 0))
                    ) {
                        qcfFileMapper.updateDate(qcf, sfbFile.getCentre(), ddate, sfbModify.getFlag());
                    }
                }
            }

            //入库日期修改
            List<SfuFile> sfuArr = sfuFileMapper.searchSfuList(searchVo);
            if (sfuArr.size() > 0) {
                for (SfuFile sfu : sfuArr) {
                    if ((sfu.getSfu02() != null && (sfbModify.getFlag() ? sfu.getSfu02().compareTo(ddate) < 0 : sfu.getSfu02().compareTo(ddate) > 0))
                            || (sfu.getSfu14() != null && (sfbModify.getFlag() ? sfu.getSfu14().compareTo(ddate) < 0 : sfu.getSfu14().compareTo(ddate) > 0))
                    ) {
                        sfuFileMapper.updateDate(sfu, sfbFile.getCentre(), ddate, sfbModify.getFlag());
                    }
                    //入库异动记录
                    if (sfu.getTlf06() != null && (sfbModify.getFlag() ? sfu.getTlf06().compareTo(ddate) < 0 : sfu.getTlf06().compareTo(ddate) > 0)) {
                        if(sfu.getTlf907().equals("入库")) iTlfService.alterByCode(sfbFile.getCentre(),null,sfu.getSfu01(),"1",ddate,null,null);
                        else iTlfService.alterByCode(sfbFile.getCentre(),sfu.getSfu01(),null,"-1",ddate,null,null);
                    }
                }
            }

            appender.append(sfbFile.getCentre()+ ": " + sfbFile.getSfb01()+ "; " + "ddate: " + DateUtils.formatDateTime(new Date()) + "; modifyDate: " + DateUtils.formatDate(ddate) +"; IP: " + IPUtils.getIpAddr(request));
        }
        appender.flush();
    }

    @Override
    @Transactional
    public void closeOut(List<SfbFile> sfbFiles) {
        for (SfbFile sfb : sfbFiles) {

            SfbFile record = new SfbFile();
            record.setCentre(sfb.getCentre());
            record.setSfb04("8");
            record.setSfb28("3");
            record.setSfb36(DateUtils.parseDate(DateUtils.formatDate(new Date())));
            record.setSfb37(DateUtils.parseDate(DateUtils.formatDate(new Date())));
            record.setSfb01(sfb.getSfb01());
            sfbFileMapper.updateByPrimaryKeySelective(record);
        }
    }

    @Override
    public List<SfaFile> searchSfaList(SearchVo searchVo) {
        return sfaFileMapper.searchSfaList(searchVo);
    }

    @Override
    public int updateDepartment(SfbFile sfbFile) {
        sfbFile.setSfb82(sfbFile.getSfb98());
        return sfbFileMapper.updateByPrimaryKeySelective(sfbFile);
    }

    @Override
    public void isFQC(SfbFile sfbFile) {
        sfbFileMapper.updateByPrimaryKeySelective(sfbFile);
    }

    @Override
    @Transactional
    public int updateByExcel(MultipartFile file, String centre) throws IOException {
        ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
        List<Map<String, Object>> read = reader.readAll();
        int count = 0;
        for (Map<String, Object> map : read) {
            SfbFile sfb = new SfbFile();
            sfb.setCentre(centre);
            sfb.setSfb01( map.get("工单编号").toString());
            sfb.setSfb98(map.get("成本中心").toString());
            sfb.setSfb82(map.get("成本中心").toString());
            count = count + this.updateDepartment(sfb);
        }
        return count;
    }

    @Override
    @Transactional
    public void updateFL(SfbFile sfbFile) {
        sfbFileMapper.updateByPrimaryKeySelective(sfbFile);
        EcmFile ecmFile = new EcmFile();
        ecmFile.setCentre(sfbFile.getCentre());
        ecmFile.setEcm01(sfbFile.getSfb01());
        ecmFile.setEcm301(sfbFile.getSfb081());
        ecmFileMapper.updateByPrimaryKeySelective(ecmFile);
    }

    @Override
    @Transactional
    public void updateRK(SfbFile sfbFile) {
        sfbFileMapper.updateByPrimaryKeySelective(sfbFile);
        EcmFile ecmFile = new EcmFile();
        ecmFile.setCentre(sfbFile.getCentre());
        ecmFile.setEcm01(sfbFile.getSfb01());
        ecmFile.setEcm311(sfbFile.getSfb09());
        ecmFileMapper.updateByPrimaryKeySelective(ecmFile);
    }

    @Override
    @Transactional
    public void updateBF(SfbFile sfbFile) {
        sfbFileMapper.updateByPrimaryKeySelective(sfbFile);
        EcmFile ecmFile = new EcmFile();
        ecmFile.setCentre(sfbFile.getCentre());
        ecmFile.setEcm01(sfbFile.getSfb01());
        ecmFile.setEcm313(sfbFile.getSfb12());
        ecmFileMapper.updateByPrimaryKeySelective(ecmFile);
    }

    @Override
    @Transactional
    public void updateProductionLine(SfbFile sfbFile) {
        sfbFileMapper.updateByPrimaryKeySelective(sfbFile);
    }
}
