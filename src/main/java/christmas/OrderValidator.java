package christmas;

import java.util.HashSet;
import java.util.Set;

public class OrderValidator {
    public static void validateMenuExist(String menuName) {
        try {
            Menu.from(menuName);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public static void validateQuantityRange(int quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public static void validateMaxQuantity(int quantity) {
        if (quantity > 20) {
            throw new IllegalArgumentException("[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다. 다시 입력해 주세요.");
        }
    }

    public static void validateQuantityIsNumber(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public static void validateNoSpaceInInput(String input) {
        if(input.contains(" ")) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public static void validateNoDuplicateMenuNames(String[] orders) {
        Set<String> menuNames = new HashSet<>();

        for (String order : orders) {
            String menuName = order.split("-")[0];
            if (!menuNames.add(menuName)) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }
}
