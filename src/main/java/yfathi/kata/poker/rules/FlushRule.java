package yfathi.kata.poker.rules;

import java.util.Optional;
import java.util.function.Function;
import yfathi.kata.poker.model.HandOutcome;
import yfathi.kata.poker.model.HandRanking;
import yfathi.kata.poker.model.PlayerHand;
import yfathi.kata.poker.utils.ScoreUtils;

/**
 * The type Flush rule.
 */
public class FlushRule implements Function<PlayerHand, Optional<HandRanking>> {

    @Override
    public Optional<HandRanking> apply(PlayerHand playerHand) {

        final var cards = playerHand.getCards();
        if (ScoreUtils.isSameColor(cards)) {
            var handRanking=new HandRanking(playerHand.getPlayer(), cards);
            // Set  Flush
            handRanking.setHandOutcome(HandOutcome.FLS);
            // Set Higherhand (in case of Tie)
            handRanking.setHigherHand(cards.get(cards.size()-1).getNumber().getScore());
            // Burn All the cards
            handRanking.getCards().forEach(card -> card.setFree(false));

            return
                Optional.of(handRanking);
        }
        return Optional.empty();
    }
}
