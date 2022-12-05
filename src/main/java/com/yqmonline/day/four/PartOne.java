package com.yqmonline.day.four;

import com.yqmonline.util.FileReader;

import java.util.List;
import java.util.stream.Collectors;

public class PartOne {
    static List<String> input = FileReader.readEntireFile("D4");


    public static void main(String[] args) {
        List<ListEntry> list = input.stream().map(ListEntry::new).toList();
        int count = 0;
        int p2 = 0;
        for(ListEntry e : list) {
            if(e.assignmentContainsAssignment()) {
                count++;
            }
            if(e.assignmentContainsSome()) {
                p2++;
            }
        }
        System.out.println(count);
        System.out.println(p2);

        count = 0;
    }
}
