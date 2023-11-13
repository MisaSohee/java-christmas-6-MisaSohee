package christmas;

public class OrderValidator {
    public static void validateMenuExist(String menuName) {
        try {
            Menu.from(menuName);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public static void validateQuantityRange(int quantity) {
        if (quantity < 1 || quantity > 20) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
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


}
