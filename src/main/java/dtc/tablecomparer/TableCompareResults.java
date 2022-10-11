package dtc.tablecomparer;

import dtc.table.StraatTable;
import dtc.utilities.Straat;
import org.jsoup.nodes.Element;

import java.util.List;

public class TableCompareResults {
    private final Straat straat;
    private final StraatTable straatTable;
    private final List<Element> removedRows;
    private final List<Element> addedRows;

    public TableCompareResults(StraatTable straatTable,  List<Element> removedRows, List<Element> addedRows) {
        straat = straatTable.getStraat();
        this.straatTable = straatTable;
        this.removedRows = removedRows;
        this.addedRows = addedRows;
    }

    public StraatTable getStraatTable() {
        return straatTable;
    }

    public Straat getStraat() {
        return straat;
    }

    public List<Element> getAddedRows() {
        return addedRows;
    }

    public List<Element> getRemovedRows() {
        return removedRows;
    }
}
