package dtc.table;

import dtc.utilities.Straat;

import java.io.IOException;

public class StraatTable extends Table{
    private final Straat straat;

    public StraatTable(String path, Straat straat) throws IOException {
        super(path);
        this.straat = straat;
    }

    public Straat getStraat() {
        return straat;
    }
}
