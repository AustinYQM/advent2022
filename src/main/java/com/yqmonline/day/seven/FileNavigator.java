package com.yqmonline.day.seven;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class FileNavigator {
    public static Directory currentDirectory;
    public static final Stack<Directory> previousDirectory = new Stack<>();
    public static final List<Directory> allDirectories = new ArrayList<>();

    public static Directory doCDCommand(String option) {
        if(option.equals("..")) {
            currentDirectory = previousDirectory.pop();
        } else {
            previousDirectory.push(currentDirectory);
            Directory newD = new Directory(currentDirectory, option);
            if(currentDirectory != null) currentDirectory.addDirectory(newD);
            allDirectories.add(newD);
            currentDirectory = newD;
        }
        return currentDirectory;
    }
    public static Directory rootDirectory() {
        return allDirectories.stream().filter(d -> d.getParentDirectory() == null).toList().get(0);
    }




}
