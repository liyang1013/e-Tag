package com.keboda.eomsback.timer;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.keboda.eomsback.flux.pojo.RobotsStatus;
import com.keboda.eomsback.flux.service.IWmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.SortedMap;
import java.util.TreeMap;

@Component
public class WmsTimer {

    private static final String URL = "http://172.17.200.154:8090/rest/robots/states";

    private static final String authorization = "mrbase64 mrrest:YWRtaW4mYWRtaW4=";

    @Autowired
    private IWmsService iWmsService;

    /**
     * 定时获取RCS小车状态接口信息，写入FLUX WMS库
     */
    private void getRobotsStatus() {

        SortedMap<Object, Object> sortedMap = new TreeMap<Object, Object>() {
            private static final long serialVersionUID = 1L;

            {
                ArrayList<Integer> id = new ArrayList<>();
                put("params", id);
            }
        };
        HttpResponse res = null;
        res = HttpRequest.post(URL)
                .header("authorization", authorization)
                .timeout(2000)
                .body(JSONUtil.toJsonStr(sortedMap))
                .execute();

        if (res != null && res.getStatus() == 200) {
            JSONObject jsonObject = new JSONObject(res.body());
            JSONArray data = new JSONArray(jsonObject.get("data"));
            for (Object obj : data) {

                JSONObject car = new JSONObject(obj);
                JSONObject postion = new JSONObject(car.get("position"));
                JSONObject target = new JSONObject(car.get("target"));

                RobotsStatus robotsStatusFile = new RobotsStatus();
                robotsStatusFile.setId((Integer) car.get("id"));
                robotsStatusFile.setIp((String) car.get("ip"));
                robotsStatusFile.setAgvtype((String) car.get("agvType"));
                robotsStatusFile.setXPosition((BigDecimal) (postion.get("x")));
                robotsStatusFile.setYPosition((BigDecimal) postion.get("y"));
                robotsStatusFile.setXTarget((BigDecimal) target.get("x"));
                robotsStatusFile.setYTarget((BigDecimal) target.get("y"));
                robotsStatusFile.setEnable((Boolean) car.get("enable"));
                robotsStatusFile.setFloorid((Integer) postion.get("floorId"));
                robotsStatusFile.setMapid((Integer) car.get("mapId"));
                robotsStatusFile.setTaskState((String) car.get("taskState"));
                robotsStatusFile.setAgvState((String) car.get("agvState"));
                robotsStatusFile.setLoaded((Boolean) car.get("loaded"));
                robotsStatusFile.setBattery((BigDecimal) car.get("battery"));
                robotsStatusFile.setOnline((Boolean) car.get("online"));
                robotsStatusFile.setUpdatetime(new Date());

                RobotsStatus robotsStatus = iWmsService.selectRobotsStatusByKey(robotsStatusFile.getId());

                if (robotsStatus == null) {
                    iWmsService.insertRobotsStatusSelective(robotsStatusFile);
                } else {
                    iWmsService.updateRobotsStatusSelective(robotsStatusFile);
                }
            }
        }
    }
}
