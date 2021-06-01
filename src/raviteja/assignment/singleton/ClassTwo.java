package raviteja.assignment.singleton;

public class ClassTwo {
    public String stringVar;
   /* public static void initializeVars(String str){
        this.stringVar=str;
    }*/
    public void printStrVar(){
        System.out.println(this.stringVar);
    }
    public static ClassTwo singletonObject=new ClassTwo();
    public static ClassTwo getSingletonObject(){
        return singletonObject;
    }
}
