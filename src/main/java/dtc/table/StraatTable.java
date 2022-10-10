package dtc.table;

import dtc.utilities.Straat;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StraatTable {
    List<String> header;
    List<List<String>> body;

    private final Straat straat;

    public StraatTable(Straat straat) {
        this.straat = straat;
        header = new ArrayList<>();
        body = new ArrayList<>();
    }

    public Straat getStraat() {
        return straat;
    }

    void initializeHeaderAndBody(Elements header, Elements body) {
        if(!header.isEmpty()) {
            this.header = TableUtils.extractRow(header.get(0));
        } else {
            this.header = Collections.emptyList();
        }
        this.body = new ArrayList<>();
        for (Element row : body ) {
            this.body.add(TableUtils.extractRow(row));
        }
    }

    public int getRowSize() {
        return body.size();
    }

    public int getColumnSize() {
        if(!body.isEmpty()) {
            return body.size();
        }
        return 0;
    }

    public String getRow(int rowNo) {
        return String.join(" ", body.get(rowNo));
    }

    public int rows() {
        return body.size();
    }
}
