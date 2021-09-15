package yfathi.kata.poker.model;

import java.util.List;

/**
 * The type Player hand.
 */
public class PlayerHand implements Comparable<PlayerHand> {

    private final String player;
    private final List<Card> cards;
    private HandOutcome handOutcome;
    private int higherHand =0;


    /**
     * Instantiates a new Player hand.
     *
     * @param player the player
     * @param cards  the cards
     */
    public PlayerHand(String player, List<Card> cards) {
        this.player = player;
        this.cards = cards;
        cards.sort(Card::compareTo);
        this.handOutcome=HandOutcome.HC;
    }

    /**
     * Gets player.
     *
     * @return the player
     */
    public String getPlayer() {
        return player;
    }

    /**
     * Gets cards.
     *
     * @return the cards
     */
    public List<Card> getCards() {
        return cards;
    }

    /**
     * Gets hand outcome.
     *
     * @return the hand outcome
     */
    public HandOutcome getHandOutcome() {
        return handOutcome;
    }

    /**
     * Gets higher hand.
     *
     * @return the higher hand
     */
    public int getHigherHand() {
        return higherHand;
    }

    /**
     * Sets higher hand.
     *
     * @param higherHand the higher hand
     */
    public void setHigherHand(int higherHand) {
        this.higherHand = higherHand;
    }

    /**
     * Sets hand outcome.
     *
     * @param handOutcome the hand outcome
     */
    public void setHandOutcome(HandOutcome handOutcome) {
        this.handOutcome = handOutcome;
    }



    @Override
    public String toString() {
        return "PlayerHand{" +
                "player='" + player + '\'' +
                ", cards=" + cards +
                ", handOutcome=" + handOutcome +
                '}';
    }

    @Override
    public int compareTo(PlayerHand o) {
        return (this.handOutcome.getScore()+this.higherHand)-(o.handOutcome.getScore()+o.getHigherHand());
    }
}
