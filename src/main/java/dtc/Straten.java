package dtc;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Straten {
    private final Map<String, Straat> currentStraten;
    private static final String[] STRAAT_NAMES = {
            "BZ",
            "DEF",
            "platform",
            "PS",
            "ROP"
    };
    public Straten() {
        currentStraten = new HashMap<>();
        for (String straatName : STRAAT_NAMES) {
            final Straat straat = new Straat(straatName);
            currentStraten.put(straatName, straat);
        }
    }

    public Straat get(String straatName) {
        return currentStraten.get(straatName);
    }

    public Collection<Straat> getAll() {
        return currentStraten.values();
    }
}
