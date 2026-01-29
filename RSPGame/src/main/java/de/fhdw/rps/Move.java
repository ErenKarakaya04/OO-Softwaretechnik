package de.fhdw.rps;

public enum Move {
    ROCK,
    PAPER,
    SCISSORS;

    public static Move getRandomMove() {
        Move[] moves = Move.values();
        return moves[(int) (Math.random() * moves.length)];
    }

}

