package com.linkedList.geek;

import java.util.Scanner;

public class MarsRoverProblem {
	String curPos=null;
	public static void main(String [] args){

		
		MarsRoverProblem marsRoverProblem = new MarsRoverProblem();

		Scanner sc = new Scanner(System.in);
		String firstLine = sc.nextLine();
		String[] max = firstLine.split(" ");
		
		while(sc.hasNextLine()){
			String secondLine = sc.nextLine();
			String position[] = secondLine.split(" ");
			
		    int matrix[][] = new int[Integer.parseInt(max[0])][Integer.parseInt(max[1])];
		    
		    
		    String movement = sc.nextLine();
		    String[] moves = movement.split("");
		    
		    String final_position = marsRoverProblem.moveRover(position,moves);
		    System.out.println(final_position);
		    
		    
		}
		
	}
	
	public String moveRover(String position[],String moves[]){
		curPos =position[2];
		
		String finalPosition =null;
		
		int x = Integer.parseInt(position[0]);
		int y = Integer.parseInt(position[1]);

		for(int i=0; i<moves.length; i++){
			switch(moves[i]){
			case "L": 
				if(curPos.equals("N")){
					curPos = "W";
					continue;
				}else if(curPos.equals("W")){
					curPos = "S";
					continue;
					
				}else if(curPos.equals("S")){
					curPos = "E";
					continue;
				}else if(curPos.equals("E")){
					curPos = "N";
					continue;
				}
			case "R":
				if(curPos.equals("N")){
					curPos = "E";
					continue;
				}else if(curPos.equals("W")){
					curPos = "N";
					continue;
					
				}else if(curPos.equals("S")){
					curPos ="W";
					continue;
				}else if(curPos.equals("E")){
					curPos = "S";
					continue;
				}
				
			case "M":
				if(curPos.equals("N")){
					 x = x;
					 y = y+1;
					finalPosition = x+" "+y+" "+curPos;					
					continue;
				}else if(curPos.equals("W")){
					 x = x-1;
					 y = y;
					finalPosition = x+" "+y+" "+curPos;					
					continue;
					
				}else if(curPos.equals("S")){
					 x = x;
					 y = y-1;
					finalPosition = x+" "+y+" "+curPos;		
					continue;
				}else if(curPos.equals("E")){
					 x = x+1;
					 y = y;
					finalPosition = x+" "+y+" "+curPos;		
					continue;
				}
			
			}

				
		}
		return finalPosition;
		
	}
	
	
}
