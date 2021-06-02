package com.zemoso.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {

    public static void main(String[] args){
        System.out.println("Enter the sentence");
        Scanner scanner=new Scanner(System.in);
        String userInput=scanner.nextLine();
        Pattern p = Pattern.compile("^[A-Z]");
        Matcher matcher=p.matcher(userInput);
        if(matcher.find()){
            System.out.println("Sentence begins with a capital letter");
        }
        else{
            System.out.println("Sentence is not beginning with a capital letter");
        }
        p=Pattern.compile("[.]$");
        matcher=p.matcher(userInput);
        if(matcher.find()){
            System.out.println("Sentence ends with a period");
        }
        else{
            System.out.println("Sentence is not ending with a period");
        }
    }
}
