public class PantsBuilder extends ClothingBuilder{
    private Pants pants = new Pants();


    public PantsBuilder addFit(String fit) {
        pants.setFit(fit);
        return this;
    }
    public PantsBuilder addLength(double length) {
        pants.setLength(length);
        return this;
    }

    @Override
    public PantsBuilder addMaterial(String material) {
        pants.setMaterial(material);
        return this;
    }

    @Override
    public PantsBuilder addId() {
        pants.setId();
        return this;
    }

    @Override
    public PantsBuilder addName(String name) {
        pants.setName(name);
        return this;
    }

    @Override
    public PantsBuilder addColor(String color) {
        pants.setColor(color);
        return this;
    }

    @Override
    public PantsBuilder addSize(String size) {
        pants.setSize(size);
        return this;
    }

    @Override
    public PantsBuilder addPrice(double price) {
        pants.setPrice(price);
        return this;
    }

    @Override
    public Pants build() {
        return pants;
    }

    @Override
    public void buildClothing(OrderManager orderManager) {
        Pants pants;
        PantsBuilder pantsBuilder = new PantsBuilder();
        pants = pantsBuilder.addId().build();

        chooseMaterial(pants, pantsBuilder);
        chooseColor(pants, pantsBuilder);
        chooseSize(pants, pantsBuilder);
        confirmItem(pants, orderManager);

    }


}
