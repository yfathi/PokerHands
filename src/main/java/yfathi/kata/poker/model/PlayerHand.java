package yfathi.kata.poker.model;

import java.util.List;

public class PlayerHand implements Comparable<PlayerHand> {

    private final String player;
    private final List<Card> cards;
    private HandOutcome handOutcome;
    private int higherHand =0;


    public PlayerHand(String player, List<Card> cards) {
        this.player = player;
        this.cards = cards;
        cards.sort(Card::compareTo);
        this.handOutcome=HandOutcome.HC;
    }

    public String getPlayer() {
        return player;
    }

    public List<Card> getCards() {
        return cards;
    }

    public HandOutcome getHandOutcome() {
        return handOutcome;
    }

    public int getHigherHand() {
        return higherHand;
    }

    public void setHigherHand(int higherHand) {
        this.higherHand = higherHand;
    }

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
