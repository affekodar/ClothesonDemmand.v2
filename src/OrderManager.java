import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    private static OrderManager instance;
    private List<OrderObserver> observers;
    private List<Object> order;





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
    public void addToOrder(Object item) {
        order.add(item);
        notifyObservers();
    }

    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }
    public void removeObserver(OrderObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.orderAdded(order);
        }
    }

    public List<Object> getOrder() {
        return order;
    }
}
