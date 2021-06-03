package com.zemoso.dates;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Assignment4 {
    public static void main(String[] args){
        System.out.println("Enter the number of inputs in the first line: ");
        System.out.println("Enter registration date and current date in the second line in this pattern: 'dd-mm-yyyy dd-mm-yyyy'");
        Scanner scanner=new Scanner(System.in);
        String noOfInputsStr=scanner.nextLine();
        int n=Integer.parseInt(noOfInputsStr);
        List<String> datesList=new ArrayList<String>();
        String regAndCurrentDate;
        for(int i=0;i<n;i++){
            regAndCurrentDate=scanner.nextLine();
            datesList.add(regAndCurrentDate);
        }
        String[] splitDates=new String[2];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate registrationDate=LocalDate.now();
        LocalDate currentDate=LocalDate.now();
        LocalDate lowerLimitRegDate=LocalDate.now();
        LocalDate upperLimitRegDate=LocalDate.now();
        for(int i=0;i<n;i++){
            splitDates=datesList.get(i).split(" ");
            try {
                registrationDate = LocalDate.parse(splitDates[0],formatter);
                currentDate = LocalDate.parse(splitDates[1],formatter);
            }
            catch(Exception e){
System.out.println(e.getStackTrace());
            }
            long days= Duration.between(registrationDate.atStartOfDay(),currentDate.atStartOfDay()).toDays();
            if(days<=30 && days>=-30){
                System.out.println("No Range");
            }
            else {
                lowerLimitRegDate = upperLimitRegDate = registrationDate;
                lowerLimitRegDate=lowerLimitRegDate.withYear(currentDate.getYear());
                upperLimitRegDate=upperLimitRegDate.withYear(currentDate.getYear());
                lowerLimitRegDate=lowerLimitRegDate.minusDays(30);
                upperLimitRegDate=upperLimitRegDate.plusDays(30);
                System.out.print(formatter.format(lowerLimitRegDate) + " " + formatter.format(upperLimitRegDate));
                System.out.println();
            }


        }
    }
}
