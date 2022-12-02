package com.yqmonline.day.one;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@NoArgsConstructor
public class ElfList {
    private final List<Elf> list = new ArrayList<>();

    public void newElf() {
        this.list.add(new Elf());
    }

    private Elf getMostRecentElf() {
        return list.get(list.size() - 1);
    }

    public void addMealToRecentElf(String meal) {
        getMostRecentElf().addMeal(Integer.parseInt(meal));
    }

    private List<Elf> getSortedList(Comparator<Elf> elfComparator) {
        ArrayList<Elf> copy = new ArrayList<>(list);
        copy.sort(elfComparator);
        return copy;
    }

    private List<Elf> getReverseElves() {
        return getSortedList(Comparator.reverseOrder());
    }

    private Elf getBiggestElf() {
        return getReverseElves().get(0);
    }

    public List<Elf> getTopXElves(int topX) {
        return getReverseElves().subList(0, topX);
    }

    public void printBiggestElf() {
        System.out.println("-= Biggest Elf =-");
        System.out.println(getBiggestElf());
    }

    public void printTopXElves(int topX) {
        System.out.println("-= Top " + topX + " Elves =-");
        getTopXElves(topX).forEach(Elf::printElf);
    }
}
