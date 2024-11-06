package com.keboda.eomsback.authorityReview.service.impl;

import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.dynamic.datasource.annotation.DSTransactional;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.keboda.eomsback.authorityReview.pojo.AuthorityRecordsVo;
import com.keboda.eomsback.authorityReview.pojo.Permission;
import com.keboda.eomsback.authorityReview.pojo.PersonalPosition;
import com.keboda.eomsback.authorityReview.service.*;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.system.pojo.AzpFile;
import com.keboda.eomsback.system.pojo.GazFile;
import com.keboda.eomsback.system.pojo.ZwFile;
import com.keboda.eomsback.system.pojo.ZxFile;
import com.keboda.eomsback.system.service.*;
import com.keboda.eomsback.utils.ImportExcelUtil;
import com.keboda.eomsback.utils.StringUtils;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AuthorityReviewServiceImpl implements IAuthorityReviewService {

    @Resource
    private IPermissionService iPermissionService;
    @Resource
    private IPositionService iPositionService;
    @Resource
    private IZxwService iZxwService;
    @Resource
    private IGazService iGazService;
    @Resource
    private IZwService iZwService;
    @Resource
    private IZxService iZxService;
    @Resource
    private IPersonalPositionService iPersonalPositionService;
    @Resource
    private IActionMenuService iActionMenuService;
    @Resource
    private IAzpService iAzpService;

    @Override
    public Page<AuthorityRecordsVo> searchPositionRecordsListPageHelper(SearchVo searchVo) {
        String[] exclude = iActionMenuService.selectByPrimaryKey("exclude").getAction().split(",");
        PageHelper.startPage(searchVo.getCurrentPage(), searchVo.getSize());
        return iPositionService.searchPositionRecordsListPageHelper(searchVo, exclude);
    }

    @Override
    @DSTransactional
    public String importPositionRecords(MultipartFile file, String year) throws IOException {

        if (year == null || year.isEmpty() || year.equals("null")) throw new RuntimeException("导入目标年份不可为空");
        StringBuilder sb = new StringBuilder();
        int successCount = 0;

        ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
        List<Map<String, Object>> sheetData = reader.readAll();
        List<Permission> list = new ArrayList<>();

        for (Map<String, Object> map : sheetData) {
            Permission permission = new Permission();

            permission.setPositionCode((String) map.get("职位代码"));
            permission.setPermissionCode((String) map.get("作业代码"));
            permission.setContainAmount(StringUtils.formatBoolean((String) map.get("金额")));
            permission.setContainCreate(StringUtils.formatBoolean((String) map.get("新增")));
            permission.setContainDelete(StringUtils.formatBoolean((String) map.get("删除")));
            permission.setContainUpdate(StringUtils.formatBoolean((String) map.get("修改")));
            permission.setContainRead(StringUtils.formatBoolean((String) map.get("查询")));
            permission.setContainConfirm(StringUtils.formatBoolean((String) map.get("审核")));
            permission.setContainUnConfirm(StringUtils.formatBoolean((String) map.get("撤销审核")));
            permission.setContainVoid(StringUtils.formatBoolean((String) map.get("作废")));
            permission.setContainUnVoid(StringUtils.formatBoolean((String) map.get("撤销作废")));
            permission.setContainPost(StringUtils.formatBoolean((String) map.get("过账")));
            permission.setContainUnPost(StringUtils.formatBoolean((String) map.get("撤销过账")));
            permission.setContainPrint(StringUtils.formatBoolean((String) map.get("打印")));
            permission.setContainExport(StringUtils.formatBoolean((String) map.get("数据导出")));

            list.add(permission);
        }

        Map<String, List<Permission>> map = list.stream().collect(Collectors.groupingBy(Permission::getPositionCode));

        for (String positionCode : map.keySet()) {

            ZwFile zwFile = iZwService.selectByPrimaryKey(positionCode);
            if (zwFile == null) continue;

            Integer uuid = iPositionService.merge(zwFile.getZw01(), zwFile.getZw02(), year);

            List<Permission> permissionList = map.get(positionCode);
            for (Permission permission : permissionList) {
                GazFile gazFile = iGazService.selectByPrimaryKey(permission.getPermissionCode());
                if (gazFile == null) continue;

                permission.setUuid(uuid);
                permission.setPermissionName(gazFile.getGaz03());
                iPermissionService.merge(permission);
                successCount++;

            }
        }

        sb.append("导入成功:  ").append(successCount).append("条");
        return sb.toString();
    }

    @Override
    public void deletePositionRecords(List<AuthorityRecordsVo> authorityRecordsVoList) {
        iPermissionService.deletePositionRecords(authorityRecordsVoList);
    }

    @Override
    public Map<String, List<AuthorityRecordsVo>> positionContrastRecords(SearchVo searchVo) {

        Map<String, List<AuthorityRecordsVo>> map = new HashMap<>();

        for (String code : searchVo.getCodes()) {
            StringBuilder sb = new StringBuilder();


            List<AuthorityRecordsVo> current = iZxwService.searchRecordsList(code);
            List<AuthorityRecordsVo> records = iPermissionService.searchRecordsList(searchVo.getYear(), code);

            sb.append("职位：").append(current.get(0).getPositionName());

            for (AuthorityRecordsVo vo : current) {
                vo.setColor("green");
                for (AuthorityRecordsVo record : records) {
                    if (vo.getPermissionCode().equals(record.getPermissionCode())) {
                        if (!vo.getIsAmount().equals(record.getIsAmount())) {
                            vo.setIsAmount(record.getIsAmount() + " => " + vo.getIsAmount());
                        }
                        if (!vo.getIsCreate().equals(record.getIsCreate())) {
                            vo.setIsCreate(record.getIsCreate() + " => " + vo.getIsCreate());
                        }
                        if (!vo.getIsDelete().equals(record.getIsDelete())) {
                            vo.setIsDelete(record.getIsDelete() + " => " + vo.getIsDelete());
                        }
                        if (!vo.getIsUpdate().equals(record.getIsUpdate())) {
                            vo.setIsUpdate(record.getIsUpdate() + " => " + vo.getIsUpdate());
                        }
                        if (!vo.getIsRead().equals(record.getIsRead())) {
                            vo.setIsRead(record.getIsRead() + " => " + vo.getIsRead());
                        }
                        if (!vo.getIsConfirm().equals(record.getIsConfirm())) {
                            vo.setIsConfirm(record.getIsConfirm() + " => " + vo.getIsConfirm());
                        }
                        if (!vo.getIsUnConfirm().equals(record.getIsUnConfirm())) {
                            vo.setIsUnConfirm(record.getIsUnConfirm() + " => " + vo.getIsUnConfirm());
                        }
                        if (!vo.getIsVoid().equals(record.getIsVoid())) {
                            vo.setIsVoid(record.getIsVoid() + " => " + vo.getIsVoid());
                        }
                        if (!vo.getIsUnVoid().equals(record.getIsUnVoid())) {
                            vo.setIsUnVoid(record.getIsUnVoid() + " => " + vo.getIsUnVoid());
                        }
                        if (!vo.getIsPost().equals(record.getIsPost())) {
                            vo.setIsPost(record.getIsPost() + " => " + vo.getIsPost());
                        }
                        if (!vo.getIsUnPost().equals(record.getIsUnPost())) {
                            vo.setIsUnPost(record.getIsUnPost() + " => " + vo.getIsUnPost());
                        }
                        if (!vo.getIsExport().equals(record.getIsExport())) {
                            vo.setIsExport(record.getIsExport() + " => " + vo.getIsExport());
                        }
                        if (!vo.getIsPrint().equals(record.getIsPrint())) {
                            vo.setIsPrint(record.getIsPrint() + " => " + vo.getIsPrint());
                        }
                        vo.setColor("white");
                        records.remove(record);
                        break;
                    }
                }
            }

            current.stream().filter(e -> e.getIsAmount().length() > 1 || e.getIsCreate().length() > 1 ||
                    e.getIsDelete().length() > 1 || e.getIsUpdate().length() > 1 || e.getIsRead().length() > 1 ||
                    e.getIsPost().length() > 1 || e.getIsUnPost().length() > 1 || e.getIsVoid().length() > 1 ||
                    e.getIsUnVoid().length() > 1 || e.getIsConfirm().length() > 1 || e.getIsUnConfirm().length() > 1 ||
                    e.getIsPrint().length() > 1 || e.getIsExport().length() > 1).forEach(e -> e.setColor("yellow"));
            for (AuthorityRecordsVo record : records) {
                record.setColor("red");
                current.add(record);
            }
            sb.append(" 新增权限：").append(current.stream().filter(e -> e.getColor().equals("green")).count());
            sb.append(" 修改权限：").append(current.stream().filter(e -> e.getColor().equals("yellow")).count());
            sb.append(" 移除权限：").append(current.stream().filter(e -> e.getColor().equals("red")).count());
            map.put(sb.toString(), current);
        }
        return map;
    }

    @Override
    public void currentPermission2Excel(HttpServletResponse response) throws IOException {

        List<AuthorityRecordsVo> list = iZxwService.searchRecordsList(null);
        ExcelWriter writer = ExcelUtil.getWriter(true);

        writer.addHeaderAlias("positionCode", "职位代码");
        writer.addHeaderAlias("positionName", "职位");
        writer.addHeaderAlias("permissionCode", "作业代码");
        writer.addHeaderAlias("permissionName", "作业名称");
        writer.addHeaderAlias("isAmount", "金额");
        writer.addHeaderAlias("isCreate", "新增");
        writer.addHeaderAlias("isDelete", "删除");
        writer.addHeaderAlias("isUpdate", "更新");
        writer.addHeaderAlias("isRead", "查询");
        writer.addHeaderAlias("isConfirm", "审核");
        writer.addHeaderAlias("isUnConfirm", "撤销审核");
        writer.addHeaderAlias("isVoid", "作废");
        writer.addHeaderAlias("isUnVoid", "撤销作废");
        writer.addHeaderAlias("isPost", "过账");
        writer.addHeaderAlias("isUnPost", "撤销过账");
        writer.addHeaderAlias("isPrint", "打印");
        writer.addHeaderAlias("isExport", "数据导出");

        writer.getSheet().setColumnWidth(0, 5000);
        writer.getSheet().setColumnWidth(1, 10000);
        writer.getSheet().setColumnWidth(2, 5000);
        writer.getSheet().setColumnWidth(3, 10000);

        writer.setOnlyAlias(true);
        writer.write(list, true);

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=现行权限档案.xlsx");
        ServletOutputStream out = response.getOutputStream();

        writer.flush(out, true);
        writer.close();
        IoUtil.close(out);
    }

    @Override
    public void positionContrastRecords2Excel(HttpServletResponse response, SearchVo searchVo) {

        if (searchVo.getYear() == null) throw new RuntimeException("目标年份不可为空");

        Integer iyear = searchVo.getYear();

        List<AuthorityRecordsVo> list = new ArrayList<>();

        List<ZwFile> zw = new ArrayList<>();

        for (String zw01 : searchVo.getCodes()) {
            zw.add(iZwService.selectByPrimaryKey(zw01));
            list.addAll(iZxwService.searchRecordsList(zw01));
        }

        Collections.reverse(list);
        Map<String, List<AuthorityRecordsVo>> map = list.stream().filter(Objects::nonNull).collect(Collectors.groupingBy(AuthorityRecordsVo::getPositionName, LinkedHashMap::new, Collectors.toList()));
        ExcelWriter writer = ExcelUtil.getWriter(true);

        writer.addHeaderAlias("zw01", "岗位代码");
        writer.addHeaderAlias("zw02", "岗位名称");

        writer.getSheet().setColumnWidth(0, 5000);
        writer.getSheet().setColumnWidth(1, 10000);

        Collections.reverse(zw);
        writer.setOnlyAlias(true);
        writer.write(zw, true);


        for (String sheetName : map.keySet()) {
            List<AuthorityRecordsVo> current = map.get(sheetName);

            sheetName = sheetName.replace("/", "、");

            writer.setSheet(sheetName);
            List<AuthorityRecordsVo> records = iPermissionService.searchRecordsList(iyear, current.get(0).getPositionCode());

            for (AuthorityRecordsVo vo : current) {
                vo.setColor("green");
                for (AuthorityRecordsVo record : records) {
                    if (vo.getPermissionCode().equals(record.getPermissionCode())) {
                        if (!vo.getIsAmount().equals(record.getIsAmount())) {
                            vo.setIsAmount(record.getIsAmount() + " => " + vo.getIsAmount());
                        }
                        if (!vo.getIsCreate().equals(record.getIsCreate())) {
                            vo.setIsCreate(record.getIsCreate() + " => " + vo.getIsCreate());
                        }
                        if (!vo.getIsDelete().equals(record.getIsDelete())) {
                            vo.setIsDelete(record.getIsDelete() + " => " + vo.getIsDelete());
                        }
                        if (!vo.getIsUpdate().equals(record.getIsUpdate())) {
                            vo.setIsUpdate(record.getIsUpdate() + " => " + vo.getIsUpdate());
                        }
                        if (!vo.getIsRead().equals(record.getIsRead())) {
                            vo.setIsRead(record.getIsRead() + " => " + vo.getIsRead());
                        }
                        if (!vo.getIsConfirm().equals(record.getIsConfirm())) {
                            vo.setIsConfirm(record.getIsConfirm() + " => " + vo.getIsConfirm());
                        }
                        if (!vo.getIsUnConfirm().equals(record.getIsUnConfirm())) {
                            vo.setIsUnConfirm(record.getIsUnConfirm() + " => " + vo.getIsUnConfirm());
                        }
                        if (!vo.getIsVoid().equals(record.getIsVoid())) {
                            vo.setIsVoid(record.getIsVoid() + " => " + vo.getIsVoid());
                        }
                        if (!vo.getIsUnVoid().equals(record.getIsUnVoid())) {
                            vo.setIsUnVoid(record.getIsUnVoid() + " => " + vo.getIsUnVoid());
                        }
                        if (!vo.getIsPost().equals(record.getIsPost())) {
                            vo.setIsPost(record.getIsPost() + " => " + vo.getIsPost());
                        }
                        if (!vo.getIsUnPost().equals(record.getIsUnPost())) {
                            vo.setIsUnPost(record.getIsUnPost() + " => " + vo.getIsUnPost());
                        }
                        if (!vo.getIsExport().equals(record.getIsExport())) {
                            vo.setIsExport(record.getIsExport() + " => " + vo.getIsExport());
                        }
                        if (!vo.getIsPrint().equals(record.getIsPrint())) {
                            vo.setIsPrint(record.getIsPrint() + " => " + vo.getIsPrint());
                        }
                        vo.setColor("white");
                        records.remove(record);
                        break;
                    }
                }
            }

            current.stream().filter(e -> e.getIsAmount().length() > 1 || e.getIsCreate().length() > 1 ||
                    e.getIsDelete().length() > 1 || e.getIsUpdate().length() > 1 || e.getIsRead().length() > 1 ||
                    e.getIsPost().length() > 1 || e.getIsUnPost().length() > 1 || e.getIsVoid().length() > 1 ||
                    e.getIsUnVoid().length() > 1 || e.getIsConfirm().length() > 1 || e.getIsUnConfirm().length() > 1 ||
                    e.getIsPrint().length() > 1 || e.getIsExport().length() > 1).forEach(e -> e.setColor("yellow"));
            for (AuthorityRecordsVo record : records) {
                record.setColor("red");
                current.add(record);
            }

            writer.addHeaderAlias("permissionCode", "作业代码");
            writer.addHeaderAlias("permissionName", "作业名称");
            writer.addHeaderAlias("isAmount", "金额");
            writer.addHeaderAlias("isCreate", "新增");
            writer.addHeaderAlias("isDelete", "删除");
            writer.addHeaderAlias("isUpdate", "更新");
            writer.addHeaderAlias("isRead", "查询");
            writer.addHeaderAlias("isConfirm", "审核");
            writer.addHeaderAlias("isUnConfirm", "撤销审核");
            writer.addHeaderAlias("isVoid", "作废");
            writer.addHeaderAlias("isUnVoid", "撤销作废");
            writer.addHeaderAlias("isPost", "过账");
            writer.addHeaderAlias("isUnPost", "撤销过账");
            writer.addHeaderAlias("isPrint", "打印");
            writer.addHeaderAlias("isExport", "数据导出");

            writer.getSheet().setColumnWidth(0, 5000);
            writer.getSheet().setColumnWidth(1, 10000);

            writer.setOnlyAlias(true);
            writer.write(current, true);

            current.forEach(e -> {

                if (e.getColor().equals("red")) {

                    CellStyle cellStyle = writer.createCellStyle(0, current.indexOf(e) + 1);
                    cellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
                    cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

                }
                if (e.getColor().equals("green")) {

                    CellStyle cellStyle = writer.createCellStyle(0, current.indexOf(e) + 1);
                    cellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
                    cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

                }
                if (e.getColor().equals("yellow")) {

                    CellStyle cellStyle = writer.createCellStyle(0, current.indexOf(e) + 1);
                    cellStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
                    cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

                }
            });
        }

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=现行权限档案.xlsx");

        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        writer.flush(out, true);
        writer.close();
        IoUtil.close(out);

    }

    @Override
    public Page<PersonalPosition> searchPersonalPositionRecordsListPageHelper(SearchVo searchVo) {
        return iPersonalPositionService.searchPersonalPositionRecordsListPageHelper(searchVo);
    }

    @Override
    @DSTransactional
    public String importPersonalPositionRecords(MultipartFile file, String year) throws IOException {

        if (year == null || year.isEmpty() || year.equals("null")) throw new RuntimeException("导入目标年份不可为空");
        Integer iyear = Integer.valueOf(year);

        ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
        for (int i = 0; i < reader.getSheets().size(); i++) {

            String sheetName = reader.getSheets().get(i).getSheetName();
            List<Map<String, String>> sheetData = ImportExcelUtil.getSheetData(reader.getSheets().get(i));

            if ("账套".equals(sheetName)) {
                for (Map<String, String> map : sheetData) {
                    String gh = map.get("工号");
                    String zx = map.get("账套");

                    ZxFile zxFile = iZxService.selectByPrimaryKey(gh);
                    AzpFile azpFile = iAzpService.selectByPrimaryKey(zx);
                    if (zxFile != null && azpFile != null) {
                        iPersonalPositionService.merge(iyear, 3, zxFile.getZx01(), zxFile.getZx02(), azpFile.getAzp01(), azpFile.getAzp02());
                    }
                }

            } else if ("岗位".equals(sheetName)) {
                for (Map<String, String> map : sheetData) {
                    String gh = map.get("工号");
                    String gw = map.get("组权限");

                    ZxFile zxFile = iZxService.selectByPrimaryKey(gh);
                    ZwFile zwFile = iZwService.selectByPrimaryKey(gw);

                    if (zxFile != null && zwFile != null) {
                        iPersonalPositionService.merge(iyear, 1, zxFile.getZx01(), zxFile.getZx02(), zwFile.getZw01(), zwFile.getZw02());
                    }
                }

            } else if ("单独权限".equals(sheetName)) {
                for (Map<String, String> map : sheetData) {
                    String gh = map.get("工号");
                    String zy = map.get("作业代码");

                    ZxFile zxFile = iZxService.selectByPrimaryKey(gh);
                    GazFile gazFile = iGazService.selectByPrimaryKey(zy);

                    if (zxFile != null && gazFile != null) {
                        iPersonalPositionService.merge(iyear, 2, zxFile.getZx01(), zxFile.getZx02(), gazFile.getGaz01(), gazFile.getGaz03());
                    }
                }
            }
        }
        return "导入完成";
    }

    @Override
    @DSTransactional
    public void deletePersonalPositionRecords(List<PersonalPosition> personalPositions) {
        for (PersonalPosition personalPosition : personalPositions) {
            iPersonalPositionService.deletePersonalPositionRecords(personalPosition);
        }

    }

    @Override
    public Page<PersonalPosition> searchPersonalPositionContrastRecordsListPageHelper(SearchVo searchVo) {
        Page<PersonalPosition> page = iZxService.searchPersonalPositionContrastRecordsListPageHelper(searchVo);
        for (PersonalPosition personalPosition : page.getResult()) {

            PersonalPosition position = iPersonalPositionService.PersonalPositionContrastRecords(searchVo.getYear(), searchVo.getItype(), personalPosition.getCode());
            if (position != null) {
                personalPosition.setPermissionCode(position.getPermissionCode());
                personalPosition.setPermissionName(position.getPermissionName());
            }
            if (!StringUtils.contrastStringArr(personalPosition.getZx04(), personalPosition.getPermissionCode())) {
                personalPosition.setColor("yellow");
            }
        }
        return page;
    }

    @Override
    public void PersonalPositionContrastRecords2Excel(HttpServletResponse response, String year) {

        if (year == null || year.isEmpty() || year.equals("null")) throw new RuntimeException("目标年份不可为空");

        Integer iyear = Integer.valueOf(year);
        List<PersonalPosition> list = iZxService.personalPositionContrastRecords(null);

        Map<Integer, List<PersonalPosition>> map = list.stream().collect(Collectors.groupingBy(PersonalPosition::getItype));
        ExcelWriter writer = ExcelUtil.getWriter(true);

        int i = 0;
        for (Integer type : map.keySet()) {

            for (PersonalPosition personalPosition : map.get(type)) {
                PersonalPosition position = iPersonalPositionService.PersonalPositionContrastRecords(iyear, type, personalPosition.getCode());
                if (position != null) {
                    personalPosition.setPermissionCode(position.getPermissionCode());
                    personalPosition.setPermissionName(position.getPermissionName());
                }
            }

            if (type == 1) {
                if (i == 0) writer.renameSheet("岗位");
                else writer.setSheet("岗位");
                writer.addHeaderAlias("code", "工号");
                writer.addHeaderAlias("name", "姓名");
                writer.addHeaderAlias("zx04", "当前职位代码");
                writer.addHeaderAlias("zw02", "当前职位");
                writer.addHeaderAlias("permissionCode", "历史职位代码");
                writer.addHeaderAlias("permissionName", "历史职位");


            } else if (type == 2) {
                if (i == 0) writer.renameSheet("单独权限");
                else writer.setSheet("单独权限");
                writer.addHeaderAlias("code", "工号");
                writer.addHeaderAlias("name", "姓名");
                writer.addHeaderAlias("zx04", "当前作业代码");
                writer.addHeaderAlias("zw02", "当前作业");
                writer.addHeaderAlias("permissionCode", "历史作业代码");
                writer.addHeaderAlias("permissionName", "历史作业");

            } else if (type == 3) {
                if (i == 0) writer.renameSheet("账套");
                else writer.setSheet("账套");
                writer.addHeaderAlias("code", "工号");
                writer.addHeaderAlias("name", "姓名");
                writer.addHeaderAlias("zx04", "当前中心代码");
                writer.addHeaderAlias("zw02", "当前中心");
                writer.addHeaderAlias("permissionCode", "历史中心代码");
                writer.addHeaderAlias("permissionName", "历史中心");

            }
            writer.getSheet().setColumnWidth(0, 5000);
            writer.getSheet().setColumnWidth(1, 5000);
            writer.getSheet().setColumnWidth(2, 10000);
            writer.getSheet().setColumnWidth(3, 20000);
            writer.getSheet().setColumnWidth(4, 10000);
            writer.getSheet().setColumnWidth(5, 20000);

            writer.setOnlyAlias(true);
            writer.write(map.get(type), true);

            for (PersonalPosition personalPosition : map.get(type)) {

                if (!StringUtils.contrastStringArr(personalPosition.getZx04(), personalPosition.getPermissionCode())) {
                    CellStyle cellStyle = writer.createCellStyle(0, map.get(type).indexOf(personalPosition) + 1);
                    cellStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
                    cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                }
            }
            i++;
        }

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=现行权限档案.xlsx");

        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        writer.flush(out, true);
        writer.close();
        IoUtil.close(out);
    }

}
