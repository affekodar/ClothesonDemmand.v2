import java.util.List;

public interface OrderObserver {
    public void orderAdded(List<Object> order);
    public void orderFinished(List<Object> order);
}
