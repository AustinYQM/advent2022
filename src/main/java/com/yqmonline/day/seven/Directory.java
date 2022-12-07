package com.yqmonline.day.seven;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Directory {
    private Set<AFile> files = new HashSet<>();
    private Set<Directory> childDirectories = new HashSet<>();
    private final Directory parentDirectory;
    private final String directoryName;

    public Directory getParentDirectory() { return parentDirectory; }
    Directory(Directory parentDirectory, String directoryName) {
        this.parentDirectory = parentDirectory;
        this.directoryName = directoryName;
    }

    public void addFile(String filename, int size) {
        files.add(new AFile(filename, size));
    }
    public void addDirectory(String directoryName) {
        childDirectories.add(new Directory(this, directoryName));
    }
    public void addDirectory(Directory directory) {
        childDirectories.add(directory);
    }

    public int getFileSize() {
        return files.stream().mapToInt(AFile::size).sum();
    }

    public int getChildrenSize() {
        return childDirectories.stream().mapToInt(Directory::getChildrenSize).sum() + getFileSize();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj instanceof Directory d) {
            return this.parentDirectory.equals(d.parentDirectory) && this.directoryName.equals(d.directoryName);
        }
        return false;
    }
    public String buildParentList() {
        StringBuilder sb = new StringBuilder("/").append(this.directoryName);
        Directory iterator = parentDirectory;
        while(iterator != null) {
            sb.insert(0, iterator.directoryName).insert(0, "/");
            iterator = iterator.parentDirectory;
        }
        return sb.toString();
    }

}
