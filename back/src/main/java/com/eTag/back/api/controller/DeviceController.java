package com.eTag.back.api.controller;

import com.eTag.back.api.pojo.Devices;
import com.eTag.back.api.pojo.LabelRequestBody;
import com.eTag.back.api.service.IDevicesService;
import com.eTag.back.entity.BaseResult;
import com.eTag.back.entity.LabelResult;
import com.eTag.back.entity.SearchVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/device")
public class DeviceController {
    @Autowired
    private IDevicesService iDevicesService;

    @PostMapping("/searchDevicePageHelper")
    public BaseResult searchDevicePageHelper(@RequestBody SearchVo searchVo) {
        PageHelper.startPage(searchVo.getCurrentPage(), searchVo.getSize());
        Page<Devices> page = iDevicesService.searchDevicePageHelper(searchVo);
        return BaseResult.success(page, page.getTotal());
    }

    @PostMapping("/getTemplate")
    public BaseResult getTemplate(@RequestBody Devices devices) {
        return BaseResult.success(iDevicesService.getTemplate(devices));
    }

    @PostMapping("/uploadFile")
    public BaseResult uploadFile(MultipartFile file) throws IOException, NoSuchAlgorithmException {
        return BaseResult.success(iDevicesService.uploadFile(file));
    }

    @PostMapping("/enable")
    public BaseResult enable(@RequestBody Devices devices) {
        iDevicesService.enable(devices);
        return BaseResult.success(devices.getStatus() ? "开启标签" : "关闭标签");
    }

    @PostMapping("/addLabel")
    public BaseResult addLabel(@RequestBody Devices devices) {
        iDevicesService.addLabel(devices);
        return BaseResult.success();
    }

    @PostMapping("/deleteDevice")
    public BaseResult deleteDevice(@RequestBody Devices devices) {
        iDevicesService.deleteDevice(devices);
        return BaseResult.success();
    }

    @GetMapping("/getLabel")
    public LabelResult getLabel(LabelRequestBody body) {
        return LabelResult.builder().State("Done").Message("获取成功").Number("").Data(iDevicesService.getLabel(body)).build();
    }

