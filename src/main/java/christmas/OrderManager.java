package christmas;

import java.util.HashMap;
import java.util.Map;

public class OrderManager {
    InputView inputView = new InputView();

    public void manageOrder() {
        String orderInput = inputView.getUserOrderInput();
        String[] orders = orderInput.split(",");

        Map<Menu, Integer> orderMap = new HashMap<>();

        for (String order : orders) {
            String[] details = order.split("-");
            String menuName = details[0];
            String quantitystr = details[1];

            int quantity = Integer.parseInt(quantitystr);
            Menu menu = Menu.from(menuName);
            orderMap.put(menu, quantity);
        }
    }
}
