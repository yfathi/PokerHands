package yfathi.kata.poker.model;

import java.util.Objects;

/**
 * The type Card.
 */
public class Card implements Comparable<Card>{

    private final Color color;
    private final Number number;
    private boolean free=true;


    /**
     * Instantiates a new Card.
     *
     * @param input the input
     */
    public Card(String input) {
        this.number = Number.valueOf("_"+input.substring(0,1));
        this.color = Color.valueOf(input.substring(1,2));
    }

    /**
     * Gets color.
     *
     * @return the color
     */
    public Color getColor() {
        return color;
    }


    /**
     * Gets number.
     *
     * @return the number
     */
    public Number getNumber() {
        return number;
    }

    /**
     * Is free boolean.
     *
     * @return the boolean
     */
    public boolean isFree() {
        return free;
    }

    /**
     * Sets free.
     *
     * @param free the free
     */
    public void setFree(boolean free) {
        this.free = free;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return number == card.number && color == card.color;
    }

    /**
     * Get score integer.
     *
     * @return the integer
     */
    public Integer getScore(){
      return   this.getNumber().getScore();
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, number);
    }

    @Override
    public String toString() {
        return number.getLabel() + color ;
    }

    @Override
    public int compareTo(Card o) {
        return this.getNumber().getScore()-o.getNumber().getScore();
    }


}
