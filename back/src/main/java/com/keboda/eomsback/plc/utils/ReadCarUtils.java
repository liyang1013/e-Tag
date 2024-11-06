package com.keboda.eomsback.plc.utils;

import Communication.Profinet.Siemens.SiemensS7Net;
import com.keboda.eomsback.plc.enums.CarDB;


public class ReadCarUtils {


    //********************************************************Boolean**************************************************//

    /**
     * @return 网络心跳
     */
    public static Boolean getHeartBeat(SiemensS7Net s7Net) {
        return ReadPLCUtils.readBoolean(s7Net, CarDB.DB20_0.DB1101());
    }

    /**
     * @return 换层位已对准
     */
    public static Boolean getBarterTier(SiemensS7Net s7Net) {
        return ReadPLCUtils.readBoolean(s7Net, CarDB.DB20_1.DB1101());
    }

    /**
     * @return 是否已寻过原点
     */
    public static Boolean getIfOrigin(SiemensS7Net s7Net) {
        return ReadPLCUtils.readBoolean(s7Net, CarDB.DB20_2.DB1101());
    }

    /**
     * @return 是否接受指令
     */
    public static Boolean getIfReceive(SiemensS7Net s7Net) {
        return ReadPLCUtils.readBoolean(s7Net, CarDB.DB20_3.DB1101());
    }

    /**
     * @return 是否有故障警告
     */
    public static Boolean getIfFault(SiemensS7Net s7Net) {
        return ReadPLCUtils.readBoolean(s7Net, CarDB.DB20_4.DB1101());
    }

    /**
     * @return 电池电量低
     */
    public static Boolean getLowBattery(SiemensS7Net s7Net) {
        return ReadPLCUtils.readBoolean(s7Net, CarDB.DB8_0.DB1101());
    }

    /**
     * @return 电池数据异常
     */
    public static Boolean getCellException(SiemensS7Net s7Net) {
        return ReadPLCUtils.readBoolean(s7Net, CarDB.DB8_1.DB1101());
    }

    /**
     * @return 无托盘可出
     */
    public static Boolean getNoTrayOut(SiemensS7Net s7Net) {
        return ReadPLCUtils.readBoolean(s7Net, CarDB.DB8_2.DB1101());
    }

    /**
     * @return 定位片异常
     */
    public static Boolean getNoTrayEnter(SiemensS7Net s7Net) {
        return ReadPLCUtils.readBoolean(s7Net, CarDB.DB8_3.DB1101());
    }

    /**
     * @return 反光纸异常
     */
    public static Boolean getNoGoodsEnter(SiemensS7Net s7Net) {
        return ReadPLCUtils.readBoolean(s7Net, CarDB.DB8_4.DB1101());
    }

    /**
     * @return 任务指令错误
     */
    public static Boolean getOrderError(SiemensS7Net s7Net) {
        return ReadPLCUtils.readBoolean(s7Net, CarDB.DB8_5.DB1101());
    }

    /**
     * @return 小车目的地未准备好
     */
    public static Boolean getNotPrepare(SiemensS7Net s7Net) {
        return ReadPLCUtils.readBoolean(s7Net, CarDB.DB8_6.DB1101());
    }

    /**
     * @return 行走驱动器故障
     */
    public static Boolean getFault01(SiemensS7Net s7Net) {
        return ReadPLCUtils.readBoolean(s7Net, CarDB.DB36_0.DB1101());
    }

    /**
     * @return 顶升驱动器故障
     */
    public static Boolean getFault02(SiemensS7Net s7Net) {
        return ReadPLCUtils.readBoolean(s7Net, CarDB.DB36_1.DB1101());
    }

    /**
     * @return 托盘顶升动作超时
     */
    public static Boolean getFault03(SiemensS7Net s7Net) {
        return ReadPLCUtils.readBoolean(s7Net, CarDB.DB36_2.DB1101());
    }

    /**
     * @return 小车位置异常
     */
    public static Boolean getFault04(SiemensS7Net s7Net) {
        return ReadPLCUtils.readBoolean(s7Net, CarDB.DB36_3.DB1101());
    }

