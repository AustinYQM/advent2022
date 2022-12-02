package com.yqmonline.day.one;

import com.yqmonline.util.FileReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PartOne {
    //private static final List<Elf> betterElves = new ArrayList<>();
    private static final ElfList elfList = new ElfList();
    public static void main(String[] args) {
        List<String> list = FileReader.readEntireFile("D1");
        elfList.newElf();
        while(!list.isEmpty()) {
            int lastIndex = list.size() - 1;
            String elf = list.remove(lastIndex);
            if(!elf.isEmpty()) {
                elfList.addMealToRecentElf(elf);
            } else {
                elfList.newElf();
            }
        }

        elfList.printBiggestElf();
        elfList.printTopXElves(3);

        System.out.println("Total: " + elfList.getTopXElves(3).stream().mapToInt(Elf::getTotalCalories).sum());
    }

//sum    private static Elf getHighestElf() {
//        ArrayList<Elf> copy = new ArrayList<>(betterElves);
//        copy.sort(Comparator.reverseOrder());
//        return copy.get(0);
//    }
//
//    private static List<Elf> getTop3Elves() {
//        ArrayList<Elf> copy = new ArrayList<>(betterElves);
//        copy.sort(Comparator.reverseOrder());
//        return copy.subList(0, 3);
//    }
}
