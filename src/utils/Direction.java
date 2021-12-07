package utils;

public enum Direction {

    LEFT(-1),
    NEUTRAL(0),
    RIGHT(1);

    public final int modificator;

    Direction(int modificator) {
        this.modificator = modificator;
    }

}

