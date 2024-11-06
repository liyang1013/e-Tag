package com.keboda.eomsback.plc.utils;

import Communication.Profinet.Siemens.SiemensS7Net;
import com.keboda.eomsback.plc.enums.ConveyDB;


public class ReadConveyUtils {

    //********************************************************Boolean**************************************************//

    public static Boolean getConveySizeBefore(SiemensS7Net s7Net, Integer id) {
        return ReadPLCUtils.readBoolean(s7Net, ConveyDB.ConveySizeBefore.getDB400(id));
    }

    public static Boolean getConveySizeLater(SiemensS7Net s7Net, Integer id) {
        return ReadPLCUtils.readBoolean(s7Net, ConveyDB.ConveySizeLater.getDB400(id));
    }

    public static Boolean getConveySizeLeft(SiemensS7Net s7Net, Integer id) {
        return ReadPLCUtils.readBoolean(s7Net, ConveyDB.ConveySizeLeft.getDB400(id));
    }

    public static Boolean getConveySizeRight(SiemensS7Net s7Net, Integer id) {
        return ReadPLCUtils.readBoolean(s7Net, ConveyDB.ConveySizeRight.getDB400(id));
    }

    public static Boolean getConveySizeHigh(SiemensS7Net s7Net, Integer id) {
        return ReadPLCUtils.readBoolean(s7Net, ConveyDB.ConveySizeHigh.getDB400(id));
    }

    public static Boolean getConveyHighPosition(SiemensS7Net s7Net, Integer id) {
        return ReadPLCUtils.readBoolean(s7Net, ConveyDB.ConveyHighPosition.getDB400(id));
    }

    public static Boolean getConveyShortPosition(SiemensS7Net s7Net, Integer id) {
        return ReadPLCUtils.readBoolean(s7Net, ConveyDB.ConveyShortPosition.getDB400(id));
    }

    public static Boolean getConveySwitch(SiemensS7Net s7Net, Integer id) {
        return ReadPLCUtils.readBoolean(s7Net, ConveyDB.ConveySwitch.getDB400(id));
    }

    public static Boolean getConveyEnRequest(SiemensS7Net s7Net, Integer id) {
        return ReadPLCUtils.readBoolean(s7Net, ConveyDB.ConveyEnRequest.getDB400(id));
    }

    public static Boolean getConveyExArrived(SiemensS7Net s7Net, Integer id) {
        return ReadPLCUtils.readBoolean(s7Net, ConveyDB.ConveyExArrived.getDB400(id));
    }

    public static Boolean getConveyPickArrived(SiemensS7Net s7Net, Integer id) {
        return ReadPLCUtils.readBoolean(s7Net, ConveyDB.ConveyPickArrived.getDB400(id));
    }

    public static Boolean getConveyPickRequest(SiemensS7Net s7Net, Integer id) {
        return ReadPLCUtils.readBoolean(s7Net, ConveyDB.ConveyPickRequest.getDB400(id));
    }

    public static Boolean getConveyOpCoSupRequest(SiemensS7Net s7Net, Integer id) {
        return ReadPLCUtils.readBoolean(s7Net, ConveyDB.ConveyOpCoSupRequest.getDB400(id));
    }

    public static Boolean getConveyOpCoSupArrived(SiemensS7Net s7Net, Integer id) {
        return ReadPLCUtils.readBoolean(s7Net, ConveyDB.ConveyOpCoSupArrived.getDB400(id));
    }

    public static Boolean getConveyOpCoBackRequest(SiemensS7Net s7Net, Integer id) {
        return ReadPLCUtils.readBoolean(s7Net, ConveyDB.ConveyOpCoBackRequest.getDB400(id));
    }

    public static Boolean getConveyOpCoOpCoReceived(SiemensS7Net s7Net, Integer id) {
        return ReadPLCUtils.readBoolean(s7Net, ConveyDB.ConveyOpCoOpCoReceived.getDB400(id));
    }

    public static Boolean getConveyOpCoUnloaded(SiemensS7Net s7Net, Integer id) {
        return ReadPLCUtils.readBoolean(s7Net, ConveyDB.ConveyOpCoUnloaded.getDB400(id));
    }

    public static Boolean getConveyEleExRequest(SiemensS7Net s7Net, Integer id) {
        return ReadPLCUtils.readBoolean(s7Net, ConveyDB.ConveyEleExRequest.getDB400(id));
    }

    public static Boolean getConveyEleExAllowed(SiemensS7Net s7Net, Integer id) {
        return ReadPLCUtils.readBoolean(s7Net, ConveyDB.ConveyEleExAllowed.getDB400(id));
    }

    public static Boolean getConveyEleExArrived(SiemensS7Net s7Net, Integer id) {
        return ReadPLCUtils.readBoolean(s7Net, ConveyDB.ConveyEleExArrived.getDB400(id));
    }

    public static Boolean getConveyHydEnRequest(SiemensS7Net s7Net, Integer id) {
        return ReadPLCUtils.readBoolean(s7Net, ConveyDB.ConveyHydEnRequest.getDB400(id));
    }

