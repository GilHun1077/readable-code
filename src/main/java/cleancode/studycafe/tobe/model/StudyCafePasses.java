package cleancode.studycafe.tobe.model;

import java.util.List;

import static cleancode.studycafe.tobe.model.StudyCafePassType.*;

public class StudyCafePasses {

    private static final List<StudyCafePass> studyCafePasses = List.of(
            StudyCafePass.of(HOURLY, 2, 4000, 0.0),
            StudyCafePass.of(HOURLY, 4, 6500, 0.0),
            StudyCafePass.of(HOURLY, 6, 9000, 0.0),
            StudyCafePass.of(HOURLY, 8, 11000, 0.0),
            StudyCafePass.of(HOURLY, 10, 12000, 0.0),
            StudyCafePass.of(HOURLY, 12, 13000, 0.0),
            StudyCafePass.of(WEEKLY, 1, 60000, 0.0),
            StudyCafePass.of(WEEKLY, 2, 100000, 0.1),
            StudyCafePass.of(WEEKLY, 3, 130000, 0.1),
            StudyCafePass.of(WEEKLY, 4, 150000, 0.1),
            StudyCafePass.of(WEEKLY, 12, 400000, 0.15),
            StudyCafePass.of(FIXED, 4, 250000, 0.1),
            StudyCafePass.of(FIXED, 12, 700000, 0.15)
    );


    public List<StudyCafePass> selectStudyCafePassesFrom(StudyCafePassType studyCafePassType) {
        return studyCafePasses.stream()
                .filter(studyCafePass -> studyCafePass.getPassType() == studyCafePassType)
                .toList();
    }
}
