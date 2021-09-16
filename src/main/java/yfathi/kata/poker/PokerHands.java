package yfathi.kata.poker;

import yfathi.kata.poker.service.GameEngine;
import yfathi.kata.poker.service.GameInputReaderDefault;
import yfathi.kata.poker.service.GameRankingCalculatorDefault;

/**
 * The type Poker hands.
 */
public class PokerHands {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        GameEngine ge =new GameEngine(new GameRankingCalculatorDefault(), new GameInputReaderDefault());

        ge.play("Black: 2H 2H 2H 2C 6H ,White: 3H 2H 5H 6H 7H");

        System.out.println("Winner is " + ge.getCurrentWinner().getPlayer());
        System.out.println("with is " + ge.getCurrentWinner().getHandOutcome());
    }
}
