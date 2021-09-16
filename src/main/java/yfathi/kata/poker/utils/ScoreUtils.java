package yfathi.kata.poker.utils;

import yfathi.kata.poker.model.Card;
import yfathi.kata.poker.model.Color;
import yfathi.kata.poker.model.PlayerHand;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The type Score utils.
 */
public class ScoreUtils {

    /**
     * Is same color boolean.
     *
     * @param cards the cards
     * @return the boolean
     */
    public static boolean isSameColor(List<Card> cards){
        Color color = cards.get(0).getColor();
       return cards.stream().allMatch(card -> card.getColor().equals(color));
    }

    /**
     * Is consecutive boolean.
     *
     * @param cards the cards
     * @return the boolean
     */
    public static boolean isConsecutive(List<Card> cards){
        var consecutive =true;
        for (int i = 1; i < cards.size(); i++) {
            if(cards.get(i).compareTo(cards.get(i - 1)) != 1){
                consecutive = false;
                break;
            }
        }
        return consecutive;
    }

    /**
     * Comput same value score integer.
     *
     * @param cards     the cards
     * @param sameValue the same value
     * @return the integer
     */
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


    public static Integer compareTie(List<Card> cards1,List<Card> cards2) {
        cards1.sort(Card::compareTo);
        cards2.sort(Card::compareTo);
        for (int i = cards1.size()-1; i >-1; i--) {
            final int compare = cards1.get(i).compareTo(cards2.get(i));
            if(compare >0){
                return 1;
            }else if(compare<0){
                return 2;
            }
        }
       return 0;
    }

}
