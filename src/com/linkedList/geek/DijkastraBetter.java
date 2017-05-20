package com.linkedList.geek;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class DijkastraBetter {

	static class Edge{	
		int src;
		int dest; 
		int weight;

		public Edge(int src, int dest, int weight) {
			super();
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}	
	}

	static class Graph{
		int v;
		ArrayList<Edge> edges;

		public Graph(int v){
			this.v = v;
			edges = new ArrayList<Edge>();
		}

		public void addEdge(int src, int dest, int wt){
			edges.add(new Edge(src, dest, wt));
		}

		public List<Edge> findNeighbours(int src){
			ArrayList<Edge> neighbours = new ArrayList<Edge>();
			for(Edge edge : this.edges){
				// for undirected graph. For directed check only src == edge.src
				if(src == edge.src || src == edge.dest){
					neighbours.add(edge);
				}
			}
			return neighbours;
		}

	}

	public static void main(String[] args) {

		int vertices = 9;

		Graph g = new Graph(vertices);

		g.addEdge(0, 1, 4);
		g.addEdge(0, 7, 8);
		g.addEdge(1, 7, 11);
		g.addEdge(1, 2, 8);
		g.addEdge(2, 8, 2);
		g.addEdge(7, 8, 7);
		g.addEdge(7, 6, 1);
		g.addEdge(6, 8, 6);
		g.addEdge(2, 3, 7);
		g.addEdge(2, 5, 4);
		g.addEdge(6, 5, 2);
		g.addEdge(3, 5, 14);
		g.addEdge(3, 4, 9);
		g.addEdge(5, 4, 10);

		Integer[] markParent = new Integer[vertices];
		Integer[] markDist = new Integer[vertices];
		
		Map<Integer, Integer> mapHeap = new HashMap<Integer, Integer>();

		for(int i = 0; i < vertices; i++){
			mapHeap.put(i, Integer.MAX_VALUE);
		}
		mapHeap.put(0, 0);

		while(!mapHeap.isEmpty()){

			Entry<Integer, Integer> min = null;
			//get min value in map
			for (Entry<Integer, Integer> entry : mapHeap.entrySet()) {
				if (min == null || min.getValue() > entry.getValue()) {
					min = entry;
				}
			}
			int src = min.getKey();
			int dist = min.getValue();

			// update dist array
			markDist[src] = dist;
			
			// find neighbouring edges
			List<Edge> neighbours = g.findNeighbours(src);

			// find mind min dist to vertex for neighbours
			for(Edge edge : neighbours){
				int temp = src==edge.src?edge.dest:edge.src;
				if(mapHeap.containsKey(temp) && mapHeap.get(temp) > edge.weight + markDist[src]){
					mapHeap.put(temp, edge.weight + markDist[src]);
					markParent[temp] = src;
				}
			}	
			//remove min value src
			mapHeap.remove(src);

		}

		/*for(int i = 0; i < markParent.length; i++){
	System.out.println(markParent[i]); 
	}*/

		// print shortest dist to dest
		System.out.println("Vertex Dist");
		for(int i = 0; i < markDist.length; i++){
			System.out.println(i + " " +markDist[i]); 
		}
		System.out.println();

		// find path to destination
		Integer dest = 4;
		System.out.println("Path from 0 to " + dest + " : "); 
		printRes(markParent, dest);
		/*while(dest != null){
	System.out.print(dest + " ");
	dest = markParent[dest];
	}*/

	}

	static void printRes(Integer[] markParent, Integer dest){
		if(dest != null){
			printRes(markParent, markParent[dest]);	
			System.out.print(dest + " ");
		}
	}	
	
	
//	private void printShort(Graph g){
//		int vertices = 9;
//		
//		int dist[] = new int[9];
//		Boolean splSet[] = new Boolean[vertices]; 
//
//		
//		for(int i = 0; i<vertices; i++){
//			dist[i] = Integer.MAX_VALUE;
//			splSet[i] = false;
//		}
//		
//		dist[0] = 0;
//		
//		int parent[] = new int[9];
//		
//		int min = -1;
//		
//		for(int i = 0; i<vertices ; i++){
//			min = minimum(dist, splSet);
//			
//			List<Edge> list = g.findNeighbours(min);
//			
//			for(Edge edge: list){
//				if(min)
//			}
//			
//		}
//	}
//	
//	private int minimum(int[] dist, Boolean [] aplSet){
//		int min = 0;
//		int index_min = 0; 
//		for(int i=0; i<dist.length; i++){
//			if(dist[i]<=min && aplSet[i] == false){
//				min = dist[i];
//				index_min = i;
//			}
//		}
//		return index_min;
//	}
}
