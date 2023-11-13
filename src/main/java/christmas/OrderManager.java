package christmas;

import org.junit.jupiter.api.Order;
import org.mockito.internal.matchers.Or;

import java.util.HashMap;
import java.util.Map;

public class OrderManager {
    InputView inputView = new InputView();

    public void manageOrder() {
        String orderInput = inputView.getUserOrderInput();

        OrderValidator.validateNoSpaceInInput(orderInput);

        String[] orders = orderInput.split(",");

        OrderValidator.validateNoDuplicateMenuNames(orders);

        Map<Menu, Integer> orderMap = new HashMap<>();

        for (String order : orders) {
            String[] details = order.split("-");
            String menuName = details[0];
            String quantityStr = details[1];

            OrderValidator.validateMenuExist(menuName);
            OrderValidator.validateQuantityIsNumber(quantityStr);
            OrderValidator.validateQuantityRange(Integer.parseInt(quantityStr));
            OrderValidator.validateMaxQuantity(Integer.parseInt(quantityStr));

            int quantity = Integer.parseInt(quantityStr);

            Menu menu = Menu.from(menuName);
            orderMap.put(menu, quantity);
        }

        OrderValidator.validateNotOnlyDrinks(orderMap);
    }
}
