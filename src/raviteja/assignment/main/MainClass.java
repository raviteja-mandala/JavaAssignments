package raviteja.assignment.main;

import raviteja.assignment.data.ClassOne;
import raviteja.assignment.singleton.ClassTwo;

public class MainClass {
    public static void main(String[] args){
        ClassOne cOne=new ClassOne();
        cOne.printVariables();
        cOne.printLocalVariables();

        ClassTwo cTwo= ClassTwo.getSingletonObject();
        cTwo.printStrVar();
    }
}
