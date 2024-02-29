import java.util.List;

public class CEO implements OrderObserver {
    private static final int id = 1;

    public CEO() {
    }

    @Override
    public void orderAdded(List<Object> order) {
        System.out.println("CEO notified - New order placed and the team has started production" + order.toString());
        System.out.println();
    }

    @Override
    public void orderFinished(List<Object> order) {
        System.out.println("CEO notified - Order for" + order.get(0).toString() + "is now ready to be shipped!");
    }

}
