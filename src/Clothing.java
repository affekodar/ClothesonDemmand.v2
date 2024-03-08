public abstract class Clothing extends BusinessObject {

    private String material;
    private String color;
    private String size;
    private double price;

    public Clothing() {
    }

    public abstract void setId();


    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract int getId();

    @Override
    public String toString() {
        return "Clothing" +
                "id=" +
                "material=" + material + '\'' +
                ", color=" + color + '\'' +
                ", size=" + size + '\'' +
                ", price=" + price;
    }
}
