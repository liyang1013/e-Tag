package com.keboda.eomsback.plc.utils;

import Communication.Core.Types.OperateResultExOne;
import Communication.Profinet.Siemens.SiemensS7Net;

public class ReadPLCUtils {
    /**
     * 获取PLC设备DB块Boolean信息
     *
     * @param s7Net PLC-S7
     * @param db    DB块
     * @return 失败：false
     */
    public static Boolean readBoolean(SiemensS7Net s7Net, String db) {
        Boolean info = false;
        OperateResultExOne<Boolean> booleanOperateResultExOne = s7Net.ReadBool(db);
        if (booleanOperateResultExOne.IsSuccess) {
            info = booleanOperateResultExOne.Content;
        }
        return info;
    }

    /**
     * 获取PLC设备DB块Byte信息
     *
     * @param s7Net PLC-S7
     * @param db    DB块
     * @return 失败：-1
     */
    public static Byte readByte(SiemensS7Net s7Net, String db) {
        Byte info = Byte.valueOf("-1");
        OperateResultExOne<Byte> byteOperateResultExOne = s7Net.ReadByte(db);
        if (byteOperateResultExOne.IsSuccess) {
            info = byteOperateResultExOne.Content;
        }
        return info;
    }

    /**
     * 获取PLC设备DB块byte[]信息
     *
     * @param s7Net PLC-S7
     * @param db    DB块
     * @return 失败：-1
     */
    public static byte[] readByteArr(SiemensS7Net s7Net, String db) {
        byte[] info = new byte[]{};
        OperateResultExOne<byte[]> byteArrOperateResultExOne = s7Net.Read(db, (short) 32);
        if (byteArrOperateResultExOne.IsSuccess) {
            info = byteArrOperateResultExOne.Content;
        }
        return info;
    }

    /**
     * 获取PLC设备DB块Short信息
     *
     * @param s7Net PLC-S7
     * @param db    DB块
     * @return 失败：-1
     */
    public static Short readShort(SiemensS7Net s7Net, String db) {
        Short info = -1;
        OperateResultExOne<Short> shortOperateResultExOne = s7Net.ReadInt16(db);
        if (shortOperateResultExOne.IsSuccess) {
            info = shortOperateResultExOne.Content;
        }
        return info;
    }

    /**
     * 获取PLC设备DB块Integer信息
     *
     * @param s7Net PLC-S7
     * @param db    DB块
     * @return 失败：-1
     */
    public static Integer readInteger(SiemensS7Net s7Net, String db) {
        Integer info = -1;
        OperateResultExOne<Integer> integerOperateResultExOne1 = s7Net.ReadInt32(db);
        if (integerOperateResultExOne1.IsSuccess) {
            info = integerOperateResultExOne1.Content;
        }
        return info;
    }

    /**
     * 获取PLC设备DB块Float信息
     *
     * @param s7Net PLC-S7
     * @param db    DB块
     * @return 失败：-1F
     */
    public static Float readFloat(SiemensS7Net s7Net, String db) {
        Float info = -1F;
        OperateResultExOne<Float> floatOperateResultExOne1 = s7Net.ReadFloat(db);
        if (floatOperateResultExOne1.IsSuccess) {
            info = floatOperateResultExOne1.Content;
        }
        return info;
    }
}
