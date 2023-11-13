package christmas;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

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

    public static int applyWeekendDiscount(int totalPrice, int orderDate, int numberOfMainDishes) {
        LocalDate date = LocalDate.of(2023, 12, orderDate);
        DayOfWeek dayOfWeek = date.getDayOfWeek();

        if (dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY) {
            int discount = 2023 * numberOfMainDishes;
            return totalPrice - discount;
        }
        return totalPrice;
    }

    public static int applySpecialDiscount(int totalPrice, int orderDate) {
        List<Integer> specialDays = Arrays.asList(3, 10, 17, 24, 25, 31);

        if (specialDays.contains(orderDate)) {
            return totalPrice - 1000;
        }
        return totalPrice;
    }

    public static boolean isEligibleForGift(int totalPriceBeforeDiscount) {
        final int GIFT_THRESHOLD = 120000;

        return totalPriceBeforeDiscount >= GIFT_THRESHOLD;
    }
}
