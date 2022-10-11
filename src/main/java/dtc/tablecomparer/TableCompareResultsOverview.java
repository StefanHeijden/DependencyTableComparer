package dtc.tablecomparer;

import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TableCompareResultsOverview {
    private final List<TableCompareResults> allTableCompareResults;
    public TableCompareResultsOverview() {
        allTableCompareResults = new ArrayList<>();
    }

    public void addNewOverView(TableCompareResults tableCompareResults) {
        allTableCompareResults.add(tableCompareResults);
    }

    public Iterator<TableCompareResults> getTableCompareResults() {
        return allTableCompareResults.iterator();
    }

    public Element getHeader() {
        if(!allTableCompareResults.isEmpty()) {
            return allTableCompareResults.get(0).getStraatTable().getHeader();
        }
        throw new ArrayIndexOutOfBoundsException("TableCompareResultsOverview has no entries.");
    }
}
