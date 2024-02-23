import java.util.List;

public interface OrderObserver {
    public void orderAdded(List<Object> order);
}
