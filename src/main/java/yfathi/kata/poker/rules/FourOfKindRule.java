package yfathi.kata.poker.rules;

import java.util.function.Function;
import yfathi.kata.poker.model.Card;
import yfathi.kata.poker.model.HandOutcome;
import yfathi.kata.poker.model.HandRanking;
import yfathi.kata.poker.model.PlayerHand;
import yfathi.kata.poker.utils.ScoreUtils;

import java.util.*;

/**
 * The type Four of kind rule.
 */
public class FourOfKindRule implements Function<PlayerHand, Optional<HandRanking>> {

    @Override
    public Optional<HandRanking> apply(PlayerHand playerHand) {
        final var cards = playerHand.getCards();

        final Integer fourOfKind = ScoreUtils.computeSameValueScore(cards, 4);
        // if 4 cards has same value (fourOfKind Score
        if (!fourOfKind.equals(0)) {
            var handRanking= new HandRanking(playerHand.getPlayer(),playerHand.getCards());
            // Set Four of Kind
            handRanking.setHandOutcome(HandOutcome.FOK);
            handRanking.setHigherHand(fourOfKind);
            // Set Higher hand (in case of Tie) and burn
            for (Card card : handRanking.getCards()) {
                if (card.getScore().equals(fourOfKind)) {
                    card.setFree(false);
                }
            }
            return Optional.of(handRanking);
        }
        return Optional.empty();
    }
}
