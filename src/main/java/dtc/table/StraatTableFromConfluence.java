package dtc.table;

import dtc.utilities.Straat;
import org.jsoup.select.Elements;

public class StraatTableFromConfluence extends StraatTable {

    public StraatTableFromConfluence(Elements header, Elements body, Straat straat) {
        super(straat);
        initializeHeaderAndBody(header, body);
    }

}
