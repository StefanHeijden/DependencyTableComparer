package dtc.tablecomparer;

import dtc.table.ConfluenceTable;
import dtc.table.StraatTable;

import java.util.ArrayList;
import java.util.List;

public class TableComparer {

    public static TableCompareResultsOverview CompareConfluenceTableWithStratenTables(ConfluenceTable confluenceTable, List<StraatTable> straatTables) {
        TableCompareResultsOverview tableCompareResultsOveriew = new TableCompareResultsOverview();
        for (StraatTable straatTable : straatTables ) {
            tableCompareResultsOveriew.addNewOverView(CompareConfluenceTableWithStratenTable(confluenceTable, straatTable));
        }
        return tableCompareResultsOveriew;
    }

    public static TableCompareResults CompareConfluenceTableWithStratenTable(ConfluenceTable confluenceTable, StraatTable straatTable) {
        StraatTable oldTableFromConfluence = confluenceTable.getStraatTable(straatTable.getStraat());
        List<String> addedRows = compareWhetherFirstTableContainsEntriesNotInSecondTable(straatTable, oldTableFromConfluence);
        List<String> removedRows = compareWhetherFirstTableContainsEntriesNotInSecondTable(oldTableFromConfluence, straatTable);
        return new TableCompareResults(straatTable, removedRows, addedRows);
    }

    private static List<String> compareWhetherFirstTableContainsEntriesNotInSecondTable(StraatTable tableToCheck, StraatTable tableToCheckWith) {
        List<String> rows = new ArrayList<>();
        for (int i = 0; i < tableToCheck.rows(); i++) {
            boolean containsNot =  doesTableContainRow(tableToCheckWith, tableToCheck.getRow(i));
            if(containsNot) {
                rows.add(tableToCheck.getRow(i));
            }
        }
        return rows;
    }

    private static boolean doesTableContainRow(StraatTable tableToCheckWith, String row) {
        for (int i = 0; i < tableToCheckWith.rows(); i++) {
            if (areRowsEqual(tableToCheckWith.getRow(i), row)) {
                return false;
            }
        }
        return true;
    }

    private static boolean areRowsEqual(String row1, String row2) {
        return row1.equals(row2);
    }

    private TableComparer(){}
}
