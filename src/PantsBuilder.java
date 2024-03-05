import java.util.Scanner;

public class PantsBuilder extends ClothingBuilder implements ClothingDecoratingCommand {
    private final Pants pants = new Pants();
    Scanner scanner = new Scanner(System.in);
    private final static String fitPrompt = """
            Choose Fit

            1. Tight
            2. Standard
            3. Loose

            Enter choice:\s""";
    private final static String lengthPrompt = """
            Choose Length

            1. 100
            2. 120
            3. 140

            Enter choice:\s""";


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
        orderManager.notifyCEOItemStarted(pants);
//        process(pants, pantsBuilder, orderManager);
        chooseMaterial(pantsBuilder);
        chooseColor(pantsBuilder);
        chooseSize(pantsBuilder);
        chooseFit(pantsBuilder);
        chooseLength(pantsBuilder);
        pants.setPrice(100);
        placeOrder(pants, orderManager);

    }


    @Override
    public Clothing process(Clothing item, ClothingBuilder builder, OrderManager orderManager) {
        if (builder instanceof PantsBuilder) {
            chooseMaterial(builder);
            chooseColor(builder);
            chooseSize(builder);
            chooseFit((PantsBuilder) builder);
            chooseLength((PantsBuilder) builder);
            item.setPrice(100);
            placeOrder(item, orderManager);
        }
        return item;
    }

    private void chooseFit(PantsBuilder builder) {
        System.out.println(fitPrompt);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> builder.addFit("Tight").build();
            case 2 -> builder.addFit("Standard").build();
            case 3 -> builder.addFit("Loose").build();
        }
    }

    private void chooseLength(PantsBuilder builder) {
        System.out.println(lengthPrompt);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> builder.addLength(100).build();
            case 2 -> builder.addLength(120).build();
            case 3 -> builder.addLength(140).build();
        }
    }
}