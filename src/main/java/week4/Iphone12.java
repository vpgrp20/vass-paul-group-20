package week4;

public class Iphone12 extends Apple {
    private final String IMEI;
    private final Color color;
    private final Material material = Material.GLASS;
    private int batteryLife;

    public Iphone12(String IMEI, Color color) {
        super(11);
        this.IMEI = IMEI;
        this.color = color;
    }
}
