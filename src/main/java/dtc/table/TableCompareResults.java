package dtc.table;

import dtc.utilities.Straat;

import java.util.List;

public class TableCompareResults {
    private final Straat straat;
    private final StraatTable straatTable;
    private final List<String> removedRows;
    private final List<String> newRows;

    public TableCompareResults(StraatTable straatTable,  List<String> removedRows, List<String> newRows) {
        straat = straatTable.getStraat();
        this.straatTable = straatTable;
        this.removedRows = removedRows;
        this.newRows = newRows;
    }

    public StraatTable getStraatTable() {
        return straatTable;
    }

    public Straat getStraat() {
        return straat;
    }

    public List<String> getNewRows() {
        return newRows;
    }

    public List<String> getRemovedRows() {
        return removedRows;
    }
}
