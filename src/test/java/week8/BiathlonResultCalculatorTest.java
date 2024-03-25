package week8;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BiathlonResultCalculatorTest {
    BiathlonResultCalculator calculator;
    List<BiathlonAthlete> athletes;

    @BeforeEach
    void setup() {
        calculator = new BiathlonResultCalculator(Path.of("src/test/resources/week8/AthleteTest.csv"));
        athletes = calculator.getAthletes();
    }

    @AfterEach
    void cleanup() {
        calculator = null;
        athletes = null;
    }

    @Test
    void getAthletes_returnsCorrectAthleteNames() {

        String expectedFirst = "FirstName";
        String expectedSecond = "FourthName";
        String expectedThird = "ThirdName";
        String expectedFourth = "FifthName";
        String expectedFifth = "SecondName";

        assertAll(
                () -> assertEquals(expectedFirst, athletes.get(0).getAthleteName()),
                () -> assertEquals(expectedSecond, athletes.get(1).getAthleteName()),
                () -> assertEquals(expectedThird, athletes.get(2).getAthleteName()),
                () -> assertEquals(expectedFourth, athletes.get(3).getAthleteName()),
                () -> assertEquals(expectedFifth, athletes.get(4).getAthleteName())
        );
    }

    @Test
    void getAthletes_returnsCorrectAthleteTimes() {

        int firstMinutes = 16;
        int firstSeconds = 10;

        int secondMinutes = 18;
        int secondSeconds = 10;

        int thirdMinutes = 21;
        int thirdSeconds = 55;

        int fourthMinutes = 26;
        int fourthSeconds = 35;

        int fifthMinutes = 28;
        int fifthSeconds = 15;

        assertAll(
                () -> assertEquals(firstMinutes, athletes.get(0).getFinalResultMinutes()),
                () -> assertEquals(firstSeconds, athletes.get(0).getFinalResultSeconds())
        );

        assertAll(
                () -> assertEquals(secondMinutes, athletes.get(1).getFinalResultMinutes()),
                () -> assertEquals(secondSeconds, athletes.get(1).getFinalResultSeconds())
        );

        assertAll(
                () -> assertEquals(thirdMinutes, athletes.get(2).getFinalResultMinutes()),
                () -> assertEquals(thirdSeconds, athletes.get(2).getFinalResultSeconds())
        );

        assertAll(
                () -> assertEquals(fourthMinutes, athletes.get(3).getFinalResultMinutes()),
                () -> assertEquals(fourthSeconds, athletes.get(3).getFinalResultSeconds())
        );

        assertAll(
                () -> assertEquals(fifthMinutes, athletes.get(4).getFinalResultMinutes()),
                () -> assertEquals(fifthSeconds, athletes.get(4).getFinalResultSeconds())
        );
    }


}