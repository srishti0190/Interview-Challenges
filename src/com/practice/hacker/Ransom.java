package com.practice.hacker;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Ransom {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
        }
        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
        }
        find(magazine,ransom);
    }
     
    private static void find(String magazine[], String ransom[]){
        HashSet<String> set = new HashSet<String>();
        int a= 0;
        if(magazine.length<ransom.length){
            System.out.println("No");
        }else{
            for(int i=0; i<magazine.length; i++){
                if(ransom.length!=i){
                    if(set.add(ransom[i])!=true){
                        a++;
                        System.out.println(a);
                    }
                       if(set.add(magazine[i])!=true)
                       a++;
                       
                       if(ransom.length==a){
                          
                       }
                }
            }
        }      
    }
}
