package com.linkedList.geek;

public class ArrayProblem {
	
	public static void main(String []args){
	int[] array = new int[]{1,2,3,53,5341,3,4,2,1,2345};
	findDuplicates(array);
   } 
   
   
   /**
    * Total available memory is 4KB i.e total 32000 bits 
    * total number of integers 32000
    * Find Duplicates and print
    * 
    */
   
   private static void findDuplicates(int array[]){
	   byte[] bitVector = new byte[32000/8];
	   
	   for(int i=0; i<array.length; i++){		   
		   int n = array[i];
		   if((bitVector[ n/8] & (1 << n%8)) ==0)
			   bitVector [n / 8] |= 1 << (n % 8);		   
		   else
			   System.out.println(array[i]);
	   }
   }
}
