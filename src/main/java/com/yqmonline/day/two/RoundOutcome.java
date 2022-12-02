package com.yqmonline.day.two;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RoundOutcome {
    LOST(0), DRAW(3), WIN(6);

    private final int score;
}
