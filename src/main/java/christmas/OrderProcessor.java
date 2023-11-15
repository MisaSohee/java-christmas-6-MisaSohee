package christmas;

import java.util.HashMap;
import java.util.Map;

public class OrderProcessor {
    public static Map<Menu, Integer> processOrders() {
        Map<Menu, Integer> orderMap = new HashMap<>();
        String[] orders = getOrderInput();
        for (String order : orders) {
            processOrderItem(order, orderMap);
        }
        return orderMap;
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

    private static void processOrderItem(String order, Map<Menu, Integer> orderMap) {
        validateOrderItem(order);

        String menuName = getMenuNameFromOrderItem(order);
        int quantity = getQuantityFromOrderItem(order);

        Menu menu = Menu.from(menuName);
        orderMap.put(menu, quantity);
    }

    private static void validateOrderItem(String order) {
        OrderValidator.validateOrderFormat(order);

        String[] details = order.split("-");
        String menuName = details[0];
        String quantityStr = details[1];

        OrderValidator.validateMenuExist(menuName);
        OrderValidator.validateQuantityIsNumber(quantityStr);
        OrderValidator.validateQuantityRange(Integer.parseInt(quantityStr));
    }

    private static String getMenuNameFromOrderItem(String order) {
        return order.split("-")[0];
    }

    private static int getQuantityFromOrderItem(String order) {
        return Integer.parseInt(order.split("-")[1]);
    }
}
