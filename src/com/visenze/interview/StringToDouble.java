package com.visenze.interview;

import java.math.BigDecimal;

public class StringToDouble {
 public static void main(String [] args){
	String strin = "-31415926.0250";
	
	StringToDouble string = new StringToDouble();
	string.stringToDouble(strin);
	
	
 }
 
 private void stringToDouble(String strin){
	 String c[] = strin.split("");
	 String[] substrings = null;
	 int mul =0;
	 double value= 0;
	 
	 
	 if(c[0].equals("-")){
		 
		 strin = strin.substring(1);
		 substrings = strin.split("\\."); 
		  mul = -1;
	 }else{
		 strin = strin.substring(0);
		 substrings = strin.split("\\."); 
		  mul = 1;
	 }
	 
	 value = findValue(substrings[0]);
	 value = mul * (value+ (findValue(substrings[1])/(Math.pow(10, substrings[1].length()))));
	 
	 
	 System.out.println(BigDecimal.valueOf(value));
 }
 
 private double findValue(String s){ 	 
		 String c[] = s.split("");
		 int size = s.length()-1;
		 int length = size; 
		 
		 double value= 0; 
	 
	 	while(length>=0){
	 		int number = (size)-(length);
	 		value = value + ((Integer.parseInt(c[number]))* (Math.pow(10, length)));
	 		length--;
	 	}
	 return value;
 }
	
}
