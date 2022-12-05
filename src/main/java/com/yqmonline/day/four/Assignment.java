package com.yqmonline.day.four;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Assignment {
    private final List<Integer> sections;

    // String is listed as start-end
    Assignment(String assignment) {
        int start = Integer.parseInt(assignment.substring(0, assignment.indexOf('-')));
        int end = Integer.parseInt(assignment.substring(assignment.indexOf('-') + 1));

        sections = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
    }

    public List<Integer> getSections() {
        return sections;
    }
}
