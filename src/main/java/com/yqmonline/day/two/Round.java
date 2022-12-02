package com.yqmonline.day.two;

public class Round {
    private final GameMove theirMove;
    private final GameMove yourMove;
    private final RoundOutcome roundOutcome;

    Round(char them, char you) {
        theirMove = EnumMapper.mapMove(them);
        yourMove = EnumMapper.mapMove(you);

        roundOutcome = EnumMapper.mapOutcome(theirMove, yourMove);
    }

    Round(char them, char you, boolean part2) {
        theirMove = EnumMapper.mapMove(them);
        roundOutcome = EnumMapper.mapOutcome(EnumMapper.mapMove(you));
        yourMove = EnumMapper.mapMove(theirMove, roundOutcome);
    }




    public int yourRoundScore() {
        return yourMove.getScore() + roundOutcome.getScore();
    }
    public int theirRoundScore() {
        return theirMove.getScore() + opponentOutcome().getScore();
    }

    private RoundOutcome opponentOutcome() {
        return switch (roundOutcome) {
            case LOST -> RoundOutcome.WIN;
            case DRAW -> RoundOutcome.DRAW;
            case WIN -> RoundOutcome.LOST;
        };
    }




}
