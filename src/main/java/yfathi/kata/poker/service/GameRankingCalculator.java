package yfathi.kata.poker.service;

import yfathi.kata.poker.model.HandRanking;
import yfathi.kata.poker.model.PlayerHand;


/**
 * Game ranking calculator.
 */
public interface GameRankingCalculator {

  /**
   * Computes a player hand ranking.
   *
   * @param playerHand the player hand
   * @return the hand ranking
   */
  HandRanking compute(PlayerHand playerHand);
}
