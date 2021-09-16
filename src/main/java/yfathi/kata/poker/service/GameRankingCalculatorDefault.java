package yfathi.kata.poker.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import yfathi.kata.poker.model.HandRanking;
import yfathi.kata.poker.model.PlayerHand;
import yfathi.kata.poker.rules.FlushRule;
import yfathi.kata.poker.rules.FourOfKindRule;
import yfathi.kata.poker.rules.FullHouseRule;
import yfathi.kata.poker.rules.HighCardRule;
import yfathi.kata.poker.rules.PairRule;
import yfathi.kata.poker.rules.StraightFlushRule;
import yfathi.kata.poker.rules.StraightRule;
import yfathi.kata.poker.rules.ThreeOfKindRule;
import yfathi.kata.poker.rules.TwoPairsRule;

public class GameRankingCalculatorDefault implements GameRankingCalculator {

  private final List<Function<PlayerHand, Optional<HandRanking>>> rules;

  public GameRankingCalculatorDefault() {
    this.rules = new ArrayList<>();
    // Order is Crucial
    rules.add(new StraightFlushRule());
    rules.add(new FourOfKindRule());
    rules.add(new FullHouseRule());
    rules.add(new FlushRule());
    rules.add(new StraightRule());
    rules.add(new ThreeOfKindRule());
    rules.add(new TwoPairsRule());
    rules.add(new PairRule());
    rules.add(new HighCardRule());
  }

  public HandRanking compute(PlayerHand playerHand) {
    return rules.stream().map(rule -> rule.apply(playerHand))
        .flatMap(Optional::stream)
        .findFirst().get();
  }
}
