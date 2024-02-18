package week4;

public class GalaxyS24 extends Samsung {
    private final String IMEI;
    private final Color color;
    private final Material material = Material.ALUMINUM;
    private int batteryLife;

    public GalaxyS24(String IMEI, Color color) {
        super(12);
        this.IMEI = IMEI;
        this.color = color;
    }
}
