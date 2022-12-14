package dtc;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

import static dtc.ApplicationTestPaths.PATH_TO_SIMPLE_TEST;
import static dtc.DependencyTableComparer.straten;
import static dtc.utilities.ApplicationsPaths.PATH_TO_CONFLUENCE_PAGE;

class DependencyTableComparerTest {

    private static Stream<Arguments> provideStringsForSimpleTest() {
        return Stream.of(
                Arguments.of(PATH_TO_SIMPLE_TEST + PATH_TO_CONFLUENCE_PAGE, "confluence"),
                Arguments.of(PATH_TO_SIMPLE_TEST + straten.get("BZ").getPathToSonarQubePage(), "BZ"),
                Arguments.of(PATH_TO_SIMPLE_TEST + straten.get("DEF").getPathToSonarQubePage(), "DEF"),
                Arguments.of(PATH_TO_SIMPLE_TEST + straten.get("platform").getPathToSonarQubePage(), "platform"),
                Arguments.of(PATH_TO_SIMPLE_TEST + straten.get("PS").getPathToSonarQubePage(), "PS"),
                Arguments.of(PATH_TO_SIMPLE_TEST + straten.get("ROP").getPathToSonarQubePage(), "ROP")
        );
    }

    @ParameterizedTest
    @MethodSource("provideStringsForSimpleTest")
        void shouldAnswerWithTrue(String path, String resultColumnText) throws IOException {
//        StraatTable result = new StraatTableFromSonarQube();
//        assertEquals(1, result.getRowSize());
//        assertEquals(1, result.getColumnSize());
//        assertEquals(resultColumnText, result.getRow(0));
    }
}
