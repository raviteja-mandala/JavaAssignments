package raviteja.assignment.data;

public class ClassOne {
    public int intVar;
    public char charVar;
    public void printVariables(){
        System.out.println(this.intVar);
        System.out.println(this.charVar);
    }
    public void printLocalVariables(){
        int intLocalVar;
        char charLocalVar;
      /*  System.out.println("local int variable --> "+intLocalVar+" local char variable --> "+charLocalVar);*/
    }
}
