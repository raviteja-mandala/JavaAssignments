package com.zemoso.exception;

public class TestExceptions {

    public static void testExceptions(int number) throws NewExceptionOne,NewExceptionTwo,NewExceptionThree{
        if(number==1){
            throw new NewExceptionOne("NewExceptionOne thrown");
        }
        if(number==2){
            throw new NewExceptionTwo("NewExceptionTwo thrown");
        }
        if(number==3){
            throw new NewExceptionThree("NewExceptionThree thrown");
        }
    }

    public static void main(String[] args){
        try{
            TestExceptions.testExceptions(2);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            System.out.println("testing exceptions");
        }
    }
}

class NewExceptionOne extends Exception{
    public NewExceptionOne(String exceptionString){
        super(exceptionString);
    }
}

class NewExceptionTwo extends Exception{
    public NewExceptionTwo(String exceptionString){
        super(exceptionString);
    }
}

class NewExceptionThree extends Exception{
    public NewExceptionThree(String exceptionString){
        super(exceptionString);
    }
}
