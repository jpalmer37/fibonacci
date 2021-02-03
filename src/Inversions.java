// Author: John Palmer

import java.lang.Math.*;

public class Inversions {
    
    // Function to sort an array and return the number of inversions  
    public static int invCounter(int[] A, int size){
        
        // If array size is 0 or 1, no inversions are possible
        if (size < 2){
            return 0;
        }

        // Find the middle value 
        int middle = (int) Math.ceil(size / 2);

        
        int[] leftArray = new int[middle];
        int[] rightArray = new int[size - middle];
        
        // Load left and right arrays   
        for (int a = 0; a < middle; a++){
            leftArray[a] = A[a];
        }
        for (int b = middle; b < size; b++){
            rightArray[b - middle] = A[b];
        }

        // Record the number of inversions in the left and right subarrays
        int left = invCounter(leftArray, middle);
        int right = invCounter(rightArray, size - middle);

        // Count the inversions recorded at the current merge event
        int current = merge(A, leftArray, rightArray, middle, size-middle);
        
        // Return the number of inversions
        return current + left + right;  
    }

    // Function to merge two subarrays together and detect cases of inversions 
    public static int merge(int[] A, int[] left, int[] right, int L, int R){
        int i = 0, j = 0, k = 0;
        
        int inv = 0;
        int factor = 0;   // ** Factor is used to count the number of inversions added at once

        // Merge the left and right subarrays into a combined array
        while (i < L && j < R){
             
            // Load from left 
            if (left[i] < right[j]){
                A[k] = left[i];
                i++;
                inv = inv + factor;  // ** Increase the number of inversions by "factor"
            // Load from right 
            }else{
                A[k] = right[j];
                j++;
                factor++;     // **  Increase the number of inversions counted by 1
            }
            k++; 

        }
        
        // Load remaining elements in left 
        while (i < L){
            A[k] = left[i];
            i++;
            k++;
            inv = inv + factor; // ** Increase the number of inversions by "factor"
        }
        // Load remaining elements in right 
        while (j < R){
            A[k] = right[j];
            j++;
            k++;
        }

        // Return the number of inversions 
        return inv;
    }

    // Testing
    public static void main(String[] args){
        int[] myArr = {3,5,2,7,1,4};
        int[] myArr2 = {5,4,3,2,1};
        
        for (int i = 0; i < myArr.length; i++){
            System.out.print(myArr[i]);
        }
        int res = invCounter(myArr, myArr.length);
        
        System.out.print("\nNumber of inversions:  ");
        System.out.println(res);

        for (int i = 0; i < myArr2.length; i++){
            System.out.print(myArr2[i]);
        }

        int res2 = invCounter(myArr2, myArr2.length);
        System.out.print("\nNumber of inversions:  ");
        System.out.println(res2);

    }
}
