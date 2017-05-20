package com.linkedList.geek;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class StackFromQueues {
	    Queue<Integer> q1 = new LinkedList<Integer>();
	    Queue<Integer> q2 = new LinkedList<Integer>();
	    
	    /*The method pop which return the element poped out of the stack*/
	    int pop()
	    {
	    if(q2.size()>0)
	    	return q2.poll();
	    else if(q1.size()>0)
	    	return q1.poll();
	    else
	    	return 0;
    
	    }
		
	    /* The method push to push element into the stack */
	    void push(int a)
	    {
		// Your code here
	    	Queue<Integer> temp =null;
	    	if(q1.size()==0){ 
	    			q1.add(a);
	    		}
	    	else{
	    		if(q2.size()>0){
	    			while(q2.isEmpty()!=true){
	    			q2.offer(q1.poll());
	    			}
	    			q1.add(a);
	    			temp = q1;
	    			q1=q2;
	    			q2=temp;	    		
	    		}else{
	    			q2.add(a);
	    		}
	    	}
	    }
	    
	    public static void main(String [] args){
	    	StackFromQueues stackFromQueues = new StackFromQueues();
	    	
	    	Scanner sc = new Scanner(System.in);
	    	sc.nextLine();
	    	sc.nextLine();
	    	
	    	String string = sc.nextLine();
	    	
	    	sc.close();
	    	
	    	String [] dekho = string.split(" ");
	    	
	    	int size = 0;
	    	
	    	while(!(size>dekho.length-1)){
	    		
	    	int num = Integer.parseInt(dekho[size]);
	    	
	    	size ++;
	    	
	    	if(num==1){
		    	stackFromQueues.push(Integer.parseInt(dekho[size]));
		    	size ++;
	    	}
	    	else if(num ==2){
	    		System.out.print(stackFromQueues.pop()+" ");
	    	}
	     	}

	    }
}
