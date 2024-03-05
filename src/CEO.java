import java.util.List;

public class CEO implements OrderObserver {

    public CEO() {
    }

    @Override
    public void itemStarted(Clothing item) {
        if (item instanceof Pants) {
            System.out.println("CEO notified - New pants are being produced");
        } else if (item instanceof Skirt) {
            System.out.println("CEO notified - New skirt is being produced");
        } else if (item instanceof TShirt) {
            System.out.println("CEO notified - New T-Shirt is being produced");
        }
    }

    @Override
    public void orderAdded(List<BusinessObject> order) {
        System.out.println("CEO notified - New order placed and the team has started production" + order.toString());
        System.out.println();
    }

    @Override
    public void orderFinished(List<BusinessObject> order) {
        System.out.println("CEO notified - Order for" + order.get(0).toString() + "is now ready to be shipped!");
    }

}
