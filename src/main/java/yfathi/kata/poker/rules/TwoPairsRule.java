package yfathi.kata.poker.rules;

import java.util.Optional;
import java.util.function.Function;
import yfathi.kata.poker.model.Card;
import yfathi.kata.poker.model.HandOutcome;
import yfathi.kata.poker.model.HandRanking;
import yfathi.kata.poker.model.PlayerHand;
import yfathi.kata.poker.utils.ScoreUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Two pairs rule.
 */
public class TwoPairsRule implements Function<PlayerHand, Optional<HandRanking>> {

    @Override
    public Optional<HandRanking> apply(PlayerHand playerHand) {
        final List<Card> cards = playerHand.getCards();
        final Integer firstPair =  ScoreUtils.computeSameValueScore(cards, 2);
        final Integer secondPair =  ScoreUtils.computeSameValueScore(cards.stream().filter(card -> card.getScore()!=firstPair).collect(Collectors.toList()), 2);

        // if 4 cards has same value (fourOfKind Score
        if (!firstPair.equals(0) && !secondPair.equals(0)) {
            var handRanking= new HandRanking(playerHand.getPlayer(),playerHand.getCards());
            // Set Full House
            handRanking.setHandOutcome(HandOutcome.TPR);
            handRanking.setHigherHand(firstPair);
            // Set Higher hand (in case of Tie) and burn
            for (Card card : handRanking.getCards()) {
                if (card.getScore().equals(firstPair)||card.getScore().equals(secondPair)) {
                    card.setFree(false);
                }
            }
            return Optional.of(handRanking);
        }
        return Optional.empty();
    }

}
