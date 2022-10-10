package dtc.table;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static dtc.ApplicationTestPaths.PATH_TO_SIMPLE_TEST;
import static dtc.DependencyTableComparer.straten;
import static dtc.table.ConfluenceTable.TABLE_ORDER_ON_PAGE;
import static dtc.table.TableComparer.CompareConfluenceTableWithStratenTable;
import static dtc.utilities.ApplicationsPaths.PATH_TO_CONFLUENCE_PAGE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TableComparerTest {

    @Test
    void simpleTest() throws IOException {
        ConfluenceTable confluenceTable = new ConfluenceTable(PATH_TO_SIMPLE_TEST + PATH_TO_CONFLUENCE_PAGE);
        StraatTable straatTable = new StraatTableFromSonarQube(PATH_TO_SIMPLE_TEST + straten.get(TABLE_ORDER_ON_PAGE[0]).getPathToSonarQubePage(),
                straten.get(TABLE_ORDER_ON_PAGE[0]));
        TableCompareResults tableCompareResults = CompareConfluenceTableWithStratenTable(confluenceTable, straatTable);
        assertEquals(1, tableCompareResults.getNewRows().size());
        assertEquals(1, tableCompareResults.getRemovedRows().size());
        assertEquals(1, tableCompareResults.getStraatTable().rows());
        assertEquals("platform", tableCompareResults.getStraatTable().getRow(0));
    }
}
