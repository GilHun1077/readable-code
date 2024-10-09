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
            updateStudyCafeLockerPassAt(studyCafePass);

            outputHandler.showPassOrderSummary(studyCafePass);
        } catch (AppException e) {
            outputHandler.showSimpleMessage(e.getMessage());
        } catch (Exception e) {
            outputHandler.showSimpleMessage("알 수 없는 오류가 발생했습니다.");
        }
    }

    private StudyCafePass selectStudyCafePassFrom(StudyCafePassType studyCafePassType) {
        List<StudyCafePass> studyCafePassCandidates = StudyCafePasses.selectStudyCafePassesFrom(studyCafePassType);

        outputHandler.showPassListForSelection(studyCafePassCandidates);
        return inputHandler.getSelectPass(studyCafePassCandidates);
    }

    private void updateStudyCafeLockerPassAt(StudyCafePass studyCafePass) {
        if (studyCafePass.doesLockerUsable()) {
            outputHandler.askLockerPass(studyCafePass.getLockerPass());
            StudyCafeLockerPassType lockerPassType = inputHandler.getLockerPassTypeSelectingUserAction();
            studyCafePass.updateLockerPassType(lockerPassType);
        }
    }

}
