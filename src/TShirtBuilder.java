import java.util.List;
import java.util.Scanner;

public class TShirtBuilder extends ClothingBuilder {
    private final TShirt tShirt = new TShirt();
    Scanner scanner = new Scanner(System.in);
    private final static String neckPrompt = "Choose Pattern\n\n" +
            "1. 30 cm\n" +
            "2. 40 cm\n" +
            "3. 50 cm \n\n" +
            "Enter choice: ";
    private final static String sleevesPrompt = "Choose Waistline\n\n" +
            "1. 20 cm\n" +
            "2. 30 cm\n" +
            "3. 40 cm\n\n" +
            "Enter choice: ";

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
    public void buildClothing(OrderManager orderManager, ClothingBuilder tShirtBuilder) {
        TShirt tShirt;
        tShirt = (TShirt) tShirtBuilder.addId().build();
        process(tShirt, tShirtBuilder, orderManager);
    }

    @Override
    public Clothing process(Clothing item, ClothingBuilder builder, OrderManager orderManager) {
        if (builder instanceof TShirtBuilder) {
            chooseMaterial(item, builder);
            chooseColor(item, builder);
            chooseSize(item, builder);
            chooseNeck(item, builder);
            chooseSleeves(item, builder);
            placeOrder(item, orderManager);
            item.setPrice(50);
        }
        return item;
    }

    private void chooseSleeves(Clothing item, ClothingBuilder builder) {
        System.out.println(sleevesPrompt);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> item = addSleeves(20).build();
            case 2 -> item = addSleeves(30).build();
            case 3 -> item = addSleeves(40).build();
        }
    }

    private void chooseNeck(Clothing item, ClothingBuilder builder) {
        System.out.println(neckPrompt);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> item = addNeck(30).build();
            case 2 -> item = addNeck(40).build();
            case 3 -> item = addNeck(50).build();
        }
    }
}
