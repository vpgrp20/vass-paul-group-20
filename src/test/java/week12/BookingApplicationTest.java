package week12;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BookingApplicationTest {
    BookingApplication application = new BookingApplication();

    @Test
    void insertIntoAccommodationTable() {
        int initialCount = application.getAccommodationTableCount();
        application.insertIntoAccommodationTable("testType", "testBedType", 50, "test description");
        int currentCount = application.getAccommodationTableCount();

        assertEquals(initialCount + 1, currentCount);
    }

    @Test
    void getPricePerRoom_shouldReturnsCorrectPrice() {
        final List<Double> list = application.getPricePerRoom();

        double expectedFirst = 25;
        double expectedSecond = 15;
        double expectedThird = 35;
        double expectedFourth = 15;
        double expectedFifth = 25;

        assertAll(
                () -> assertEquals(expectedFirst, list.get(0)),
                () -> assertEquals(expectedSecond, list.get(1)),
                () -> assertEquals(expectedThird, list.get(2)),
                () -> assertEquals(expectedFourth, list.get(3)),
                () -> assertEquals(expectedFifth, list.get(4))
        );
    }
}