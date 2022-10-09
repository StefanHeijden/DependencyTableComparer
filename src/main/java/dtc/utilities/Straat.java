package dtc.utilities;

import static dtc.utilities.ApplicationsPaths.FILE_TYPE;
import static dtc.utilities.ApplicationsPaths.PATH_TO_INPUT;
import static dtc.utilities.ApplicationsPaths.PATH_TO_RESULTS_FILE;

public class Straat {
    private String name;

    public Straat(String name) {
        this.name = name;
    }

    public String getStraatName() {
        return name;
    }

    public String getPathToSonarQubePage() {
        return PATH_TO_INPUT + name + FILE_TYPE;
    }

    public String getPathToResultFileTable() {
        return getPathToResultFile() + "/table" + FILE_TYPE;
    }

    public String getPathToResultFileRemoved() {
        return getPathToResultFile() + "/removed" + FILE_TYPE;
    }

    public String getPathToResultFileAdded() {
        return getPathToResultFile() + "/added" + FILE_TYPE;
    }

    public String getPathToResultFile() {
        return PATH_TO_RESULTS_FILE + name;
    }

    @Override
    public boolean equals(Object compareTo) {
        return compareTo instanceof Straat && ((Straat) compareTo).getStraatName().equals(getStraatName());
    }

    @Override
    public int hashCode() {
        return getStraatName().hashCode();
    }
}
