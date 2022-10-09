package dtc.table;

import java.util.Collections;
import java.util.List;

public class TableComparer {

    public static TableCompareResultsOverview CompareConfluenceTableWithStratenTables(ConfluenceTable confluenceTable, List<StraatTable> straatTables) {
        TableCompareResultsOverview tableCompareResultsOveriew = new TableCompareResultsOverview();
        for (StraatTable straatTable : straatTables ) {
            tableCompareResultsOveriew.addNewOverView(CompareConfluenceTableWithStratenTable(confluenceTable, straatTable));
        }
        return tableCompareResultsOveriew;
    }

    protected static TableCompareResults CompareConfluenceTableWithStratenTable(ConfluenceTable confluenceTable, StraatTable straatTable) {
        StraatTable oldTableFromConfluence = confluenceTable.getStraatTable(straatTable.getStraat());
        List<String> removedRows = getRemovedRows(oldTableFromConfluence, straatTable);
        List<String> addedRows = getAddedRows(oldTableFromConfluence, straatTable);
        return new TableCompareResults(straatTable, removedRows, addedRows);
    }

    private static List<String> getAddedRows(StraatTable oldTableFromConfluence, StraatTable straatTable) {
        return Collections.emptyList();
    }

    private static List<String> getRemovedRows(StraatTable oldTableFromConfluence, StraatTable straatTable) {
        return Collections.emptyList();
    }

    private TableComparer(){}
}
