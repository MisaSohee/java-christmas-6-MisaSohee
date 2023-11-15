package christmas;

import java.util.HashMap;
import java.util.Map;

public class OrderManager {
    public static OrderInfo manageOrder(int visitDate) {
        Map<Menu, Integer> orderMap;
        try {
            orderMap = OrderProcessor.processOrders();
            OrderValidator.validateOrder(orderMap);
            checkEventParticipant(orderMap);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return manageOrder(visitDate);
        }
        return new OrderInfo(visitDate, orderMap);
    }

    private static void checkEventParticipant(Map<Menu, Integer> orderMap) {
        int totalOrderPrice = OrderInfo.calculateTotalOrderPrice(orderMap);
        if (totalOrderPrice >= 10000) {
            EventParticipantManager.increaseParticipantCount();
        }
    }
}
