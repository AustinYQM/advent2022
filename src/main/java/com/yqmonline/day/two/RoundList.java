package com.yqmonline.day.two;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class RoundList {
    private final List<Round> list = new ArrayList<>(2500);

    public void addRoundFromString(String round) {
        list.add(new Round(round.charAt(0), round.charAt(2)));
    }
    public void addRoundFromString2(String round) {
        list.add(new Round(round.charAt(0), round.charAt(2), true));
    }

    public int calcYourScore() {
        return list.stream().mapToInt(Round::yourRoundScore).sum();
    }
    public int calcTheirScore() {
        return list.stream().mapToInt(Round::theirRoundScore).sum();
    }

    public void printList() {
        for(int i = 0; i < list.size(); i++) {
            System.out.println("Round " + (i+1) + ": " + list.get(i).yourRoundScore());
        }
    }
}
