import java.util.Scanner;

public class SkirtBuilder extends ClothingBuilder {
    private final Skirt skirt = new Skirt();
    Scanner scanner = new Scanner(System.in);
    private final static String patternPrompt = """
            Choose Pattern

            1. Short
            2. Standard
            3. Long

            Enter choice:\s""";
    private final static String waistlinePrompt = """
            Choose Waistline

            1. 80 cm
            2. 100 cm
            3. 120 cm

            Enter choice:\s""";

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

//        process(skirt, skirtBuilder, orderManager);
            chooseMaterial(skirtBuilder);
            chooseColor(skirtBuilder);
            chooseSize(skirtBuilder);
            chooseWaistline(skirtBuilder);
            choosePattern(skirtBuilder);
            skirt.setPrice(80);
            placeOrder(skirt, orderManager);




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
    public Clothing process(Clothing item, ClothingBuilder builder, OrderManager orderManager) {
        if (builder instanceof SkirtBuilder) {
            chooseMaterial(builder);
            chooseColor(builder);
            chooseSize(builder);
            chooseWaistline((SkirtBuilder) builder);
            choosePattern((SkirtBuilder) builder);
            item.setPrice(80);
            placeOrder(item, orderManager);
        }
        return item;
    }

    private void choosePattern(SkirtBuilder builder) {
        System.out.println(patternPrompt);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> builder.addPattern("Short").build();
            case 2 -> builder.addPattern("Standard").build();
            case 3 -> builder.addPattern("Long").build();
        }
    }

    private void chooseWaistline(SkirtBuilder builder) {
        System.out.println(waistlinePrompt);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> builder.addWaistline(80).build();
            case 2 -> builder.addWaistline(100).build();
            case 3 -> builder.addWaistline(120).build();
        }
    }
}
