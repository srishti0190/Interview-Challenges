package com.linkedList.geek;

import java.util.ArrayList;
import java.util.Scanner;

import com.practice.hacker.CharacterRecognition;

public class Lazada {
	public static void main(String args[]){
//		Scanner sc=new Scanner(System.in);
//		
//	       int N=sc.nextInt();
//	       int M=sc.nextInt();
//	       int K=sc.nextInt();
//	       sc.nextLine();
//	       
//	      for(int i=0;i<K;i++){
//	    	  
//	    	  ArrayList<String> matrix = new ArrayList<>();
//	    	  String temp="";
//	    	  sc.nextLine();
//	    	    for(int j=0;j<N;j++){
//	    	    temp=temp.concat(sc.nextLine());	    
//	    		}
//       }
	      
	      System.out.println(new Lazada().solution("))"));
	}
	
	
	public int solution(String str) { 
		int closingBracket = 0;
		int openingBracket = 0;
		
		for(int i=0;i<str.length();i++){
			if(str.charAt(i) ==')'){
				closingBracket ++;
			}
		}
		
		for(int j=0; j<str.length();j++){
			if(closingBracket == openingBracket){
				System.out.println(closingBracket);
				System.out.println(openingBracket);
				return j;
			}
			System.out.println(closingBracket+ "closing");
			System.out.println(openingBracket +"opening");
				if(str.charAt(j)==')'){
					closingBracket --;
				}else if (str.charAt(j) == '('){
					openingBracket ++;
				}

		}
		return -1;
	}
	
	

		
		
		
//	    int closingBracket = 0;
//	    int openingBracket = 0;
//
//	    for (int i = 0; i < s.length(); i++) {
//	        char c = s.charAt(i);
//	        if (c == ')') {
//	            closingBracket++;
//	        }
//	    }
//
//	    for (int i = 0; i < s.length(); i++) {
//	        if (openingBracket == closingBracket) {
//	            return i;
//	        }
//
//	        char c = s.charAt(i);
//	        if (c == ')') {
//	            closingBracket--;
//	        } else if (c == '(') {
//	            openingBracket++;
//	        }
//	    }
//
//	    return -1
	}

