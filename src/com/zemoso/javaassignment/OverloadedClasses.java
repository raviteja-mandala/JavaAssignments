package com.zemoso.javaassignment;

public class OverloadedClasses {
    public Integer accountId;
    public Integer employeeId;
    public String accountName;

    public OverloadedClasses(int accountId){
        this.accountName="HDFC"+accountId;
        System.out.println("accountName--> "+accountName);
    }

    public OverloadedClasses(int accountId, int employeeId){
        this(accountId);
        this.accountId=accountId;
        this.employeeId=employeeId;
        System.out.println("accountId--> "+accountId);
        System.out.println("employeeId--> "+employeeId);
    }

    public static void main(String[] args){
        OverloadedClasses olc1=new OverloadedClasses(1,12);
    }
}
