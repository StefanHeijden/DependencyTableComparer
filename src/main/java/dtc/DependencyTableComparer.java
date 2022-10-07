package dtc;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static dtc.ApplicationsPaths.PATH_TO_CONFLUENCE_PAGE;
import static dtc.TableUtils.extractTable;

/**
 * Dependency Table Comparer
 *
 */
public class DependencyTableComparer {
    
    public static void main(String[] args) throws IOException {
        File confluencePage = new File(PATH_TO_CONFLUENCE_PAGE);
        Document parsedConfluencePage = Jsoup.parse(confluencePage);
        List<List<String>> table = extractTable(parsedConfluencePage);
        Straten straten = new Straten();
        for (Straat straat : straten.getAll() ) {
            Document parsedStraat = Jsoup.parse(straat.getPathToSonarQubePage());
            List<List<String>> table2 = extractTable(parsedStraat);
        }
    }

}
