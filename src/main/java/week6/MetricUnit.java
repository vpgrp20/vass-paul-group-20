package week6;

public class MetricUnit {

    private String unitName;
    private double unitValue;

    public MetricUnit(String unitName) {
        parseUnit(unitName);
    }

    private void parseUnit(String unit) {
        String[] parts = unit.split(" ");
        this.unitValue = Double.parseDouble(parts[0]);
        this.unitName = parts[1];
    }

    public double toMm() {
        return switch (unitName) {
            case "mm" -> unitValue;
            case "cm" -> (double) 10 * unitValue;
            case "dm" -> (double) 100 * unitValue;
            case "m" -> (double) 1000 * unitValue;
            case "km" -> (double) 1_000_000 * unitValue;
            default -> 0.0;
        };
    }

    public double toCm() {
        return switch (unitName) {
            case "mm" -> 0.1 * unitValue;
            case "cm" -> unitValue;
            case "dm" -> (double) 10 * unitValue;
            case "m" -> (double) 100 * unitValue;
            case "km" -> (double) 100_000 * unitValue;
            default -> 0.0;
        };
    }

    public double toDm() {
        return switch (unitName) {
            case "mm" -> 0.01 * unitValue;
            case "cm" -> 0.1 * unitValue;
            case "dm" -> unitValue;
            case "m" -> (double) 10 * unitValue;
            case "km" -> (double) 10_000 * unitValue;
            default -> 0.0;
        };
    }

    public double toM() {
        return switch (unitName) {
            case "mm" -> 0.001 * unitValue;
            case "cm" -> 0.01 * unitValue;
            case "dm" -> 0.1 * unitValue;
            case "m" -> unitValue;
            case "km" -> (double) 1000 * unitValue;
            default -> 0.0;
        };
    }

    public double toKm() {
        return switch (unitName) {
            case "mm" -> ((double) 1 / 1_000_000) * unitValue;
            case "cm" -> ((double) 1 / 100_000) * unitValue;
            case "dm" -> ((double) 1 / 10_000) * unitValue;
            case "m" -> ((double) 1 / 1000) * unitValue;
            case "km" -> unitValue;
            default -> 0.0;
        };
    }

    @Override
    public String toString() {
        return "MetricUnit{" +
                "unitName='" + unitName + '\'' +
                ", unitValue=" + unitValue +
                '}';
    }
}
