package com.yqmonline.day.eight;

import java.util.List;
import com.google.common.collect.Lists;

public class Wood {

    private Tree[][] wood;
    private List<Tree> allTrees; // just for convenience iterate over all
    private int rowSize, columnSize;

    public Wood(List<String> inputLines) {
        columnSize = inputLines.size();
        rowSize = inputLines.get(0).length();
        wood = new Tree[rowSize][columnSize];
        allTrees = Lists.newArrayList();
        createWood(inputLines);
    }

    private void createWood(List<String> rows) {
        for (int rowIndex = 0; rowIndex < rowSize; rowIndex++) {
            String oneRow = rows.get(rowIndex);
            for (int columnIndex = 0; columnIndex < columnSize; columnIndex++) {
                var tree = new Tree(Integer.parseInt(oneRow.substring(columnIndex, columnIndex + 1)));
                wood[rowIndex][columnIndex] = tree;
                allTrees.add(tree);
                setSiblings(rowIndex, columnIndex);
            }
        }
    }

    private void setSiblings(int rowIndex, int columnIndex) {
        var actualTree = wood[rowIndex][columnIndex];
        if (rowIndex > 0) {
            var treeAbove = wood[rowIndex - 1][columnIndex];
            actualTree.setTop(treeAbove);
            treeAbove.setBottom(actualTree);
        }
        if (columnIndex > 0) {
            var treeLeft = wood[rowIndex][columnIndex - 1];
            actualTree.setLeft(treeLeft);
            treeLeft.setRight(actualTree);
        }
    }

    public int countPart1() {
        int result = 0;
        for (Tree oneTree : allTrees) {
            if (oneTree.allLeftLower() || oneTree.allRightLower() || oneTree.allTopLower()
                    || oneTree.allBottomLower()) {
                result++;
            }
        }
        return result;
    }

    public int countPart2() {
        int result = -1;
        for (Tree oneTree : allTrees) {
            int intermediate = oneTree.scenicScore();
            if (intermediate > result)
                result = intermediate;
        }
        return result;
    }

    public void print() {
        System.out.println("-- wood --");
        for (int rowIndex = 0; rowIndex < rowSize; rowIndex++) {
            for (int columnIndex = 0; columnIndex < columnSize; columnIndex++) {
                System.out.print(wood[rowIndex][columnIndex].getHeight());
            }
            System.out.println("");
        }
        System.out.println("----------");
    }

}
