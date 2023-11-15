package christmas;

public class OrderService {
    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();

    public void runService() {
        outputView.printEventGuidelines();
        outputView.printMenu();
        outputView.printMessage();

        int date = inputView.readDate();
        outputView.requestOrder();

        OrderInfo orderInfo = OrderManager.manageOrder(date);
        outputView.printOrder(orderInfo.getOrderMap(), date);
        outputView.printTotalOrderPrice(orderInfo);

        EventDetail eventDetail = EventManager.calculateEventDetails(orderInfo);
        outputView.printGiftMenu(eventDetail);
        outputView.printEvents(eventDetail);
        outputView.printTotalBenefit(eventDetail);
        outputView.printExpectedPayment(orderInfo,eventDetail);
        outputView.printBadge(eventDetail);
    }
}
