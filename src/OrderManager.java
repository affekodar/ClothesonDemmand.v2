import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    private static OrderManager instance;
    private List<Clothing> order;
    private OrderManager() {
        order = new ArrayList<>();
    }
    public static OrderManager getInstance() {
        if (instance == null) {
            instance = new OrderManager();
        }
        return instance;
    }
    public void addToOrder(Clothing clothing) {
        order.add(clothing);
    }
    public List<Clothing> getOrder() {
        return order;
    }
}
