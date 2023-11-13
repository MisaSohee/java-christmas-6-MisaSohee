package christmas;

public class OrderValidator {
    public static void validateMenuName(String menuName) {
        try {
            Menu.from(menuName);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 메뉴판에 없는 메뉴입니다. 다시 입력해 주세요.");
        }
    }
}
