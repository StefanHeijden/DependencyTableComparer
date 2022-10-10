package dtc.table;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Table {
    List<String> header;
    List<List<String>> body;

    public Table(String pathToFile) throws IOException {
        Document document = TableUtils.getDocumentFromFile(pathToFile);
        Element table = TableUtils.getDependencySummaryTable(document);
        initializeHeaderAndBody(TableUtils.extractVulnerableBodyRowsFromTable(table), TableUtils.extractBodyRowsFromTable(table));
    }

    public Table(Elements header, Elements body) {
        initializeHeaderAndBody(header, body);
    }

    private void initializeHeaderAndBody(Elements header, Elements body) {
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
