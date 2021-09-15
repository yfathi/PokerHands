package yfathi.kata.poker.rules;

import yfathi.kata.poker.model.Card;
import yfathi.kata.poker.model.HandOutcome;
import yfathi.kata.poker.model.PlayerHand;
import yfathi.kata.poker.utils.ScoreUtils;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ThreeOfKindRule implements Consumer<PlayerHand> {

    @Override
    public void accept(PlayerHand playerHand) {
        final List<Card> cards = playerHand.getCards().stream().filter(Card::isFree).collect(Collectors.toList());
        if (cards.size()<2) return;
        final Integer threeOfKind = ScoreUtils.computSameValueScore(cards, 3);

        // if 4 cards has same value (threeOfKind Score
        if (!threeOfKind.equals(0)) {
            // Set Four of Kind
            playerHand.setHandOutcome(HandOutcome.TK);
            playerHand.setHigherHand(threeOfKind);
            // Set Higher hand (in case of Tie) and burn
            for (Card card : playerHand.getCards()) {
                if (card.getScore().equals(threeOfKind)) {
                    card.setFree(false);
                }
            }
        }
    }
}
