package com.linkedList.geek;

public class NQueen {
	  int q[][] ; 
 public static void main(StringManipulate [] args){
	 NQueen nqueen = new NQueen();
	 int n =4;
	 nqueen.checkPosition(n,n);
 }
 
  public void checkPosition(int n, int length){
		q = new int[n][n];
		q[n-length][n-length]=1;
		
		System.out.println("roe" +(n-length));
		
	  for(int i=0; i<n ; i++){
		  boolean check = false;
		  if(i+1!=n)
		  check = checkIfPlaced(i+1,n, n-length);
		  if(check==true){
			  continue;
		  }else{
			  q = new int[n][n];
			  break;
		  }
	  }
	  length --;
	  printQueens(q);
	  if(length!=0)
		  checkPosition(n, length);		  
  }
  
  private boolean checkIfPlaced(int c, int n, int r){
	  for(int i=0; i<n ;i++){
		  System.out.println("row" +i + "col" +c+ "is" +q[i+1][c-1]);
		  if(!(i==0)){
			  if(q[i-1][c-1]==1){
				  continue;
			  }
		  }if(i+1!=n){
		  if(q[i+1][c-1]==1){
			  continue;
		  }}
		  if(q[i][c-1]==1){
			  continue;
		  }
		  if(r==i){
			  continue;
		  }
		 else{
			  q[i][c]=1;
			  System.out.println("true" +i+ "   " +c);
			 return true;
		  }
	  }
	  return false;
  }
  
  private void printQueens(int [][]q){
	  System.out.print("[");
	  for(int i=0; i<q.length;i++){
		  for(int j=0; j<q.length;j++){
			  if(q[i][j]==1){
				  System.out.print(+i+" ");
			  }
		  }
	  }
	  System.out.println("]");
  }
}
