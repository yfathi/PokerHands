package yfathi.kata.poker.utils;

import yfathi.kata.poker.model.Card;
import yfathi.kata.poker.model.Color;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public static Integer computSameValueScore(List<Card> cards, Integer sameValue) {
        final Map<Integer, Integer> countMap = new HashMap<>();

        Integer scoreSameValue =0;
        for (Card card : cards) {
            final Integer score = card.getScore();
            if (countMap.containsKey(score)) {
                countMap.put(score, countMap.get(score )+1);

                if (countMap.get(score).equals(sameValue)) {
                    scoreSameValue = score;
                }
            } else {
                countMap.put(score, 1);
            }
        }
        return scoreSameValue;
    }
}
