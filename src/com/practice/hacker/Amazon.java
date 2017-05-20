package com.practice.hacker;

import java.util.ArrayList;

public class Amazon {
	
	
	public static void main(String [] args){
		 
		System.out.println(totalScore(new String[]{"5","-2","4","Z","X","9","+","+"}, 8));
	}
	
	    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	    public static  int totalScore(String[] blocks, int n){
	    	ArrayList<Integer> current_score=new ArrayList<>();
	        int total_score=0;
	        int arraySize=0;
	        
	       for(int i=0; i<n;i++){    	
	            if(blocks[i].matches("-?\\d+(\\.\\d+)?")){
	            	int number = Integer.parseInt(blocks[i]);
	                current_score.add(number);
	                total_score+=current_score.get(arraySize);
	                arraySize ++;
	            }
	            
	           else if(blocks[i] == "X"){
	                current_score.add(2*current_score.get(arraySize-1));
	                  total_score+=current_score.get(arraySize);
		                arraySize++;
	            } 
	           
	           else if(blocks[i] == "Z"){	        	  
	                    total_score = total_score - current_score.get(arraySize-1);
	                    current_score.remove(arraySize-1);
	                    arraySize--;
	                }
	                
	                else if(blocks[i] == "+"){                      
	                   current_score.add(current_score.get(arraySize-1)+current_score.get(arraySize-2));                 
	                   arraySize++;
	                   total_score+=current_score.get(arraySize-1);
	                }
	            }
	          
	        return total_score;

	       }
	  
}
