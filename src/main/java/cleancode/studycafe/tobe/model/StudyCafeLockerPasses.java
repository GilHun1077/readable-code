package cleancode.studycafe.tobe.model;

import java.util.List;

import static cleancode.studycafe.tobe.model.StudyCafePassType.*;

public class StudyCafeLockerPasses {

    private static final List<StudyCafeLockerPass> lockerPasses = List.of(
            StudyCafeLockerPass.of(FIXED, 4, 10000),
            StudyCafeLockerPass.of(FIXED, 12, 30000)
    );

    public static StudyCafeLockerPass getLockerPassFrom(StudyCafePassType passType, int duration) {
        return lockerPasses.stream()
                .filter(option ->
                        option.getPassType() == passType
                                && option.getDuration() == duration
                )
                .findFirst()
                .orElse(null);
    }
}
