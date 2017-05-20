package com.linkedList.geek;

import java.util.Scanner;
import java.util.Stack;

public class ParenthesisChecker {

	private Stack<String> parantheis = new Stack<>();;

	public static void main(String [] args){
		//		Scanner sc = new Scanner(System.in);
		//		String num = sc.nextLine();
		//
		//		
		//		for(int i=0 ; i<Integer.parseInt(num); i++){
		//			String firstLine = sc.nextLine();
		//			String charSeq[] = firstLine.split("");
		//			
		//			
		//		}

		String exp[] = {"*34","+1*23","+12"};
		String arr[] = prefixToPostfix(exp);
		for(int i =0 ; i<arr.length; i++){
			System.out.print(arr[i] + " ");
		}

	}

	public void findDuplicate(String charSeq[]){
		for(int y =0; y<charSeq.length;y++){
			String char_= charSeq[y];
			if(char_.equals("{") || char_.equals("(") || char_.equals("[")){
				parantheis.push(char_);
			}else{
				String char_1 = parantheis.pop();
				boolean result = checkIfSame(char_,char_1);
				if(result ==true){
					System.out.println("Balanced");
				}else{
					System.out.println("Not Balanced");
				}
			}
		}

		if(parantheis.isEmpty()!=true){
			System.out.println("Not Balanced");
		}

	}

	public boolean checkIfSame(String char_,String char_1){
		if(char_.equals("{") && char_1.equals("}")){
			return true;

		}else if(char_.equals("[") && char_1.equals("]")){
			return true;

		}else if(char_.equals("(") && char_1.equals(")")){
			return true;
		}else{
			return false;
		}
	}



	static String[] prefixToPostfix(String[] prefixes) {
        String[] new_array = new String[prefixes.length];
       for(int i=0; i<prefixes.length; i++){
           new_array[i]= prefixToPostfixWord(convert(prefixes[i]).split(""));
       }
        return new_array;
    }

   public static String prefixToPostfixWord(String[] prefixes){
        StringBuffer prefixesNew = new StringBuffer();
        Stack<Character> stack = new Stack();
        int prefixesPos =0;
        
        if(prefixes.length!=0 || prefixes!=null){
       for(int i=0; i<prefixes.length; i++){
            if(Character.isDigit(prefixes[i].charAt(0))){
                prefixesNew.append(prefixes[i]);
                continue;
            }else{
                int value = checkPrecedence(prefixes[i].charAt(0));

               if(stack.isEmpty() || value<checkPrecedence(stack.peek())){
                    stack.push(prefixes[i].charAt(0));

                   continue;
                }else {
                    while(value>checkPrecedence(stack.peek())){
                        prefixesNew.append(stack.pop().toString());
                        if(stack.isEmpty()==true)
                            break;
                    }
                    stack.push(prefixes[i].charAt(0));
                }
            }            
       }
        }

       while(stack.isEmpty()!=true){
            prefixesNew.append(stack.pop().toString());
        }

       return prefixesNew.toString();
    }

   
   public static String convert(String postfix){
	   Stack<String> s = new Stack<>();    
	   for(int i = postfix.length()-1; i>=0; i--){
	    char c = postfix.charAt(i);
	    if(isOperator(c)){
	    	 String b = null;String a = null;
	    if(s.isEmpty()!=true)
	      a = s.pop();
	    if(s.isEmpty()!=true)
	      b = s.pop();
	    if(a!=null && b!=null)
	     s.push(""+a+c+b+"");	
	    }
	    else{
	     s.push(""+c);
	    }
	   }
	    
	   return s.pop();
	  }
   
   private static boolean isOperator(char c){
	   if(c == '+' || c == '-' || c == '*' || c =='/' || c == '^')
	    return true;
	   return false;
	  }
   
   public static  int checkPrecedence(char ch){
        switch (ch)
        {
        case '+':
            return 3;
        case '-':
            return 4;    
        case '*':
            return 2;
        case '/':
            return 1;    
        }
        return -1;
    }
}
