package yfathi.kata.poker.service;

import yfathi.kata.poker.model.Card;
import yfathi.kata.poker.model.PlayerHand;
import yfathi.kata.poker.rules.*;
import yfathi.kata.poker.utils.ScoreUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * The type Game engine.
 */
public class GameEngine {


    private  List<PlayerHand> players;
    private final List<Consumer<PlayerHand>> rules;
    private PlayerHand currentWinner;

    /**
     * Instantiates a new Game engine.
     */
    public GameEngine() {
        this.rules = new ArrayList<>();
        this.players = new ArrayList<>();
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

    /**
     * Play.
     *
     * @param input the input
     */
    public void play(String input) {
        handleInput(input);
        checkRules();
        computeOutcome();
    }

    /**
     * Handle input.
     *
     * @param input the input
     */
    protected void handleInput(String input) {
        this.players = new ArrayList<>();
        this.currentWinner=null;
        Arrays.stream(input.split(",")).forEach(
                p -> {
                    var name = p.split(":")[0];
                    var cardInput = p.split(":")[1];
                    List<Card> cards = new ArrayList<>();
                    Arrays.stream(cardInput.trim().split(" ")).forEach(
                            c -> cards.add(new Card(c))
                    );
                    players.add(new PlayerHand(name, cards));
                }
        );
    }

    /**
     * Check rules.
     */
    protected void checkRules() {
        players.forEach(playerHand ->
                rules.forEach(playerHandConsumer -> playerHandConsumer.accept(playerHand))
        );
    }

    /**
     * Gets rules.
     *
     * @return the rules
     */
    public List<Consumer<PlayerHand>> getRules() {
        return rules;
    }

    /**
     * Gets current winner.
     *
     * @return the current winner
     */
    public PlayerHand getCurrentWinner() {
        return currentWinner;
    }

    /**
     * Sets current winner.
     *
     * @param currentWinner the current winner
     */
    public void setCurrentWinner(PlayerHand currentWinner) {
        this.currentWinner = currentWinner;
    }

    /**
     * Compute outcome.
     */
    protected void computeOutcome() {
        players.sort(PlayerHand::compareTo);
        final PlayerHand playerHand1 = players.get(players.size() - 1);
        final PlayerHand playerHand2 = players.get(players.size() - 2);
        if(playerHand1.compareTo(playerHand2)>0){
            // if No TIE determine the winner
            currentWinner = playerHand1;
        }else{
            final List<Card> cards1 = playerHand1.getCards().stream().filter(Card::isFree).collect(Collectors.toList());
            final List<Card> cards2 = playerHand2.getCards().stream().filter(Card::isFree).collect(Collectors.toList());
            final Integer compareTie = ScoreUtils.compareTie(cards1, cards2);
            if(compareTie !=0){
                currentWinner=players.get(players.size() - compareTie);
            }
        }
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
