package com.yqmonline.day.five;

import lombok.Data;

public record Instruction(int countToMove, int fromCol, int toCol) {

    @Override
    public String toString() {
        return "move " + countToMove + " from " + fromCol + " to " + toCol;
    }
}
