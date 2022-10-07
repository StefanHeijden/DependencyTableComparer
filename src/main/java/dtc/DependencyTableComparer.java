package dtc;

import dtc.table.ConfluenceTable;
import dtc.table.StraatTable;
import dtc.table.TableCompareResultsOverview;
import dtc.utilities.Straat;
import dtc.utilities.Straten;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static dtc.table.TableComparer.CompareConfluenceTableWithStratenTables;
import static dtc.utilities.ApplicationsPaths.PATH_TO_CONFLUENCE_PAGE;

/**
 * Dependency Table Comparer
 *
 */
public class DependencyTableComparer {
    public static final Straten straten = new Straten();
    public static void main(String[] args) throws IOException {
        ConfluenceTable confluenceTable = new ConfluenceTable(PATH_TO_CONFLUENCE_PAGE);
        List<StraatTable> straatTables = new ArrayList<>();
        for (Straat straat : straten.getAll() ) {
            straatTables.add(new StraatTable(straat.getPathToSonarQubePage(), straat));
        }
        TableCompareResultsOverview tableCompareResults = CompareConfluenceTableWithStratenTables(confluenceTable, straatTables);
//        printResults(tableCompareResults);
    }

}
