package com.yqmonline.day.three;

import com.yqmonline.util.FileReader;

import java.util.ArrayList;
import java.util.List;

public class PartTwo {
    private static final List<String> input = FileReader.readEntireFile("D3");
    private static RucksackList rucksacks = new RucksackList();

    public static void main(String[] args) {
        input.forEach(rucksacks::addRucksack);
        rucksacks.stream().forEach(System.out::println);
        int total = 0;
        for(int i = 0; i < rucksacks.size(); i += 3) {
            total += Rucksack.find3WayIntersectionValue(rucksacks.get(i), rucksacks.get(i+1), rucksacks.get(i+2));
        }
        System.out.println(total);
    }
}
