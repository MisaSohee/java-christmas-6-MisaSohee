package christmas;

public class Application {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        orderService.runService();
    }
}
