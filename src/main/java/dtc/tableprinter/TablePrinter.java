package dtc.tableprinter;

import dtc.table.StraatTable;
import dtc.table.StraatTableFromConfluence;
import dtc.tablecomparer.TableCompareResults;
import dtc.tablecomparer.TableCompareResultsOverview;
import dtc.utilities.Straat;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static dtc.utilities.ApplicationsPaths.PATH_TO_RESULTS_FILE_ALL_STRATEN;

public class TablePrinter {

    public static void printResults(TableCompareResultsOverview tableCompareResults) {
        printHTMLTables(tableCompareResults);
        printHighVulnerabilities(tableCompareResults);
    }

    private static void printHTMLTables(TableCompareResultsOverview tableCompareResults) {
        Iterator<TableCompareResults> iterator = tableCompareResults.getTableCompareResults();
        while(iterator.hasNext()) {
            StraatTable straatTable = iterator.next().getStraatTable();
            printToFile(straatTable.toHTMLTable(), straatTable.getStraat().getPathToResultFile() );
        }
    }

    private static void printHighVulnerabilities(TableCompareResultsOverview tableCompareResults) {
        List<Element> highVulnerabilities = new ArrayList<>();
        Element header = null;
        Iterator<TableCompareResults> iterator = tableCompareResults.getTableCompareResults();
        while(iterator.hasNext()) {
            StraatTable straatTable = iterator.next().getStraatTable();
            header = straatTable.getHeader();
            highVulnerabilities.addAll(getHighVulnerabilities(straatTable));
        }
        StraatTableFromConfluence highVulnerabilitiesTable = new StraatTableFromConfluence(
                header, new Elements(highVulnerabilities), new Straat("allestraten"));
        printToFile(highVulnerabilitiesTable.toHTMLTable(), PATH_TO_RESULTS_FILE_ALL_STRATEN);
    }

    private static List<Element> getHighVulnerabilities(StraatTable straatTable) {
        List<Element> highVulnerabilities = new ArrayList<>();
        Iterator<Element> rows = straatTable.getRows();
        while(rows.hasNext()) {
            Element row = rows.next();
            if(isHighVulnerability(row)) {
                highVulnerabilities.add(row);
            }
        }
        return highVulnerabilities;
    }

    private static boolean isHighVulnerability(Element row) {
        String severity = row.child(3).text();
        return severity.equals("CRITICAL") || severity.equals("HIGH");
    }

    private static void printToFile(List<String> toPrint, String pathToFile) {
        try {
            Path file = Paths.get(pathToFile);
            File myObj = new File(pathToFile);
            myObj.createNewFile();
            Files.write(file, toPrint, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new IllegalArgumentException("File path is bad!");
        }
    }

    private TablePrinter () {}
}
