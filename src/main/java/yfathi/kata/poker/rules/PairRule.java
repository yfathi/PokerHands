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
 * The type Pair rule.
 */
public class PairRule implements Function<PlayerHand, Optional<HandRanking>> {

@Override
public Optional<HandRanking> apply(PlayerHand playerHand) {
        final List<Card> cards = playerHand.getCards();

        final Integer pair =  ScoreUtils.computeSameValueScore(cards, 2);

        // if 4 cards has same value (fourOfKind Score
        if (!pair.equals(0) ) {
            var handRanking= new HandRanking(playerHand.getPlayer(),playerHand.getCards());
            // Set Full House
            handRanking.setHandOutcome(HandOutcome.PR);
            handRanking.setHigherHand(pair);
            // Set Higher hand (in case of Tie) and burn
            for (Card card : handRanking.getCards()) {
                if (card.getScore().equals(pair)) {
                    card.setFree(false);
                }
            }
            return Optional.of(handRanking);
        }
        return Optional.empty();
    }

}
