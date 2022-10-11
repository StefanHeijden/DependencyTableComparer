package dtc.table;

import dtc.tablecomparer.TableCompareResults;
import dtc.tablecomparer.TableCompareResultsOverview;
import dtc.utilities.Straat;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StraatTableRemovedDependencies extends StraatTable {

    public StraatTableRemovedDependencies(TableCompareResultsOverview tableCompareResults) {
        super(new Straat("removed"));
        initializeHeader(tableCompareResults.getHeader());
        initializeBody(generateRemovedDependencies(tableCompareResults));
        removeDuplicatesFromBody();
    }

    private Elements generateRemovedDependencies(TableCompareResultsOverview tableCompareResults) {
        List<Element> removedDependencies = new ArrayList<>();
        Iterator<TableCompareResults> iterator = tableCompareResults.getTableCompareResults();
        while(iterator.hasNext()) {
            TableCompareResults tableCompareResult = iterator.next();
            removedDependencies.addAll(tableCompareResult.getRemovedRows());
        }
        return new Elements(removedDependencies);
    }

}
