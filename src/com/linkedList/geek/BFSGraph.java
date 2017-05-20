package com.linkedList.geek;

import java.util.ArrayList;
import java.util.List;

public class BFSGraph {

		public static void main(StringManipulate [] args){
			
		}
		
		public class Node{
			private ArrayList<Node> adjacent_nodes;
			private boolean visited;
			private int data;
			public ArrayList<Node> getAdjacent_nodes() {
				return adjacent_nodes;
			}
			public void setAdjacent_nodes(ArrayList<Node> adjacent_nodes) {
				this.adjacent_nodes = adjacent_nodes;
			}
			public boolean isVisited() {
				return visited;
			}
			public void setVisited(boolean visited) {
				this.visited = visited;
			}
			public int getData() {
				return data;
			}
			public void setData(int data) {
				this.data = data;
			}
			
			
			
		}
		
		
		public void bfsTraversal(Node d){
			ArrayList<Node> adjacent = d.adjacent_nodes;
			System.out.print(d.data +" ");
			d.visited = true;
				
			 for(Node ad : adjacent){
				 if(d.visited!=true){
						System.out.print(d.data +" ");
						d.visited = true;
					}else{
						continue;
					}	 
			 }
		}	
}
