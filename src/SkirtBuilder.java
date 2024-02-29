import java.util.Scanner;

public class SkirtBuilder extends ClothingBuilder {
    private final Skirt skirt = new Skirt();
    Scanner scanner = new Scanner(System.in);
    private final static String patternPrompt = "Choose Pattern\n\n" +
            "1. Short\n" +
            "2. Standard\n" +
            "3. Long\n\n" +
            "Enter choice: ";
    private final static String waistlinePrompt = "Choose Waistline\n\n" +
            "1. 80 cm\n" +
            "2. 100 cm\n" +
            "3. 120 cm\n\n" +
            "Enter choice: ";

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
    public void buildClothing(OrderManager orderManager, ClothingBuilder skirtBuilder) {
        Skirt skirt;
        skirt = (Skirt) skirtBuilder.addId().build();
        process(skirt, skirtBuilder, orderManager);
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
            chooseMaterial(item, builder);
            chooseColor(item, builder);
            chooseSize(item, builder);
            chooseWaistline(item, builder);
            choosePattern(item, builder);
            item.setPrice(80);
            placeOrder(item, orderManager);
        }
        return item;
    }

    private void choosePattern(Clothing item, ClothingBuilder builder) {
        System.out.println(patternPrompt);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> item = addPattern("Short").build();
            case 2 -> item = addPattern("Standard").build();
            case 3 -> item = addPattern("Long").build();
        }
    }

    private void chooseWaistline(Clothing item, ClothingBuilder builder) {
        System.out.println(waistlinePrompt);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> item = addWaistline(80).build();
            case 2 -> item = addWaistline(100).build();
            case 3 -> item = addWaistline(120).build();
        }
    }
}
