package com.zemoso.filereader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class TestFileReader {
    public static void main(String[] args){
        File file=new File("/home/ravitm/Documents/a2.txt");
        HashMap<Character,Integer> hashMap=new HashMap<Character,Integer>();
        try {
            FileReader fileReader = new FileReader(file);
            int i;
            while((i=fileReader.read())!=-1){
                char character=(char)i;
                if(hashMap.get(character)==null){
                    hashMap.put(character,1);
                }
                else{
                    hashMap.put(character,hashMap.get(character)+1);
                }
            }
        }
        catch(IOException exception){

        }
        System.out.println(hashMap);
    }
}
