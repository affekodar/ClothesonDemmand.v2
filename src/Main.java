public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();

        menu.mainMenu();
        System.out.println(OrderManager.getInstance().getOrder());
    }
}
