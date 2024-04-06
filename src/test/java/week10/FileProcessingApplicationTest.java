package week10;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FileProcessingApplicationTest {

    FileProcessingApplication application = new FileProcessingApplication();
    String inputFile = "src/test/resources/week10/InputTestFile.txt";
    String outputFile = "src/test/resources/week10/OutputTestFile.txt";


    @Test
    void getUserNames_returnsNamesInCorrectOrder() {
        application.processFiles(inputFile, 6, outputFile);

        List<String> actualResult = application.getUserNames(outputFile);
        String[] expectedResult = {"Aaac", "Aaad", "Baaa"};

        assertAll(
                () -> assertEquals(expectedResult[0], actualResult.get(0)),
                () -> assertEquals(expectedResult[1], actualResult.get(1)),
                () -> assertEquals(expectedResult[2], actualResult.get(2))
        );
    }
}