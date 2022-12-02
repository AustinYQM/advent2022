package com.yqmonline.day.two;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@RequiredArgsConstructor
@Getter
public enum GameMove {
    ROCK(1), PAPER(2), SCISSORS(3);

    private final int score;

}
