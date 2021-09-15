package yfathi.kata.poker.model;

import java.util.Objects;

public class Card implements Comparable<Card>{

    private final Color color;
    private final Number number;
    private boolean free=true;


    public Card(String input) {
        this.number = Number.valueOf("_"+input.substring(0,1));
        this.color = Color.valueOf(input.substring(1,2));
    }

    public Color getColor() {
        return color;
    }


    public Number getNumber() {
        return number;
    }

    public boolean isFree() {
        return free;
    }

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
