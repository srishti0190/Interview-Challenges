package com.practice.hacker;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;



public class FindXor {
	int max=0;
	public static void main(String args[]){
		FindXor obj=new FindXor();
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		ArrayList<Integer> listarray=new ArrayList<Integer>();
        String str=sc.next();
        String[]  strarray=str.split(" ");
		for(int i=0;i<strarray.length;i++){
			listarray.add(Integer.parseInt(strarray[i]));
		}
		System.out.println(listarray);
		obj.max=listarray.get(0);
		obj.findmaxXor(listarray);
		
	}

	private void findmaxXor(ArrayList<Integer> listarray) {
		ArrayList<Integer> prefix=new ArrayList<Integer>();
		ArrayList<Integer> suffix=new ArrayList<Integer>();
		ArrayList<Integer> temp2=new ArrayList<Integer>();
		temp2=(ArrayList<Integer>) listarray.clone();
		
		for(int i=0;i<listarray.size();i++){
			prefix.add(listarray.get(i));
			temp2.remove(0);
			ArrayList<Integer> temp=new ArrayList<Integer>();
			temp=(ArrayList<Integer>) temp2.clone();
			for(int j=i;temp.size()!=0;j++){
				suffix=temp;
				handlearrays(prefix,suffix);
				temp.remove(0);
			}
			
		}
		System.out.println(max);
		
		
	}
	
	private int handlearrays(ArrayList<Integer> prefix,ArrayList<Integer> suffix){
		System.out.println(prefix+","+suffix);
		int max1=findxor(prefix);
		int max2=findxor(suffix);
		if(max1>max2)
			max=max1;
		else
			max=max2;
		
		int max3=xor(max1,max2);
		if(max<max3)
			max=max3;
		
		return max;
		
	}
	
	private int findxor(ArrayList<Integer> list){
		int xor=0;
		int i=0;
		for(i=0;i<(list.size()-1);i++){
			xor=xor^xor(list.get(i),list.get(i+1));
		}
		xor=xor(xor,list.get(list.size()-1));
		return xor;
	}

    private int xor(int a,int b){
    	int xor=0;
    	
    	xor=a^b;
    	
    	return xor;
    }

}



