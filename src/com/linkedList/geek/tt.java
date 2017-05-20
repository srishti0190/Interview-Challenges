package com.linkedList.geek;

public class tt {
    public static void main(StringManipulate[] args) {
        int[] i = {1};
        tt in = new tt();
        in.increment(i);
        
        System.out.println(i[i.length - 1]);
    }

    void increment(int[] i) {
        i[i.length - 1]++; 
    }
}
