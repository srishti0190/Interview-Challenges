package com.linkedList.geek;

import java.util.Arrays;
import java.util.Scanner;

public class Knaosack {
	private 		int max = 0;
	private int actual;

	public static void main(String [] args){
		
		Scanner sc=new Scanner(System.in);
		String val = sc.nextLine();
		
		for(int z=0; z<Integer.parseInt(val); z++){
		String input= sc.nextLine();
		String value = sc.nextLine();
		
		int arr [] = new int[Integer.valueOf(input.split(" ")[0])];
		int weight = (Integer.valueOf(input.split(" ")[1]));
		
		int y=0;
		
		for(String i : value.split(" ")){
			arr[y] = Integer.parseInt(i);
			y++;
		}

		Knaosack kk = new Knaosack();
		kk.actual = weight;
	
		System.out.println(kk.recursion(weight, arr.length-1, arr));
		}     
	}
	
	public int knapsack(int W, int[]wt, int[]value){
		int array[][] = new int[value.length+1][W+1];
		int i=0;
		int y =0;
		
		for( i=0; i<value.length; i++){
			for( y=0;y<=W;y++){
				if(i==0 || y==0){
					array[i][y] = 0;  
				}
				else{
					if(wt[i-1]<=y){
						array[i][y] =Math.max(value[i-1]+array[i-1][W-wt[i-1]], array[i-1][y]); 
					}else{
						array[i][y] = array[i-1][y];
					}
				}
			}
		}
		return array[value.length][W];
	}
	
	
	public int recursion(int R, int i, int[]arr){
		int dividend = 0;
		int remainder=R;
		int loop = i;
		
		Arrays.sort(arr);
		
		
		while(loop>=0){	
			if(actual%arr[loop] == 0){
				max = actual;
				break;
			}
			else{
				if(remainder%arr[loop] == 0){
					dividend = remainder/arr[loop];
				}else{
					remainder = remainder%arr[loop];
					dividend = remainder/arr[loop];
				}
				
				max = max + dividend*arr[i];
				loop = loop-1;
				continue;
			}	
		}
		return max;

	}

}
