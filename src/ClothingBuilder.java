import java.util.List;
import java.util.Scanner;

public abstract class ClothingBuilder extends Menu implements ClothingDecoratingCommand{

   private final static Scanner scanner = new Scanner(System.in);

   private final static String materialMenuPrompt = "\nMaterial\n\nChoose Material\n" +
           "1. Cotton\n" +
           "2. Linnen\n\n" +
           "Enter choice: ";
   private final static String colorMenuPrompt = "\nColor\n\nChoose Color\n" +
           "1. Blue\n" +
           "2. Yellow\n\n" +
           "Enter choice: ";
   private final static String sizeMenuPrompt = "\nSize\n\nChoose Size\n" +
           "1. Small\n" +
           "2. Large\n\n" +
           "Enter choice:";

   private final static String placeOrderPrompt = "\nDo you want to place order?\n" +
           "1. Yes\n" +
           "2. No, add item and continue shopping\n" +
           "3. No, exit shop\n";


   public void orderToString(List<Object> order) {
      System.out.println("Shopping Cart");
      System.out.println("Items: " + (order.size() - 1));
      for (Object item : order) {
         System.out.print(item.toString());
      }
      System.out.println();
   }
   public void chooseMaterial(Clothing item, ClothingBuilder builder) {
      System.out.println(materialMenuPrompt);
      int choice = scanner.nextInt();

      switch (choice) {
         case 1 -> {
            item = builder.addMaterial("Cotton").build();
         }
         case 2 -> {
            item = builder.addMaterial("Linnen").build();
         }
      }
   }
   public void chooseColor(Clothing item, ClothingBuilder builder) {
      System.out.println(sizeMenuPrompt);
      int choice = scanner.nextInt();

      switch (choice) {
         case 1 -> {
            item = builder.addSize("Small").build();
         }
         case 2 -> {
            item = builder.addSize("Large").build();
         }
      }
   }

   public void chooseSize(Clothing item, ClothingBuilder builder) {
      System.out.println(colorMenuPrompt);
      int choice = scanner.nextInt();

      switch (choice) {
         case 1 -> {
            item = builder.addColor("Blue").build();
         }
         case 2 -> {
            item = builder.addColor("Yellow").build();
         }
      }
   }


   public void placeOrder(Clothing item, OrderManager orderManager) {
      System.out.println(placeOrderPrompt);
      int choice = scanner.nextInt();

      switch (choice) {
         case 1 -> {
            orderManager.addOrder(item);
            System.out.println("Thanks for ordering, your order is being handled! You will get an email when order is processed with your receipt.");
            setRunning(false);
//            System.exit(0);
         }
         case 2 -> {
            orderManager.addItemToOrder(item);
            setRunning(true);
         }
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
   public abstract void buildClothing(OrderManager orderManager, ClothingBuilder builder);


   public abstract Clothing process(Clothing item, ClothingBuilder builder, OrderManager orderManager);
}
