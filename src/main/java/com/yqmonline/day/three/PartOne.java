package com.yqmonline.day.three;

import com.yqmonline.util.FileReader;

import java.util.ArrayList;
import java.util.List;

public class PartOne {
    private static final List<String> input = FileReader.readEntireFile("D3");
    private static final List<Integer> priorities = new ArrayList<>(300);
    private static RucksackList rucksacks = new RucksackList();

    public static void main(String[] args) {
//        System.out.println(PriorityMapper.mapSinglePriority('a'));
//        System.out.println(PriorityMapper.mapSinglePriority('b'));
//        System.out.println(PriorityMapper.mapSinglePriority('A'));
//        System.out.println(PriorityMapper.mapSinglePriority('B'));
        input.forEach(rucksacks::addRucksack);
        rucksacks.stream().forEach(System.out::println);
        int total = rucksacks.stream().mapToInt(Rucksack::findIntersectionValue).sum();
        System.out.println(total);
    }
}
