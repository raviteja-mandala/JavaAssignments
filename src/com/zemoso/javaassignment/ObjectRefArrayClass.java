package com.zemoso.javaassignment;

public class ObjectRefArrayClass {
    public ObjectRefArrayClass(String accountName){
        System.out.println("AccountName --> "+accountName);
    }

    public static void main(String[] args){
        ObjectRefArrayClass[] objectArray=new ObjectRefArrayClass[3];
        objectArray[0]=new ObjectRefArrayClass("A1");
        objectArray[1]=new ObjectRefArrayClass("A2");
        objectArray[2]=new ObjectRefArrayClass("A3");
    }
}
