package com.yqmonline.util;



import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {

   public static List<String> readEntireFile(String fileName) {
        List<String> results = null;
        try(Stream<String> lines = Files.lines(Paths.get("src/main/resources/"+fileName+".input"))) {
            results = lines.collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Can't see shit boss");
            System.out.println(e.getMessage());
        }
        return results != null ? results : new ArrayList<>();
   }

   public static List<Character> fileIsOneLine(String fileName) {
       List<Character> chars = new ArrayList<>();
       try(Scanner read = new Scanner(new File("src/main/resources/"+fileName+".input"))) {
           for(char c : read.nextLine().toCharArray()) {
               chars.add(c);
           }
       } catch (Exception e) {
           System.out.println("Can't see shit boss");
       }
       return chars;
   }
}
