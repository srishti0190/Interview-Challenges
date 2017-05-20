package com.linkedList.geek;

import java.util.Arrays;

public class EqualArray {

	public static void main(StringManipulate[] args){

	}
	
	//Minimum number of opertions needed to make all the elements of an array equal
	
	public void makeEqual(int arr[]){
		Arrays.sort(arr);
		int median = arr.length/2;
		int min_steps =0;
		
		for(int i =0; i<arr.length; i++){
			min_steps += (Math.abs(arr[i]-arr[median]));		
		}
		
		System.out.println(min_steps);
	}
	
	public void twoMedians(int index1, int index2, int arr[]){
		int min_steps_1 =0;
		int min_steps2=0;

		for(int i=0; i<arr.length; i++){
			min_steps_1+= Math.abs(arr[index1]-arr[i]);
			min_steps2+= Math.abs(arr[index2]-arr[i]);
		}
		System.out.println(Math.min(min_steps_1, min_steps2));
	}
}
