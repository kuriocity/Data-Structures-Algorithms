package dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.utility.Utility.*;

public class Sorting {
    public static void main(String[] args) {
        int[] arr = //{66,22, 11, 33, 44, 55 };
                //{5, 4, 3, 2, 1};
                {5, 8, 20, 2, 18, 5};
        //bubbleSort(arr);
        //lomutoPartition(arr);
        //println(Arrays.toString(arr));
        //mergeSort(arr, 0, arr.length - 1);
        //println(Arrays.toString(arr));
        //println(intersection2SortedArrays(new int[]{3, 5, 10, 10, 10, 15, 15, 20}, new int[]{5, 10, 10, 15, 30}));
        //cycleSortDistinct(arr);
        //countingSort(arr);
        int[] arr2 = {319, 212, 6, 8, 100, 50};
        //radixSort(arr2);
        bucketSort(arr2, 4);
        printArray("in main ", arr2);

    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void bubbleSort(int[] arr) {
        arr[1] = Integer.MAX_VALUE;
        arr[0] = Integer.MIN_VALUE - arr[1];
        swap(arr, 4, 5);
    }

    static void selectionSort(int[] arr) {

    }

    static void insertionSort(int[] arr) {

    }

    static void merge2SortedArrays(int[] arr1, int arr2[]) {

    }


    static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int[] larray = new int[mid - left + 1];
        int[] rarray = new int[right - mid];
        int k = left;
        for (int i = left; i <= mid; i++) larray[i - left] = arr[i];
        for (int j = mid + 1; j <= right; j++) rarray[j - (mid + 1)] = arr[j];
        int i = 0, j = 0;
        int inversionCount = 0;
        while (i < larray.length && j < rarray.length) {
            if (larray[i] <= rarray[j]) {
                arr[k] = larray[i];
                i++;
                k++;
            } else {
                arr[k] = rarray[j];
                j++;
                k++;
                inversionCount += mid - i;
            }
        }
        while (i < larray.length) {
            arr[k] = larray[i];
            i++;
            k++;
        }
        while (j < rarray.length) {
            arr[k] = rarray[j];
            j++;
            k++;
        }
        println(Arrays.toString(arr));
        println("Inversions " + inversionCount);
    }

    static List intersection2SortedArrays(int[] arr, int[] arr2) {
        List<Integer> integers = new ArrayList<>();
        int i = 0, j = 0;
        while (i < arr.length && j < arr2.length) {
            if (arr[i] < arr2[j]) {
                i++;
            } else if (arr[i] > arr2[j]) {
                j++;
            } else {
                integers.add(arr[i]);
                i++;
                j++;
            }
        }

        return integers;
    }

    static void union2SortedArrays(int[] arr, int[] arr2) {
        //List<Integer> integers = new ArrayList<>();
        int i = 0, j = 0;
        while (i < arr.length && j < arr2.length) {
            if (arr[i] < arr2[j]) {
                i++;
            } else if (arr[i] > arr2[j]) {
                j++;
            } else {
                //integers.add(arr[i]);
                i++;
                j++;
            }
        }
    }

    static int countInversions(int[] arr) {
        return -1;
    }

    static void lomutoPartition(int[] arr) {
        int left = 0, right = arr.length - 1;
        int pivot = right; //always last
        int i = -1;
        for (int j = 0; j < right; j++) {
            if (arr[j] < arr[pivot]) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, pivot);
        printArray(arr);
    }

    //without do while?
    static void hoarePartition(int[] arr) {

    }

    static void quickSort(int[] arr) {

    }

    static int kthSmallestElement(int[] arr) {
        return -1;
    }

    //-ve and +ve
    static void sortArray2TypesOfElements(int[] arr) {

    }

    static void dutchNationalFlag(int[] arr) {
    }

    static void mergeOverlappingIntervals(int[] arr) {
    }

    static int maximumGuests(int[] arrival, int[] departure) {
        return -1;
    }

    //mine not working
    static void cycleSortDistinct(int[] arr) {
        int numSwaps = 0;
        for (int i = 0; i < arr.length; i++) {
            int item = arr[i];
            int pos = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] < item) pos++;
            }
            if (pos > -1) {
                if (arr[i] != arr[pos]) {
                    swap(arr, i, pos);
                    numSwaps++;
                }
                printArray(arr);
            }
            println(numSwaps);

        }
    }

    static void countingSort(int[] arr) {
        int max = 0;
        for (int item : arr) max = Math.max(max, item);
        int count[] = new int[max + 1];
        for (int item : arr) count[item]++;
        printArray(count);
        for (int i = 1; i < count.length; i++) count[i] += count[i - 1];
        printArray(count);
        int output[] = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }
        arr = output;
        printArray(count);
        printArray(output);
        printArray(arr);
    }

    static void radixSort(int[] arr) {
        printArray("before sorting", arr);
        int max = 0;
        for (int item : arr) max = Math.max(max, item);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortRadix(arr, exp);
        }
        printArray("final array", arr);
        //arr=new int[]{1,3,4,6,6,8};
    }

    static void countingSortRadix(int[] arr, int exp) {
        int count[] = new int[10];
        for (int item : arr) {
            count[(item / exp) % 10]++;
        }
        printArray(count);
        for (int i = 1; i < count.length; i++) count[i] += count[i - 1];
        printArray(count);
        int output[] = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        //arr = output;
        for (int i = 0; i < arr.length; i++) arr[i] = output[i];
        //printArray(count);
        printArray("in method", arr);

    }

    static void bucketSort(int[] arr, int k) {
        printArray("before sorting", arr);
        int max = 0;
        for (int item : arr) max = Math.max(max, item);
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < k; i++) buckets.add(new ArrayList<Integer>());
        for (int item : arr) {
            int bucketIndex = k * item / (max + 1);
            buckets.get(bucketIndex).add(item);
        }
        int index = 0;
        for (int i = 0; i < k; i++) {
            Collections.sort(buckets.get(i));
            for (int j = 0; j < buckets.get(i).size(); j++) arr[index++] = buckets.get(i).get(j);
        }
        printArray("in method", arr);

    }

}
