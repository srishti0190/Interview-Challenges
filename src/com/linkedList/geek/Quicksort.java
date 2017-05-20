package com.linkedList.geek;

public class Quicksort {
	public static void main(String args[]){
		Quicksort quicksort = new Quicksort();
		int array[] = {12,6,32,12};
		quicksort.sort(array,0,array.length-1);
		printArray(array);
	}

	public void sort(int [] arr, int l, int r){
		        if (l < r)
		        {
		            // Find the middle point
		            int m = (l+r)/2;
		            int n = 4/2-1; 
		            System.out.println("ksjdhfksd" +n);
		 
		            // Sort first and second halves
		            sort(arr, l, m);
		            sort(arr , m+1, r);
		            
		            System.out.println("what is high and low" +l +m+r);
		 
		            // Merge the sorted halves
		            merge(arr, l, m, r);
		        }
		    
	}

	void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];
 
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];
 
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
