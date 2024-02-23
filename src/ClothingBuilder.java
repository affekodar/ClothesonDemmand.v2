import java.util.List;
import java.util.Scanner;

public abstract class ClothingBuilder extends Menu{

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
   private final static String confirmOrderPrompt =
           "1. Add item to cart and continue shopping\n" +
           "2. Add item and show cart\n" +
           "3. Add item and place order\n";


   public void orderToString(List<Object> order) {
      System.out.println("Shopping Cart");
      System.out.println("Items: " + order.size());
      for (Object item : order) {
         System.out.println(item.toString());
      }
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

   public void confirmItem(Clothing item, List<Object> order) {
      System.out.println(confirmOrderPrompt);
      int choice = scanner.nextInt();

      switch (choice) {
         case 1 -> {
            order.add(item);
         }
         case 2 -> {
            order.add(item);
            orderToString(order);
         }
         case 3 -> {
            order.add(item);
            setRunning(false);
         }
      }
   }

   private void placeOrder(List<Object> order) {

   }

   public abstract ClothingBuilder addMaterial(String material);
   public abstract ClothingBuilder addId();
   public abstract ClothingBuilder addName(String name);
   public abstract ClothingBuilder addColor(String color);
   public abstract ClothingBuilder addSize(String size);
   public abstract ClothingBuilder addPrice(double price);
   public abstract Clothing build();
   public abstract void buildClothing(List<Object> order);


}
