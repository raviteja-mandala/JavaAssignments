package com.zemoso.inheritance;

public class TestInheritanceProblem4 {
    public static void main(String[] args){
        Cycle1 cycle1=FactoryMethod.getCycle1("Unicycle1");
        cycle1.getCost();
    }

}

interface Cycle1{
    int getCost();
}

class Unicycle1 implements Cycle1{
    public int getCost(){
        return 10;
    }
}

class Bicycle1 implements Cycle1{
    public int getCost(){
        return 20;
    }
}

class Tricycle1 implements Cycle1{
    public int getCost(){
        return 30;
    }
}

class FactoryMethod{
    public static Cycle1 getCycle1(String getType){
        Cycle1 cycle1=null;
        if(getType.equalsIgnoreCase("Unicycle")){
            cycle1=new Unicycle1();
        }
        if(getType.equalsIgnoreCase("Bicycle")){
            cycle1=new Bicycle1();
        }
        if(getType.equalsIgnoreCase("Tricycle")){
            cycle1=new Tricycle1();
        }
        return cycle1;
    }
}
