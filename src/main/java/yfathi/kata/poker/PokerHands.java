package yfathi.kata.poker;

import yfathi.kata.poker.service.GameEngine;

public class PokerHands {

    public static void main(String[] args) {
        GameEngine ge =new GameEngine();

        ge.play("Black: 2H 3H 4H 5H 6H ,White: 3H 4H 5H 6H 7H");

        System.out.println("Winner is " + ge.getCurrentWinner().getPlayer());
        System.out.println("with is " + ge.getCurrentWinner().getHandOutcome());
    }
}
