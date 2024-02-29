import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    private static OrderManager instance;
    private final List<OrderObserver> observers;
    private final List<Object> order;


    private OrderManager() {
        observers = new ArrayList<>();
        order = new ArrayList<>();
    }

    public static OrderManager getInstance() {
        if (instance == null) {
            instance = new OrderManager();
        }
        return instance;
    }

    public void addOrder(Object item) {
        order.add(item);
        System.out.println("Thanks for ordering, your order is being handled! You will get an email when order is processed with your receipt.\n");
        notifyCEOPlacedOrder();
    }

    public void addOrderWithoutItem() {
        System.out.println("Thanks for ordering, your order is being handled! You will get an email when order is processed with your receipt.\n");
        notifyCEOPlacedOrder();
    }
    public void addItemToOrder(Object item) {
        order.add(item);
    }

    public void simulateOrderFinished() {
        notifyCEOFinishedOrder();
        printReceipt();
        System.exit(0);
    }

    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(OrderObserver observer) {
        observers.remove(observer);
    }

    private void notifyCEOPlacedOrder() {

        for (OrderObserver observer : observers) {
            observer.orderAdded(order);
        }
        simulateOrderFinished();
        System.out.println();
    }

    private void notifyCEOFinishedOrder() {
        System.out.println();
        for (OrderObserver observer : observers) {
            observer.orderFinished(order);
        }
        System.out.println();
    }

    public void printReceipt() {
        System.out.println("============== RECEIPT ==============");
        if (order.get(0) instanceof Customer) {
            System.out.println("customer_id: " + ((Customer) order.get(0)).getId() + " Name:" + ((Customer) order.get(0)).getName());
        }
        System.out.println("Items " + (order.size() - 1) + "\t\t\tPrice");
        System.out.println("-------------------------------------");
        double total = 0;
        for (int i = 1; i < order.size(); i++) {
            if (order.get(i) instanceof Pants) {
                System.out.printf("%-15s\t$%.2f\n", "pants_id: " + ((Pants) order.get(i)).getId(), ((Pants) order.get(i)).getPrice());
            } else if (order.get(i) instanceof Skirt) {
                System.out.printf("%-15s\t$%.2f\n", "skirt_id: " + ((Skirt) order.get(i)).getId(), ((Skirt) order.get(i)).getPrice());
            } else if (order.get(i) instanceof TShirt) {
                System.out.printf("%-15s\t$%.2f\n", "t-shirt_id: " + ((TShirt) order.get(i)).getId(), ((TShirt) order.get(i)).getPrice());
            }

            total += ((Clothing) order.get(i)).getPrice();
        }
        System.out.println("-------------------------------------");
        System.out.printf("TOTAL\t\t\t$%.2f\n", total);
        System.out.println("=====================================");
        System.out.println();
        System.out.println();
    }
    public void orderToString(List<Object> order) {
        System.out.println("Shopping Cart");
        System.out.println("Items: " + (order.size() - 1));
        for (Object item : order) {
            System.out.print(item.toString());
        }
        System.out.println();
    }

    public List<Object> getOrder() {
        return order;
    }
}
