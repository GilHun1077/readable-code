package cleancode.studycafe.tobe.model;

public class StudyCafePass {

    private final StudyCafePassType passType;
    private final int duration;
    private final int price;
    private final double discountRate;

    private StudyCafeLockerPassType lockerPassType;

    private StudyCafePass(StudyCafePassType passType, int duration, int price, double discountRate, StudyCafeLockerPassType lockerPassType) {
        this.passType = passType;
        this.duration = duration;
        this.price = price;
        this.discountRate = discountRate;
        this.lockerPassType = lockerPassType;
    }

    public static StudyCafePass of(StudyCafePassType passType, int duration, int price, double discountRate, StudyCafeLockerPassType lockerPassType) {
        return new StudyCafePass(passType, duration, price, discountRate, lockerPassType);
    }

    public int calculateDiscountPrice() {
        return (int) (getPrice() * getDiscountRate());
    }

    public int calculateTotalPrice() {
        int lockerPrice = 0;
        if (doesLockerUse()) {
            lockerPrice = getLockerPass().getPrice();
        }
        return getPrice() - calculateDiscountPrice() + lockerPrice;
    }

    public void updateLockerPassType(StudyCafeLockerPassType lockerPassType) {
        this.lockerPassType = lockerPassType;
    }

    public boolean doesLockerUsable() {
        return lockerPassType == StudyCafeLockerPassType.USABLE;
    }

    public boolean doesLockerUse() {
        return lockerPassType == StudyCafeLockerPassType.USE;
    }

    public boolean hasDiscountPrice() {
        return calculateDiscountPrice() > 0;
    }

    public StudyCafePassType getPassType() {
        return passType;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public String display() {
        if (passType == StudyCafePassType.HOURLY) {
            return String.format("%s시간권 - %,d원", duration, price);
        }
        if (passType == StudyCafePassType.WEEKLY) {
            return String.format("%s주권 - %,d원", duration, price);
        }
        if (passType == StudyCafePassType.FIXED) {
            return String.format("%s주권 - %,d원", duration, price);
        }
        return "";
    }

    public StudyCafeLockerPass getLockerPass() {
        return StudyCafeLockerPasses.getLockerPassFrom(passType, duration);
    }

    public String getLockerPassInfo() {
        return getLockerPass().display();
    }

    private int getPrice() {
        return price;
    }
}
