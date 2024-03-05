import java.util.Scanner;

public class TShirtBuilder extends ClothingBuilder {
    private final TShirt tShirt = new TShirt();
    Scanner scanner = new Scanner(System.in);
    private final static String neckPrompt = """
            Choose Neck

            1. 30 cm
            2. 40 cm
            3. 50 cm\s

            Enter choice:\s""";
    private final static String sleevesPrompt = """
            Choose Sleeves

            1. 20 cm
            2. 30 cm
            3. 40 cm

            Enter choice:\s""";

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
    public Clothing buildClothing(OrderManager orderManager) {
        TShirt tShirt;
        TShirtBuilder tShirtBuilder = new TShirtBuilder();
        tShirt = tShirtBuilder.addId().build();
        orderManager.notifyCEOItemStarted(tShirt);
        return tShirt;
    }

    @Override
    public void process(Clothing item, ClothingBuilder builder, OrderManager orderManager) {
        if (builder instanceof TShirtBuilder) {
            chooseMaterial(builder);
            chooseColor(builder);
            chooseSize(builder);
            chooseNeck((TShirtBuilder) builder);
            chooseSleeves((TShirtBuilder) builder);
            item.setPrice(50);
            placeOrder(item, orderManager);
        }
    }

    private void chooseSleeves(TShirtBuilder builder) {
        System.out.println(sleevesPrompt);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> builder.addSleeves(20).build();
            case 2 -> builder.addSleeves(30).build();
            case 3 -> builder.addSleeves(40).build();
        }
    }

    private void chooseNeck(TShirtBuilder builder) {
        System.out.println(neckPrompt);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> builder.addNeck(30).build();
            case 2 -> builder.addNeck(40).build();
            case 3 -> builder.addNeck(50).build();
        }
    }
}
