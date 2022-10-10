package dtc.table;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TableUtils {

    public static Document getDocumentFromFile(String path) throws IOException {
        File confluencePage = new File(path);
        return Jsoup.parse(confluencePage);
    }

    public static List<List<String>> extractTable(Document doc) {
        List<List<String>> tableText = new ArrayList<>();
        Elements rows = doc.select("tr");
        for(Element row : rows) {
            tableText.add(extractRow(row));
        }
        return tableText;
    }

    static List<String> extractRow(Element row) {
        List<String> rowText = new ArrayList<>();
        Elements columns = row.select("td");
        for (org.jsoup.nodes.Element column:columns) {
            rowText.add(column.text());
        }
        return rowText;
    }

    public static Elements extractTables(Document doc) {
        return doc.select("table");
    }

    public static Elements extractHeaderRowsFromTable(Element tables) {
        return tables.select("thead").select("tr");
    }

    public static Elements extractBodyRowsFromTable(Element tables) {
        return tables.select("tbody").select("tr");
    }

    public static Elements extractVulnerableBodyRowsFromTable(Element tables) {
        return tables.select("tbody").select(".vulnerable");
    }

    private TableUtils() {}

    public static Element getDependencySummaryTable(Document document) {
        Elements tables = Jsoup.parse(document.select("iframe").attr("srcdoc")).select("#summaryTable");
        if (tables.size() > 1) {
            throw new IllegalArgumentException("Too many DependencySummaryTables where found");
        }
        if (tables.isEmpty()) {
            throw new IllegalArgumentException("No DependencySummaryTable was found");
        }
        return Jsoup.parse(document.select("iframe").attr("srcdoc")).select("#summaryTable").get(0);
    }
}
