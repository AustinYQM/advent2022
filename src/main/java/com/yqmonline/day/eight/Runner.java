package com.yqmonline.day.eight;

import com.yqmonline.util.FileReader;


import java.util.List;


public class Runner {
    public static List<String> input = FileReader.readEntireFile("D8");

    public static void main(String[] args) {
        System.out.println("----- Day 8 part 1 and 2 ----");
        Wood wood = new Wood(input);
        System.out.println("result part 1= " + wood.countPart1());
        System.out.println("result part 2= " + wood.countPart2());
        System.out.println("-----------------------------");

    }

}
