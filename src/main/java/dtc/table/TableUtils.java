package dtc.table;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class TableUtils {

    public static List<List<String>> extractTable(Document doc) {
        List<List<String>> tableText = new ArrayList<>();
        Elements rows = doc.select("tr");
        for(Element row :rows) {
            tableText.add(extractRow(row));
        }
        return tableText;
    }
    
    private static List<String> extractRow(Element row) {
        List<String> rowText = new ArrayList<>();
        Elements columns = row.select("td");
        for (org.jsoup.nodes.Element column:columns) {
            rowText.add(column.text());
        }
        return rowText;
    }

    private TableUtils() {}
}