    @PostMapping("/postLabel")
    public LabelResult postLabel(LabelRequestBody body) {
        return LabelResult.builder().State("Done").Message("获取成功").Number("").Data(
                "{\"name\":\"绿色日常视频\",\"resolution\":\"800*1280\",\"type\":\"cus\",\"itemNum\":1,\"status\":0,\"thumbnail\":\"http://xunmaotemp.oss-cn-hangzhou.aliyuncs.com/uploads/1817/20230831/b0cc9c155e0504f73d576b29506ff250.png\",\"width\":800,\"height\":1280,\"contextWidth\":800,\"contextHeight\":1280,\"devicePixelRatio\":1,\"onlyRender\":false,\"child_list\":[{\"name\":\"自定义图片\",\"x\":0,\"y\":478.33,\"w\":800,\"h\":800,\"angle\":0,\"type\":\"image\",\"operation\":{\"lock\":false,\"invisible\":false},\"desc\":{\"src\":\"http://xunmaotemp.oss-cn-hangzhou.aliyuncs.com/uploads/000000000001819/20230825/95a66a537507f445cd4d3fb39d539d8a.jpg\"},\"extension\":{\"ex_type\":\"image\",\"bind\":\"\",\"swiper_list\":[],\"lin_src\":\"\"},\"uuid\":\"f5529ec6-dcb3-a683-88e2-725fc758f187\",\"edit\":true},{\"type\":\"text\",\"name\":\"商品名称\",\"x\":41.02,\"y\":509.44,\"w\":722.42,\"h\":124,\"angle\":0,\"desc\":{\"text\":\"商品名称哈\",\"color\":\"#F7F7F7\",\"fontSize\":\"120\",\"fontWeight\":\"bold\",\"textAlign\":\"center\",\"fontFamily\":\"SimHei\",\"borderRadius\":0,\"borderWidth\":0},\"operation\":{\"lock\":false,\"invisible\":false},\"extension\":{\"textDecoration\":\"none\",\"ex_type\":\"text\",\"bind\":\"$item_name\"},\"uuid\":\"401cbdf6-e43d-fd4a-373f-8560972f5c1f\",\"edit\":true},{\"name\":\"商品图片\",\"x\":548.76,\"y\":1065.84,\"w\":200,\"h\":198.38,\"angle\":0,\"type\":\"image\",\"operation\":{\"lock\":false,\"invisible\":false},\"desc\":{\"src\":\"http://xunmaotemp.oss-cn-hangzhou.aliyuncs.com/uploads/1794/20230216/0ad93b49aa41c46661425fbb1a2f9aa4.jpg\"},\"extension\":{\"ex_type\":\"image\",\"bind\":\"$item_image\",\"swiper_list\":[],\"lin_src\":\"\"},\"uuid\":\"306a67b6-8e8a-c9b4-9e4f-e2cd45c9f668\"},{\"type\":\"html\",\"name\":\"零售价\",\"x\":53.91,\"y\":757.28,\"w\":669.58,\"h\":259.18,\"angle\":0,\"desc\":{\"html\":\"\"},\"operation\":{\"lock\":false,\"invisible\":false,\"disableScale\":false},\"extension\":{\"ex_type\":\"price\",\"html\":{\"text\":\"999.99\",\"color\":\"#2F5801\",\"intFontSize\":\"250\",\"floatFontSize\":\"180\",\"fontWeight\":\"bold\",\"fontFamily\":\"Impact\",\"textAlign\":\"center\",\"numFloatStyle\":\"ct\",\"fontStyle\":\"normal\",\"textDecoration\":\"none\",\"bgColor\":\"\"},\"unit_price\":\"500g\",\"bind\":\"$sale_price\"},\"uuid\":\"cb4165e1-e3b2-ed89-a5b1-959ca27b8495\"},{\"type\":\"text\",\"name\":\"文本\",\"x\":537.25,\"y\":1024.4,\"w\":103.42,\"h\":53.62,\"angle\":0,\"desc\":{\"text\":\"元/\",\"color\":\"#333333\",\"fontSize\":\"50\",\"fontWeight\":\"bold\",\"textAlign\":\"left\",\"fontFamily\":\"sans-serif\",\"borderRadius\":0,\"borderWidth\":0},\"operation\":{\"lock\":false,\"invisible\":false},\"extension\":{\"textDecoration\":\"\",\"ex_type\":\"text\",\"bind\":\"\"},\"uuid\":\"4c7441f8-e6a4-bf3e-ff70-b59376680ddf\"},{\"type\":\"text\",\"name\":\"单位\",\"x\":606.22,\"y\":1026,\"w\":169.87,\"h\":50.68,\"angle\":0,\"desc\":{\"text\":\"$单位\",\"color\":\"#333333\",\"fontSize\":\"50\",\"fontWeight\":\"bold\",\"textAlign\":\"left\",\"fontFamily\":\"sans-serif\",\"borderRadius\":0,\"borderWidth\":0},\"operation\":{\"lock\":false,\"invisible\":false},\"extension\":{\"textDecoration\":\"\",\"ex_type\":\"text\",\"bind\":\"$item_unit\"},\"uuid\":\"56edc5c4-cd6b-5088-5b4e-e0d15fd7b6c3\"},{\"type\":\"text\",\"name\":\"商品条码\",\"x\":287.61,\"y\":1233.83,\"w\":136.11,\"h\":27.53,\"angle\":0,\"desc\":{\"text\":\"6985412541232\",\"color\":\"#333333\",\"fontSize\":\"18\",\"fontWeight\":\"normal\",\"textAlign\":\"center\",\"fontFamily\":\"Impact\",\"borderRadius\":0,\"borderWidth\":0},\"operation\":{\"lock\":false,\"invisible\":false},\"extension\":{\"textDecoration\":\"\",\"ex_type\":\"text\",\"bind\":\"$item_no\"},\"uuid\":\"f3077539-cda5-d48e-3661-9c1636b75b53\"},{\"name\":\"二维码\",\"x\":30.25,\"y\":1133.35,\"w\":104.97,\"h\":98.36,\"angle\":0,\"type\":\"image\",\"operation\":{\"lock\":false,\"invisible\":false},\"desc\":{\"src\":\"http://xunmaotemp.oss-cn-hangzhou.aliyuncs.com/uploads/1794/20230216/0ca1f2bf6b86d268a051355e04896f04.png\"},\"extension\":{\"ex_type\":\"qr_code\",\"bind\":\"$device_info\",\"value\":\"http://www.maolink.cn\"},\"uuid\":\"af5deb29-fce7-34f5-0913-dd9b4adef471\"},{\"name\":\"条形码\",\"x\":284.31,\"y\":1191.37,\"w\":147.95,\"h\":42.42,\"angle\":0,\"type\":\"image\",\"operation\":{\"lock\":false,\"invisible\":false},\"desc\":{\"src\":\"http://xunmaotemp.oss-cn-hangzhou.aliyuncs.com/uploads/1820/20230223/3323a18c21280ab6b6d77c6d26ced3d5.png\"},\"extension\":{\"ex_type\":\"bar_code\",\"bind\":\"$bar_item_no\",\"value\":\"\"},\"uuid\":\"751ada41-40bb-c2b5-573e-3a73db8a3eeb\"},{\"type\":\"text\",\"name\":\"文本\",\"x\":270.23,\"y\":1093.14,\"w\":121.86,\"h\":44,\"angle\":0,\"desc\":{\"text\":\"产地：\",\"color\":\"#333333\",\"fontSize\":\"40\",\"fontWeight\":\"normal\",\"textAlign\":\"left\",\"fontFamily\":\"SimHei\",\"borderRadius\":0,\"borderWidth\":0},\"operation\":{\"lock\":false,\"invisible\":false},\"extension\":{\"textDecoration\":\"\",\"ex_type\":\"text\",\"bind\":\"\"},\"uuid\":\"e2f7ca2a-3e8f-5437-1eae-ddbe82ff4505\"},{\"type\":\"text\",\"name\":\"文本\",\"x\":269.32,\"y\":1134.52,\"w\":121.85,\"h\":44,\"angle\":0,\"desc\":{\"text\":\"规格：\",\"color\":\"#333333\",\"fontSize\":\"40\",\"fontWeight\":\"normal\",\"textAlign\":\"left\",\"fontFamily\":\"SimHei\",\"borderRadius\":0,\"borderWidth\":0},\"operation\":{\"lock\":false,\"invisible\":false},\"extension\":{\"textDecoration\":\"\",\"ex_type\":\"text\",\"bind\":\"\"},\"uuid\":\"60ffa27e-67dc-7e03-2fe9-0e3257c6c9d8\"},{\"type\":\"text\",\"name\":\"产地\",\"x\":365.96,\"y\":1094.3,\"w\":212.97,\"h\":44,\"angle\":0,\"desc\":{\"text\":\"$产地\",\"color\":\"#333333\",\"fontSize\":\"40\",\"fontWeight\":\"normal\",\"textAlign\":\"left\",\"fontFamily\":\"SimHei\",\"borderRadius\":0,\"borderWidth\":0},\"operation\":{\"lock\":false,\"invisible\":false},\"extension\":{\"textDecoration\":\"\",\"ex_type\":\"text\",\"bind\":\"$area_address\"},\"uuid\":\"e73cbffc-83be-28f1-a1e5-82534e64d653\"},{\"type\":\"text\",\"name\":\"规格\",\"x\":365.37,\"y\":1132.3,\"w\":196.29,\"h\":44,\"angle\":0,\"desc\":{\"text\":\"$规格\",\"color\":\"#333333\",\"fontSize\":\"40\",\"fontWeight\":\"normal\",\"textAlign\":\"left\",\"fontFamily\":\"SimHei\",\"borderRadius\":0,\"borderWidth\":0},\"operation\":{\"lock\":false,\"invisible\":false},\"extension\":{\"textDecoration\":\"\",\"ex_type\":\"text\",\"bind\":\"$item_size\"},\"uuid\":\"c17cd989-ed43-efe8-368d-0b70f4ddcb52\"},{\"type\":\"text\",\"name\":\"版本号\",\"x\":40.39,\"y\":1237.67,\"w\":155.72,\"h\":24,\"angle\":0,\"desc\":{\"text\":\"$版本号\",\"color\":\"#000000\",\"fontSize\":\"20\",\"fontWeight\":\"bold\",\"textAlign\":\"left\",\"fontFamily\":\"sans-serif\",\"borderRadius\":0,\"borderWidth\":0},\"operation\":{\"lock\":false,\"invisible\":false},\"extension\":{\"textDecoration\":\"\",\"ex_type\":\"text\",\"bind\":\"$pos_version\"},\"uuid\":\"3da5e749-a502-c329-1baf-099352ac8ace\"},{\"type\":\"text\",\"name\":\"文本\",\"x\":40.33,\"y\":687.69,\"w\":263.33,\"h\":84,\"angle\":0,\"desc\":{\"text\":\"零售价：\",\"color\":\"#010101\",\"fontSize\":\"65\",\"fontWeight\":\"bold\",\"textAlign\":\"left\",\"fontFamily\":\"sans-serif\",\"borderRadius\":0,\"borderWidth\":0},\"operation\":{\"lock\":false,\"invisible\":false},\"extension\":{\"textDecoration\":\"\",\"ex_type\":\"text\",\"bind\":\"\"},\"uuid\":\"b1945577-dc8f-2fc7-9069-0d6adfdb2d45\"},{\"name\":\"商品视频\",\"x\":0,\"y\":0,\"w\":800,\"h\":480,\"angle\":0,\"type\":\"image\",\"operation\":{\"lock\":false,\"invisible\":false},\"desc\":{\"src\":\"http://xunmaotemp.oss-cn-hangzhou.aliyuncs.com/uploads/1794/20230216/12bff7da18f4728c281e6a93d345e897.png\"},\"extension\":{\"ex_type\":\"video\",\"bind\":\"$item_video\",\"value\":\"\"},\"uuid\":\"73ee394a-e3fc-c789-3709-65a45bc19470\"}],\"cls\":\"20\"}"
        ).build();
    }
}
