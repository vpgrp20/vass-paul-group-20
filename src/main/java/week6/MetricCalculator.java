package week6;

import java.util.ArrayList;
import java.util.List;

public class MetricCalculator {

    public String calculateExpression(String output, String expression) {
        if (expression.contains("*") || expression.contains("/") || expression.contains("^")) {
            throw new IllegalArgumentException("Only ADDITION and SUBTRACTION operations are allowed");
        }

        final String[] parts = expression.split("([+\\-])");
        List<MetricUnit> unitList = getList(parts);

        final List<Double> values = unitList.stream()
                .map(unit -> convertUnit(unit, output))
                .toList();
        String[] operations = getOperationsArray(expression);

        String result = calculateDistance(values, operations) + " " + output;
        System.out.println(result);
        return result;
    }

    public Double convertUnit(MetricUnit unit, String outputUnit) {
        return switch (outputUnit) {
            case "mm" -> unit.toMm();
            case "cm" -> unit.toCm();
            case "dm" -> unit.toDm();
            case "m" -> unit.toM();
            case "km" -> unit.toKm();
            default -> 0.0;
        };
    }

    public List<MetricUnit> getList(String[] parts) {
        List<MetricUnit> unitList = new ArrayList<>();
        for (String part : parts) {
            unitList.add(new MetricUnit(part.trim()));
        }
        return unitList;
    }

    public String[] getOperationsArray(String expression) {
        List<String> operations = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            String s = String.valueOf(expression.charAt(i));
            if (s.equals("+") || s.equals("-")) {
                operations.add(s);
            }
        }

        String[] result = new String[operations.size()];
        operations.toArray(result);
        return result;
    }

    public double calculateDistance(List<Double> values, String[] operations) {
        double result = values.get(0);
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].equals("+")) {
                result += values.get(i + 1);
            } else if (operations[i].equals("-")) {
                result -= values.get(i + 1);
            }
        }
        return result;
    }
}
