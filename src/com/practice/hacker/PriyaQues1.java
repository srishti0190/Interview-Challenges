package com.practice.hacker;

import java.util.ArrayList;
import java.util.Scanner;

public class PriyaQues1 {
		ArrayList<String> group=new ArrayList<String>();
	    ArrayList<Integer> indexarraylist=new ArrayList<Integer>();
	    
		public static void main(String args[]){
			PriyaQues1 obj=new PriyaQues1();
			 
			 int a=3;
			 int b=3;
			System.out.println(1^2^3);
			 Scanner sc=new Scanner(System.in);
		       int N=sc.nextInt();
		       int M=sc.nextInt();
		       int K=sc.nextInt();
		       sc.nextLine();
		      for(int i=0;i<K;i++){
		    	  String temp="";
		    	  sc.nextLine();
		    	    for(int j=0;j<N;j++){
		    	    temp=temp.concat(sc.nextLine());
		    		}
		    	   obj.group.add(temp);
		       }
		      
	       ArrayList<Integer> lisrec=new ArrayList<Integer>();
			lisrec=obj.countPixels(obj.group);
			int max=0;
			int index=0;
			for(int i=0;i<lisrec.size();i++){
				if(lisrec.get(i)>max){
					max=lisrec.get(i);
					index=i;
				}
				
			}
			obj.findPixels(obj.group,index);
			System.out.println(obj.indexarraylist.size());
	}
		
		public ArrayList<Integer> countPixels(ArrayList<String> group){
			ArrayList<Integer> pixelarray=new ArrayList<Integer>();
			for(int j=0;j<group.get(0).length();j++){
					int count0=0;
					int count1=0;
					int min=0;
						for(int i=0;i<group.size();i++){
							if(group.get(i).charAt(j)=='0')
								count0++;
							else
								count1++;
						}
						
						if(count0<count1)
							min=count0;
						else
							min=count1;
						
						pixelarray.add(min);
				
			}
			int max=0;
			return pixelarray;
//			int index=0;
//			for(int k=0;k<pixelarray.size();k++){
//				if(pixelarray.get(k)>max)
//					{
//					max=pixelarray.get(k);
//					index=k;
//					}
//			}
//			return max;
			}

		public ArrayList<ArrayList<String>> groupTogether(ArrayList<String> group,int index){
			
			if(!(indexarraylist.contains(index)))
				indexarraylist.add(index);

			ArrayList<ArrayList<String>> combo=new ArrayList<ArrayList<String>>();
			ArrayList<String> newgroup0=new ArrayList<String>();
			ArrayList<String> newgroup1=new ArrayList<String>();
			
				for(int j=0;j<group.size();j++){
					if(group.get(j).charAt(index)=='0')
						newgroup0.add(group.get(j));
						else
							newgroup1.add(group.get(j));
					}
				
				combo.add(newgroup0);
				combo.add(newgroup1);
				
				return combo;
				}
		
		public void findPixels(ArrayList<String> group,int index){
			if(group.size()>1){
			ArrayList<ArrayList<String>> combo=groupTogether(group,index);
			pixelRecur(combo);
			}
		}
		
		public void pixelRecur(ArrayList<ArrayList<String>> combo){
			ArrayList<Integer> maxpixelarray=new ArrayList<Integer>();
			int max=0;
			int index=0;
			
			if(combo.size()>1){
					for(int i=0;i<combo.size();i++){
						if(combo.get(i).size()>1){
						ArrayList<Integer> pixelarray=countPixels(combo.get(i));
						for(int j=0;j<pixelarray.size();j++){
							if(j>=maxpixelarray.size())
									maxpixelarray.add(j,0);
							
							int temp=maxpixelarray.get(j)+pixelarray.get(j);
							maxpixelarray.set(j,temp);
							 
							if(max<maxpixelarray.get(j)){
									max=maxpixelarray.get(j);
									index=j;
						   }
							 
					   }
					}	
					}
					for(int i=0;i<combo.size();i++){
						if(combo.get(i).size()>1)
					   findPixels(combo.get(i),index);
						}
					
			}
		}
			

}
