package yfathi.kata.poker.service;

import java.util.List;
import yfathi.kata.poker.model.PlayerHand;

/**
 * Let you read  an input String and transform it to a list of player hands .
 */
public interface GameInputReader {

  /**
   * read  an input String and transform it to a list of player hands.
   *
   * @param input the input
   * @return the list
   */
  List<PlayerHand> handleInput(String input);
}
