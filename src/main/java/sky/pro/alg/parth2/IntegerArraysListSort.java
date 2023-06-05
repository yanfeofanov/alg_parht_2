package sky.pro.alg.parth2;

import java.util.Arrays;
import java.util.Random;

public class IntegerArraysListSort {

    public static void  bubbleSort(int[] arr){
        for (int i = arr.length-1; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if(arr[j]>arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }


    public static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length ; i++) {
            int midIdx = i;
            for (int j = 0; j < arr.length; j++) {
                if(arr[j] < arr[midIdx]){
                    midIdx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[midIdx];
            arr[midIdx] = temp;
        }
    }

    public static void insertionSort(int[] arr){
        for (int out = 1; out < arr.length ; out++) {
            int temp = arr[out];
            int in  = out;
            while (in > 0 && arr[in -1] >= temp){
                arr[in]=arr[in -1];
                in--;
            }
            arr[in]=temp;
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr1 = new int [100_000];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = rand.nextInt(100);
        }
        int[] arr2 = Arrays.copyOf(arr1,arr1.length);
        int[] arr3 = Arrays.copyOf(arr1,arr1.length);

        long start = System.currentTimeMillis();
        bubbleSort(arr1);
        long time = System.currentTimeMillis() - start;
        System.out.println("bubble sort "+time);

        start = System.currentTimeMillis();
        selectionSort(arr2);
        time = System.currentTimeMillis() - start;
        System.out.println("selection sort "+time);

        start = System.currentTimeMillis();
        insertionSort(arr3);
        time = System.currentTimeMillis() - start;
        System.out.println("insertion sort "+time);
     }
}
