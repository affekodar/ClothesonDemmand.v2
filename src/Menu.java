import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private static final PantsBuilder pantsBuilder = new PantsBuilder();
    private static final SkirtBuilder skirtBuilder = new SkirtBuilder();
    private static final TShirtBuilder tShirtBuilder = new TShirtBuilder();
    private final OrderManager orderManager = OrderManager.getInstance();
    private final ClothingDecoratingPipeline processingPipeline = new ClothingDecoratingPipeline();

    private final Customer customer = new Customer();

    private boolean running = true;

    private static final String mainMenuPrompt = """

            Main Menu

            Which item would you like to customize?

            1. Pants
            2. Skirt
            3. T-Shirt

            4. Show Cart
            5. Place Order

            6. Exit Shop

            Enter Choice:\s""";

    public void startProgram() {
        addCustomerDetails();
        CEO ceo = new CEO();
        orderManager.addObserver(ceo);
        processingPipeline.addCommand(pantsBuilder);
        processingPipeline.addCommand(skirtBuilder);
        processingPipeline.addCommand(tShirtBuilder);

        while (running) {
            System.out.println(mainMenuPrompt);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> processingPipeline.execute(pantsBuilder.buildClothing(orderManager), pantsBuilder, orderManager);
                case 2 -> processingPipeline.execute(skirtBuilder.buildClothing(orderManager), skirtBuilder, orderManager);
                case 3 -> processingPipeline.execute(tShirtBuilder.buildClothing(orderManager), tShirtBuilder, orderManager);
                case 4 -> orderManager.orderToString(orderManager.getOrder());
                case 5 -> orderManager.addOrderWithoutItem();
                case 6 -> running = false;
                default -> System.out.println("Ogiltigt val. Försök igen.");
            }
        }

    }

    private void addCustomerDetails() {
        System.out.println("Welcome to Wigells!");
        System.out.println();
        System.out.println("Add Customer Details");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Adress: ");
        String adress = scanner.nextLine();

        customer.setId();
        customer.setName(name);
        customer.setEmail(email);
        customer.setAdress(adress);
        orderManager.addItemToOrder(customer);
    }


}
