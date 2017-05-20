package com.linkedList.geek;

public class ZeroOne {

	public static void main(StringManipulate []args){
		ZeroOne dd = new ZeroOne();
		int arr[] = {1,0,1,0,1,1,0,1,1};
		dd.findMaxSteps(arr);
	}
	
	
	// Swapping to put all 1's on left and all 0's on right
	public void solution(int arr[]){
		int zero = 0;
		int one =0;
		
		
		for(int i=0; i<arr.length; i++)
		{
			if(arr[i] ==1)
				one++;
			
			if(arr[i]==0){
				int temp = arr[one-i];
				arr[one-i]=arr[i];
				arr[i]=arr[one-i];
			}
		}
	}

	
	//Find minimum number of steps needed to align all 0's together and all 1's together
	
	public void findMaxSteps(int arr[]){
		int prev1 = 0; 
		int next1 = 0;
		
		int prev0 =0;
		int next0 = 0;
		
		int max_steps1 = 0;
		int max_steps2 =0;
		
		for(int i = 0; i<arr.length; i++){
			if(arr[i] ==1){
				prev1 = next1;
				next1 = i;
				max_steps1 = max_steps1 + (next1-prev1);
				next1 = prev1+1;
			}else{
				prev0= next0;
				next0=i;
				max_steps2 = max_steps2 + (next0-prev0);
				next0 = prev0+1;
			}
		}
		
		System.out.println(Math.min(max_steps1, max_steps2));
	}
	
	
}
