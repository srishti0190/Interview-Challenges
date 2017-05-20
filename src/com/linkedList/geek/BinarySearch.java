package com.linkedList.geek;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearch {
	private Node root;
	private 		Queue<Node> q = new LinkedList<>();
	public static void main(String [] args){
		//		int arr[] = {22,1,4,66,23,5,9,0,1,4,5,33,5,78,32,12,32,21};
		//	
		//		BinarySearch tree= new BinarySearch();
		//		tree.root = tree.new Node(1);
		//        tree.root.right = tree.new Node(2);
		//        tree.root.left = tree. new Node(-1);
		//        tree.root.right.right = tree.new Node(4);
		//        tree.root.right.right.left = tree.new Node(3);
		//        
		//        System.out.println(tree.findRoot(tree.root, 4, 3).value);      

		//        tree.printTopView(tree.root);

		//        System.out.println(tree.maxHeight(tree.root));
		//        Node print = tree.insertNodeKey(tree.root, 16);
		//        
		//        tree.fullNode(tree.root);
		//        
		//        System.out.println(print.value);

		//		b.bunarySearch(arr);

		//        Node T = tree.new Node('a');
		//        T.left = tree.new Node('b');
		//        T.right = tree.new Node('d');
		//        T.left.left = tree.new Node('c');
		//        T.right.right = tree.new Node('e');
		// 
		//        Node S = tree.new Node('a');
		//        S.left = tree.new Node('b');
		//        S.right = tree.new Node('d');
		//        S.left.left = tree.new Node('c');
		// 
		//        if (tree.subtree(T, S)) {
		//            System.out.println("Yes , S is a subtree of T");
		//        } else {
		//            System.out.println("No, S is not a subtree of T");
		//        }
		//        
		//    	
		//    	/**Spaces*/
		//    	char str[] = {'s',' ','a','b','c',' ',' '}; 
		//    	tree.ReplaceFun(str, 7);


//		BinarySearch tree = new BinarySearch();
//
//
//
//		tree.insert(50);
//		tree.insert(30);
//		tree.insert(20);
//		tree.insert(40);
//		tree.insert(70);
//		tree.insert(60);
//		tree.insert(80);
		
//		
		BinarySearch tree = new BinarySearch();
//		BinarySearch tree2 = new BinarySearch();
		
		// TREE 1
		/* Construct the following tree
			26
			/ \
			10	 3
		/ \	 \
		4	 6	 3
		\
			30 */
		
//		tree.root = new Node(26);
//		tree.root.right = new Node(3);
//		tree.root.right.right = new Node(3);
//		tree.root.left = new Node(10);
//		tree.root.left.left = new Node(4);
//		tree.root.left.left.right = new Node(30);
//		tree.root.left.right = new Node(6);
//
//		// TREE 2
//		/* Construct the following tree
//		10
//		/ \
//		4	 6
//		\
//		30 */
//		
//		tree2.root = new Node(10);
//		tree2.root.right = new Node(6);
//		tree2.root.left = new Node(4);
//		tree2.root.left.right = new Node(30);
//
//		if (tree.findsSubtree(tree.root, tree2.root))
//			System.out.println("Tree 2 is subtree of Tree 1 ");
//		else
//			System.out.println("Tree 2 is not a subtree of Tree 1");
		
		System.out.println(tree.updateBits(1024,21,2,6));
		
		
		
	}
		
	public Node findRoot(Node root, int a, int b){
		if(root.value<a && root.value<b){
			return findRoot(root.right,a,b);
		}else if(root.value>a && root.value>b){
			return findRoot(root.left,a,b);
		}else
			return root;
	}

	//check if the aray can be converted to pre-order tree traversal

	public Boolean findInorder(Node node, int arr[]){
		int root = node.value;

		Stack<Integer> stack = new Stack<>();

		for(int i=0; i<arr.length; i++){

			if(arr[i] < node.value){
				return false;
			}

			while(!stack.isEmpty() && arr[i]>stack.peek()){
				root = stack.peek();
				stack.pop();
			}
			stack.push(arr[i]);
		}
		return true;
	}

	void insert(int key)
	{
		root = insertRec(root, key);
	}

	/* A recursive function to insert a new key in BST */
	Node insertRec(Node root, int key)
	{

		/* If the tree is empty, return a new node */
		if (root == null)
		{
			root = new Node(key);
			return root;
		}

		/* Otherwise, recur down the tree */
		if (key < root.value)
			root.left = insertRec(root.left, key);
		else if (key > root.value)
			root.right = insertRec(root.right, key);

		/* return the (unchanged) node pointer */
		return root;
	}

	//print top view of the tree

	public void printTopView(Node root){
		Node left = root;
		Node right =root;
		q.add(root);		

		while(left.left!=null || right.right!=null){
			if(left.left!=null){
				q.add(left.left);
				left = left.left;
			}
			if(right.right!=null){
				q.add(right.right);
				right=right.right;
			}


		}

		while(q.isEmpty()!=true){
			System.out.println(q.poll().value);
		}

	}

	//	public void bunarySearch(int arr[]){
	//		Node root = new Node();
	//		root.left = null;
	//		root.right = null;
	//		
	//		root.value = arr[0];
	//		
	//		for(int i =1; i<arr.length ; i++){
	//			Node node  = new Node();
	//			node.value = arr[1];
	//			if(node.value>root.value){
	//				root.right=node;
	//			}
	//			else{
	//				root.left=node;
	//			}
	//			
	//			root = node;
	//		}
	//		
	//	}

	private static class Node{
		public Node(int i){
			value= i;
		}

		private Node left = null;
		private Node right = null;
		private int value;
		private int height;
		private Node parent;
	}

	public int maxHeight(Node root){
		int maxHeightL = 0;
		int maxHeightR = 0;

		if(root == null)
			return 0;
		else{
			maxHeightL  = maxHeight(root.left);
			maxHeightR = maxHeight(root.right);
		}

		if(maxHeightL>maxHeightR)
			return maxHeightL+1;
		else
			return maxHeightR+1;


	}

	//inser a node in a binary tree

	public Node insertNodeKey(Node root, int key){
		if(root==null){
			Node node = new Node(key);
			return node;
		}
		if(root.value>key){
			root.left = insertNodeKey(root.left, key);
		}else{
			root.right = insertNodeKey(root.right, key);
		}
		return root;
	}

	public void fullNode(Node d){
		if(d==null){
			return;
		}
		fullNode(d.left);
		fullNode(d.right);
		if(d.left!=null && d.right!=null){
			System.out.print(d.value+" ");	
			return;
		}else{
			return;
		}

	}

	private Boolean subtree(Node t1, Node t2){
		Boolean value = true; 

		if(t1 == null){
			value= false;
			return value;
		}

		if(t2 == null){
			return value; 
		}

		else{
			if(t2.value>t1.value)
				subtree(t1.right,t2);

			else if(t2.value<t1.value)
				subtree(t1.left,t2);

			else if(t2.value == t1.value)
				subtree(t1,t2.left);
			subtree(t1,t2.right);
		}
		return value;
	}


	public void ReplaceFun(char[] str, int length){
		int spaces = 0;
		System.out.println("sdfsfd");
		for(int i=0; i<length;i++){
			if(str[i]== ' '){
				str[i]='%'+'2'+'0'; 
			}
		}

		int mat[][] = {{1,2,3,4},
				{5,6,7,8},
				{9,22,12,12}
		};

		{
			System.out.println(mat[0].length);
		}


	}

	public Node createMinimumHeight(int arr[], int beg, int end, Node root){
		if(beg==end){
			return new Node(arr[beg]);
		}

		int mid = beg+end/2;
		root = new Node(arr[mid]);
		root.left = createMinimumHeight(arr, beg, mid-1, root);	
		root.right = createMinimumHeight(arr, mid+1, end, root);

		return root;
	}

	public void deleteNode(Node node,int todelete){
		while(node !=null){
			if(todelete==node.value)
				break;		
			else if(node.value>todelete)
				node = node.right;			
			else if(node.value<todelete)
				node = node.left;		
		}

	}

	public void delete(Node node, int key){
		if(node.left == null){
			node = node.right;
			node.right = null;
		}else if(node.right == null){
			node = node.left;
			node.left =null;
		}
		else{
			node.value = inorder(node.right);
		}
	}

	public int inorder(Node node){
		while(node.left!=null)
			node = node.left;

		int min = node.value;
		node = null;
		return min;
	}

	public Node balanceTree(Node root, int insert){
		Node node = new Node(insert);
		if(root == null){
			return node;
		}

		if(root.value>insert){
			root = root.left; 
			root.left = balanceTree(root, insert);
		}else if(root.value<insert){
			root.right = balanceTree(root.right, insert);
		}

		node.height =0;
		root.height= calculateHeight(root)+1;

		int balance=getBalance(root);

		//right right
		if(balance<-1 && insert > root.right.value){
			leftRotation(root);
		}

		//left left
		else if (balance>1 && insert < root.left.value){
			rightRotation(root);
		}

		//right left
		else if (balance <-1 && insert <root.right.value){
			node.right=rightRotation(root.right);
			return leftRotation(root);
		}

		//left right
		else if (balance >1 && insert > root.left.value){
			node.left=leftRotation(root.left);
			return rightRotation(root);
		}

		return root;
	}

	public int calculateHeight(Node root){
		if(root.left==null && root.right!=null)
			return root.right.height;
		else if(root.right==null && root.left!=null)
			return root.left.height;
		else
			return Math.max(root.left.height, root.right.height);
	}

	public int getBalance(Node root){
		if(root.left==null && root.right!=null)
			return (0-root.right.height);
		else if(root.right==null && root.left!=null)
			return (root.left.height-0);
		else
			return root.left.height-root.right.height;
	}

	public Node leftRotation(Node root){
		Node temp = root;
		root = root.right;
		temp.right = root.left;
		root.left = temp;

		temp.height = calculateHeight(temp)+1;
		root.height = calculateHeight(root)+1;

		return root;

	}

	public Node rightRotation(Node root){
		Node temp = root;
		root = root.left;
		temp.left = root.right;
		root.right = temp;

		temp.height = calculateHeight(temp)+1;
		root.height = calculateHeight(root)+1;

		return root;


	}


	// create Linked Lists of each depth

	public void depth(Node node){
		Queue<Node> nodes = new LinkedList<>();
		nodes.add(node);
		int prev =1;
		int next =0;

		ArrayList<LinkedList<Node>> arrays = new ArrayList<>();
		LinkedList<Node> linkedLists = new LinkedList<>();

		while(nodes.isEmpty()!=true){		

			if(prev ==0){
				arrays.add(linkedLists);
				linkedLists=new LinkedList<>();
				prev = next; 
				next=0;
			}
			node = nodes.poll();	
			if(node.left!=null){
				nodes.add(node.left);
				if(prev!=0)
					linkedLists.add(node.left);
				next++;
			}
			if(node.right!=null){
				nodes.add(node.right);
				if(prev!=0)
					linkedLists.add(node.right);
				next++;
			}
			prev --;
		}
	}


	public ArrayList<LinkedList<Node>> findLevelLinkedList(Node root){
		int level=0;
		ArrayList<LinkedList<Node>> result = new ArrayList<>();
		LinkedList<Node> nodes = new LinkedList<>();
		nodes.add(root);
		result.add(level, nodes);

		while(true){
			nodes = new LinkedList<>();

			for(int i=0; i<result.get(level).size();i++){
				Node node = result.get(level).get(i);
				if(node.left!=null)
					nodes.add(node.left);
				if(node.right!=null)
					nodes.add(node.right);			
			}

			if(nodes.size()==0){
				break;
			}else{
				result.add(level+1,nodes);
				level++;
			}
		}
		return result;
	}

	public Node findInorderSuccessor(Node root){

		if (root ==null) return null;

		if(root.right!=null)
			return leftMostChild(root.right);
		
		else if(root.parent == null && root.right ==null)
			return null;

		else{
			Node e= null;
			while((e =root.parent) !=null){
				if(e.left ==root){
					break;
				}else{
					root = e;
				}		
			}
			return e;
		}
	}

	public static Node leftMostChild(Node e) {
		if (e == null) return null;
		while (e.left != null) e = e.left;
		return e;
	}
	
	
	public Node commonAncestor(Node a, Node b, Node root){
		if(check(a, root.left) && check(b, root.left) )
			return commonAncestor(a, b, root.left);
		else if(check(a, root.right) && check(b, root.right))
			return commonAncestor(a, b, root.right);
		else
			return root;
	}
	
	public boolean check(Node a, Node root){
		if(root==null) return false;
			if(root.value == a.value)
				return true;			 
				if(check(a, root.left) || check(a, root.right))
					return true;
					else
						return false;
	}
	
	
	public boolean findsSubtree(Node T1, Node T2){
		
		Queue<Node> queue = new LinkedList<>();
		Node markStart =null;
		queue.add(T1);
		while(queue.isEmpty()!=true){
			T1 = queue.poll();
			if(T1.left==T2){
				markStart = T1.left;
				break;
			}else if( T1.right==T2){
				markStart=T1.right;
				break;
			}else{
				queue.add(T1.left);
				queue.add(T1.right);
			}
		}
		
		return matchTree(markStart,T2);
		
	}
	
	public boolean matchTree(Node t1, Node t2){
		
		if(t2.left==null && t2.right==null)
			return true;
		
			if(t1.left!=null && t2.left!=null){
			if(t1.left.value==t2.left.value)
			matchTree(t1.left, t2.left);
			else
				return false;
			}else{
				return false;
			}
		
			if(t1.right!=null && t2.right!=null){
				if(t1.right.value==t2.right.value){
					matchTree(t1.right, t2.right);
				}else
					return false;
			}else{
				return false;
			}
			return false;
	}
	
	
	//Another version of finding subtree
	
	public boolean findSubtree(Node t1, Node t2){
		if(t2==null)
			return true;
		
		if(t1 ==null)
			return false;

		if(t1.value==t2.value)
			return matchTree1(t1, t2);
		
		return (findsSubtree(t1.left, t2) || findsSubtree(t1.right, t2));
	}
	
	public boolean matchTree1(Node t1, Node t2){
		if (t1 == null && t2 == null)
			return true;

		if (t1 == null || t2 == null)
			return false;
		
		return (t1.value==t2.value &&  matchTree1(t1.left, t2.left) && matchTree1(t1.right, t2.right));
			
	}
	
	public void findSum(Node root, int level, int sum, ArrayList<Integer> nodes){
		if(root == null)
			return;
		
		
		
	}
	
	public static int updateBits(int n, int m, int i, int j) {
		int max = ~0; /* All 1’s */
		System.out.println("max value" +max);
		int kya =(1 << j);
		System.out.println("Kya lki kya value" +kya);
		int left = max - (kya - 1);
		System.out.println("left" +left);
		int right = ((1 << i) - 1);
		int mask = left | right;
		System.out.println("right value" +mask);
		
		int some = (n & mask) | (m << i);
		System.out.println("Some me kya h" +some);
		
		return some;
	}
	}
	
	
	
	


