package christmas;

public class EventManager {
    public static int applyDdayDiscount(int totalPrice, int orderDate) {
        if(orderDate <= 25) {
            int discount = 1000 + (orderDate - 1) * 100;
            return totalPrice - discount;
        }
        return totalPrice;
    }
}
