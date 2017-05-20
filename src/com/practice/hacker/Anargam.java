package com.practice.hacker;

import java.io.*;
	import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//import com.linkedList.geek.Node;


public class Anargam {
	    public static int numberNeeded(String s, String s1) {
	int sum=0;
	    	for(char i='a';i<='z';i++){
	    		int len1=s.length()-s.replaceAll(Character.toString(i),"").length();
	    		int len2=s1.length()-s1.replaceAll(Character.toString(i),"").length();
	    		sum=sum+Math.abs(len1-len2);
	    	}
	    	return sum;
	        
	    }
	      
	  
	    public static void main(String[] args) {
	    	Anargam sol = new Anargam();
	    	
	    	/** Anagram **/
//	        Scanner in = new Scanner(System.in);
//	        String a = in.next();
//	        String b = in.next();
//	        System.out.println(numberNeeded(a, b));
	       	/** hourGalss **/
//	    	 Scanner sc=new Scanner(System.in);
//	         int array[][] = new int[6][6];
//	         
//	         for(int i = 0; i<6 ; i++){
//	              String line = sc.nextLine();
//	             String arr[]  = line.split(" ");
//	               for(int j=0; j<6; j++){
//	                 array[i][j] = Integer.parseInt(arr[j]); 
//	                 }
//	         }
//
//	         Anargam sol = new Anargam();
//	        System.out.println(sol.hourGlass(array));
	        
	       /** LeftRotation **/  
//	        Scanner in = new Scanner(System.in);
//	        int a = in.nextInt();
//	        int b = in.nextInt();

	       

//	        String[] arr = c.split(" ");
	        
//	       ArrayList<Integer> arrayList = new ArrayList<Integer>();
//	       
//	        for(int i = 0; i<a; i++){
//	        	String c = in.next();
//	        	arrayList.add(Integer.parseInt(c));
//	        }
//	        
//	        sol.leftRotation(arrayList, b);
	    	
	    	/** LinkedList add element **/ 
//	    	Node head = sol.new Node();
//	    	head.data = 5;
//	    	head.next=null; 
//
//	    	head = sol.InsertNth(head, 3, 0);
//	    	while(head!=null){
//	    		System.out.println(head.data);
//	    		head = head.next;
//	    	};
	    	
//	    	Node head = sol.new Node();
//	    	Node node1 = sol.new Node();
//	    	Node node2 = sol.new Node();
//	    	Node node3 = sol.new Node();
//	    	Node node4 = sol.new Node();
//	    	node1.data=3;
//	    	node2.data=6;
//	    	node3.data=1;
//	    	node4.data=0;
//	    	
//	    	head.data=5;
//	    	head.next= node1;
//	    	node1.next=node2;
//	    	node2.next=node3;
//	    	node3.next=node4;
//	    	node4.next=null;
//	    	
//	    	sol.findMiddleElement(node2,head);
	    	
	    	System.out.println(sol.binaryGap(8, 0, 0,0));
	    }
	    
	    public int hourGlass(int [][]args){
			int max_sum=Integer.MIN_VALUE;
	    	for(int i=0; i<args.length;i++){
	    		for(int j=0; j<args.length;j++){
	    			if((j>3 || i> 3)!=true){
	    			int sum = args[i][j]+args[i][j+1]+args[i][j+2]+args[i+1][j+1]+args[i+2][j]+args[i+2][j+1]+args[i+2][j+2];
	    			System.out.println(sum);
	    			max_sum = Math.max(sum, max_sum);
	    		}
	    		}
	    	}
	    	return max_sum;
	    }
	    
	    public void leftRotation(ArrayList<Integer> arrayList, int rot){	    	
	    	for(int i=0; i<rot; i++){
	    		int a = arrayList.get(0);
	    		arrayList.add(a);
	    		arrayList.remove(0);
	    	}
	    	
	    	for(int i=0; i<arrayList.size(); i++){
	    		System.out.print(arrayList.get(i) +" ");
	    	}
	    }
	    
	    Node InsertNth(Node head, int data, int position) {
	    	Node newNode = new Node();
	    	newNode.data=data;
	    	
	    	if(head==null){
	    		newNode.next=null;		    			    	
		    	return newNode;
	    	}else if(position==0){
	    		newNode.next=head;
		    	return newNode;
		    
	    	}else{
	    		Node root = head;
	    		Node next_node =null;
	    		for(int i=0; i<position ; i++){
	    			next_node = root.next;
		    		root = next_node;
		    	} 
		    	newNode.next=next_node;
		    	return head;
	    	}
	    	}
	    
	    void ReversePrint(Node head) {
	    	  // This is a "method-only" submission. 
	    	  // You only need to complete this method. 
	    	
	    	if(head==null){
	    		return; 
	    	}else{
		    	ReversePrint(head.next);
		    	System.out.println(head.data);
	    	}
	    	}
	    
