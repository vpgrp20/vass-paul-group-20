package week6;

public class TaskWeek6 {
    public static void main(String[] args) {
        MetricCalculator calculator = new MetricCalculator();
        calculator.calculateExpression("mm","10 cm + 1 m - 10 mm");
        calculator.calculateExpression("km","100 m + 10 m - 1 m");
    }
}
