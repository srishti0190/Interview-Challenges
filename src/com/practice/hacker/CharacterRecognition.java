package com.practice.hacker;

import java.util.ArrayList;
import java.util.Scanner;

import com.practice.hacker.TrieMaxXor.TrieNode;

public class CharacterRecognition {
	
	private ArrayList<ArrayList<String>> arrayList; 
	private int pixelcount =0;
 
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		
		CharacterRecognition chars = new CharacterRecognition();
		
		chars.arrayList = new ArrayList<ArrayList<String>>();
		
		
	       int N=sc.nextInt();
	       int M=sc.nextInt();
	       int K=sc.nextInt();
	       sc.nextLine();
	       
	      for(int i=0;i<K;i++){
	    	  
	    	  ArrayList<String> matrix = new ArrayList<>();
	    	  String temp="";
	    	  sc.nextLine();
	    	    for(int j=0;j<N;j++){
	    	    temp=temp.concat(sc.nextLine());	    
	    		}
	    	    matrix.add(temp);
	    	    chars.arrayList.add(matrix); 
	    	    chars.insert(chars.arrayList);
       }
	}
	
	public class TrieNode
	   {
		   public int value; // Only used in leaf nodes
		   public TrieNode[] arr  = new TrieNode[2];
	   }
	
	private void insert(ArrayList<ArrayList<String>> matrix){
		for(int i=0; i< matrix.size(); i++){
			ArrayList<String> temp = matrix.get(i);
			ArrayList<String> temp2= null;
			if(i!=matrix.size()-1){
			temp2 = matrix.get(i+1);
			for(int y=0; y<temp.size();y++){
				if(Integer.parseInt(temp.get(y))!=Integer.parseInt(temp2.get(y))){
					pixelcount++;
					break;
				}
			}		
			}		
			
			
		}
	}
}
