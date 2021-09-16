package yfathi.kata.poker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import yfathi.kata.poker.model.HandOutcome;
import yfathi.kata.poker.service.GameEngine;
import yfathi.kata.poker.service.GameInputReaderDefault;
import yfathi.kata.poker.service.GameRankingCalculatorDefault;


public class PokerTest {

    GameEngine ge;

    @BeforeEach
    void prepare(){
         ge =new GameEngine(new GameRankingCalculatorDefault(), new GameInputReaderDefault());
    }


    @Test
    void should_black_win_with_straight_flush_over_a_two_pair()  {
        ge.play("Black: 2H 3H 4H 5H 6H ,White: 3S 5C 5H 3D 7H");
        assertNotNull(ge.getCurrentWinner());
        assertEquals("Black",ge.getCurrentWinner().getPlayer());
        assertEquals(HandOutcome.STRFH,ge.getCurrentWinner().getHandOutcome());
    }

    @Test
    void should_white_win_with_straight_flush_tie_with_higher_card(){

        ge.play("Black: 2H 3H 4H 5H 6H ,White: 3H 4H 5H 6H 7H");
        assertNotNull(ge.getCurrentWinner());
        assertEquals("White",ge.getCurrentWinner().getPlayer());
        assertEquals(HandOutcome.STRFH,ge.getCurrentWinner().getHandOutcome());
    }
    @Test
    void should_tie_when_both_have_same_score(){

        ge.play("Black: 2H 3H 4H 5H 6H ,White: 2C 3C 4C 5C 6C");
        assertNull(ge.getCurrentWinner());

    }

    @Test
    void should_black_win_with_four_of_kind_over_a_two_pair()  {
        ge.play("Black: 2H 2C 2D 2S 6H ,White: 3H 5C 5S 3S 7H");
        assertNotNull(ge.getCurrentWinner());
        assertEquals("Black",ge.getCurrentWinner().getPlayer());
        assertEquals(HandOutcome.FOK,ge.getCurrentWinner().getHandOutcome());

    }
    @Test
    void should_white_win_with_highest_four_of_kind(){

        ge.play("Black: 2H 2C 2D 2S 6H ,White: 3H 3C 3S 3D 7H");
        assertNotNull(ge.getCurrentWinner());
        assertEquals("White",ge.getCurrentWinner().getPlayer());
    }

    @Test
    void should_black_win_with_full_house_over_a_two_pair()  {

        ge.play("Black: 3H 3D 3S 5H 5C ,White: 3H 5C 5H 3S 7D");
        assertNotNull(ge.getCurrentWinner());
        assertEquals(HandOutcome.FH,ge.getCurrentWinner().getHandOutcome());
        assertEquals("Black",ge.getCurrentWinner().getPlayer());

    }
    @Test
    void should_black_win_with_flush_over_a_pair()  {
        ge.play("Black: 2H 5H 3H TH 6H ,White: 3H 9C 5H 3S 7D");
        assertNotNull(ge.getCurrentWinner());
        assertEquals(HandOutcome.FLS,ge.getCurrentWinner().getHandOutcome());
        assertEquals("Black",ge.getCurrentWinner().getPlayer());

        ge.play("Black: 2H 5H 3H TH 6H ,White: 3C 5C 5C 3C KC");
        assertNotNull(ge.getCurrentWinner());
        assertEquals(HandOutcome.FLS,ge.getCurrentWinner().getHandOutcome());
        assertEquals("White",ge.getCurrentWinner().getPlayer());
    }

    @Test
    void should_white_win_with_highest_flush()  {
        ge.play("Black: 2H 5H 3H TH 6H ,White: 3C 5C 5C 3C KC");
        assertNotNull(ge.getCurrentWinner());
        assertEquals(HandOutcome.FLS,ge.getCurrentWinner().getHandOutcome());
        assertEquals("White",ge.getCurrentWinner().getPlayer());
    }

    @Test
    void should_black_win_with_straight_over_a_pair()  {
        ge.play("Black: 2H 3D 4C 5S 6H ,White: 3H 5C 5H 9S 7D");
        assertNotNull(ge.getCurrentWinner());
        assertEquals(HandOutcome.STR,ge.getCurrentWinner().getHandOutcome());

        assertEquals("Black",ge.getCurrentWinner().getPlayer());
        
        
    }
    @Test
    void should_black_win_with_three_of_kind_over_a_pair()  {
        ge.play("Black: 2H 2C 2D 5D 6H ,White: 6H 5C 5H 3S 7D");
        assertNotNull(ge.getCurrentWinner());
        assertEquals(HandOutcome.TK, ge.getCurrentWinner().getHandOutcome());
        assertEquals("Black",ge.getCurrentWinner().getPlayer());

        ge.play("Black: 2H 2C 2D 5D 6H ,White: 3H 3C 5H 3S 7D");
        assertNotNull(ge.getCurrentWinner());
        assertEquals(HandOutcome.TK, ge.getCurrentWinner().getHandOutcome());
        assertEquals("White",ge.getCurrentWinner().getPlayer());
    }

