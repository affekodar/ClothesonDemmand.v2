public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();

        menu.startProgram();
        System.out.println(OrderManager.getInstance().getOrder());
    }
}
