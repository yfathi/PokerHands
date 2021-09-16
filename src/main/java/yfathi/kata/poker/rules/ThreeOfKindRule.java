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
 * The type Three of kind rule.
 */
public class ThreeOfKindRule implements Function<PlayerHand, Optional<HandRanking>> {

    @Override
    public Optional<HandRanking> apply(PlayerHand playerHand) {
        final List<Card> cards = playerHand.getCards();

        final Integer threeOfKind = ScoreUtils.computeSameValueScore(cards, 3);

        // if 4 cards has same value (threeOfKind Score
        if (!threeOfKind.equals(0)) {
            var handRanking= new HandRanking(playerHand.getPlayer(),playerHand.getCards());
            // Set Four of Kind
            handRanking.setHandOutcome(HandOutcome.TK);
            handRanking.setHigherHand(threeOfKind);
            // Set Higher hand (in case of Tie) and burn
            for (Card card : handRanking.getCards()) {
                if (card.getScore().equals(threeOfKind)) {
                    card.setFree(false);
                }
            }
            return Optional.of(handRanking);
        }
        return Optional.empty();
    }
}