    public static Boolean getConveyHydExAllowed(SiemensS7Net s7Net, Integer id) {
        return ReadPLCUtils.readBoolean(s7Net, ConveyDB.ConveyHydExAllowed.getDB400(id));
    }

    public static Boolean getConveyHydExRequest(SiemensS7Net s7Net, Integer id) {
        return ReadPLCUtils.readBoolean(s7Net, ConveyDB.ConveyHydExRequest.getDB401(id));
    }

    public static Boolean getConveyFault0(SiemensS7Net s7Net, Integer id) {
        return ReadPLCUtils.readBoolean(s7Net, ConveyDB.ConveyFault0.getDB711(id));
    }

    public static Boolean getConveyFault1(SiemensS7Net s7Net, Integer id) {
        return ReadPLCUtils.readBoolean(s7Net, ConveyDB.ConveyFault1.getDB711(id));
    }

    public static Boolean getConveyFault2(SiemensS7Net s7Net, Integer id) {
        return ReadPLCUtils.readBoolean(s7Net, ConveyDB.ConveyFault2.getDB711(id));
    }

    public static Boolean getConveyFault3(SiemensS7Net s7Net, Integer id) {
        return ReadPLCUtils.readBoolean(s7Net, ConveyDB.ConveyFault3.getDB711(id));
    }

    public static Boolean getConveyFault4(SiemensS7Net s7Net, Integer id) {
        return ReadPLCUtils.readBoolean(s7Net, ConveyDB.ConveyFault4.getDB711(id));
    }

    public static Boolean getConveyFault5(SiemensS7Net s7Net, Integer id) {
        return ReadPLCUtils.readBoolean(s7Net, ConveyDB.ConveyFault5.getDB711(id));
    }

    public static Boolean getConveyFault6(SiemensS7Net s7Net, Integer id) {
        return ReadPLCUtils.readBoolean(s7Net, ConveyDB.ConveyFault6.getDB711(id));
    }

    public static Boolean getConveyFault7(SiemensS7Net s7Net, Integer id) {
        return ReadPLCUtils.readBoolean(s7Net, ConveyDB.ConveyFault7.getDB711(id));
    }

    public static Boolean getConveyFault8(SiemensS7Net s7Net, Integer id) {
        return ReadPLCUtils.readBoolean(s7Net, ConveyDB.ConveyFault8.getDB711(id));
    }

    public static Boolean getConveyFault9(SiemensS7Net s7Net, Integer id) {
        return ReadPLCUtils.readBoolean(s7Net, ConveyDB.ConveyFault9.getDB711(id));
    }

    public static Boolean getConveyHeartbeat(SiemensS7Net s7Net) {
        return ReadPLCUtils.readBoolean(s7Net, ConveyDB.ConveyHeartbeat.getDB400(0));
    }

    //********************************************************byte[]***************************************************//

    /**
     * @param id 1~10
     * @return 重量
     */
    public static String getPlcWeigh(SiemensS7Net s7Net, Integer id) {
        int DBB = (id - 1) * 8;
        byte[] plcWeigh = new byte[7];
        for (int i = 0; i < 7; ++i) {
            plcWeigh[i] = ReadPLCUtils.readByte(s7Net, "DB10011." + (DBB + i));
        }
        return new String(plcWeigh).replaceAll(" ", "");
    }

    //*********************************************************Short***************************************************//

    public static short getConveyUnitNr(SiemensS7Net s7Net, Integer id) {
        return ReadPLCUtils.readShort(s7Net, ConveyDB.ConveyUnitNr.getDB400(id));
    }

    public static short getConveyType(SiemensS7Net s7Net, Integer id) {
        return ReadPLCUtils.readShort(s7Net, ConveyDB.ConveyType.getDB400(id));
    }

    public static short getConveyStatus(SiemensS7Net s7Net, Integer id) {
        return ReadPLCUtils.readShort(s7Net, ConveyDB.ConveyStatus.getDB400(id));
    }

    public static short getConveyDest(SiemensS7Net s7Net, Integer id) {
        return ReadPLCUtils.readShort(s7Net, ConveyDB.ConveyDest.getDB400(id));
    }

    public static short getConveyStorageType(SiemensS7Net s7Net, Integer id) {
        return ReadPLCUtils.readShort(s7Net, ConveyDB.ConveyStorageType.getDB400(id));
    }


    //*******************************************************Integer***************************************************//

    public static Integer getConveyIndex(SiemensS7Net s7Net, Integer id) {
        return ReadPLCUtils.readInteger(s7Net, ConveyDB.ConveyIndex.getDB400(id));
    }

    public static Integer getConveyPlcTaskNumber(SiemensS7Net s7Net, Integer id) {
        return ReadPLCUtils.readInteger(s7Net, ConveyDB.ConveyPlcTaskNumber.getDB400(id));
    }

    public static Integer getConveyPlcTaskReturnNumber(SiemensS7Net s7Net, Integer id) {
        return ReadPLCUtils.readInteger(s7Net, ConveyDB.ConveyPlcTaskReturnNumber.getDB400(id));
    }

}
