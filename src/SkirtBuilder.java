public class SkirtBuilder extends ClothingBuilder {
    private final Skirt skirt = new Skirt();

    @Override
    public SkirtBuilder addMaterial(String material) {
        skirt.setMaterial(material);
        return this;
    }

    @Override
    public SkirtBuilder addId() {
        skirt.setId();
        return this;
    }

    @Override
    public SkirtBuilder addName(String name) {
        skirt.setName(name);
        return this;
    }

    @Override
    public SkirtBuilder addColor(String color) {
        skirt.setColor(color);
        return this;
    }

    @Override
    public SkirtBuilder addSize(String size) {
        skirt.setSize(size);
        return this;
    }

    @Override
    public SkirtBuilder addPrice(double price) {
        skirt.setPrice(price);
        return this;
    }

    public SkirtBuilder addWaistline(double waistline) {
        skirt.setWaistline(waistline);
        return this;
    }

    public SkirtBuilder addPattern(String pattern) {
        skirt.setPattern(pattern);
        return this;
    }

    @Override
    public Skirt build() {
        return skirt;
    }

    @Override
    public void buildClothing(OrderManager orderManager) {
        Skirt skirt;
        SkirtBuilder skirtBuilder = new SkirtBuilder();
        skirt = skirtBuilder.addId().build();
        orderManager.notifyCEOItemStarted(skirt);
        chooseMaterial(skirtBuilder);
        chooseColor(skirtBuilder);
        chooseSize(skirtBuilder);
        commandProcess(skirt);
        skirtBuilder.addPrice(80).build();
        placeOrder(skirtBuilder, orderManager);
    }

}
