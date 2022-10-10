package dtc.table;

import dtc.utilities.Straat;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class ConfluenceTable {
    protected static final String[] TABLE_ORDER_ON_PAGE = {
            "platform",
            "DEF",
            "ROP",
            "PS",
            "BZ",
            "Alle straten"
    };
    private final List<StraatTable> straatTables;
    public ConfluenceTable(String pathToConfluencePage) throws IOException {
        straatTables = new ArrayList<>();
        Document document = TableUtils.getDocumentFromFile(pathToConfluencePage);
        Elements tables = TableUtils.extractTables(document);
        for (int i = 0; i < tables.size(); i++) {
            straatTables.add(createStraatTable(tables.get(i), TABLE_ORDER_ON_PAGE[i]));
        }
    }

    private StraatTable createStraatTable(Element table, String straat) {
        Elements header = TableUtils.extractHeaderRowsFromTable(table);
        Elements body = TableUtils.extractBodyRowsFromTable(table);
        return new StraatTable(header, body, straat);
    }

    public Iterator<StraatTable> getStraatTables() {
        return straatTables.iterator();
    }

    public StraatTable getStraatTable(Straat straat) {
        Optional<StraatTable> result = straatTables.stream().filter(straatTable -> straatTable.getStraat().equals(straat)).findFirst();
        if(result.isPresent()) {
            return result.get();
        }
        throw new IllegalArgumentException("Straat was not found");
    }
}
