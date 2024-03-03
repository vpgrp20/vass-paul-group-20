package week4;

public class GalaxyS23 extends Samsung {
    private final String IMEI;
    private final Color color;
    private final Material material = Material.PLASTIC;
    private int batteryLife;

    public GalaxyS23(String IMEI, Color color) {
        super(10);
        this.IMEI = IMEI;
        this.color = color;
    }
}
