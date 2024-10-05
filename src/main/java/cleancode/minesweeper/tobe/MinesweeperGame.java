package cleancode.minesweeper.tobe;

import cleancode.minesweeper.tobe.gamelevel.*;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MinesweeperGame {

    public static void main(String[] args) {
        GameLevel gameLevel = new Beginner();

        Minesweeper minesweeper = new Minesweeper(gameLevel);
        minesweeper.run();
    }

}
