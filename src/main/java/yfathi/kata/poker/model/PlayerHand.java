package yfathi.kata.poker.model;

import java.util.List;

/**
 * The type Player hand.
 */
public class PlayerHand{

    private final String player;
    private final List<Card> cards;


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


    @Override
    public String toString() {
        return "PlayerHand{" +
                "player='" + player + '\'' +
                ", cards=" + cards +
                '}';
    }

}
