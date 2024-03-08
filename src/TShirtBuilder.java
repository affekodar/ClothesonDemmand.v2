public class TShirtBuilder extends ClothingBuilder {
    private final TShirt tShirt = new TShirt();

    @Override
    public TShirtBuilder addMaterial(String material) {
        tShirt.setMaterial(material);
        return this;
    }

    @Override
    public TShirtBuilder addId() {
        tShirt.setId();
        return this;
    }

    @Override
    public TShirtBuilder addName(String name) {
        tShirt.setName(name);
        return this;
    }

    @Override
    public TShirtBuilder addColor(String color) {
        tShirt.setColor(color);
        return this;
    }

    @Override
    public TShirtBuilder addSize(String size) {
        tShirt.setSize(size);
        return this;
    }

    @Override
    public TShirtBuilder addPrice(double price) {
        tShirt.setPrice(price);
        return this;
    }

    public TShirtBuilder addSleeves(double sleeves) {
        tShirt.setSleeves(sleeves);
        return this;
    }

    public TShirtBuilder addNeck(double neck) {
        tShirt.setNeck(neck);
        return this;
    }

    @Override
    public TShirt build() {
        return tShirt;
    }

    @Override
    public void buildClothing(OrderManager orderManager) {
        TShirt tShirt;
        TShirtBuilder tShirtBuilder = new TShirtBuilder();
        tShirt = tShirtBuilder.addId().build();
        orderManager.notifyCEOItemStarted(tShirt);
        chooseMaterial(tShirtBuilder);
        chooseColor(tShirtBuilder);
        chooseSize(tShirtBuilder);
        commandProcess(tShirt);
        tShirtBuilder.addPrice(50).build();
        placeOrder(tShirtBuilder, orderManager);
    }
}
