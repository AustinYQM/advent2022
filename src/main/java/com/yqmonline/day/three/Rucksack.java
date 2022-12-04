package com.yqmonline.day.three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Rucksack {
    private final String firstCompartment;
    private final String secondCompartment;
    private final String fullContents;

    Rucksack(String fullContents) {
        this.fullContents = fullContents;
        firstCompartment = fullContents.substring(0, fullContents.length() / 2);
        secondCompartment = fullContents.substring(fullContents.length() / 2);
    }

    public int findIntersectionValue() {
        if(intersection().size() == 1) {
            return PriorityMapper.mapSinglePriority(intersection().get(0));
        } else {
            return 0;
        }
    }

    private List<Character> intersection() {
        List<Character> firstCompartment = stringToCharList(this.firstCompartment);
        List<Character> secondCompartment = stringToCharList(this.secondCompartment);

        return firstCompartment.stream().distinct().filter(secondCompartment::contains).collect(Collectors.toList());
    }

    public static List<Character> intersection(Rucksack r1, Rucksack r2, Rucksack r3) {
        List<Character> r1String = stringToCharList(r1.fullContents);
        List<Character> r2String = stringToCharList(r2.fullContents);
        List<Character> r3String = stringToCharList(r3.fullContents);

        return r1String.stream().distinct().filter(r2String::contains).filter(r3String::contains).toList();
    }

    public static int find3WayIntersectionValue(Rucksack r1, Rucksack r2, Rucksack r3) {
        if(intersection(r1, r2, r3).size() == 1) {
            return PriorityMapper.mapSinglePriority(intersection(r1, r2, r3).get(0));
        } else {
            return 0;
        }
    }

    private static List<Character> stringToCharList(String stringToConvert) {
        List<Character> list = new ArrayList<>();
        for (char c : stringToConvert.toCharArray()) {
            list.add(c);
        }
        return list;
    }
    @Override
    public String toString() {
        return "C1: " + firstCompartment + " C2: " + secondCompartment;
    }
}
