package dsa.arrays;

import static com.utility.Utility.*;

public class BinarySearch {
    public static void main(String[] args) {
        //           0  1  2  3   4   5
        int arr[] = {2, 5, 7, 9, 10, 12};
        //println(binarySearch(arr, 9));
        println(binarySearchRecursive(arr, 0, arr.length - 1, 90));
    }

    static int binarySearch(int arr[], int num) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            println(start + " " + mid + " " + end);
            if (arr[mid] == num) return mid;
            else if (arr[mid] > num) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }

    static int binarySearchRecursive(int arr[], int start, int end, int num) {
        if (start > end) return -1;
        int mid = (start + end) / 2;
        if (arr[mid] == num) return mid;
        else if (arr[mid] > num) return binarySearchRecursive(arr, start, mid - 1, num);
        else return binarySearchRecursive(arr, mid + 1, end, num);

    }

    static int firstOccurence(int arr[], int x) {
        return -1;
    }

    static int lastOccurence(int arr[], int x) {
        return -1;
    }

    static int countOfOccurences(int arr[], int x) {
        return -1;
    }

    static int countOf1s(int arr[], int x) {
        return -1;
    }

    static int squareRoot(int x) {
        return 1;
    }

    static int searchInfiniteSizedArray(int arr[], int x) {
        return -1;
    }

    static int peakElement(int arr[], int x) {
        return -1;
    }

    static int twoPointerApproach(int arr[], int x) {
        return -1;
    }

    static int median2SortedArrays(int arr1[], int arr2[]) {
        return -1;
    }

    static int majorityElement(int arr[]) {
        return -1;
    }

    static int repeatingElements(int arr[]) {
        return -1;
    }

    static int allocateMinimumPages(int arr[], int x) {
        return -1;
    }


}
