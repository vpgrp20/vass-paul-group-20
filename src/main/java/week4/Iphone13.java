package week4;

public class Iphone13 extends Apple {
    private final String IMEI;
    private final Color color;
    private final Material material = Material.STEEL;
    private int batteryLife;

    public Iphone13(String IMEI, Color color) {
        super(14);
        this.IMEI = IMEI;
        this.color = color;
    }
}
