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

        OrderInfo orderInfo = OrderManager.manageOrder(date);
        Map<Menu, Integer> orderMap = orderInfo.getOrderMap();
        OutputView.printOrder(orderMap, date);

        OutputView.printTotalOrderPrice(orderInfo);

        EventDetail eventDetail = EventManager.calculateEventDetails(orderInfo);
        OutputView.printGiftMenu(eventDetail);

        OutputView.printEvents(eventDetail);

        OutputView.printTotalBenefit(eventDetail);

        OutputView.printExpectedPayment(orderInfo,eventDetail);
    }
}