	    Node Reverse(Node head) {
    		Node current =head;
    		Node previous = null; 
    		Node temp;
	    	while(current!=null){
	    		temp=current.next;
	    		current.next = previous;
	    		previous=current;
	    		current =temp;
	    	}
	    	head = previous;
	    	return head;
	    }
	    
	    
	    int CompareLists(Node headA, Node headB) {
	        // This is a "method-only" submission. 
	        // You only need to complete this method
	    	int number_nodes1 =0; 
	    	int number_nodes2=0;
	    	
	    	while(headA!=null || headB!=null){
	    		int dataa =0, datab = 0;
	    		if(headA!=null){
	    			dataa=headA.data;
	    			number_nodes1++;
	    			headA =headA.next;
	    		}
	    		if(headB!=null){
	    			datab = headB.data;
	    			number_nodes2++;
	    			headB=headB.next;
	    		}
	    		
	    		if((number_nodes1!=number_nodes2) || (dataa!=datab)){
	    			return 0;
	    		}
	    	}
	    	
	    	return 1;
	      
	    }
	    

	    boolean hasCycle(Node head) {
	    		HashSet<Node> visitedNodes = new HashSet<>();
	    		while(head!=null){
	    			if(visitedNodes.add(head) == false){
	    				return true; 
	    			}
	    			head = head.next;	    			
	    		}
	    		return false;
	    }
	    
//	    int FindMergeNode(Node headA, Node headB) {
//	        // Complete this function
//	        // Do not write the main method. 
//	    	if(headA!=null){
//	    		headA = headA.next;
//	    	}
//	    	if(headB!=null){
//	    		headB = headB.next;
//	    	}
//	    	
//	    }
	    
	    
	    Node SortedInsert(Node head,int data) {
	    	Node root = head;
	    	 Node n = new Node();
	    	 n.data=data;
	    	 
	    	 if(head ==null){
	    		 n.next=null;n.prev=null;
	    		 return n;
	    	 }
	    	 
	    	 while(head!=null){
	    		 if(head.data>data){
	    			 n.next=head;
	    			 n.prev=null;
	    			 head.prev=n;
	    			 return n;
	    		 }else{
	    		 if(head.next!=null){
	    		 if(head.next.data>data){
	    			 n.next=head.next;
	    			 head.next = n;
	    			 n.prev=head;
	    			 return root;
	    		 }else{
	    			head = head.next; 
	    		 }
	    		 }else{
	    			 head.next=n;
	    			 n.prev=head;
	    			 n.next=null;
	    			 return root;
	    		 }
	    		 }
	    		 
	    	 }
	    	 return root;
	    }
	    
	    
	    Node Reverse_double(Node head) {
	    	if(head==null){
    			return head;
    		}   
    		Node temp_pre = head.prev; 
    		head.prev = head.next;
    		head.next = temp_pre;
            Node root = Reverse(head.prev);
            if(root==null)
                return head;
            else
            	return null;
	    }
	    
	    public int[] solution(int N, int[] A) {
	        int counter = 0;
	        int counters[] = new int[N];
	        int current_max=0;
	        int max =0; 
	        
	        for(int i=counter; i<A.length; i++){
	         if(A[i]>=1 && A[i]<=N){
	        	 if(counters[A[i]-1]<current_max){
	        		 counters[A[i]-1] = current_max+1;
	        	 }else{
	        		 counters[A[i]-1]++;
	        	 }
	             max = Math.max(counters[A[i]-1],max);
	         }else{
	        	 current_max = max;
	         }
	            
	        }
	        return counters;
	        
	        
	    }
	    
	    
	    
	    public int findNthToLast(Node head, int n){
			int a = 0; 
			int b= 0;
			
			while(head!=null){
				head = head.next;
			if(b-a > n)
				a++;
			else 
				b++;
				}
			return a;
		} 
	    
	    public void findMiddleElement(Node middle, Node head){
	    	middle.data = middle.next.data;
	    	Node temp = middle.next;
	    	middle.next=null;
	    	middle.next = temp.next;
	    	temp=null;
	    	
	    	while(head!=null){
	    		System.out.print(head.data+ " ");
	    		head = head.next;
	    	}
	    	
	    }
	    
//	    public Node addNumberList(Node head1, Node head2){
//	       int carry =0;
//	    	Node root= null;
//	    	Node next = null;
//	    	int next_ =0;
//	    	int next_2=0;
//	    	
//	       while(head1!=null && head2!=null){
//	    	   int value = head1.data+head2.data+carry;
//	    	   if(head1.next!=null){
//	    		    next_ = head1.next.data;
//	    	   }else if(head2.next!=null){
//	    		   next_2 = head2.next.data;
//	    	   }
//	    	   int value_next = next_+next_2;
//	    	
//	    	   carry=0;
//	    	   if(value>9){
//	    		   carry=1;
//	    		   value=value%10;
//	    	   }
//	    	   root = new Node();
//	    	   next = new Node();
//	    	   next.data = value_next;
//	    	   
//	    	   root.data=value;
//	    	   root.next=next;
//	    	   
//	    	   head1= head1.next;
//	    	   head2 = head2.next;	
//	       }
//	       
//	       if(carry!=0){
//	    	   Node temp = root; 
//	    	  root = new Node();
//	    	  root.next = temp;
//	    	  root.data=carry;
//	       }
//	       
//	       
//	    }
//	    
//	    public int sol(Tree t){
//	    	HashMap<Integer, Integer> map = new HashMap<>();
//	    	return searchMaxNodes(t, map, 0);
//	    }
//	    
//		public int searchMaxNodes(Node r, HashMap<Integer, Integer> map, int max){
//			int max_left =0;
//			int max_right =0;
//			
//			if(r==null){
//				max = map.size();
//				return max;
//			}
//			
//			if(!map.containsKey(r.data)){
//				max = map.size();
//			}else{
//				map.put(r.data, max+1);
//			}
//			
//			max_left = searchMaxNodes(r.l, map, max);
//			max_right = searchMaxNodes(r.r, map, max);
//			
//			if(map.get(r.data)<=1){
//				map.remove(r.data);
//			}else{
//				map.put(r.data,map.get(r.data)-1);
//			}
//			
//			return Math.max(max_left,max_right);			
//		}
//	    
	    	
//	    public int findLongest(Node n){
//	    	int left_height =0;
//	    	int right_height =0;
//	    	
//	    	if(n==null){
//	    		return 0;
//	    	}
//	    	
//	    	left_height = findLongest(n.left);
//	    	right_height = findLongest(n.right);
//	    	
//	    	if(left_height<=right_height){
//	    		return right_height+1;
//	    	}else if(left_height>right_height){
//	    		return left_height+1;
//	    	}
//	    	
//	    }
		
