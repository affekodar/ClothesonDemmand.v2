import java.util.List;

public interface OrderObserver {
    void orderAdded(List<Object> order);

    void orderFinished(List<Object> order);
}