    /**
     * @return 小车换向动作超时
     */
    public static Boolean getFault05(SiemensS7Net s7Net) {
        return ReadPLCUtils.readBoolean(s7Net, CarDB.DB36_4.DB1101());
    }

    public static Boolean getFault06(SiemensS7Net s7Net) {
        return ReadPLCUtils.readBoolean(s7Net, CarDB.DB36_5.DB1101());
    }

    /**
     * @return 托盘感应信号异常
     */
    public static Boolean getFault07(SiemensS7Net s7Net) {
        return ReadPLCUtils.readBoolean(s7Net, CarDB.DB36_6.DB1101());
    }

    /**
     * @return 换向顶升感应器异常
     */
    public static Boolean getFault08(SiemensS7Net s7Net) {
        return ReadPLCUtils.readBoolean(s7Net, CarDB.DB36_7.DB1101());
    }

    /**
     * @return X方向到位调整超时
     */
    public static Boolean getFault09(SiemensS7Net s7Net) {
        return ReadPLCUtils.readBoolean(s7Net, CarDB.DB37_0.DB1101());
    }

    /**
     * @return Y方向到位调整超时
     */
    public static Boolean getFault10(SiemensS7Net s7Net) {
        return ReadPLCUtils.readBoolean(s7Net, CarDB.DB37_1.DB1101());
    }

    /**
     * @return 顶升时货物位置异常
     */
    public static Boolean getFault11(SiemensS7Net s7Net) {
        return ReadPLCUtils.readBoolean(s7Net, CarDB.DB37_2.DB1101());
    }

    /**
     * @return 母轨绝对定位误差过大
     */
    public static Boolean getFault12(SiemensS7Net s7Net) {
        return ReadPLCUtils.readBoolean(s7Net, CarDB.DB37_3.DB1101());
    }

    /**
     * @return 子轨绝对定位误差过大
     */
    public static Boolean getFault13(SiemensS7Net s7Net) {
        return ReadPLCUtils.readBoolean(s7Net, CarDB.DB37_4.DB1101());
    }

    /**
     * @return 出货母轨定位误差过大
     */
    public static Boolean getFault14(SiemensS7Net s7Net) {
        return ReadPLCUtils.readBoolean(s7Net, CarDB.DB37_5.DB1101());
    }

    /**
     * @return 出货子轨定位误差过大
     */
    public static Boolean getFault15(SiemensS7Net s7Net) {
        return ReadPLCUtils.readBoolean(s7Net, CarDB.DB37_6.DB1101());
    }

    /**
     * @return 入货时小车状态异常
     */
    public static Boolean getFault16(SiemensS7Net s7Net) {
        return ReadPLCUtils.readBoolean(s7Net, CarDB.DB37_7.DB1101());
    }

    /**
     * @return 行走母轨定位误差过大
     */
    public static Boolean getFault17(SiemensS7Net s7Net) {
        return ReadPLCUtils.readBoolean(s7Net, CarDB.DB38_0.DB1101());
    }

    /**
     * @return 行走子轨定位误差过大
     */
    public static Boolean getFault18(SiemensS7Net s7Net) {
        return ReadPLCUtils.readBoolean(s7Net, CarDB.DB38_1.DB1101());
    }

    /**
     * @return 行走巷道中有障碍物
     */
    public static Boolean getFault19(SiemensS7Net s7Net) {
        return ReadPLCUtils.readBoolean(s7Net, CarDB.DB38_2.DB1101());
    }

    /**
     * @return 货物巷道中有障碍物
     */
    public static Boolean getFault20(SiemensS7Net s7Net) {
        return ReadPLCUtils.readBoolean(s7Net, CarDB.DB38_3.DB1101());
    }

    /**
     * @return RFID读写器异常
     */
    public static Boolean getFault21(SiemensS7Net s7Net) {
        return ReadPLCUtils.readBoolean(s7Net, CarDB.DB38_4.DB1101());
    }

    //*********************************************************Byte****************************************************//

    /**
     * @return 举旗
     */
    public static Byte getTarget(SiemensS7Net s7Net) {
        return ReadPLCUtils.readByte(s7Net, CarDB.DB0.DB1101());
    }

