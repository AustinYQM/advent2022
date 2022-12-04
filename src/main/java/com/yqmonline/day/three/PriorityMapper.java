package com.yqmonline.day.three;

public class PriorityMapper {


    public static int mapSinglePriority(char priority) {
        if(Character.isUpperCase(priority)) {
            return (int) priority - 38;
        }
        if(Character.isLowerCase(priority)) {
            return (int) priority - 96;
        }
        return 0;
    }

}
