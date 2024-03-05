import java.util.List;

public interface OrderObserver {
    void itemStarted(Clothing item);

    void orderAdded(List<BusinessObject> order);

    void orderFinished(List<BusinessObject> order);
}
