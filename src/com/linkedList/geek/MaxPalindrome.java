package com.linkedList.geek;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class MaxPalindrome {
	
	private       
    Stack<Integer> set = new Stack<Integer>();
	private ArrayList<Integer> array;

	private int max_palindrome;
	
	public class Node{
		private int data;
		private Node node;
		
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public Node getNode() {
			return node;
		}
		public void setNode(Node node) {
			this.node = node;
		} 		
	}
	
	public Node maxPalindrome(Node head)
    {     
      if(set.search(head.getData())==-1){
    	  array = new ArrayList<>();
    	  set.push(head.getData());
      }else{
   	  
    	  int index =set.search(head.getData());
    	  System.out.println("look at the index of 2" +index);

    		  String pal = String.valueOf(set.subList(index-1, set.size()));
    		  array.add(head.getData());
    		  
        	  System.out.println("apla of value" +pal);
    		  
        	  pal = pal+array.toString();
        	  
        	  System.out.println("apla" +pal);
        	  
        	  StringBuffer strBuff = new StringBuffer(pal);
        	  if (pal.equals(strBuff.reverse())){
            	maxPalindrome(pal.length());

    	     	
      }
      }

       
      return head;
    }
	

	public void maxPalindrome(int max_length){
	max_palindrome = Math.max(max_length, max_palindrome);
	}
	
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		String line1 = sc.nextLine();
		
		ArrayList<Node> nodes = new ArrayList<>();
		
		MaxPalindrome maxPalindrome = new MaxPalindrome();
		
		
		for(int i =0; i<Integer.parseInt(line1); i++){
			String line2 = sc.nextLine();
			String line3 = sc.nextLine();
			
			String [] arry = line3.split(" ");
			
			
			Node head = maxPalindrome.new Node();
			head.data = Integer.parseInt(arry[0]);
			
			for(int y=1; y<arry.length; y++){
				Node temp = maxPalindrome.new Node();
				
				temp.data = Integer.parseInt(arry[y]);
				head.node = temp;
				
				
				maxPalindrome.maxPalindrome(temp);
			
				
				head = temp;		
				
			}
			
		}	
		
		System.out.println(maxPalindrome.max_palindrome);
		
	}
}
