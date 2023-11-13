package christmas;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class EventManager {
    public static int applyDdayDiscount(int totalPrice, int orderDate) {
        if(orderDate <= 25) {
            int discount = 1000 + (orderDate - 1) * 100;
            return totalPrice - discount;
        }
        return totalPrice;
    }

    public static int applyWeekdayDiscount(int totalPrice, int orderDate, int numberOfDesserts) {
        LocalDate date = LocalDate.of(2023, 12, orderDate);
        DayOfWeek dayOfWeek = date.getDayOfWeek();

        if (dayOfWeek != DayOfWeek.FRIDAY && dayOfWeek != DayOfWeek.SATURDAY) {
            int discount = 2023 * numberOfDesserts;
            return totalPrice - discount;
        }
        return totalPrice;
    }
}
