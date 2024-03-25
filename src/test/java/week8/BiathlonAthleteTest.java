package week8;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

class BiathlonAthleteTest {

    BiathlonAthlete athlete;

    @BeforeEach
    void setup() {
        athlete = new BiathlonAthlete(11, "RandomName", CountryCode.CZ, 30, 27, "xxxox", "xxxxx", "xxoxo");
    }

    @AfterEach
    void cleanup() {
        athlete = null;
    }

    @Test
    void finalTime_shouldBeCalculatedCorrectly() {
        int expectedMinutes = 30;
        int expectedSeconds = 57;


        assertAll(
                () -> assertEquals(expectedMinutes, athlete.getFinalResultMinutes()),
                () -> assertEquals(expectedSeconds, athlete.getFinalResultSeconds()));
    }

    @Test
    void finalTime_shouldBeEqual_forTwoAthletesWithEqualTimesButDifferentConfigurations() {
        int athleteMinutes = athlete.getFinalResultMinutes();
        int athleteSeconds = athlete.getFinalResultSeconds();

        BiathlonAthlete otherAthlete = new BiathlonAthlete(12, "RandomNameOther", CountryCode.CZ, 29, 47, "xoxox", "xoxox", "oxoxo");

        int otherAthleteMinutes = otherAthlete.getFinalResultMinutes();
        int otherAthleteSeconds = otherAthlete.getFinalResultSeconds();

        assertAll(
                () -> assertEquals(athleteMinutes, otherAthleteMinutes),
                () -> assertEquals(athleteSeconds, otherAthleteSeconds)
        );
    }

}