		public int binaryGap(int n, int counter, int max, int index){
			if(n==0)
				return max;

			if(n%2==0 && index==0)
				index=0;
			
			else if(n%2==0)
				counter ++;
			else {
				max = Math.max(counter, max);
				index++;
				counter =0;
			}
			n = n/2;

			return binaryGap(n, counter, max, index);
		}
		
		public int checkPermutation(int a[], int N){
			int max=0;
			int array[] = new int[a.length];
			
			for(int i=0; i<a.length;i++){
				if(array[a[i]]==1){
					return 0;
				}
				else
					array[a[i]]=1;				
				max = Math.max(max, a[i]);
			}
			
			for(int i=max-1; i<0;i--){
				if((a[i]-a[i-1]) ==1){
					continue;
				}else{
					return 0;
				}
			}
			return 1;
			
		}
		
		public int checkPermutations2(int a[]){
			int min =Integer.MAX_VALUE;
			int sum=0;
			HashMap<Integer,Integer> hash = new HashMap<>();
			for(int i=0; i<a.length; i++){
				if(hash.containsKey(a[i]))
					min = Math.min(min, i);
				else{
					min=i;
					sum +=a[i];
				}
				
				hash.put(a[i],min);
			}
			
			if(max!=a.length)
				return 0;
			else
				if(sum!=((max/2)*(1+max)))
					return 0;
				else
					return 1;
		}
		
		
		
		public void Avl(Node root, int value){
			insertNode(root, value);
			checkBalance();
			rotateAVL();
		}
		
		public Node insertNode(Node root, int value){
			Node node = new Node();
			node.data = value;
			
			if(root==null)
				return node;
			
			if(root!=null){
					if(root.data<value){
						root.next = insertNode(root.next,value);
					}else{
						root.prev = insertNode(root.prev,value);
				}
					
			}
		
		node.height=1+Math.max(root.prev.data,root.next.data);
		
		int balance = root.prev.height-root.next.height;
		
		if(balance<1 && value<node.prev.data)
			return rightRotate(root);
		else if(balance>1 && value>root.next.data)
			return leftRotation(root);
					
			else if(balance<1 && value>node.prev.data){
				leftRotation(root.prev);
				return rightRotation(root);
			}
				
				else if(balance>1 && value<node.next.data){
					rightRotation(root.prev);
					return leftRotation(root);
				}
				
				
		}
		
		
		public Node leftRotation(Node root){
			Node root1 = root;
			root = root.next;
			
			root1.next = root.prev;
			root.prev=root1;
			
			root1.height = Math.max(root1.prev.height, root1.next.height)+1;
			root.height = Math.max(root.prev.height, root.next.height)+1;
			
			return root1;
			
		}
	
		
		public void stringPermutations(String name, int a, int b){
			
			if(a==b){
				System.out.println(name);
			}
			else{		
				for(int i=a; i<=b;i++){
					name = swap(name, i,a);
					stringPermutations(name, i, a+1);
					name = swap(name,i,a);
				
				}
			}			
		}
		
			public class Tower{
				private int index ; 
				private Stack<Integer> disks;
				
				public void add(int disk){
					if(!disks.isEmpty()){
						System.out.println();
					}else{
						disks.push(disk);
					}
				}
				
				public void moveDisks(int disk, Tower source, Tower destination){
					int node =0;
					if(source.disks.size()>0){
						node  = source.disks.pop();
						moveDisks(disk, source, destination);
						if(source.disks.isEmpty())
							source.disks.push(disk);
					}
					destination.disks.push(node);
				}
				
			}
   
	    class Node {
	        int data;
	        Node next;
	        Node prev;
	        int height;
	     }
	    }
	    
	    

	    
