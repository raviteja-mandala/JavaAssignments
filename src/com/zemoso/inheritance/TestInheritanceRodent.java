package com.zemoso.inheritance;

public class TestInheritanceRodent {
public static void main(String[] args){
    Rodent[] rodents={new Mouse(),new Gerbil(),new Hamster()};
    for(Rodent rodent : rodents){
        rodent.eatFood();
    }
}
}

abstract class Rodent{
    Rodent(){
        System.out.println("This is also a Rodent class");
    }
    public abstract void eatFood();
}
class Mouse extends Rodent{
    Mouse(){
        System.out.println("This is from Mouse class");
    }

    public void eatFood(){
        System.out.println("mouse is eating");
    }
}
class Gerbil extends Rodent{
    Gerbil(){
        System.out.println("This is from Gerbil class");
    }

    public void eatFood(){
        System.out.println("gerbil is eating");
    }
}
class Hamster extends Rodent{
    Hamster(){
        System.out.println("This is from Hamster class");
    }

    public void eatFood(){
        System.out.println("hamster is eating");
    }
}
