package dtc.tablecomparer;

import dtc.table.StraatTable;
import dtc.utilities.Straat;

import java.util.ArrayList;
import java.util.List;

public class TableCompareResults {
    private final Straat straat;
    private final StraatTable straatTable;
    private final List<String> removedRows;
    private final List<String> addedRows;

    public TableCompareResults(StraatTable straatTable,  List<String> removedRows, List<String> addedRows) {
        straat = straatTable.getStraat();
        this.straatTable = straatTable;
        this.removedRows = removedRows;
        this.addedRows = addedRows;
    }

    public StraatTable getStraatTable() {
        return straatTable;
    }

    public Straat getStraat() {
        return straat;
    }

    public List<String> getAddedRows() {
        return addedRows;
    }

    public List<String> getRemovedRows() {
        return removedRows;
    }
    
    public List<String> toFileLines() {
        List<String> fileLines = new ArrayList<>();
        fileLines.add("Removed dependencies");
        fileLines.addAll(removedRows);
        fileLines.add("---------------------------------------------------------------------");
        fileLines.add("Added dependencies");
        fileLines.addAll(addedRows);
        fileLines.add("---------------------------------------------------------------------");
        fileLines.add("Table of dependencies");
        fileLines.addAll(straatTable.toHTMLTable());
        return fileLines;
    }
}
