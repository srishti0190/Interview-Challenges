package com.linkedList.geek;

public class MatrixSearch {
	public static void main(StringManipulate [] args){
		int arr[] = {12,2,4,7,44,6,21,16,20,22};
		MatrixSearch mm = new MatrixSearch();
		mm.findLongestSubsequence(arr);		}
	
	
	//Complexity is O(n2)
	
	private void findLongestSubsequence(int [] array){		
		
		int max_sub = 0;
		
		for(int i=0; i<array.length; i++){
			
			int arr[] = new int[array.length];
			
			for(int j=0; j>array.length; i++){
				
				if(array[i]<array[j]){
					arr[j]= array[j];
				}else{
					break;
				}
			}
			
			max_sub = Math.max(max_sub, arr.length); 
			
		}
		
		System.out.println(max_sub);
	}
	
	
	//O(n)
	public void longestSubsequence(int [] arr){
		
	}
}
