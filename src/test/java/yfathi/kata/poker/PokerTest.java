package yfathi.kata.poker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import yfathi.kata.poker.service.GameEngine;


public class PokerTest {

    GameEngine ge;

    @BeforeEach
    void prepare(){
         ge =new GameEngine();
    }

    @Test
    void testStraightFlush()  {
        ge.play("Black: 2H 3H 4H 5H 6H ,White: 3S 5C 5H 3D 7H");
        Assertions.assertEquals("Black",ge.getCurrentWinner().getPlayer());
    }

    @Test
    void testTie()  {
        ge.play("Black: 2H 3H 4H 5H 6H ,White: 2C 3C 4C 5C 6C");
        Assertions.assertNull(ge.getCurrentWinner());
    }
    @Test
    void testFourOfKind()  {
        ge.play("Black: 2H 2C 2D 2S 6H ,White: 3H 5C 5S 3S 7H");
        Assertions.assertEquals("Black",ge.getCurrentWinner().getPlayer());
    }

    @Test
    void testFullHouse()  {
        ge.play("Black: 3H 3D 3S 5H 5C ,White: 3H 5C 5H 3S 7D");
        Assertions.assertEquals("Black",ge.getCurrentWinner().getPlayer());
    }
    @Test
    void testFlush()  {
        ge.play("Black: 2H 5H 3H TH 6H ,White: 3H 5C 5H 3S 7D");
        Assertions.assertEquals("Black",ge.getCurrentWinner().getPlayer());
    }
    @Test
    void testStraight()  {
        ge.play("Black: 2H 3D 4C 5S 6H ,White: 3H 5C 5H 3S 7D");
        Assertions.assertEquals("Black",ge.getCurrentWinner().getPlayer());
    }
    @Test
    void testThreeOfKind()  {
        ge.play("Black: 2H 2C 2D 5D 6H ,White: 3H 5C 5H 3S 7D");
        Assertions.assertEquals("Black",ge.getCurrentWinner().getPlayer());
    }
    @Test
    void testTwoPairs()  {
        ge.play("Black: 2H 2D 4H 5C 6H ,White: 3H 5C 5H 3S 7D");
        Assertions.assertEquals("Black",ge.getCurrentWinner().getPlayer());
    }
    @Test
    void testHighCard()  {
        ge.play("Black: KH 3D 4H 5S 6H ,White: 3H 5C 5H 3S 7D");
        Assertions.assertEquals("Black",ge.getCurrentWinner().getPlayer());
    }

}
