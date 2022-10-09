package dtc.table;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Iterator;

import static dtc.ApplicationTestPaths.PATH_TO_BIG_TEST;
import static dtc.ApplicationTestPaths.PATH_TO_MEDIUM_TEST;
import static dtc.ApplicationTestPaths.PATH_TO_SIMPLE_TEST;
import static dtc.utilities.ApplicationsPaths.PATH_TO_CONFLUENCE_PAGE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ConfluenceTableTest {

    @Test
    void runSimpleTest() throws IOException {
        ConfluenceTable confluenceTable = new ConfluenceTable(PATH_TO_SIMPLE_TEST + PATH_TO_CONFLUENCE_PAGE);
        Iterator<StraatTable> straatTables = confluenceTable.getStraatTables();
        assertTrue(straatTables.hasNext());
        StraatTable straatTable = straatTables.next();
        assertEquals(ConfluenceTable.TABLE_ORDER_ON_PAGE[0], straatTable.getStraat().getStraatName());
        assertFalse(straatTables.hasNext());
    }

    @Test
    void runMediumTest() throws IOException {
        ConfluenceTable confluenceTable = new ConfluenceTable(PATH_TO_MEDIUM_TEST + PATH_TO_CONFLUENCE_PAGE);
        Iterator<StraatTable> straatTables = confluenceTable.getStraatTables();
        getNextTableAndCheckRowSizeAndElements(straatTables, 1, "confluence");
        getNextTableAndCheckRowSizeAndElements(straatTables, 1, "confluence2");
        getNextTableAndCheckRowSizeAndElements(straatTables, 1, "confluence3");
        assertFalse(straatTables.hasNext());
    }

    @Test
    void runBigTest() throws IOException {
        ConfluenceTable confluenceTable = new ConfluenceTable(PATH_TO_BIG_TEST + PATH_TO_CONFLUENCE_PAGE);
        Iterator<StraatTable> straatTables = confluenceTable.getStraatTables();
        getNextTableAndCheckRowSizeAndElements(straatTables, 2, "confluence confluence2 confluence3");
        getNextTableAndCheckRowSizeAndElements(straatTables, 1, "confluence2");
        getNextTableAndCheckRowSizeAndElements(straatTables, 1, "confluence3");
        assertFalse(straatTables.hasNext());
    }

    private void getNextTableAndCheckRowSizeAndElements(Iterator<StraatTable> straatTables, int rowsize, String firstRow) {
        assertTrue(straatTables.hasNext());
        StraatTable straatTable = straatTables.next();
        assertEquals(rowsize, straatTable.getRowSize());
        assertEquals(firstRow, straatTable.getRow(0));
    }
}
