package dtc.table;

import dtc.utilities.Straat;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StraatTableFromSonarQube extends StraatTable {
    protected static final String[] MINIMIZABLE_ROWS = {
            "yui-2.xx-sources-1.01.12.jar",
            "wicket-extjs-bundle-0.26.0.jar",
            "wicket-datetime-7.18.0.jar",
            "wicket-core-7.18.0.jar"
    };

    public StraatTableFromSonarQube(String pathToFile, Straat straat) throws IOException {
        super(straat);
        Document document = TableUtils.getDocumentFromFile(pathToFile);
        Element table = TableUtils.getDependencySummaryTable(document);
        Elements rows = TableUtils.extractVulnerableBodyRowsFromTable(table);
        rows = minimizeRows(rows);
        initializeHeader(TableUtils.extractHeaderRowsFromTable(table));
        initializeBody(rows);
    }

    private Elements minimizeRows(Elements rows) {
        List<Element> minimizedRows = new ArrayList<>();
        for (Element row : rows) {
            if(!(isRowMinimizable(row) && !containsMinimizedRow(minimizedRows, getMinimizableRow(row)))) {
                minimizedRows.add(row);
            }
        }
        return new Elements(minimizedRows);
    }

    private String getMinimizableRow(Element row) {
        for (String minimizableRow : MINIMIZABLE_ROWS) {
            if(row.text().startsWith(minimizableRow)) {
                return minimizableRow;
            }
        }
        throw new IllegalArgumentException("Expected a result");
    }

    private boolean isRowMinimizable(Element row) {
        for (String minimizableRow : MINIMIZABLE_ROWS) {
            if(row.text().startsWith(minimizableRow)) {
                return true;
            }
        }
        return false;
    }

    private boolean containsMinimizedRow(List<Element> rows, String minimizedRow) {
        for (Element row : rows ) {
            if(row.text().startsWith(minimizedRow)) {
                return true;
            }
        }
        return false;
    }


}
