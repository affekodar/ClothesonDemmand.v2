public class Pants extends Clothing {

    private String fit;
    private double length;
    private int id;
    private static int nextId = 1;

    public Pants() {
    }

    public String getFit() {
        return fit;
    }

    public void setFit(String fit) {
        this.fit = fit;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public int getId() {
        return id;
    }

    @Override
    public void setId() {
        this.id = nextId++;
    }

    @Override
    public String toString() {
        return "pants_" +
                "id: " + getId() +
                ", material: " + getMaterial() +
                ", color: " + getColor() +
                ", size: " + getSize() +
                ", fit " + getFit() +
                ", length " + getLength();
    }
}
