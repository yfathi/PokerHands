package yfathi.kata.poker.rules;

import yfathi.kata.poker.model.Card;
import yfathi.kata.poker.model.HandOutcome;
import yfathi.kata.poker.model.PlayerHand;
import yfathi.kata.poker.utils.ScoreUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * The type Pair rule.
 */
public class PairRule implements Consumer<PlayerHand> {

    @Override
    public void accept(PlayerHand playerHand) {
        final List<Card> cards = playerHand.getCards().stream().filter(Card::isFree).collect(Collectors.toList());
        if (cards.size()<2) return;
        final Integer pair =  ScoreUtils.computSameValueScore(cards, 2);

        // if 4 cards has same value (fourOfKind Score
        if (!pair.equals(0) ) {
            // Set Full House
            playerHand.setHandOutcome(HandOutcome.PR);
            playerHand.setHigherHand(pair);
            // Set Higher hand (in case of Tie) and burn
            for (Card card : playerHand.getCards()) {
                if (card.getScore().equals(pair)) {
                    card.setFree(false);
                }
            }
        }
    }

}
