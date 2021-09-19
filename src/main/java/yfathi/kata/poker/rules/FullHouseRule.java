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
 * The type Full house rule.
 */
public class FullHouseRule implements Function<PlayerHand, Optional<HandRanking>> {

    @Override
    public Optional<HandRanking> apply(PlayerHand playerHand) {
        final List<Card> cards = playerHand.getCards();

        final Integer threeOfKind =  ScoreUtils.computeSameValueScore(cards, 3);
        final Integer pairValue= ScoreUtils.computeSameValueScore(cards.stream().filter(card -> card.getScore()!= threeOfKind).collect(Collectors.toList()), 2);

        // if 4 cards has same value (fourOfKind Score
        if (!threeOfKind.equals(0) && !pairValue.equals(0)) {
            var handRanking= new HandRanking(playerHand.getPlayer(),playerHand.getCards());
            // Set Full House
            handRanking.setHandOutcome(HandOutcome.FH);
            handRanking.setHigherHand(threeOfKind);
            // Set Higher hand (in case of Tie) and burn
            for (Card card : handRanking.getCards()) {
                        card.setFree(false);
            }
            return Optional.of(handRanking);
        }
        return  Optional.empty();
    }

}
