package com.yqmonline.day.one;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@NoArgsConstructor
public class Elf implements Comparable<Elf> {
    private final List<Integer> meals = new ArrayList<>();

    public void addMeal(Integer meal) {
        meals.add(meal);
        Collections.sort(meals);
    }
    public void addMeals(List<Integer> meals) {
        this.meals.addAll(meals);
        Collections.sort(this.meals);
    }

    public Integer getBiggestMeal() {
        return meals.get(meals.size() - 1);
    }
    public Integer getSmallestMeal() {
        return meals.get(0);
    }
    public Integer getTotalCalories() {
        Integer totalCalories = 0;
        for(Integer meal : meals)
            totalCalories += meal;
        return totalCalories;
    }

    @Override
    public int compareTo(Elf otherElf) {
        return this.getTotalCalories()
                .compareTo(otherElf.getTotalCalories());
    }

    public void printElf() {
        System.out.println(this);
    }
    @Override
    public String toString() {

        return "Hi: " + this.getBiggestMeal() + "\n" +
                "Lo: " + this.getSmallestMeal() + "\n" +
                "Total: " + this.getTotalCalories() + "\n";
    }
}
