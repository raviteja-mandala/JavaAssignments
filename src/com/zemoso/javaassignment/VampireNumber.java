package com.zemoso.javaassignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class VampireNumber {
    public int vampireNoCount;
    public VampireNumber(int number){
        this.vampireNoCount=number;
    }
    public List<VampireFactors> generateVampireNumbers(){
        int vampireNos=0;
        int numberOfDigits=0;
        List<VampireFactors> vampireFactorsList=new ArrayList<VampireFactors>();
        for(int i=1260;;i++){
            numberOfDigits=getNoOfDigits(i);
            if(numberOfDigits%2==0){
                getVampireNumberFactors(i,numberOfDigits,vampireFactorsList);
            }
            if(vampireFactorsList.size()==vampireNoCount){
                break;
            }
        }
        return vampireFactorsList;
    }

    private void getVampireNumberFactors(int evenDigitsNumber, int numberOfDigits,List<VampireFactors> vampireFactorsList) {
        int secondFactor=0;
        int minRangeNumber=(int)Math.pow(10,(numberOfDigits/2)-1);
        int maxRangeNumber=(int)Math.pow(10,(numberOfDigits/2));
        for(int i = minRangeNumber; i<=maxRangeNumber-1; i++){
            if(evenDigitsNumber%i==0){
                secondFactor=evenDigitsNumber/i;
                if(getNoOfDigits(secondFactor)==numberOfDigits/2){
                    String firstFactorStr= String.valueOf(i);
                    String secondFactorStr=String.valueOf(secondFactor);

                    char[] combinedNumberArray=(firstFactorStr+secondFactorStr).toCharArray();
                    Arrays.sort(combinedNumberArray);


                    String mainNumberStr=String.valueOf(evenDigitsNumber);
                    char[] mainNumberStrArray=mainNumberStr.toCharArray();
                    Arrays.sort(mainNumberStrArray);
                    String s1=String.valueOf(combinedNumberArray);
                    String s2=String.valueOf(mainNumberStrArray);
                    if(s1.equalsIgnoreCase(s2) && !(i%10==0 && secondFactor%10==0)){
                        vampireFactorsList.add(new VampireFactors(evenDigitsNumber,i,secondFactor));
                        break;
                    }


                }
            }
        }

    }

    private int getNoOfDigits(int i) {
        int numberOfDigits=0;
        while(i>0){
            i=i/10;
            numberOfDigits++;
        }
        return numberOfDigits;
    }

    public static void main(String[] args){
        System.out.println("Enter n to get first n vampire numbers ");
        Scanner scanner=new Scanner(System.in);
        int vampireNoCount=scanner.nextInt();
        VampireNumber vnumber=new VampireNumber(vampireNoCount);
        printVampireNumbers(vnumber.generateVampireNumbers());
    }

    private static void printVampireNumbers(List<VampireFactors> vampireFactorsList) {
        for(VampireFactors vampireFactorVariable: vampireFactorsList){
            System.out.println(vampireFactorVariable.mainNumber+"="+ vampireFactorVariable.firstFactor+"*"+vampireFactorVariable.secondFactor);
        }
    }
}
class VampireFactors{
    public int mainNumber;
    public int firstFactor;
    public int secondFactor;
    public VampireFactors(int mainNumber,int firstFactor, int secondFactor){
        this.mainNumber=mainNumber;
        this.firstFactor=firstFactor;
        this.secondFactor=secondFactor;
    }
}
