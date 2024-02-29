public class Skirt extends Clothing {
    private double waistline;
    private String pattern;
    private int id;
    private static int nextId = 1;

    @Override
    public void setId() {
        this.id = nextId++;
    }

    @Override
    public int getId() {
        return id;
    }

    public Skirt(){}

    public double getWaistline() {
        return waistline;
    }

    public void setWaistline(double waistline) {
        this.waistline = waistline;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
    public String toString() {
        return "skirt_" +
                "id: " + getId()+
                ", material: " + getMaterial() +
                ", color: " + getColor() +
                ", size: " + getSize() +
                ", waistline: " + getWaistline() +
                ", pattern: " + getPattern();
    }
}
