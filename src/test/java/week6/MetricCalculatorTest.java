package week6;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MetricCalculatorTest {

    MetricCalculator calculator;

    @BeforeEach
    void setup() {
        calculator = new MetricCalculator();
    }

    @AfterEach
    void cleanup() {
        calculator = null;
    }

    @Test
    void calculateExpression_shouldReturnCorrectResult() {
        String unit = "mm";
        String expression = "10 cm + 1 m - 10 mm";

        String expectedResult = "1090.0 mm";

        assertEquals(expectedResult, calculator.calculateExpression(unit, expression));
    }

    @Test
    void calculateExpression_shouldThrowException_whenExpressionContainsMultiplication() {
        String unit = "mm";
        String expression = "1 m * 3 cm";

        Executable executable = () -> calculator.calculateExpression(unit, expression);

        assertThrows(IllegalArgumentException.class, executable);
    }

    @Test
    void calculateExpression_shouldThrowException_whenExpressionContainsDivision() {
        String unit = "mm";
        String expression = "1 m / 3 cm";

        Executable executable = () -> calculator.calculateExpression(unit, expression);

        assertThrows(IllegalArgumentException.class, executable);
    }

    @Test
    void calculateExpression_shouldThrowException_whenExpressionContainsPower() {
        String unit = "mm";
        String expression = "1 m ^ 3 cm";

        Executable executable = () -> calculator.calculateExpression(unit, expression);

        assertThrows(IllegalArgumentException.class, executable);
    }

    @ParameterizedTest
    @ValueSource(strings = {"10 cm + 1 m - 50 mm"})
    void calculateExpression_shouldReturnCorrectResultFromGivenValueSource(String first) {
        String expectedResult = "105.0 cm";

        String actualResult = calculator.calculateExpression("cm", first);

        assertEquals(expectedResult, actualResult);
    }
}
