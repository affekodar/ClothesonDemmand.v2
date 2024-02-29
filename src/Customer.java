import java.util.ArrayList;
import java.util.List;

public class Customer extends BusinessObject {
    private String adress, email;
    private int id;
    private static int nextId = 1;
    private List<Object> items = new ArrayList<>();

    public void setId(int id) {
        this.id = id;
    }

    public List<Object> getItems() {
        return items;
    }

    public void setItems(List<Object> items) {
        this.items = items;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = nextId++;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Customer.nextId = nextId;
    }


    public Customer() {
    }

    @Override
    public String toString() {
        return "\nCustomer " +
                "name: " + getName() +
                ", adress: " + adress +
                ", email: " + email +
                ", id: " + id + "\n";
    }
}
