package dtc.table;

import dtc.utilities.Straat;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class StraatTable {
    Element headerElement;
    List<List<String>> body;
    List<Element> bodyElements;

    private final Straat straat;

    public StraatTable(Straat straat) {
        this.straat = straat;
        body = new ArrayList<>();
        bodyElements = new ArrayList<>();
    }

    public Straat getStraat() {
        return straat;
    }

    void initializeHeader(Elements header) {
        if(!header.isEmpty()) {
            headerElement = header.get(0);
        }
    }

    public Element getHeader() {
        return headerElement;
    }

    void initializeHeader(Element header) {
        headerElement = header;
    }

    void initializeBody(Elements body) {
        this.body = new ArrayList<>();
        for (Element row : body ) {
            bodyElements.add(row);
            this.body.add(TableUtils.extractRow(row));
        }
    }

    public int getRowSize() {
        return body.size();
    }

    public Element getRow(int rowNo) {
        return bodyElements.get(rowNo);
    }

    public int rows() {
        return body.size();
    }

    public List<String> toHTMLTable() {
        return TableUtils.toHTMLTable(generateHeaderHTML(), generateBodyHTML());
    }

    private List<String> generateHeaderHTML() {
        String html = headerElement.toString();
        html = html.replace(">, <", ">\n<");
        return Arrays.asList(html.split("\n"));
    }

    private List<String> generateBodyHTML() {
        String html = bodyElements.toString();
        html = html.substring(1, html.length() -2).replace(">, <", ">\n<");
        return Arrays.asList(html.split("\n"));
    }

    public Iterator<Element> getRows() {
        return bodyElements.iterator();
    }

    void removeDuplicatesFromBody() {
        List<Element> uniqueBodyElements = new ArrayList<>();
        for (Element row : bodyElements) {
            if(!doesUniqueBodyElementsContainRow(uniqueBodyElements, row)) {
                uniqueBodyElements.add(row);
            }
        }
        bodyElements = new Elements(uniqueBodyElements);
    }
    
    private boolean doesUniqueBodyElementsContainRow(List<Element> uniqueBodyElements, Element rowToCheck) {
        for (Element row : uniqueBodyElements) {
            if(TableUtils.areRowsEqual(row, rowToCheck)) {
                return true;
            }
        }
        return false;
    }
}
