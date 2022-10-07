package dtc;

import static dtc.ApplicationsPaths.FILE_TYPE;
import static dtc.ApplicationsPaths.PATH_TO_INPUT;
import static dtc.ApplicationsPaths.PATH_TO_RESULTS_FILE;

public class Straat {
    private String name;

    Straat(String name) {
        this.name = name;
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
}
