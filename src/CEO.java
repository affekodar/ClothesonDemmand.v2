import java.util.List;

public class CEO implements OrderObserver{
    private static final int id = 1;
    public CEO() {
    }

    @Override
    public void orderAdded(List<Object> order) {
        System.out.println("CEO notified: New order added - ");
    }
}
