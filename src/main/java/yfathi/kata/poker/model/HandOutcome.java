package yfathi.kata.poker.model;

/**
 * The enum Hand outcome.
 */
public enum HandOutcome {
    /**
     * The Hc.
     */
    HC("High Card", 0),
    /**
     * Pr hand outcome.
     */
    PR("Pair", 100),
    /**
     * The Tpr.
     */
    TPR("Two Pairs", 200),
    /**
     * The Tk.
     */
    TK("Three of a Kind", 300),
    /**
     * Str hand outcome.
     */
    STR("Straight", 400),
    /**
     * Fls hand outcome.
     */
    FLS("Flush", 500),
    /**
     * The Fok.
     */
    FOK("Four of a Kind ", 600),
    /**
     * The Fh.
     */
    FH("Full House", 700),
    /**
     * The Strfh.
     */
    STRFH("Straight Flush", 800);

    private final String label;
    private final int score;

    HandOutcome(String label, int score) {
        this.label = label;
        this.score = score;
    }

    /**
     * Gets label.
     *
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * Gets score.
     *
     * @return the score
     */
    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return  label;
    }
}
