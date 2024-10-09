package cleancode.studycafe.tobe.model;

public enum StudyCafeLockerPassType {
    USABLE("사용가능"),
    UNUSABLE("사용불가"),
    USE("사용"),
    NOT_USE("미사용"),
    ;

    private final String description;

    StudyCafeLockerPassType(String description) {
        this.description = description;
    }
}
