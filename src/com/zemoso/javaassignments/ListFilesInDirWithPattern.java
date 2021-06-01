package com.zemoso.javaassignments;

import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ListFilesInDirWithPattern {
    private static int noOfFilesFound=0;
    public static void main(String[] args){
        Scanner scannerInput = new Scanner(System.in);
        File dirPath=new File("/home/ravitm/Desktop/testRepository/");
        System.out.println("Enter the file name pattern to search. Enter -1 to end the program.");
        String userInput=scannerInput.next();
        while(!(userInput.equalsIgnoreCase("-1"))){
            findFilesWithPattern(userInput,dirPath);
            if(noOfFilesFound==0){
                System.out.println("No files found with the given pattern");
            }
            if(noOfFilesFound>0){
                noOfFilesFound=0;
            }
            userInput=scannerInput.next();
        }
        scannerInput.close();
    }

    private static void findFilesWithPattern(String userInput, File dirPath) {
        File[] filesList=dirPath.listFiles();
        for(int i=0;i<filesList.length;i++){
            if(filesList[i].isDirectory()){
                findFilesWithPattern(userInput,filesList[i]);
            }
            else{
                if(Pattern.matches(userInput,filesList[i].getName())){
                    noOfFilesFound++;
                    System.out.println(filesList[i].getAbsolutePath());
                }
            }
        }
    }
}
