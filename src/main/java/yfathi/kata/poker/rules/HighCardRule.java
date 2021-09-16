package yfathi.kata.poker.rules;

import java.util.Optional;
import java.util.function.Function;
import yfathi.kata.poker.model.Card;
import yfathi.kata.poker.model.HandRanking;
import yfathi.kata.poker.model.PlayerHand;

import java.util.List;

/**
 * The type High card rule.
 */
public class HighCardRule implements Function<PlayerHand, Optional<HandRanking>> {

@Override
public Optional<HandRanking> apply(PlayerHand playerHand) {

        final List<Card> cards = playerHand.getCards();
        var handRanking= new HandRanking(playerHand.getPlayer(),playerHand.getCards());
        handRanking.setHigherHand(cards.get(cards.size()-1).getNumber().getScore());
        return   Optional.of(handRanking);
    }

}
