package dtc.table;

import dtc.tablecomparer.TableCompareResults;
import dtc.tablecomparer.TableCompareResultsOverview;
import dtc.utilities.Straat;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StraatTableForHighVulnerabilties extends StraatTable {

    public StraatTableForHighVulnerabilties(TableCompareResultsOverview tableCompareResults) {
        super(new Straat("alle straten"));
        generateNewStraatTableForHighVulnerabilities(tableCompareResults);
        initializeHeader(tableCompareResults.getHeader());
    }

    private void generateNewStraatTableForHighVulnerabilities(TableCompareResultsOverview tableCompareResults) {
        List<Element> highVulnerabilities = new ArrayList<>();
        Iterator<TableCompareResults> iterator = tableCompareResults.getTableCompareResults();
        while(iterator.hasNext()) {
            StraatTable straatTable = iterator.next().getStraatTable();
            highVulnerabilities.addAll(getHighVulnerabilitiesFromAStraatTable(straatTable));
        }
        initializeBody(new Elements(highVulnerabilities));
    }

    private List<Element> getHighVulnerabilitiesFromAStraatTable(StraatTable straatTable) {
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

    private boolean isHighVulnerability(Element row) {
        String severity = row.child(3).text();
        return severity.equals("CRITICAL") || severity.equals("HIGH");
    }
}
