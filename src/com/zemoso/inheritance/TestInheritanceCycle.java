package com.zemoso.inheritance;

public class TestInheritanceCycle {
    public static void main(String[] args){
        Cycle[] cycles={new Unicycle(),new Bicycle(),new Tricycle()};
        for(Cycle cycle : cycles){
          //  cycle.balance();
            if(cycle instanceof Unicycle){
                ((Unicycle)cycle).balance();
            }
            if(cycle instanceof Bicycle){
                ((Bicycle)cycle).balance();
            }
        }
    }
}

class Cycle{

}

class Unicycle extends Cycle{
    public void balance(){
        System.out.println("balancing unicycle");
    }
}
class Bicycle extends Cycle{
    public void balance(){
        System.out.println("balancing bicycle");
    }
}
class Tricycle extends Cycle{

}


