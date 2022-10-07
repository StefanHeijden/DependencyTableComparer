package dtc.table;

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
        return new TableCompareResults(straatTable);
    }

    private TableComparer(){}
}
