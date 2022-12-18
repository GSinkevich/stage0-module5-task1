package com.epam.mjc.stage0;


/**
 * Here are the tasks for working with the arrays.
 * <p>
 * The usage of any additional packages (such as java.util.*) is forbidden.
 */
public class ArrayTasks {

    /**
     * Return a String[] array that will list all the seasons of the year, starting with winter.
     */
    public String[] seasonsArray() {
        return  new String[]{"winter", "spring", "summer", "autumn"};
    }

    /**
     * Generate an int[] array of consecutive positive integers
     * starting at 1 of the given length (length parameter > 0).
     * <p>
     * Example:
     * <p>
     * length = 1  -> [1]
     * length = 3  -> [1, 2, 3]
     * length = 5  -> [1, 2, 3, 4, 5]
     */
    public int[] generateNumbers(int length) {
        var result = new int[length];
        for (int i =0; i < length; i++) {
            result[i] = i+1;
        }
        return result;
    }

    /**
     * Find the sum of all elements of the int[] array.
     * <p>
     * Example:
     * <p>
     * arr = [1, 3, 5]   -> sum = 9
     * arr = [5, -3, -4] -> sum = -2
     */
    public int totalSum(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
        }
        return  result;
    }

    /**
     * Return the index of the first occurrence of number in the arr array.
     * If there is no such element in the array, return -1.
     * <p>
     * Example:
     * <p>
     * arr = [99, -7, 102], number = -7    ->   2
     * arr = [5, -3, -4],   number = 10    ->  -1
     */
    public int findIndexOfNumber(int[] arr, int number) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]== number){
                return  i;
            }
            }
        return -1;
    }

    /**
     * Return the new String[] array obtained from the arr array
     * by reversing the order of the elements.
     * <p>
     * Example:
     * <p>
     * arr = ["Bob", "Nick"]               -> ["Nick", "Bob"]
     * arr = ["pineapple", "apple", "pen"] -> ["pen", "apple", "pineapple"]
     */
    public String[] reverseArray(String[] arr) {
        String[] result = new String[arr.length];
        for (int i = arr.length; i > 0; i--) {
            result[i-1]= arr[arr.length - i  ];
        }
        return  result;
    }

    /**
     * Return new int[] array obtained from arr int[] array
     * by choosing positive numbers only.
     * P.S. 0 is not a positive number =)
     * <p>
     * Example:
     * <p>
     * arr = [1,-2, 3]      -> [1, 3]
     * arr = [-1, -2, -3]   -> []
     * arr = [1, 2]         -> [1, 2]
     */
    public int[] getOnlyPositiveNumbers(int[] arr) {
        int count = 0;
        for (int i = 0; i <= arr.length-1; i++) {
            if (arr[i] > 0){
                count++;
            }
        }

        int[] result = new int[count];
        count = 0;
        for (int i = 0; i <= arr.length -1 ; i++) {
            if (arr[i]>0){
                result[count]=arr[i];
                count++;
            }
        }
        return  result;
    }

    /**
     * Return a sorted, ragged, two-dimensional int[][] array following these rules:
     * Incoming one-dimensional arrays must be arranged in ascending order of their length;
     * numbers in all one-dimensional arrays must be in ascending order.
     * <p>
     * Example:
     * <p>
     * arr = [[3, 1, 2,], [3,2]] -> [[2, 3], [1, 2, 3]]
     * arr = [[5, 4], [7]]       -> [[7], [4, 5]]
     */
    public int[][] sortRaggedArray(int[][] arr) {
      boolean swap = true;
      while (swap){
          swap = false;
          for (int i = 0; i < arr.length-1; i++) {
              int lengthFirstArr = arr[i].length;
              if (lengthFirstArr > arr[i+1].length){
                  int[] temp;
                  temp = arr[i];
                  arr[i]= arr[i+1];
                  arr[i+1]=temp;
                  swap = true;
              }
          }
      }

        for (int i = 0; i < arr.length-1; i++) {
            QuickSort(arr[i],0,arr[i].length-1);
        }
        return  arr;
    }

    public void QuickSort(int[] arr,int firstIndex, int lastIndex){
        if(arr.length <= 1){
            return ;
        }
        int pivot = arr[(lastIndex-firstIndex)/2 + firstIndex];
        int i = firstIndex; int j = lastIndex;
        while(i < j){
            while(arr[i] < pivot){
                i++;
            }
            while(arr[j] > pivot){
                j--;
            }

            if(i <= j){
                int temp = arr[i];
                arr[i]=arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if(firstIndex < j){QuickSort(arr, firstIndex, j);}
        if(lastIndex >i ){QuickSort(arr, i, lastIndex);}
    }
}