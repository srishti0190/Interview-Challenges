package com.linkedList.geek;

import java.util.ArrayList;
import java.util.Scanner;

public class LinkedList1 {

	private Node head;
	
	public void modifyHeadPointer(ArrayList<LinkedList1.Node> integers){
		@SuppressWarnings("unchecked")
		ArrayList<LinkedList1.Node> node_list = (ArrayList<LinkedList1.Node>)integers.clone(); 

		int pointer_odd =0;
		int pointer_even = 0;
		int pointer_position=0;
		
		for(int i=0; i<integers.size();i++){		
			if(integers.get(i).getData()%2==1){
				pointer_odd = i;
			}else{
				LinkedList1.Node temp = integers.get(0);
				
				
				LinkedList1.Node even  = integers.get(i);
				
				
				even.node = temp; 
				
				node_list.remove(i);
				node_list.add(pointer_position, even);
				pointer_position++;
					
				
				if(pointer_even!=0){
					integers.get(pointer_even).node = even; 
				}
				pointer_even = i; 
				if(pointer_even==integers.size()-1){
					integers.get(pointer_odd).node =null;
				}else{
					integers.get(pointer_odd).node = integers.get(pointer_even+1);  
				}
				
			}
		}
		for(int i=0; i<integers.size();i++){		
				System.out.print(node_list.get(i).getData()+" ");		
		}
		
	}
	
	
	public static void main(String [] args){
		
		LinkedList1 link = new LinkedList1();
		
		Scanner sc=new Scanner(System.in);
		String line1 = sc.nextLine();
		
		for(int i=0; i<Integer.parseInt(line1);i ++){
			String line2= sc.nextLine();
			String ine3 = sc.nextLine();
			
			ArrayList<LinkedList1.Node> integers = new ArrayList<LinkedList1.Node>();
			
			String[] arry = ine3.split(" ");
			
			
			int data = Integer.parseInt(arry[0]);		
			LinkedList1.Node head = link.new Node();
			head.data = data;
			
			for(int y=1; y <arry.length; y++){
				data = Integer.parseInt(arry[y]);
				LinkedList1.Node node = link.new Node();
				node.data = data;
				head.node =node;
						
				integers.add(head);
				
				head = node;
				if(y==arry.length-1){
					integers.add(head);
				}
			}
			link.modifyHeadPointer(integers);
			System.out.println();
		}
	}
	
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
}

