package cleancode.minesweeper.tobe.user;

public enum UserAction {

    OPEN("셀 열기"),
    FLAG("깃발 꽃기"),
    UNKNOWN("잘못된 입력")
    ;

    private final String description;

    UserAction(String description) {
        this.description = description;
    }
}
