import java.util.Scanner;

public class PantsBuilder extends ClothingBuilder implements ClothingDecoratingCommand{
    private final Pants pants = new Pants();
    Scanner scanner = new Scanner(System.in);
    private final static String fitPrompt = "Choose Fit\n\n" +
            "1. Tight\n" +
            "2. Standard\n" +
            "3. Loose\n\n" +
            "Enter choice: ";
    private final static String lengthPrompt = "Choose Length\n\n" +
            "1. 100\n" +
            "2. 120\n" +
            "3. 140\n\n" +
            "Enter choice: ";


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
    public void buildClothing(OrderManager orderManager, ClothingBuilder pantsBuilder) {
        Pants pants;
        pants = (Pants) pantsBuilder.addId().build();
        process(pants, pantsBuilder, orderManager);
    }



    @Override
    public Clothing process(Clothing item, ClothingBuilder builder, OrderManager orderManager) {
        if (builder instanceof PantsBuilder) {
            chooseMaterial(item, builder);
            chooseColor(item, builder);
            chooseSize(item, builder);
            chooseFit(item, builder);
            chooseLength(item, builder);
            placeOrder(item, orderManager);
            item.setPrice(100);
        }
        return item;
    }

    private void chooseFit(Clothing item, ClothingBuilder builder) {
        System.out.println(fitPrompt);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> item = addFit("Tight").build();
            case 2 -> item = addFit("Standard").build();
            case 3 -> item = addFit("Loose").build();
        }
    }

    private void chooseLength(Clothing item, ClothingBuilder builder) {
        System.out.println(lengthPrompt);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> item = addLength(100).build();
            case 2 -> item = addLength(120).build();
            case 3 -> item = addLength(140).build();
        }
    }
}