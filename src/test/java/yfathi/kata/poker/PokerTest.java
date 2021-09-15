package yfathi.kata.poker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import yfathi.kata.poker.service.GameEngine;

import java.util.List;

public class PokerTest {

    GameEngine ge;

    @BeforeEach
    void prepare(){
         ge =new GameEngine();
    }

    @Test
    void testStraightFlush()  {
        ge.play("Black: 2H 3H 4H 5H 6H ,White: 3H 5C 5H 3H 7H");
        Assertions.assertEquals("Black",ge.getCurrentWinner().getPlayer());
    }

}
