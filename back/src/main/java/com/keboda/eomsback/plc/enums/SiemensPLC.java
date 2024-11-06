package com.keboda.eomsback.plc.enums;


import Communication.Profinet.Siemens.SiemensPLCS;
import Communication.Profinet.Siemens.SiemensS7Net;

/**
 * 懒加载PLC对象实例化
 */
public enum SiemensPLC {

    //***************************************************小车**********************************************************//
    Car1("192.168.127.200", SiemensPLCS.S1200),Car2("192.168.127.203", SiemensPLCS.S1200), Car3("192.168.127.206", SiemensPLCS.S1200),
    Car4("192.168.127.209", SiemensPLCS.S1200), Car5("192.168.127.212", SiemensPLCS.S1200), Car6("192.168.127.215", SiemensPLCS.S1200),
    Car7("192.168.127.218", SiemensPLCS.S1200), Car8("192.168.127.221", SiemensPLCS.S1200), Car9("192.168.127.224", SiemensPLCS.S1200),
    Car10("192.168.127.227", SiemensPLCS.S1200), Car11("192.168.127.230", SiemensPLCS.S1200),

    //**************************************************提升机*********************************************************//
    Hoist1("192.168.127.100",SiemensPLCS.S1500),Hoist2("192.168.127.106",SiemensPLCS.S1500),Hoist3("192.168.127.112",SiemensPLCS.S1500),
    Hoist4("192.168.127.118",SiemensPLCS.S1500),

    //**************************************************传输线*********************************************************//
    Convey("192.168.127.130",SiemensPLCS.S1500),

    //**************************************************称重平台********************************************************//
    Weight1("192.168.127.160",SiemensPLCS.S1500), Weight2("192.168.127.161",SiemensPLCS.S1500), Weight3("192.168.127.162",SiemensPLCS.S1500),
    Weight4("192.168.127.163", SiemensPLCS.S1500), Weight5("192.168.127.164",SiemensPLCS.S1500), Weight6("192.168.127.165",SiemensPLCS.S1500),
    Weight7("192.168.127.166",SiemensPLCS.S1500), Weight8("192.168.127.167",SiemensPLCS.S1500), Weight9("192.168.127.168",SiemensPLCS.S1500),
    Weight10("192.168.127.169",SiemensPLCS.S1500);

    private final SiemensS7Net s7Net;

    SiemensPLC(String ip, SiemensPLCS PlcModel) {
        this.s7Net = new SiemensS7Net(PlcModel,ip);
    }

    public SiemensS7Net getSiemensS7Net(){
        return this.s7Net;
    }

}
