package com.keboda.eomsback.plc.enums;

public enum HoistDB {

    DB1("1"), DB6("6"), DB8("8"), DB9("9"), DB10("10"), DB11("11"), DB12("12"), DB13("13"), DB14("14"), DB16("16"), DB17("17"),
    DB18_0("18.0"), DB18_1("18.1"), DB18_2("18.2"), DB18_3("18.3"), DB18_4("18.4"), DB18_5("18.5"), DB18_6("18.6"), DB18_7("18.7"),
    DB19_0("19.0"), DB19_1("19.1"), DB20("20"), DB21("21"), DB25("25");

    private HoistDB(String db) {
        this.db = db;
    }

    private static final String DB111 = "DB111.";

    private static final String DB1001 = "DB1001.";

    private final String db;

    public String DB1001() {
        return DB1001 + this.db;
    }

    public String DB111() {
        return DB111 + this.db;
    }
}
