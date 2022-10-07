package dtc.table;

import java.util.List;

public class Table {
    List<List<String>> tableContent;
    public Table(List<List<String>> tableText) {
        tableContent = tableText;
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
