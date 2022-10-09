package dtc.table;

import dtc.utilities.Straat;
import org.jsoup.select.Elements;

import java.io.IOException;

public class StraatTable extends Table{
    private final Straat straat;

    public StraatTable(String path, Straat straat) throws IOException {
        super(path);
        this.straat = straat;
    }

    public StraatTable(Elements header, Elements body, String straat) {
        super(header, body);
        this.straat = new Straat(straat);
    }

    public Straat getStraat() {
        return straat;
    }
}
