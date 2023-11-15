package christmas;

import java.util.HashMap;
import java.util.Map;

public class OrderManager {
    public static OrderInfo manageOrder(int visitDate) {
        Map<Menu, Integer> orderMap = new HashMap<>();
        try {
            processOrders(orderMap);
            validateOrder(orderMap);
            checkEventParticipant(orderMap);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return manageOrder(visitDate);
        }
        return new OrderInfo(visitDate, orderMap);
    }

    private static void processOrders(Map<Menu, Integer> orderMap) {
        String[] orders = getOrderInput();
        for (String order : orders) {
            processOrderItem(order, orderMap);
        }
    }

    private static String[] getOrderInput() {
        String orderInput = InputView.getUserOrderInput();
        return parseOrderInput(orderInput);
    }

    public static String[] parseOrderInput(String orderInput) {
        OrderValidator.validateNoSpaceInInput(orderInput);
        String[] orders = orderInput.split(",");
        OrderValidator.validateNoDuplicateMenuNames(orders);
        return orders;
    }

    private static void validateOrder(Map<Menu, Integer> orderMap) {
        OrderValidator.validateTotalMaxQuantity(orderMap);
        OrderValidator.validateNotOnlyDrinks(orderMap);
    }

    private static void processOrderItem(String order, Map<Menu, Integer> orderMap) {
        OrderValidator.validateOrderFormat(order);

        String[] details = order.split("-");
        String menuName = details[0];
        String quantityStr = details[1];

        OrderValidator.validateMenuExist(menuName);
        OrderValidator.validateQuantityIsNumber(quantityStr);
        OrderValidator.validateQuantityRange(Integer.parseInt(quantityStr));

        int quantity = Integer.parseInt(quantityStr);

        Menu menu = Menu.from(menuName);
        orderMap.put(menu, quantity);
    }

    private static void checkEventParticipant(Map<Menu, Integer> orderMap) {
        int totalOrderPrice = OrderInfo.calculateTotalOrderPrice(orderMap);
        if (totalOrderPrice >= 10000) {
            EventParticipantManager.increaseParticipantCount();
        }
    }
}
