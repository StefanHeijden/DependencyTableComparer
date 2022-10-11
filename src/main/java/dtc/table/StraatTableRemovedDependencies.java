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
        generateRemovedDependencies(tableCompareResults);
        initializeHeader(tableCompareResults.getHeader());
    }

    private void generateRemovedDependencies(TableCompareResultsOverview tableCompareResults) {
        List<Element> removedDependencies = new ArrayList<>();
        Iterator<TableCompareResults> iterator = tableCompareResults.getTableCompareResults();
        while(iterator.hasNext()) {
            TableCompareResults tableCompareResult = iterator.next();
            removedDependencies.addAll(tableCompareResult.getRemovedRows());
        }
        initializeBody(new Elements(removedDependencies));
    }

}
