public class TShirt extends Clothing {

    private double sleeves;
    private double neck;
    private int id;
    private static int nextId = 1;


    @Override
    public void setId() {
        this.id = nextId++;
    }

    public TShirt(){}

    public double getSleeves() {
        return sleeves;
    }

    public void setSleeves(double sleeves) {
        this.sleeves = sleeves;
    }

    public double getNeck() {
        return neck;
    }

    public void setNeck(double neck) {
        this.neck = neck;
    }
    @Override
    public int getId() {
        return id;
    }
    @Override
    public String toString() {
        return "t-shirt_" +
                "id: " + getId() +
                ", material: " + getMaterial() +
                ", color: " + getColor() +
                ", size: " + getSize() +
                ", neck: " + getNeck() +
                ", sleeves: " + getSleeves();
    }
}
