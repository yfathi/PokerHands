package yfathi.kata.poker.rules;

import yfathi.kata.poker.model.Card;
import yfathi.kata.poker.model.HandOutcome;
import yfathi.kata.poker.model.PlayerHand;
import yfathi.kata.poker.utils.ScoreUtils;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class StraightRule implements Consumer<PlayerHand> {

    @Override
    public void accept(PlayerHand playerHand) {
        final List<Card> cards = playerHand.getCards().stream().filter(Card::isFree).collect(Collectors.toList());
        if (cards.size()<2) return;

        if (ScoreUtils.isConsecutive(cards)) {
            // Set Straight
            playerHand.setHandOutcome(HandOutcome.STR);
            // Set Higherhand (in case of Tie)
            playerHand.setHigherHand(cards.get(cards.size()-1).getNumber().getScore());
            // Burn All the cards
            playerHand.getCards().forEach(card -> card.setFree(false));
        }
    }
}
