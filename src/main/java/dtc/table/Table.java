package dtc.table;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static dtc.table.TableUtils.extractTable;

public class Table {
    List<List<String>> tableContent;
    public Table(String pathToFile) throws IOException {
        Document document = getDocumentFromFile(pathToFile);
        tableContent = extractTable(document);
    }

    private Document getDocumentFromFile(String path) throws IOException {
        File confluencePage = new File(path);
        return Jsoup.parse(confluencePage);
    }

    public int getRowSize() {
        return tableContent.size();
    }

    public int getColumnSize() {
        if(!tableContent.isEmpty()) {
            return tableContent.size();
        }
        return 0;
    }

    public String getRow(int rowNo) {
        return String.join(" ", tableContent.get(rowNo));
    }
}
