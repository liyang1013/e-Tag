package com.keboda.eomsback.plc.enums;

public enum CarDB {

    DB0("0"), DB1("1"), DB2("2"), DB3("3"), DB4("4"), DB5("5"), DB6("6"), DB7("7"),
    DB8_0("8.0"), DB8_1("8.1"), DB8_2("8.2"), DB8_3("8.3"), DB8_4("8.4"), DB8_5("8.5"), DB8_6("8.6"),
    DB12("12"), DB14("14"),  DB16("16"), DB18("18"),
    DB20_0("20.0"), DB20_1("20.1"), DB20_2("20.2"), DB20_3("20.3"), DB20_4("20.4"),
    DB21("21"), DB22("22"), DB25("25"), DB26("26"), DB28("28"), DB32("32"),
    DB36_0("36.0"), DB36_1("36.1"), DB36_2("36.2"), DB36_3("36.3"), DB36_4("36.4"), DB36_5("36.5"), DB36_6("36.6"), DB36_7("36.7"),
    DB37_0("37.0"), DB37_1("37.1"), DB37_2("37.2"), DB37_3("37.3"), DB37_4("37.4"), DB37_5("37.5"), DB37_6("37.6"), DB37_7("37.7"),
    DB38_0("38.0"), DB38_1("38.1"), DB38_2("38.2"), DB38_3("38.3"), DB38_4("38.4"),
    DB40("40"), DB44("44"), DB48("48");

    private static final String DB1101 = "DB1101.";

    private static final String DB110 = "DB110.";

    private final String db;

    private CarDB(String db) {
        this.db = db;
    }

    public String DB1101() {
        return DB1101 + this.db;
    }

}
