package com.linkedList.geek;

import java.util.Iterator;
import java.util.LinkedList;

public class FindBridge {
	private int V;   // No. of vertices
	 
    // Array  of lists for Adjacency List Representation
    private LinkedList<Integer> adj[];
    int time = 0;
    static final int NIL = -1;
	
	
	public static void main(String args[])
    {
        // Create FindBridges given in above diagrams
        System.out.println("Bridges in first FindBridge ");
        FindBridge g1 = new FindBridge(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        g1.bridge();
        System.out.println();
// 
//        System.out.println("Bridges in Second FindBridge");
//        FindBridge g2 = new FindBridge(4);
//        g2.addEdge(0, 1);
//        g2.addEdge(1, 2);
//        g2.addEdge(2, 3);
//        g2.bridge();
//        System.out.println();
// 
//        System.out.println("Bridges in Third FindBridge ");
//        FindBridge g3 = new FindBridge(7);
//        g3.addEdge(0, 1);
//        g3.addEdge(1, 2);
//        g3.addEdge(2, 0);
//        g3.addEdge(1, 3);
//        g3.addEdge(1, 4);
//        g3.addEdge(1, 6);
//        g3.addEdge(3, 5);
//        g3.addEdge(4, 5);
//        g3.bridge();
    }
	

 
    // Constructor
    FindBridge(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }
 
    // Function to add an edge into the FindBridge
    void addEdge(int v, int w)
    {
        adj[v].add(w);  // Add w to v's list.
        adj[w].add(v);  //Add v to w's list
    }
    
    private void bridge(){
    	int parent[] = new int[V]; 
    	Boolean visited[] = new Boolean[V];
    	int disc[] = new int[V];
        int low[] = new int[V];
        
        for(int i =0; i<V; i++){
        	parent[i]= NIL;
        	visited[i] = false;
        }
    	
        for(int i=0; i<V; i++){
        	if(visited[i] ==false){
        		bridgeUtil(i, parent, visited, disc, low);
        	}
        }
    }
    
    private void bridgeUtil(int i , int[] parent, Boolean visited[], int []disc, int[] low){
    	visited[i] = true;
    	
    	Iterator<Integer> iterator  = adj[i].iterator();
    	
    	disc[i] = low[i] = ++time;
 
    	
    	while(iterator.hasNext()){
    		int v = iterator.next();   		
    		
    		if(!visited[v]){				
    			parent[v]=i;
    			bridgeUtil(v, parent, visited, disc, low);
    			
    			 low[i]  = Math.min(low[i], low[v]);
    			 
    			 if (low[v] > disc[i])
                     System.out.println(i+" "+v);
    		}
    		 else if (v != parent[i])
                 low[i]  = Math.min(low[i], disc[v]);
         }
    	}
    
    
   
    }

