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

public class TwoPairsRule implements Consumer<PlayerHand> {

    @Override
    public void accept(PlayerHand playerHand) {
        final List<Card> cards = playerHand.getCards().stream().filter(Card::isFree).collect(Collectors.toList());
        if (cards.size()<2) return;
        final Map<Integer, Integer> countMap = new HashMap<>();
        final Integer firstPair =  ScoreUtils.computSameValueScore(cards, 2);
        final Integer secondPair =  ScoreUtils.computSameValueScore(cards.stream().filter(card -> card.getScore()!=firstPair).collect(Collectors.toList()), 2);

        // if 4 cards has same value (fourOfKind Score
        if (!firstPair.equals(0) && !secondPair.equals(0)) {
            // Set Full House
            playerHand.setHandOutcome(HandOutcome.TPR);
            playerHand.setHigherHand(firstPair);
            // Set Higher hand (in case of Tie) and burn
            for (Card card : playerHand.getCards()) {
                if (card.getScore().equals(firstPair)||card.getScore().equals(secondPair)) {
                    card.setFree(false);
                }
            }
        }
    }

}
