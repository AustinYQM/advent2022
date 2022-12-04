package com.yqmonline.day.three;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class RucksackList {
    private static List<Rucksack> list;

    RucksackList() {
        list = new ArrayList<>();
    }

    public void addRucksack(String fullString) {
        list.add(new Rucksack(fullString));
    }

    public Stream<Rucksack> stream() {
        return list.stream();
    }

    public Rucksack get(int i) {
        return list.get(i);
    }

    public int size() { return list.size(); }
}
