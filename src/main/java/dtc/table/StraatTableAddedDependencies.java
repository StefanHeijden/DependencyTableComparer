package dtc.table;

import dtc.tablecomparer.TableCompareResults;
import dtc.tablecomparer.TableCompareResultsOverview;
import dtc.utilities.Straat;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StraatTableAddedDependencies extends StraatTable {
    
    public StraatTableAddedDependencies(TableCompareResultsOverview tableCompareResults) {
        super(new Straat("added"));
        initializeHeader(tableCompareResults.getHeader());
        initializeBody(generateAddedDependencies(tableCompareResults));
        removeDuplicatesFromBody();
    }

    private Elements generateAddedDependencies(TableCompareResultsOverview tableCompareResults) {
        List<Element> addedDependencies = new ArrayList<>();
        Iterator<TableCompareResults> iterator = tableCompareResults.getTableCompareResults();
        while(iterator.hasNext()) {
            TableCompareResults tableCompareResult = iterator.next();
            addedDependencies.addAll(tableCompareResult.getAddedRows());
        }
        return new Elements(addedDependencies);
    }
    
}