    @Test
    void should_white_win_the_three_of_a_kind_tie_with_high_card()  {

        ge.play("Black: 2H 2C 2D 5D 6H ,White: 3H 3C 5H 3S 7D");
        assertNotNull(ge.getCurrentWinner());
        assertEquals(HandOutcome.TK, ge.getCurrentWinner().getHandOutcome());
        assertEquals("White",ge.getCurrentWinner().getPlayer());
    }
    @Test
    void should_black_win_with_two_pair_over_a_pair()  {
        ge.play("Black: KH KD 4H 3C 3H ,White: 3H 5C 5H 3S 7D");
        assertNotNull(ge.getCurrentWinner());
        assertEquals(HandOutcome.TPR, ge.getCurrentWinner().getHandOutcome());

        assertEquals("Black",ge.getCurrentWinner().getPlayer());


    }
    @Test
    void should_white_win_higher_two_pair()  {

        ge.play("Black: 2H 2D 4H 3C 3H ,White: 3H 5C 5H 3S 7D");
        assertNotNull(ge.getCurrentWinner());
        assertEquals(HandOutcome.TPR, ge.getCurrentWinner().getHandOutcome());

        assertEquals("White",ge.getCurrentWinner().getPlayer());
    }
    @Test
    void should_white_win_the_two_pair_tie_with_high_card()  {
        ge.play("Black: 2H 2D TH 3C 3H ,White: 3H 2C 2H 3S 7D");
        assertNotNull(ge.getCurrentWinner());
        assertEquals(HandOutcome.TPR, ge.getCurrentWinner().getHandOutcome());
        assertEquals("Black",ge.getCurrentWinner().getPlayer());
    }

    @Test
    void should_black_win_with_pair()  {
        ge.play("Black: KH 2D KH 5C 6H ,White: 3H 4C 5H 3S 7D");
        assertNotNull(ge.getCurrentWinner());
        assertEquals(HandOutcome.PR, ge.getCurrentWinner().getHandOutcome());
        assertEquals("Black",ge.getCurrentWinner().getPlayer());
    }

    @Test
    void should_withe_win_with_higher_pair()  {

        ge.play("Black: 4H 2D 4D 5C 6H ,White: 5H 4C 5H 3S 7D");
        assertNotNull(ge.getCurrentWinner());
        assertEquals(HandOutcome.PR, ge.getCurrentWinner().getHandOutcome());
        assertEquals("White",ge.getCurrentWinner().getPlayer());

    }

    @Test
    void should_black_win_the_pair_tie_with_high_card()  {

        ge.play("Black: 4H 2D 4D 5C 6H ,White: 4H 4D 2H 5S 3D");
        assertNotNull(ge.getCurrentWinner());
        assertEquals(HandOutcome.PR, ge.getCurrentWinner().getHandOutcome());
        assertEquals("Black",ge.getCurrentWinner().getPlayer());
    }
    @Test
    void should_white_win_with_high_card()  {
        ge.play("Black: KH 3D 4H 5S 6H ,White: AH 6C 5H 2S 7D");
        assertNotNull(ge.getCurrentWinner());
        assertEquals(HandOutcome.HC, ge.getCurrentWinner().getHandOutcome());

        assertEquals("White",ge.getCurrentWinner().getPlayer());


    }
    @Test
    void should_black_win_with_higher_card()  {

        ge.play("Black: KH 3D 4H 5S 6H ,White: TH 6C 5H 2S 7D");
        assertNotNull(ge.getCurrentWinner());
        assertEquals(HandOutcome.HC, ge.getCurrentWinner().getHandOutcome());

        assertEquals("Black",ge.getCurrentWinner().getPlayer());
    }

    @Test
    void should_white_win_with_higher_card()  {
        ge.play("Black: KH 3D 4H 5S 6H ,White: AH 6C 5H 2S 7D");
        assertNotNull(ge.getCurrentWinner());
        assertEquals(HandOutcome.HC, ge.getCurrentWinner().getHandOutcome());

        assertEquals("White",ge.getCurrentWinner().getPlayer());

    }

}
