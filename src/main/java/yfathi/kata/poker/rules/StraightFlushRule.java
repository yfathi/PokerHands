package yfathi.kata.poker.rules;

import yfathi.kata.poker.model.Card;
import yfathi.kata.poker.model.HandOutcome;
import yfathi.kata.poker.model.PlayerHand;
import yfathi.kata.poker.utils.ScoreUtils;

import java.util.List;
import java.util.function.Consumer;

public class StraightFlushRule implements Consumer<PlayerHand> {

    @Override
    public void accept(PlayerHand playerHand) {
        final List<Card> cards = playerHand.getCards();
        if (ScoreUtils.isSameColor(cards) && ScoreUtils.isConsecutive(cards)) {
            // Set Straight Flush
            playerHand.setHandOutcome(HandOutcome.STRFH);
            // Set Higherhand (in case of Tie)
            playerHand.setHigherHand(cards.get(cards.size()-1).getNumber().getScore());
        }
    }
}
