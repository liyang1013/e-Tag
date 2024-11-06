package com.keboda.eomsback.timer;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import com.keboda.eomsback.plc.enums.SiemensPLC;
import com.keboda.eomsback.plc.pojo.Car;
import com.keboda.eomsback.plc.utils.ReadCarUtils;
import com.keboda.eomsback.utils.SocketUtils;
import com.keboda.eomsback.utils.WeChatPlusUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

@Component
public class RcsTimer {
    private static final String sender = "JX2302304|JX2001001|JX1907006|SH1501001";

    /**
     * 检查RCS可用性，发送提醒
     */

    private void checkRCSStatus() {

        boolean mysql = SocketUtils.isReachable("172.17.200.154", 3306);
        boolean back = SocketUtils.isReachable("172.17.200.154", 8090);
        boolean front = SocketUtils.isReachable("172.17.200.154", 8081);

        if (!(mysql && back && front)) {
            String sb = "RCS（172.17.200.154）服务运行检测: " + "\n" +
            "mysql(3306): " + (mysql ? " 运行中" : " 未运行") + "\n" +
                    "back(8090): " + (back ? " 运行中" : " 未运行") + "\n" +
                    "front(8081): " + (front ? " 运行中" : " 未运行");

            WeChatPlusUtils.sendMessage(sender, sb);
        }
    }
}
