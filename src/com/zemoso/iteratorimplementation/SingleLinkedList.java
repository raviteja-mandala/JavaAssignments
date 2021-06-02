package com.zemoso.iteratorimplementation;

public class SingleLinkedList {
    public static void main(String[] args){
        SList slist=new SList(2);
        SlistIterator slistIterator=slist.getIterator();
        slistIterator.printElements();
        slistIterator.addElement(3);
        slistIterator.printElements();
        slistIterator.addElement(4);
        slistIterator.printElements();
        slistIterator.addElement(5);

        //new iterator object
       /* SlistIterator slistIterator2=slist.getIterator();
        while(slistIterator2.hasNextElement()){
            System.out.print(slistIterator2.nextElement());
        }
        System.out.println();*/
        slistIterator.printElements();
        slistIterator.removeElement();
        slistIterator.printElements();
        slistIterator.removeElement();
        slistIterator.printElements();
        slistIterator.removeElement();
        slistIterator.printElements();



    }

}

class SList{
    public int value;
    public SList next;
    public SList(int value){
        this.value=value;
        this.next=null;
    }

    public  SlistIterator getIterator(){
        return new SlistIterator(this);
    }
}

class SlistIterator{
    SList head;
    SList headVar;
    SlistIterator(){
        this.head=null;
        this.headVar=null;
    }
    SlistIterator(SList head){
        this.head=head;
        this.headVar=head;
    }

    boolean hasNextElement(){
        boolean retStatus=false;
        if( head!=null && head==headVar){
            retStatus=true;
        }
        else{
        if(this.headVar.next==null)
            retStatus=false;
        }
        return retStatus;
    }

   /* int nextElement(){
        if(head==headVar){
            return headVar.value;
        }
        else {
            headVar = headVar.next;
            return headVar.value;
        }
    }*/
    void addElement(int elementValue){
        if(!(this.hasNextElement())){
            headVar.next=new SList(elementValue);
            headVar=headVar.next;
        }
        else if(headVar==null){
            headVar=new SList(elementValue);
            head=headVar;
        }
        else{
            SList sListAfterThisElement = this.headVar.next;
            headVar.next = new SList(elementValue);
            headVar.next.next = sListAfterThisElement;
            headVar = headVar.next;
        }
    }

    void removeElement(){
        SList headVarLocal=head;
        while(true){
            if(headVarLocal==headVar){
                headVar=headVar.next;
                headVarLocal=headVar;
                if(headVar==null){
                    head=null;
                }
                break;
            }
            else if(headVarLocal.next==headVar){
                headVarLocal.next=headVar.next;
                if(headVarLocal.next!=null) {
                    headVar = headVarLocal.next;
                }
                else{
                    headVar=headVarLocal;
                }
                break;
            }
            headVarLocal=headVarLocal.next;

        }

    }

    void printElements(){
        if(head!=null) {
            SList headVarLocal=head;
            while (headVarLocal != null) {
                System.out.print(headVarLocal.value+" ");
                headVarLocal=headVarLocal.next;
            }
            System.out.println();
        }
    }

}
