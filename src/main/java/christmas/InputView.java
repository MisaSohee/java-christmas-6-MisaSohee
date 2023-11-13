package christmas;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputView {
    public int readDate() {
        while (true){
            try {
                System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
                int date = parseDate(Console.readLine());
                validateDate(date);
                return date;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            }
        }
    }

    private int parseDate(String input) {
        try{
            return Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    private static void validateDate(int date) {
        if (date < 1 || date > 31) {
            throw new IllegalArgumentException();
        }
    }

    public String getUserOrderInput() {
        String orderInput = Console.readLine();
        return orderInput;
    }
}
