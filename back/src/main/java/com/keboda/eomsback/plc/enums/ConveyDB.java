package com.keboda.eomsback.plc.enums;

public enum ConveyDB {

    ConveyUnitNr(2, 0), ConveyType(4, 0), ConveyStatus(6, 0), ConveyIndex(8, 0),
    ConveySizeBefore(12, 0), ConveySizeLater(12, 1), ConveySizeLeft(12, 2),
    ConveySizeRight(12, 3), ConveySizeHigh(12, 4), ConveyHighPosition(12, 5),
    ConveyShortPosition(12, 6), ConveyDest(14, 0), ConveyStorageType(16, 0),
    ConveySwitch(18,0), ConveyPlcTaskNumber(8,0), ConveyPlcTaskReturnNumber(8,0),
    ConveyEnRequest(18,1), ConveyExArrived(18,2), ConveyPickArrived(18,3),
    ConveyPickRequest(18,4), ConveyOpCoSupRequest(18,5), ConveyOpCoSupArrived(18,6),
    ConveyOpCoBackRequest(18,7), ConveyOpCoOpCoReceived(19,0), ConveyOpCoUnloaded(19,1),
    ConveyEleExRequest(19,2), ConveyEleExAllowed(19,3), ConveyEleExArrived(19,4),
    ConveyHydEnRequest(19,5),ConveyHydExAllowed(19,6),ConveyHydExRequest(17,2),
    ConveyFault0(16,0), ConveyFault1(16,1), ConveyFault2(16,2), ConveyFault3(16,3),
    ConveyFault4(16,4), ConveyFault5(16,5), ConveyFault6(16,6), ConveyFault7(16,7),
    ConveyFault8(17,0), ConveyFault9(17,1),ConveyHeartbeat(0,0);

    private static final String DB400 = "DB400.";

    private static final String DB401 = "DB401.";

    private static final String DB711 = "DB711.";

    private final Integer dbx;

    private final Integer dbs;

    ConveyDB(int dbx, int dbs) {
        this.dbx = dbx;
        this.dbs = dbs;
    }

    public String getDB400(Integer id) {

        int db = this.dbx;
        for (int i = 1; i < id; ++i) {
            db += 30;
        }
        return DB400 + db + "." + this.dbs;
    }

    public String getDB401(Integer id) {

        int db = this.dbx;
        for (int i = 1; i < id; ++i) {
            db += 30;
        }
        return DB401 + db + "." + this.dbs;
    }

    public String getDB711(Integer id) {

        int db = this.dbx;
        for (int i = 1; i < id; ++i) {
            db += 4;
        }
        return DB711 + db + "." + this.dbs;
    }
}
