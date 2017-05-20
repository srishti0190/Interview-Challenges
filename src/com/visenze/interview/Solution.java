package com.visenze.interview;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
	  public static void main(String[] args) {  
		  
		  Solution solution = new Solution();
       int a[] = {9, 7, 5, 3, 1, 4, 5, 0, -3};
       int p = -2;
	    
	    Arrays.sort(a);

	    solution.findNearestNumber(a,p);
	  }
	  
	  private void findNearestNumber(int a[] , int p){
		  int abc = 0;
		 for(int i=0; i<a.length; i++){  		  
			 if(a[i]< p){
				int dif = p-a[i]; 
				abc = Math.min(abc, dif);
			 }else if(a[i]>p){
				 int dif = a[i]-p;
				 abc = Math.min(abc, dif);
			 }else if(a[i] == p){
				 abc = p;
			 }
		  }
		  System.out.println(abc);
	  }
	  
	}
