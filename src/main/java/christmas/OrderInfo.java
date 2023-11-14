package christmas;

import java.util.Map;

public class OrderInfo {
    private int visitDate;
    private Map<Menu, Integer> orderMap;

    public OrderInfo(int visitDate, Map<Menu, Integer> orderMap) {
        this.visitDate = visitDate;
        this.orderMap = orderMap;
    }

    public int getVisitDate() {
        return visitDate;
    }

    public Map<Menu, Integer> getOrderMap() {
        return orderMap;
    }

    public static int calculateTotalOrderPrice(Map<Menu, Integer> orderMap) {
        int totalOrderPrice = 0;
        for (Map.Entry<Menu, Integer> entry : orderMap.entrySet()) {
            Menu menu = entry.getKey();
            int quantity = entry.getValue();
            totalOrderPrice += menu.getPrice() * quantity;
        }
        return totalOrderPrice;
    }
}
