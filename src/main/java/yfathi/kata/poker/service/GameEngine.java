package yfathi.kata.poker.service;

import yfathi.kata.poker.model.Card;
import yfathi.kata.poker.model.PlayerHand;
import yfathi.kata.poker.rules.FourOfKindRule;
import yfathi.kata.poker.rules.StraightFlushRule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class GameEngine {


    private final List<PlayerHand> players;
    private final List<Consumer<PlayerHand>> rules;
    private PlayerHand currentWinner;

    public GameEngine() {
        this.rules = new ArrayList<>();
        this.players = new ArrayList<>();
        rules.add(new StraightFlushRule());
        rules.add(new FourOfKindRule());
    }

    public void play(String input) {
        handleInput(input);

        checkRules();
        computeOutcome();
    }

    protected void handleInput(String input) {
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

    protected void checkRules() {
        players.forEach(playerHand ->
                rules.forEach(playerHandConsumer -> playerHandConsumer.accept(playerHand))
        );
    }

    public List<Consumer<PlayerHand>> getRules() {
        return rules;
    }

    public PlayerHand getCurrentWinner() {
        return currentWinner;
    }

    public void setCurrentWinner(PlayerHand currentWinner) {
        this.currentWinner = currentWinner;
    }

    protected void computeOutcome() {
        players.sort(PlayerHand::compareTo);
        if(players.get(players.size() - 1).compareTo(players.get(players.size()-2))>0){
            // if No TIE determine the winner
            currentWinner = players.get(players.size() - 1);
        }
    }



    public List<PlayerHand> getPlayers() {
        return players;
    }
}
