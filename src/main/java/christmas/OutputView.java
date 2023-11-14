package christmas;

import java.util.Map;

public class OutputView {
    public void printEventGuidelines(){
        System.out.println("""
                총주문 금액 10,000원 이상부터 이벤트가 적용됩니다.
                음료만 주문 시, 주문할 수 없습니다.
                메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.
                (e.g. 시저샐러드-1, 티본스테이크-1, 크리스마스파스타-1, 제로콜라-3, 아이스크림-1의 총개수는 7개)
                """);
    }

    public void printMenu(){
        System.out.println("""
                <애피타이저>
                양송이수프(6,000), 타파스(5,500), 시저샐러드(8,000)
                                
                <메인>
                티본스테이크(55,000), 바비큐립(54,000), 해산물파스타(35,000), 크리스마스파스타(25,000)
                                
                <디저트>
                초코케이크(15,000), 아이스크림(5,000)
                                
                <음료>
                제로콜라(3,000), 레드와인(60,000), 샴페인(25,000)
                """);
    }

    public void printMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void requestOrder() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
    }

    public static void printOrder(Map<Menu, Integer> orderMap, int date) {
        System.out.println("12월 " + date + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n");
        System.out.println("<주문 메뉴>");
        for (Menu menu : orderMap.keySet()) {
            Integer quantity = orderMap.get(menu);
            System.out.println(menu.getName() + " " + quantity + "개");
        }
    }

    public static void printTotalOrderPrice(OrderInfo orderInfo) {
        Map<Menu, Integer> orderMap = orderInfo.getOrderMap();
        int totalOrderPrice = OrderInfo.calculateTotalOrderPrice(orderMap);
        System.out.println("<할인 전 총주문 금액>\n" + totalOrderPrice+ "원");
    }
}
