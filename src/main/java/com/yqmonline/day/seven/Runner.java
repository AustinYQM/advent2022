package com.yqmonline.day.seven;

import com.yqmonline.day.five.Instruction;
import com.yqmonline.util.FileReader;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Runner {
    private static final int FILE_SIZE = 100000;
    private static final List<String> input = FileReader.readEntireFile("D7");
    private static final List<Directory> directories = new ArrayList<>();
    private static Directory currentDirectory;

    public static void main(String[] args) {
        for (String line : input) {
            if(line.startsWith("$")) {
                // is a command;
                String[] splits = line.split(" ");
                if(splits[1].equals("cd")) {
                    String dName = splits[2];
                    FileNavigator.doCDCommand(dName);
                }
            } else {
                // is a response
                if(!line.startsWith("dir")) {
                    String[] splits = line.split(" ");
                    FileNavigator.currentDirectory.addFile(splits[1], Integer.parseInt(splits[0]));
                }
            }

        }

        int total = FileNavigator.allDirectories.stream().mapToInt(Directory::getChildrenSize).filter(i -> i <= FILE_SIZE).sum();

        int totalSpace = 70000000;
        int target = 30000000 - (totalSpace - FileNavigator.rootDirectory().getChildrenSize());
        System.out.println("Part 1: " + total);

        int toDelete = FileNavigator.allDirectories.stream().mapToInt(Directory::getChildrenSize).filter(i -> i >= target).sorted().toArray()[0];
        System.out.println("Part 2: " + toDelete);
    }
}
