package dtc.tableprinter;

import dtc.table.StraatTable;
import dtc.table.StraatTableForHighVulnerabilties;
import dtc.tablecomparer.TableCompareResults;
import dtc.tablecomparer.TableCompareResultsOverview;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        StraatTable highVulnerabilitiesTable = new StraatTableForHighVulnerabilties(tableCompareResults);
        printToFile(highVulnerabilitiesTable.toHTMLTable(), PATH_TO_RESULTS_FILE_ALL_STRATEN);
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
