package com.linkedList.geek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StringManipulate {

    public static void main(StringManipulate[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	Scanner sc = new Scanner(System.in);
    	int a = sc.nextInt();
    	String arr[] = new String[a]; 
    	
    	for(int i=0; i<a ; i++){
    		String next = (String)sc.nextLine();
    		arr[i] = next;
    	}
    	Arrays.sort(arr);
    	
    	int b = sc.nextInt();
    	for(int y =0; y<b; y++){
    		
    	}
    }
}
