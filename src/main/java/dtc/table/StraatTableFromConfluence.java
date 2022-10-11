package dtc.table;

import dtc.utilities.Straat;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class StraatTableFromConfluence extends StraatTable {

    public StraatTableFromConfluence(Elements header, Elements body, Straat straat) {
        super(straat);
        initializeHeader(header);
        initializeBody(body);
    }

    public StraatTableFromConfluence(Element header, Elements body, Straat straat) {
        super(straat);
        initializeHeader(header);
        initializeBody(body);
    }
}
