package com.yqmonline.day.five;

import com.yqmonline.util.FileReader;

import java.util.*;

public class PartOne {
    static List<String> input = FileReader.readEntireFile("D5");
    static Map<Integer, Stack<String>> stackList = new LinkedHashMap<>();
    static List<Instruction> instructions = new ArrayList<>();

    public static void main(String[] args) {
        stackBuilder();
        stackList.replaceAll((k, v) -> reverseStacks(stackList.get(k)));
        stackList.values().forEach(System.out::println);
        buildInstructions();
        // doInstructions(); //part 1
        doInstructions2(); // part 2
        stackList.keySet().stream().sorted().forEach(k -> System.out.print(stackList.get(k).peek()));

    }
    private static void doInstructions() {
        for(Instruction instruction : instructions) {
            int count = instruction.countToMove();
            System.out.println(instruction);
            while(count-- != 0) {
                stackList.get(instruction.toCol()).push(stackList.get(instruction.fromCol()).pop());
            }
        }
    }
    private static void doInstructions2() {
        for(Instruction instruction : instructions) {
            int count = instruction.countToMove();
            System.out.println(instruction);
            Stack<String> temp = new Stack<>();
            while(count-- != 0) {
                temp.push(stackList.get(instruction.fromCol()).pop());
            }
            while(!temp.isEmpty()) {
                stackList.get(instruction.toCol()).push(temp.pop());
            }
        }
    }

    private static void buildInstructions() {
        for(String i : input) {
            if(i.startsWith("move")) {
                String[] splits = i.split(" ");
                instructions.add(new Instruction(Integer.parseInt(splits[1]), Integer.parseInt(splits[3]), Integer.parseInt(splits[5])));
            }
        }
    }

    private static void stackBuilder() {
        for(String i : input) {
            if (i.startsWith("[")) {
                // This line is a stack
                for(int x = 1,  sCount = 1; x < i.length(); x += 4) {
                    String test = i.substring(x-1, x+2);
                    if(!test.isBlank()) {
                        stackList.putIfAbsent( sCount, new Stack<>()); // not x, figure out what that is.
                        stackList.get(sCount).push(test); // not x, figure out what that is.
                    }
                    sCount++;
                }
            }
            if(i.isEmpty()) {
                return;
                // no more stacks
            }
        }
    }

    private static Stack<String> reverseStacks(Stack<String> original) {
        Stack<String> newStack = new Stack<>();
        while(!original.isEmpty()) {
            newStack.push(original.pop());
        }
        return newStack;
    }

}
