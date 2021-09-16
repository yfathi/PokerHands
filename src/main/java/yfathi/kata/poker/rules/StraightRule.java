package yfathi.kata.poker.rules;

import java.util.Optional;
import java.util.function.Function;
import yfathi.kata.poker.model.Card;
import yfathi.kata.poker.model.HandOutcome;
import yfathi.kata.poker.model.HandRanking;
import yfathi.kata.poker.model.PlayerHand;
import yfathi.kata.poker.utils.ScoreUtils;

import java.util.List;

/**
 * The type Straight rule.
 */
public class StraightRule implements Function<PlayerHand, Optional<HandRanking>> {

@Override
public Optional<HandRanking> apply(PlayerHand playerHand) {
        final List<Card> cards = playerHand.getCards();

        if (ScoreUtils.isConsecutive(cards)) {
            var handRanking= new HandRanking(playerHand.getPlayer(),playerHand.getCards());
            // Set Straight
            handRanking.setHandOutcome(HandOutcome.STR);
            // Set Higherhand (in case of Tie)
            handRanking.setHigherHand(cards.get(cards.size()-1).getNumber().getScore());
            // Burn All the cards
            handRanking.getCards().forEach(card -> card.setFree(false));
            return Optional.of(handRanking);
        }
        return Optional.empty();
    }
}
