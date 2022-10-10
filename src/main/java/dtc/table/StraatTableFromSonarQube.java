package dtc.table;

import dtc.utilities.Straat;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class StraatTableFromSonarQube extends StraatTable{

    public StraatTableFromSonarQube(String pathToFile, Straat straat) throws IOException {
        super(straat);
        Document document = TableUtils.getDocumentFromFile(pathToFile);
        Element table = TableUtils.getDependencySummaryTable(document);
        initializeHeaderAndBody(TableUtils.extractHeaderRowsFromTable(table), TableUtils.extractVulnerableBodyRowsFromTable(table));
    }

}
