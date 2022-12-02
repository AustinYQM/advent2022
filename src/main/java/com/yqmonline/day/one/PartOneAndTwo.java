package com.yqmonline.day.one;

import com.yqmonline.util.FileReader;
import java.util.List;

public class PartOneAndTwo {
    private static final List<String> input = FileReader.readEntireFile("D1");
    private static final ElfList elfList = new ElfList();
    public static void main(String[] args) {

        elfList.newElf();
        while(!input.isEmpty()) {
            int lastIndex = input.size() - 1;
            String elf = input.remove(lastIndex);
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
}
