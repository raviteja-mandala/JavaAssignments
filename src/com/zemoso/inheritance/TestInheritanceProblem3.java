package com.zemoso.inheritance;

public class TestInheritanceProblem3 extends ConcreteChild implements Child{
    public void printName(ParentOne pOne){
        System.out.println();
    }
    public void printName(ParentTwo pTwo){
        System.out.println();
    }
    public void printName(ParentThree pThree){
        System.out.println();
    }
    public void printName(Child child){
        System.out.println();
    }

    @Override
    public void printParentName() {

    }

    @Override
    public void printParentId() {

    }

    @Override
    public void printChildName() {

    }

    public static void main(String[] args){
        TestInheritanceProblem3 object=new TestInheritanceProblem3();
        ParentOne parentOne=object;
        ParentTwo parentTwo=object;
        ParentThree parentThree=object;
        Child child=object;
        object.printName(parentOne);
        object.printName(parentTwo);
        object.printName(parentThree);
        object.printName(child);
    }
}

interface ParentOne{
    void printParentName();
    void printParentId();
}

interface ParentTwo{
    void printParentName();
    void printParentId();
}

interface ParentThree{
    void printParentName();
    void printParentId();
}

interface Child extends ParentOne,ParentTwo,ParentThree{
    void printChildName();
}

class ConcreteChild {

}
