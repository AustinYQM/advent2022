package com.yqmonline.day.four;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class ListEntry {
    private Assignment firstElf;
    private Assignment secondElf;

    ListEntry(String fullString) {
        String[] split = fullString.split(",");
        firstElf = new Assignment(split[0]);
        secondElf = new Assignment(split[1]);
    }

    public boolean assignmentContainsAssignment() {
        return new HashSet<>(firstElf.getSections()).containsAll(secondElf.getSections()) || new HashSet<>(secondElf.getSections()).containsAll(firstElf.getSections());
    }
    public boolean assignmentContainsSome() {
        return firstElf.getSections().stream().filter(secondElf.getSections()::contains).toList().size() > 0;
    }

}
