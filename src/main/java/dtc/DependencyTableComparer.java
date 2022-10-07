package dtc;

import dtc.table.Table;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static dtc.ApplicationsPaths.PATH_TO_CONFLUENCE_PAGE;
import static dtc.TableUtils.extractTable;

/**
 * Dependency Table Comparer
 *
 */
public class DependencyTableComparer {
    public static final Straten straten = new Straten();
    public static void main(String[] args) throws IOException {
        Table confluenceTable = parseFile(PATH_TO_CONFLUENCE_PAGE);
        List<Table> straatTables = new ArrayList<>();
        for (Straat straat : straten.getAll() ) {
            straatTables.add(parseFile(straat.getPathToSonarQubePage()));
        }
//        TableCompareResults tableCompareResults = CompareConfluenceTableWithStratenTables(confluenceTable, straatTables);
//        printResults(tableCompareResults);
    }

    protected static Table parseFile(String path) throws IOException {
        File confluencePage = new File(path);
        Document parsedConfluencePage = Jsoup.parse(confluencePage);
        return extractTable(parsedConfluencePage);
    }

}
