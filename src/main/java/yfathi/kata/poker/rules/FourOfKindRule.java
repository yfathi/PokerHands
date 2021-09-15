package yfathi.kata.poker.rules;

import yfathi.kata.poker.model.Card;
import yfathi.kata.poker.model.HandOutcome;
import yfathi.kata.poker.model.PlayerHand;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class FourOfKindRule implements Consumer<PlayerHand> {

    @Override
    public void accept(PlayerHand playerHand) {
        final List<Card> cards = playerHand.getCards().stream().filter(Card::isFree).collect(Collectors.toList());
        final Map<Integer, Integer> countMap = new HashMap<>();
        Integer fourOfKind = 0;

        for (Card card : cards) {
            final Integer score = card.getScore();
            if (countMap.containsKey(score)) {
                if (countMap.get(score).equals(2)) {
                    fourOfKind = score;
                }
                countMap.put(score, countMap.get(score )+1);
            } else {
                countMap.put(score, 0);
            }
        }

        // if 4 cards has same value (fourOfKind Score
        if (!fourOfKind.equals(0)) {
            // Set Four of Kind
            playerHand.setHandOutcome(HandOutcome.FOK);
            playerHand.setHigherHand(fourOfKind);
            // Set Higher hand (in case of Tie) and burn
            for (Card card : playerHand.getCards()) {
                if (card.getScore().equals(fourOfKind)) {
                        card.setFree(false);
                }
            }
        }
    }
}
