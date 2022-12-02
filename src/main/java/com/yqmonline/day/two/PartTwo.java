package com.yqmonline.day.two;

import com.yqmonline.util.FileReader;

import java.util.List;

public class PartTwo {
    private static final List<String> input = FileReader.readEntireFile("D2");
    private static final RoundList rounds = new RoundList();

    public static void main(String[] args) {
        input.forEach(rounds::addRoundFromString2);

        System.out.println("Your Total Score: " + rounds.calcYourScore());
    }
}