    /**
     * @return 小车编号
     */
    public static Byte getSxcId(SiemensS7Net s7Net) {
        return ReadPLCUtils.readByte(s7Net, CarDB.DB1.DB1101());
    }

    /**
     * @return 操作模式
     */
    public static Byte getModel(SiemensS7Net s7Net) {
        return ReadPLCUtils.readByte(s7Net, CarDB.DB2.DB1101());
    }

    /**
     * @return 作业类型
     */
    public static Byte getJobType(SiemensS7Net s7Net) {
        return ReadPLCUtils.readByte(s7Net, CarDB.DB3.DB1101());
    }

    /**
     * @return 托盘顶升状态
     */
    public static Byte getTrayState(SiemensS7Net s7Net) {
        return ReadPLCUtils.readByte(s7Net, CarDB.DB4.DB1101());
    }

    /**
     * @return 换向状态
     */
    public static Byte getReversing(SiemensS7Net s7Net) {
        return ReadPLCUtils.readByte(s7Net, CarDB.DB5.DB1101());
    }

    /**
     * @return 行驶方向
     */
    public static Byte getTravel(SiemensS7Net s7Net) {
        return ReadPLCUtils.readByte(s7Net, CarDB.DB6.DB1101());
    }

    /**
     * @return 电池信息
     */
    public static Byte getCellMessage(SiemensS7Net s7Net) {
        return ReadPLCUtils.readByte(s7Net, CarDB.DB7.DB1101());
    }

    /**
     * @return 小车是否载货
     */
    public static Byte getIfBeige(SiemensS7Net s7Net) {
        return ReadPLCUtils.readByte(s7Net, CarDB.DB21.DB1101());
    }


    //*********************************************************Short***************************************************//

    /**
     * @return X轴坐标
     */
    public static Short getXAxial(SiemensS7Net s7Net) {
        return ReadPLCUtils.readShort(s7Net, CarDB.DB12.DB1101());
    }

    /**
     * @return Y轴坐标
     */
    public static Short getYAxial(SiemensS7Net s7Net) {
        return ReadPLCUtils.readShort(s7Net, CarDB.DB14.DB1101());
    }

    /**
     * @return Z轴坐标
     */
    public static Short getZAxial(SiemensS7Net s7Net) {
        return ReadPLCUtils.readShort(s7Net, CarDB.DB16.DB1101());
    }

    /**
     * @return 小车所在提升机编号
     */
    public static Short getTsjNumber(SiemensS7Net s7Net) {
        return ReadPLCUtils.readShort(s7Net, CarDB.DB18.DB1101());
    }

    /**
     * @return 小车当前电量
     */
    public static Short getEnergy(SiemensS7Net s7Net) {
        return ReadPLCUtils.readShort(s7Net, CarDB.DB26.DB1101());
    }


    //*******************************************************Integer***************************************************//

    /**
     * @return 任务号
     */
    public static Integer getTaskId(SiemensS7Net s7Net) {
        return ReadPLCUtils.readInteger(s7Net, CarDB.DB22.DB1101());
    }

    /**
     * @return 调度号
     */
    public static Integer getDispatchId(SiemensS7Net s7Net) {
        return ReadPLCUtils.readInteger(s7Net, CarDB.DB32.DB1101());
    }

    /**
     * @return X轴绝对坐标
     */
    public static Integer getXLocation(SiemensS7Net s7Net) {
        return ReadPLCUtils.readInteger(s7Net, CarDB.DB40.DB1101());
    }

    /**
     * @return Y轴绝对坐标
     */
    public static Integer getYLocation(SiemensS7Net s7Net) {
        return ReadPLCUtils.readInteger(s7Net, CarDB.DB44.DB1101());
    }

    /**
     * @return 托盘号
     */
    public static Integer getTrayId(SiemensS7Net s7Net) {
        return ReadPLCUtils.readInteger(s7Net, CarDB.DB48.DB1101());
    }

    //********************************************************Float****************************************************//

    /**
     * @return 当前速度
     */
    public static Float getSpeed(SiemensS7Net s7Net) {
        return ReadPLCUtils.readFloat(s7Net, CarDB.DB28.DB1101());
    }

}
