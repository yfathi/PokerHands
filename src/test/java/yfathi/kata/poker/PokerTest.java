package yfathi.kata.poker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import yfathi.kata.poker.model.HandOutcome;
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
        Assertions.assertNotNull(ge.getCurrentWinner());
        Assertions.assertEquals("Black",ge.getCurrentWinner().getPlayer());
        Assertions.assertEquals(HandOutcome.STRFH,ge.getCurrentWinner().getHandOutcome());
        System.out.println("Winner is " + ge.getCurrentWinner().getPlayer());
        System.out.println("with  " + ge.getCurrentWinner().getHandOutcome());

        ge.play("Black: 2H 3H 4H 5H 6H ,White: 3H 4H 5H 6H 7H");
        Assertions.assertNotNull(ge.getCurrentWinner());
        Assertions.assertEquals("White",ge.getCurrentWinner().getPlayer());
        Assertions.assertEquals(HandOutcome.STRFH,ge.getCurrentWinner().getHandOutcome());
        System.out.println("Winner is " + ge.getCurrentWinner().getPlayer());
        System.out.println("with  " + ge.getCurrentWinner().getHandOutcome());
    }

    @Test
    void testTie()  {
        ge.play("Black: 2H 3H 4H 5H 6H ,White: 2C 3C 4C 5C 6C");
        Assertions.assertNull(ge.getCurrentWinner());
    }
    @Test
    void testFourOfKind()  {
        ge.play("Black: 2H 2C 2D 2S 6H ,White: 3H 5C 5S 3S 7H");
        Assertions.assertNotNull(ge.getCurrentWinner());
        Assertions.assertEquals("Black",ge.getCurrentWinner().getPlayer());
        Assertions.assertEquals(HandOutcome.FOK,ge.getCurrentWinner().getHandOutcome());
        System.out.println("Winner is " + ge.getCurrentWinner().getPlayer());
        System.out.println("with " + ge.getCurrentWinner().getHandOutcome());

        ge.play("Black: 2H 2C 2D 2S 6H ,White: 3H 3C 3S 3D 7H");
        Assertions.assertNotNull(ge.getCurrentWinner());
        Assertions.assertEquals("White",ge.getCurrentWinner().getPlayer());
        System.out.println("Winner is " + ge.getCurrentWinner().getPlayer());
        System.out.println("with " + ge.getCurrentWinner().getHandOutcome());
    }

    @Test
    void testFullHouse()  {
        ge.play("Black: 3H 3D 3S 5H 5C ,White: 3H 5C 5H 3S 7D");
        Assertions.assertNotNull(ge.getCurrentWinner());
        Assertions.assertEquals(HandOutcome.FH,ge.getCurrentWinner().getHandOutcome());
        Assertions.assertEquals("Black",ge.getCurrentWinner().getPlayer());
        System.out.println("Winner is " + ge.getCurrentWinner().getPlayer());
        System.out.println("with " + ge.getCurrentWinner().getHandOutcome());
    }
    @Test
    void testFlush()  {
        ge.play("Black: 2H 5H 3H TH 6H ,White: 3H 5C 5H 3S 7D");
        Assertions.assertNotNull(ge.getCurrentWinner());
        Assertions.assertEquals(HandOutcome.FLS,ge.getCurrentWinner().getHandOutcome());
        Assertions.assertEquals("Black",ge.getCurrentWinner().getPlayer());

        ge.play("Black: 2H 5H 3H TH 6H ,White: 3C 5C 5C 3C KC");
        Assertions.assertNotNull(ge.getCurrentWinner());
        Assertions.assertEquals(HandOutcome.FLS,ge.getCurrentWinner().getHandOutcome());
        Assertions.assertEquals("White",ge.getCurrentWinner().getPlayer());
    }
    @Test
    void testStraight()  {
        ge.play("Black: 2H 3D 4C 5S 6H ,White: 3H 5C 5H 3S 7D");
        Assertions.assertNotNull(ge.getCurrentWinner());
        Assertions.assertEquals(HandOutcome.STR,ge.getCurrentWinner().getHandOutcome());

        Assertions.assertEquals("Black",ge.getCurrentWinner().getPlayer());
        System.out.println("Winner is " + ge.getCurrentWinner().getPlayer());
        System.out.println("with  " + ge.getCurrentWinner().getHandOutcome());
    }
    @Test
    void testThreeOfKind()  {
        ge.play("Black: 2H 2C 2D 5D 6H ,White: 3H 5C 5H 3S 7D");
        Assertions.assertNotNull(ge.getCurrentWinner());
        Assertions.assertEquals(HandOutcome.TK, ge.getCurrentWinner().getHandOutcome());
        Assertions.assertEquals("Black",ge.getCurrentWinner().getPlayer());

        ge.play("Black: 2H 2C 2D 5D 6H ,White: 3H 3C 5H 3S 7D");
        Assertions.assertNotNull(ge.getCurrentWinner());
        Assertions.assertEquals(HandOutcome.TK, ge.getCurrentWinner().getHandOutcome());
        Assertions.assertEquals("White",ge.getCurrentWinner().getPlayer());
    }
    @Test
    void testTwoPairs()  {
        ge.play("Black: 2H 2D 4H 3C 3H ,White: 3H 5C 5H 3S 7D");
        Assertions.assertNotNull(ge.getCurrentWinner());
        Assertions.assertEquals(HandOutcome.TPR, ge.getCurrentWinner().getHandOutcome());

        Assertions.assertEquals("Black",ge.getCurrentWinner().getPlayer());
    }

    @Test
    void testPair()  {
        ge.play("Black: 2H 2D 4H 5C 6H ,White: 3H 5C 5H 3S 7D");
        Assertions.assertNotNull(ge.getCurrentWinner());
        Assertions.assertEquals(HandOutcome.PR, ge.getCurrentWinner().getHandOutcome());

        Assertions.assertEquals("Black",ge.getCurrentWinner().getPlayer());
    }
    @Test
    void testHighCard()  {
        ge.play("Black: KH 3D 4H 5S 6H ,White: 3H 5C 5H 3S 7D");
        Assertions.assertNotNull(ge.getCurrentWinner());
        Assertions.assertEquals(HandOutcome.HC, ge.getCurrentWinner().getHandOutcome());

        Assertions.assertEquals("Black",ge.getCurrentWinner().getPlayer());
    }

}
