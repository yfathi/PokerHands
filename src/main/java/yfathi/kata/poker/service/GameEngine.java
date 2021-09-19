package yfathi.kata.poker.service;

import static java.util.stream.Collectors.toList;

import yfathi.kata.poker.model.Card;
import yfathi.kata.poker.model.HandRanking;
import yfathi.kata.poker.model.PlayerHand;
import yfathi.kata.poker.utils.ScoreUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Game engine.
 */
public class GameEngine {


    private  List<PlayerHand> players;
    private List<HandRanking> results;

    private HandRanking currentWinner;
    private GameRankingCalculator gameRankingCalculator;
    private GameInputReader gameInputReader;

    /**
     * Instantiates a new Game engine.
     * @param gameRankingCalculator
     * @param gameInputReader
     */
    public GameEngine(GameRankingCalculator gameRankingCalculator,
        GameInputReader gameInputReader) {
        this.gameRankingCalculator = gameRankingCalculator;
        this.gameInputReader = gameInputReader;
        this.players = new ArrayList<>();
    }

    /**
     * Play.
     *
     * @param input the input
     */
    public void play(String input) {
        this.players= gameInputReader.handleInput(input);
        applyRules();
        computeOutcome();
    }

    /**
     * Apply rules.
     */
    public void applyRules() {
       this.results=  players.stream().map(playerHand ->
           gameRankingCalculator.compute(playerHand)
        ).collect(toList());
    }



    /**
     * Gets current winner.
     *
     * @return the current winner
     */
    public HandRanking getCurrentWinner() {
        return currentWinner;
    }

    /**
     * Sets current winner.
     *
     * @param currentWinner the current winner
     */
    public void setCurrentWinner(HandRanking currentWinner) {
        this.currentWinner = currentWinner;
    }

    /**
     * Compute outcome.
     */
    protected void computeOutcome() {
        results.sort(HandRanking::compareTo);
        final HandRanking playerHand1 = results.get(results.size() - 1);
        final HandRanking playerHand2 = results.get(results.size() - 2);
        if(playerHand1.compareTo(playerHand2)>0){
            // if No TIE determine the winner
            currentWinner = playerHand1;
        }else{
            final List<Card> cards1 = filterOnFreeCard(playerHand1);
            final List<Card> cards2 = filterOnFreeCard(playerHand2);
            final Integer compareTie = ScoreUtils.compareTie(cards1, cards2);
            if(compareTie !=0){
                currentWinner=results.get(results.size() - compareTie);
            }
        }
    }

    private List<Card> filterOnFreeCard(HandRanking playerHand1) {
        return playerHand1.getCards().stream().filter(Card::isFree).collect(
            toList());
    }


    /**
     * Gets players.
     *
     * @return the players
     */
    public List<PlayerHand> getPlayers() {
        return players;
    }
}
