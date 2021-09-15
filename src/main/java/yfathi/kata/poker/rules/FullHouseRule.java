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

public class FullHouseRule implements Consumer<PlayerHand> {

    @Override
    public void accept(PlayerHand playerHand) {
        final List<Card> cards = playerHand.getCards().stream().filter(Card::isFree).collect(Collectors.toList());
        final Map<Integer, Integer> countMap = new HashMap<>();


        final Integer threeOfKind =  ScoreUtils.computSameValueScore(cards, 3);
        final Integer pairValue= ScoreUtils.computSameValueScore(cards.stream().filter(card -> card.getScore()!= threeOfKind).collect(Collectors.toList()), 2);

        // if 4 cards has same value (fourOfKind Score
        if (!threeOfKind.equals(0) && !pairValue.equals(0)) {
            // Set Four of Kind
            playerHand.setHandOutcome(HandOutcome.FH);
            playerHand.setHigherHand(threeOfKind);
            // Set Higher hand (in case of Tie) and burn
            for (Card card : playerHand.getCards()) {
                        card.setFree(false);
            }
        }
    }

}
