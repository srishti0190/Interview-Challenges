package com.practice.hacker;



import java.util.Scanner;

public class Main {
       private int INT_SIZE = 32;
       
       
   public int findMaxXOR(int arr[], int n)
       {
           Main.TrieNode root = newNode();
           insert(root, 0);
           int result = 0, xor =0;
       
           for (int i=0; i<n; i++)
           {
               xor = xor^arr[i];
               insert(root, xor);
               result = Math.max(result, check(root, xor));
           }
           return result;
       }
   
   int check(TrieNode root, int xor)
   {
       TrieNode temp = root;
       for (int i=INT_SIZE-1; i>=0; i--)
       {
          int left_shift = 1<<i;
           int val = left_shift & xor;
           
           long val_bin =  getBinary(val);
           String s = String.valueOf(val_bin);
           String arry[] = s.split("");

          int y = Integer.parseInt(arry[0]);
          if(val==1){
                    y =1;
             }

           if (temp.arr[1-y]!=null){
               temp = temp.arr[1-y];
           }
           else if (temp.arr[y] != null){
               temp = temp.arr[y];
           }
       }
       
       return xor^(temp.value);
   }
   
   void insert(TrieNode root, int xor)
   {
       TrieNode temp = root;
    
       for (int i=INT_SIZE-1; i>=0; i--)
       {
          int left_shift = 1<<i;
           int val = left_shift & xor;

           
           long val_bin =  getBinary(val);
           String s = String.valueOf(val_bin);
           
           String arry[] = s.split("");

                int y = Integer.parseInt(arry[0]);
                    if(val==1){
                           y =1;
                    }
               
           if (temp.arr[y] == null)
               temp.arr[y] = newNode();
    
           temp = temp.arr[y];
      }
       temp.value = xor;
   }
   
   public static long getBinary(int n)
   {
       long res=0;
       int t=0;
       while(n>1)
       {
           t= (int) (Math.log(n)/Math.log(2));
           res = res+(long)(Math.pow(10, t));
           n-=Math.pow(2, t);
       }
       return res;
   }
   
   public class TrieNode
   {
          public int value; // Only used in leaf nodes
          public TrieNode[] arr  = new TrieNode[2];
   }
   
   TrieNode newNode()
   {
          Main.TrieNode temp = new Main.TrieNode();
       temp.value = 0;
       temp.arr[0] = temp.arr[1] = null;
       return temp;
   }
   
   public static void main(String [] args)
   {
          Scanner sc=new Scanner(System.in);
          int N=Integer.parseInt(sc.nextLine());
            String str=sc.nextLine();
            String[]  strarray=str.split(" ");
              int listarray[] = new int[strarray.length];
              
              for(int i=0;i<strarray.length;i++){
                     listarray[i] = Integer.parseInt(strarray[i]);
              }
              
           int n = listarray.length;
           int result = (new Main()).findMaxXOR(listarray, n);
           System.out.println(result);
       }

}
