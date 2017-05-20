package com.practice.hacker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LeetSum {
	    public int[] twoSum(Integer[] nums, int target) {
	    	
	    	List<Integer> list1 = Arrays.asList(nums);
	    	list1.sort(new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					if(o1 > o2)
					return 0;
					else
						return -1;
				}
			});
	    	
	    	System.out.println("print sorted list" +list1.toString());
	    	boolean found = false;
	    	int a = nums.length/2 ;
	    	int initalint = nums[a-1];
	    	int b = target-initalint;
    		
	    	while(found!=true){
	    		if(b<initalint){
	    			initalint = nums[a/2-1];
	    			b = target-initalint;
		    		if(b ==0){
		    			int[] arr = {,initalint};
		    			found = true;
		    			return arr;
		    	}else{
		    		b = y;
		    		continue;
		    	}    	    		
	    	}else{
	    		int x = a/2;
	    		int y = nums[x-1];
	    	}
	}
	    }
	    
	    public static void main(String[] args){
	    	LeetSum ls = new LeetSum();
	    	Integer[] nums = {1,2,7,8,4,3,1,3};
	    	ls.twoSum(nums, 10);
	    }
}
