package yfathi.kata.poker.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import yfathi.kata.poker.model.Card;
import yfathi.kata.poker.model.PlayerHand;

public class GameInputReaderDefault implements GameInputReader {

  /**
   * Handle input.
   *
   * @param input the input
   */
  @Override
  public List<PlayerHand> handleInput(String input) {
    List<PlayerHand> playerHands = new ArrayList<>();
    Arrays.stream(input.split(",")).forEach(
        p -> {
          var name = p.split(":")[0];
          var cardInput = p.split(":")[1];
          List<Card> cards = new ArrayList<>();
          Arrays.stream(cardInput.trim().split(" ")).forEach(
              c -> cards.add(new Card(c))
          );
          playerHands.add(new PlayerHand(name, cards));
        }
    );
    return  playerHands;
  }

}
