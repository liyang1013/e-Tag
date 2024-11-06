package com.keboda.eomsback.plc.utils;

import Communication.Profinet.Siemens.SiemensS7Net;
import com.keboda.eomsback.plc.enums.HoistDB;

import java.util.Map;
import java.util.TreeMap;

public class ReadHoistUtils {

    //********************************************************Boolean**************************************************//

    /**
     * @return 1层库口是否有货
     */
    public static Boolean getInStock1(SiemensS7Net s7Net) {
        return ReadPLCUtils.readBoolean(s7Net, HoistDB.DB18_0.DB111());
    }

    /**
     * @return 2层库口是否有货
     */
    public static Boolean getInStock2(SiemensS7Net s7Net) {
        return ReadPLCUtils.readBoolean(s7Net, HoistDB.DB18_1.DB111());
    }

    /**
     * @return 3层库口是否有货
     */
    public static Boolean getInStock3(SiemensS7Net s7Net) {
        return ReadPLCUtils.readBoolean(s7Net, HoistDB.DB18_2.DB111());
    }

    /**
     * @return 4层库口是否有货
     */
    public static Boolean getInStock4(SiemensS7Net s7Net) {
        return ReadPLCUtils.readBoolean(s7Net, HoistDB.DB18_3.DB111());
    }

    /**
     * @return 5层库口是否有货
     */
    public static Boolean getInStock5(SiemensS7Net s7Net) {
        return ReadPLCUtils.readBoolean(s7Net, HoistDB.DB18_4.DB111());
    }

    /**
     * @return 6层库口是否有货
     */
    public static Boolean getInStock6(SiemensS7Net s7Net) {
        return ReadPLCUtils.readBoolean(s7Net, HoistDB.DB18_5.DB111());
    }

    /**
     * @return 7层库口是否有货
     */
    public static Boolean getInStock7(SiemensS7Net s7Net) {
        return ReadPLCUtils.readBoolean(s7Net, HoistDB.DB18_6.DB111());
    }

    /**
     * @return 8层库口是否有货
     */
    public static Boolean getInStock8(SiemensS7Net s7Net) {
        return ReadPLCUtils.readBoolean(s7Net, HoistDB.DB18_7.DB111());
    }

    /**
     * @return 9层库口是否有货
     */
    public static Boolean getInStock9(SiemensS7Net s7Net) {
        return ReadPLCUtils.readBoolean(s7Net, HoistDB.DB19_0.DB111());
    }

    /**
     * @return 10层库口是否有货
     */
    public static Boolean getInStock10(SiemensS7Net s7Net) {
        return ReadPLCUtils.readBoolean(s7Net, HoistDB.DB19_1.DB111());
    }

    //******************************************************Boolean[]**************************************************//


    /**
     * 返回错误状态
     * @return
     * 垂直上端超限: error3
     * 垂直下端超限: error4
     * 垂直条码定位阻档故障: error6
     * 货叉左超限: error7
     * 货叉右超限: error8
     * 松绳过载: error9
     * 垂直运行堵转超时: error11
     * 超高(超高上): error12
     * 始自检未通过故障: error16
     * 起升变频器报警: error17
     * 传送的作业地址非法: error18
     * 垂直未停准: error20
     * 货叉运行堵转超时: error21
     * 同时取车+取托盘非法: error22
     * 前超宽: error23
     * 后超宽: error24
     * 货物左超长: error26
     * 货物右超长: error27
     * 左侧外形超限: error28
     * 右侧外形超限: error29
     * 满货位入库/双重入库: error30
     * 空货位出库: error31
     * 货叉变频器报警: error32
     */
    public static Map<String, Boolean> getError(SiemensS7Net s7Net) {
        byte[] arr = ReadPLCUtils.readByteArr(s7Net, HoistDB.DB11.DB111());
        TreeMap<String, Boolean> map = new TreeMap<>();

        int count = 1;
        for (int j = 0; j < 4; ++j) {
            for (int i = 0; i < 8; ++i) {
                boolean flag = TransBit(arr, 0, j + "." + i);
                map.put("Error" + (count <= 9 ? "0"+ count : count), flag);
                ++count;
            }
        }
        return map;
    }


    //*********************************************************Byte****************************************************//

    /**
     * @return 作业类型
     */
    public static Byte getZyType(SiemensS7Net s7Net) {
        return ReadPLCUtils.readByte(s7Net, HoistDB.DB1.DB111());
    }

    /**
     * @return 操作模式
     */
    public static Byte getModel(SiemensS7Net s7Net) {
        return ReadPLCUtils.readByte(s7Net, HoistDB.DB8.DB111());
    }

    /**
     * @return 载货台载货状态
     */
    public static Byte getZhtStatus(SiemensS7Net s7Net) {
        return ReadPLCUtils.readByte(s7Net, HoistDB.DB9.DB111());
    }

    /**
     * @return 货叉动作状态
     */
    public static Byte getHcStatus(SiemensS7Net s7Net) {
        return ReadPLCUtils.readByte(s7Net, HoistDB.DB10.DB111());
    }

    /**
     * @return 是否故障
     */
    public static Byte getFault1(SiemensS7Net s7Net) {
        return ReadPLCUtils.readByte(s7Net, HoistDB.DB11.DB111());
    }

    public static Byte getFault2(SiemensS7Net s7Net) {
        return ReadPLCUtils.readByte(s7Net, HoistDB.DB12.DB111());
    }

    public static Byte getFault3(SiemensS7Net s7Net) {
        return ReadPLCUtils.readByte(s7Net, HoistDB.DB13.DB111());
    }

    public static Byte getFault4(SiemensS7Net s7Net) {
        return ReadPLCUtils.readByte(s7Net, HoistDB.DB14.DB111());
    }

    /**
     * @return 货物类型
     */
    public static Byte getHwType(SiemensS7Net s7Net) {
        return ReadPLCUtils.readByte(s7Net, HoistDB.DB16.DB111());
    }

    /**
     * @return 取货完成
     */
    public static Byte getPickOver(SiemensS7Net s7Net) {
        return ReadPLCUtils.readByte(s7Net, HoistDB.DB20.DB111());
    }

    /**
     * @return 任务完成
     */
    public static Byte getTaskOver(SiemensS7Net s7Net) {
        return ReadPLCUtils.readByte(s7Net, HoistDB.DB17.DB111());
    }


    //*********************************************************Short***************************************************//

    /**
     * @return 当前层
     */
    public static Short getFloor(SiemensS7Net s7Net) {
        return ReadPLCUtils.readShort(s7Net, HoistDB.DB6.DB111());
    }

    //*******************************************************Integer***************************************************//

    /**
     * @return 任务号
     */
    public static Integer getTaskNo(SiemensS7Net s7Net) {
        return ReadPLCUtils.readInteger(s7Net, HoistDB.DB21.DB111());
    }

    /**
     * @return 调度号
     */
    public static Integer getPalletNo(SiemensS7Net s7Net) {
        return ReadPLCUtils.readInteger(s7Net, HoistDB.DB25.DB111());
    }


    public static boolean TransBit(byte[] buffer, int prefix, String indexStr) {
        String[] sp = indexStr.split("\\.");
        int index = Integer.parseInt(sp[0]) + prefix;
        byte bitIndex = sp.length > 1 ? Byte.valueOf(sp[1]) : 0;
        byte oneByte = buffer[index];
        byte secb = (byte) (1 << bitIndex);
        return (oneByte & secb) == secb;
    }

}
