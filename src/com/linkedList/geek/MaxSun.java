package com.linkedList.geek;

public class MaxSun {
  public static void main(StringManipulate [] args){
	  MaxSun sun = new MaxSun();
	  
	  int arr [] = {1, 2 ,3, -1, 5};
	  sun.findMaxSum(arr);
  }
  
  public void findMaxSum(int arr[]){
	  int max = arr[0];
	 int sum = 0;
	  for(int i =0; i<arr.length;i++){
		  sum = sum+arr[i];
		 if(sum>max){
			  max = sum;
	  }
	  }
	  
	  System.out.println(max);
  }
}
