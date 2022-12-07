package com.yqmonline.day.six;

import com.yqmonline.util.FileReader;

import java.util.List;
import java.util.stream.Collectors;

public class Runner {
    public static final int MARKER_COUNT = 14; //change to required number
    static List<Character> input = FileReader.fileIsOneLine("D6");

    public static void main(String[] args) {
        input.forEach(System.out::print);
        for(int i = 0; i < input.size()-MARKER_COUNT; i++) {
            boolean test = input.subList(i, i+MARKER_COUNT).stream().distinct().count() == MARKER_COUNT;
            if(test) {
                System.out.println(input.subList(i, i+MARKER_COUNT));
                System.out.println(i+MARKER_COUNT);
            }
        }
    }
}
