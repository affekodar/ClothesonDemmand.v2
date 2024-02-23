import java.util.List;
import java.util.Scanner;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);
    private static final PantsBuilder pantsBuilder = new PantsBuilder();
    private static final SkirtBuilder skirtBuilder = new SkirtBuilder();
    private static final TShirtBuilder tShirtBuilder = new TShirtBuilder();
    private final OrderManager orderManager = OrderManager.getInstance();
    private List<Object> order = orderManager.getOrder();

    private static boolean running = true;

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    private static final String mainMenuPrompt = "\nWelcome to Wigells!\n\n" +
            "Which item would you like to customize?\n\n" +
            "1. Pants\n" +
            "2. Skirt\n" +
            "3. T-Shirt\n\n" +
            "Enter Choice: ";

    public void startProgram(){
        Customer customer = addCustomerDetails(new Customer());
        CEO ceo = new CEO();
        orderManager.addObserver(ceo);
        while (running){
            System.out.println(mainMenuPrompt);
            int choice = scanner.nextInt();


            switch (choice) {
                case 1 -> pantsBuilder.buildClothing(order);
                case 2 -> skirtBuilder.buildClothing(order);
                case 3 -> tShirtBuilder.buildClothing(order);
                case 4 -> running = false;
                default -> System.out.println("Ogiltigt val. Försök igen.");
            }
        }
//        orderManager.getOrder().add(customer);
        orderManager.addToOrder(customer);
    }

    private Customer addCustomerDetails(Customer customer) {
        System.out.println("Customer Details");
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
        System.out.println(customer.toString());
        return customer;
    }


}
