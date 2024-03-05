import java.util.Scanner;

public abstract class ClothingBuilder extends Menu implements ClothingDecoratingCommand {

    private final static Scanner scanner = new Scanner(System.in);

    private final static String materialMenuPrompt = """

            Material

            Choose Material
            1. Cotton
            2. Linnen

            Enter choice:\s""";
    private final static String colorMenuPrompt = """

            Color

            Choose Color
            1. Blue
            2. Yellow

            Enter choice:\s""";
    private final static String sizeMenuPrompt = """

            Size

            Choose Size
            1. Small
            2. Large

            Enter choice:""";

    private final static String placeOrderPrompt = """

            Do you want to place order?
            1. Yes
            2. No, add item and continue shopping
            3. No, exit shop
            """;


    public void chooseMaterial(ClothingBuilder builder) {
        System.out.println(materialMenuPrompt);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> builder.addMaterial("Cotton").build();
            case 2 -> builder.addMaterial("Linnen").build();
        }
    }

    public void chooseColor(ClothingBuilder builder) {
        System.out.println(sizeMenuPrompt);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> builder.addSize("Small").build();
            case 2 -> builder.addSize("Large").build();
        }
    }

    public void chooseSize(ClothingBuilder builder) {
        System.out.println(colorMenuPrompt);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> builder.addColor("Blue").build();
            case 2 -> builder.addColor("Yellow").build();

        }
    }


    public void placeOrder(Clothing item, OrderManager orderManager) {
        System.out.println(placeOrderPrompt);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> {
                orderManager.addOrder(item);
                System.out.println("Thanks for ordering, your order is being handled! You will get an email when order is processed with your receipt.");
            }
            case 2 -> orderManager.addItemToOrder(item);
            case 3 -> {
                System.out.println("You're exiting the shop, we hope to see you again!");
                System.exit(0);
            }
        }
    }


    public abstract ClothingBuilder addMaterial(String material);

    public abstract ClothingBuilder addId();

    public abstract ClothingBuilder addName(String name);

    public abstract ClothingBuilder addColor(String color);

    public abstract ClothingBuilder addSize(String size);

    public abstract ClothingBuilder addPrice(double price);

    public abstract Clothing build();

    public abstract Clothing buildClothing(OrderManager orderManager);


    public abstract void process(Clothing item, ClothingBuilder builder, OrderManager orderManager);
}
