package dtc.tableprinter;

import dtc.table.StraatTable;
import dtc.tablecomparer.TableCompareResults;
import dtc.tablecomparer.TableCompareResultsOverview;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TablePrinter {

    public static void printResults(TableCompareResultsOverview tableCompareResults) {
        printHTMLTables(tableCompareResults);
        printHighVulnerabilities(tableCompareResults);
    }

    private static void printHTMLTables(TableCompareResultsOverview tableCompareResults) {
        Iterator<TableCompareResults> iterator = tableCompareResults.getTableCompareResults();
        while(iterator.hasNext()) {
            StraatTable straatTable = iterator.next().getStraatTable();
            printToFile(straatTable.toHTMLTable(), straatTable.getStraat().getPathToResultFileTable() );
        }
    }

    private static void printHighVulnerabilities(TableCompareResultsOverview tableCompareResults) {
        List<String> highVulnerabilities = new ArrayList<>();
        Iterator<TableCompareResults> iterator = tableCompareResults.getTableCompareResults();
        while(iterator.hasNext()) {
            StraatTable straatTable = iterator.next().getStraatTable();
            highVulnerabilities.addAll(getHighVulnerabilities(straatTable));
        }
        printToFile(highVulnerabilities, "test");
    }

    private static List<String> getHighVulnerabilities(StraatTable straatTable) {
        List<String> highVulnerabilities = new ArrayList<>();
        Iterator<Element> rows = straatTable.getRows();
        while(rows.hasNext()) {
            Element row = rows.next();
            if(isHighVulnerability(row)) {
                highVulnerabilities.add(row.text());
            }
        }
        return highVulnerabilities;
    }

    private static boolean isHighVulnerability(Element row) {
        return false;
    }

    private static void printToFile(List<String> toPrint, String pathToFile) {
        try {
            Path file = Paths.get(pathToFile);
            Files.write(file, toPrint, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new IllegalArgumentException("File path is bad!");
        }
    }

    private TablePrinter () {}
}
