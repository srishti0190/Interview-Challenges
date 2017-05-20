package com.linkedList.geek;

import java.util.Stack;

public class SortStack {
	private Stack<Integer> stack;

	public static void main(StringManipulate [] args){
		SortStack sortStack = new SortStack();
		sortStack.stack = new Stack();
		sortStack.pop(sortStack.stack);
	}
	
	public void pop(Stack<Integer> s){
		
		if(s.size()==0)
			return ;
		
		int temp = s.pop();
		pop(s);
		sort(s,  temp);
	}
	
	private void sort(Stack<Integer> s, int temp){
		if(s.isEmpty() || s.peek()>temp){
			s.push(temp);
			return;
		}
		
		int var = s.pop();
		sort(s,temp);
		s.push(var);
	}
}
