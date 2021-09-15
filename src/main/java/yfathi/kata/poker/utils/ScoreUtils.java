package yfathi.kata.poker.utils;

import yfathi.kata.poker.model.Card;
import yfathi.kata.poker.model.Color;

import java.util.List;

public class ScoreUtils {

    public static boolean isSameColor(List<Card> cards){
        Color color = cards.get(0).getColor();
       return cards.stream().allMatch(card -> card.getColor().equals(color));
    }
    public static boolean isConsecutive(List<Card> cards){
        var consecutive =true;
        for (int i = 1; i < cards.size()-1; i++) {
            if(cards.get(i).compareTo(cards.get(i - 1)) != 1){
                consecutive = false;
                break;
            }
        }
        return consecutive;
    }
}
