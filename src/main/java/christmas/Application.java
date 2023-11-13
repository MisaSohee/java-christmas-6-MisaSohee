package christmas;

import java.util.Map;

public class Application {
    public static void main(String[] args) {

        OutputView outputView = new OutputView();
        outputView.printEventGuidelines();
        outputView.printMenu();
        outputView.printMessage();

        InputView inputView = new InputView();
        int date = inputView.readDate();

        outputView.requestOrder();

        Map<Menu, Integer> orderMap = OrderManager.manageOrder();
        OutputView.printOrder(orderMap);
    }
}
