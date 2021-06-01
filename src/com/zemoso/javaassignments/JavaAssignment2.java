package com.zemoso.javaassignments;

import java.util.HashMap;
import java.util.Scanner;

public class JavaAssignment2 {
    //complexity - O(length of user string + 26)
    public static void main(String[] args){
        System.out.println("Please enter the input string ");
        Scanner scanner = new Scanner(System.in);
        String userInput=scanner.nextLine();
        checkForAllAlphabets(userInput);

    }

    public static void checkForAllAlphabets(String userInput){
        userInput=userInput.toLowerCase();
        int asciiValueOfChar=0;
        char charVariable;
        HashMap<Character,Integer> charHashMap=new HashMap<Character,Integer>();
        for(int i=0;i<userInput.length();i++){
            charVariable=userInput.charAt(i);
            asciiValueOfChar=charVariable;
            //copy all the alphabets present in the string once into hashmap with key as alphabet and value as 1.
            if(asciiValueOfChar>=97 && asciiValueOfChar<=122 && charHashMap.get(charVariable)==null){
                charHashMap.put(charVariable,1);
            }
        }

        char charVar;
        int charNotFoundFlag=0;
        //Run the loop and check whether all alphabets are present in the hashmap.
        for(int i=97;i<=122;i++){
            charVar=(char) i;
            if(charHashMap.get(charVar)==null){
                charNotFoundFlag=1;
                System.out.println("String doesn't contain all characters from a to z regardless of case");
                break;
            }
        }
        if(charNotFoundFlag==0){
            System.out.println("String provided by user contains all characters!");
        }

    }
}
