package com.yqmonline.day.two;

public final class EnumMapper {
    private EnumMapper(){}

    public static GameMove mapMove(char move) {
        if(move == 'A' || move == 'X') {
            return GameMove.ROCK;
        }
        if(move == 'B' || move == 'Y') {
            return GameMove.PAPER;
        }
        if(move == 'C' || move == 'Z') {
            return GameMove.SCISSORS;
        }
        return GameMove.ROCK;
    }

    public static RoundOutcome mapOutcome(GameMove them, GameMove you) {
        switch (you) {
            case ROCK -> {
                if (them == GameMove.SCISSORS) return RoundOutcome.WIN;
                if (them == GameMove.PAPER) return RoundOutcome.LOST;
            }
            case PAPER -> {
                if (them == GameMove.ROCK) return RoundOutcome.WIN;
                if (them == GameMove.SCISSORS) return RoundOutcome.LOST;
            }
            case SCISSORS -> {
                if (them == GameMove.PAPER) return RoundOutcome.WIN;
                if (them == GameMove.ROCK) return RoundOutcome.LOST;
            }
        }
        return RoundOutcome.DRAW;
    }

    public static RoundOutcome mapOutcome(GameMove you) {
        return switch (you) {
            case ROCK -> RoundOutcome.LOST;
            case PAPER -> RoundOutcome.DRAW;
            case SCISSORS -> RoundOutcome.WIN;
        };
    }

    public static GameMove mapMove(GameMove them, RoundOutcome desiredOutcome) {
        return switch (desiredOutcome) {
            case LOST -> doLoss(them);
            case DRAW -> them;
            case WIN -> doWin(them);
        };
    }

    private static GameMove doLoss(GameMove move) {
        return switch (move) {
            case ROCK -> GameMove.SCISSORS;
            case PAPER -> GameMove.ROCK;
            case SCISSORS -> GameMove.PAPER;
        };
    }

    private static GameMove doWin(GameMove move) {
        return switch (move) {
            case ROCK -> GameMove.PAPER;
            case PAPER -> GameMove.SCISSORS;
            case SCISSORS -> GameMove.ROCK;
        };
    }
}
