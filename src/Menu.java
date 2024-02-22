import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private PantsBuilder pantsBuilder = new PantsBuilder();
    private SkirtBuilder skirtBuilder = new SkirtBuilder();
    private TShirtBuilder tShirtBuilder = new TShirtBuilder();
    private OrderManager orderManager = OrderManager.getInstance();
    ClothingBuilder clothingBuilder;
    boolean running = true;

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

    public void mainMenu(){
        while (running){
            System.out.println(mainMenuPrompt);
            int choice = scanner.nextInt();


            switch (choice) {
                case 1 -> pantsBuilder.buildClothing(orderManager);
                case 2 -> skirtBuilder.buildClothing(orderManager);
                case 3 -> tShirtBuilder.buildClothing(orderManager);
                default -> System.out.println("Ogiltigt val. Försök igen.");
            }
        }

    }


}
