package yfathi.kata.poker.model;

public enum Number {
    _2(1, "2"),
    _3(2, "3"),
    _4(3, "4"),
    _5(4, "5"),
    _6(5, "6"),
    _7(6, "7"),
    _9(7, "9"),
    _T(8, "T"),
    _J(9, "J"),
    _Q(10, "Q"),
    _K(11, "K"),
    _A(12, "A");

    private final int score;
    private final String label;

    Number(int score, String label) {
        this.score = score;
        this.label = label;
    }

    public int getScore() {
        return score;
    }

    public String getLabel() {
        return label;
    }
}
