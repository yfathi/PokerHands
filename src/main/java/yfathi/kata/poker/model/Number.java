package yfathi.kata.poker.model;

/**
 * The enum Number.
 */
public enum Number {
    /**
     * 2 number.
     */
    _2(1, "2"),
    /**
     * 3 number.
     */
    _3(2, "3"),
    /**
     * 4 number.
     */
    _4(3, "4"),
    /**
     * 5 number.
     */
    _5(4, "5"),
    /**
     * 6 number.
     */
    _6(5, "6"),
    /**
     * 7 number.
     */
    _7(6, "7"),
    /**
     * 9 number.
     */
    _9(7, "9"),
    /**
     * T number.
     */
    _T(8, "T"),
    /**
     * J number.
     */
    _J(9, "J"),
    /**
     * Q number.
     */
    _Q(10, "Q"),
    /**
     * K number.
     */
    _K(11, "K"),
    /**
     * A number.
     */
    _A(12, "A");

    private final int score;
    private final String label;

    Number(int score, String label) {
        this.score = score;
        this.label = label;
    }

    /**
     * Gets score.
     *
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * Gets label.
     *
     * @return the label
     */
    public String getLabel() {
        return label;
    }

}
