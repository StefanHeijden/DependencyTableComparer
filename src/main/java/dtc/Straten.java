package dtc;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Straten {
    private final Map<String, Straat> straten;
    private static final String[] STRAAT_NAMES = {
            "BZ",
            "DEF",
            "platform",
            "PS",
            "ROP"
    };
    public Straten() {
        straten = new HashMap<>();
        for (String straatName : STRAAT_NAMES) {
            straten.put(straatName, new Straat(straatName));
        }
    }

    public Straat get(String straatName) {
        return straten.get(straatName);
    }

    public Collection<Straat> getAll() {
        return straten.values();
    }
}
