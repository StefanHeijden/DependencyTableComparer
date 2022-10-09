package dtc.table;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Table {
    List<String> header;
    List<List<String>> body;
    public Table(String pathToFile) throws IOException {
        Document document = TableUtils.getDocumentFromFile(pathToFile);
        Element table = TableUtils.extractTables(document).get(0);
        initializeHeaderAndBody(TableUtils.extractHeaderRowsFromTable(table), TableUtils.extractBodyRowsFromTable(table));
    }

    public Table(Elements header, Elements body) {
        initializeHeaderAndBody(header, body);
    }

    private void initializeHeaderAndBody(Elements header, Elements body) {
        this.header = TableUtils.extractRow(header.get(0));
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
}
