package cleancode.studycafe.tobe;

import cleancode.studycafe.tobe.exception.AppException;
import cleancode.studycafe.tobe.io.InputHandler;
import cleancode.studycafe.tobe.io.OutputHandler;
import cleancode.studycafe.tobe.model.*;

import java.util.List;

public class StudyCafePassMachine {

    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();

    public void run() {
        try {
            outputHandler.showWelcomeMessage();
            outputHandler.showAnnouncement();

            outputHandler.askPassTypeSelection();
            StudyCafePassType studyCafePassType = inputHandler.getPassTypeSelectingUserAction();

            StudyCafePass studyCafePass = selectStudyCafePassFrom(studyCafePassType);

            StudyCafeLockerPass lockerPass = studyCafePass.getLockerPass();
            if (lockerPass != null) {
                outputHandler.askLockerPass(lockerPass);
                if (inputHandler.doesUserNotUsingLocker()) {
                    lockerPass = null;
                }
            }
            outputHandler.showPassOrderSummary(studyCafePass, lockerPass);

        } catch (AppException e) {
            outputHandler.showSimpleMessage(e.getMessage());
        } catch (Exception e) {
            outputHandler.showSimpleMessage("알 수 없는 오류가 발생했습니다.");
        }
    }

    private StudyCafePass selectStudyCafePassFrom(StudyCafePassType studyCafePassType) {
        StudyCafePasses studyCafePasses = new StudyCafePasses();
        List<StudyCafePass> studyCafePassCandidates = studyCafePasses.selectStudyCafePassesFrom(studyCafePassType);

        outputHandler.showPassListForSelection(studyCafePassCandidates);
        return inputHandler.getSelectPass(studyCafePassCandidates);
    }

}
