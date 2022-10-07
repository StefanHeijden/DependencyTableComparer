package dtc;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static dtc.ApplicationsPaths.PATH_TO_CONFLUENCE_PAGE;
import static dtc.TableUtils.extractTable;

/**
 * Dependency Table Comparer
 *
 */
public class DependencyTableComparer {
    public static final Straten straten = new Straten();
    public static void main(String[] args) throws IOException {
        List<List<String>> confluenceTable = parseFile(PATH_TO_CONFLUENCE_PAGE);
        for (Straat straat : straten.getAll() ) {
            List<List<String>> straatTable = parseFile(straat.getPathToSonarQubePage());
        }
    }

    protected static List<List<String>> parseFile(String path) throws IOException {
        File confluencePage = new File(path);
        Document parsedConfluencePage = Jsoup.parse(confluencePage);
        return extractTable(parsedConfluencePage);
    }

}
