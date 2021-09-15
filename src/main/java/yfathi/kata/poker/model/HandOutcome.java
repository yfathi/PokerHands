package yfathi.kata.poker.model;

public enum HandOutcome {
    HC("High Card", 0),
    PR("Pair", 100),
    TPR("Two Pairs", 200),
    TK("Three of a Kind", 300),
    STR("Straight", 400),
    FLS("Flush", 500),
    FOK("Four of a Kind ", 600),
    FH("Full House", 700),
    STRFH("Straight Flush", 800);

    private final String label;
    private final int score;

    HandOutcome(String label, int score) {
        this.label = label;
        this.score = score;
    }

    public String getLabel() {
        return label;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return  label;
    }
}
