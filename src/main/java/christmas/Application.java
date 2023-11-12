package christmas;

public class Application {
    public static void main(String[] args) {

        OutputView outputView = new OutputView();
        outputView.printMenu();
        outputView.printMessage();

        InputView inputView = new InputView();
        int date = inputView.readDate();
    }
}
