package dsa.dynamicProgramming.adityaVerma;

import javafx.util.Pair;

import java.util.Comparator;
import java.util.PriorityQueue;

import static com.utility.Utility.*;

public class Heap {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        //sortKSortedArray(new int[]{6, 5, 3, 2, 8, 10, 9}, 3);
        kClosestElements(new int[]{5, 6, 7, 8, 9}, 3, 7);

    }

    static int kthSmallestElement(int[] arr, int k) {

        return -1;
    }

    static int[] kLargestElement(int[] arr, int k) {

        return arr;
    }

    /**
     * <h1>Leetcode</h1>Nearly Sorted Array
     */
    static void sortKSortedArray(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int ans[] = new int[arr.length];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            minHeap.add(arr[i]);
            if (minHeap.size() > k) {
                arr[j++] = minHeap.poll();
            }
        }
        while (!minHeap.isEmpty()) {
            arr[j++] = minHeap.poll();
        }
        printArray(arr);
    }

    static void kClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair<Integer, Integer>> maxHeap = new PriorityQueue<>((first, second) -> Integer.compare(second.getKey(), first.getKey()));
        //new PriorityQueue<>(k, Comparator.comparing(Pair::getKey));
        for (int i = 0; i < arr.length; i++) {
            maxHeap.add(new Pair(Math.abs(arr[i] - x), arr[i]));
            if (maxHeap.size() > k)
                maxHeap.poll();
        }
        //while (maxHeap.size() > 0)
        //  println(maxHeap.poll());
        while (maxHeap.size() > 0)
            println(maxHeap.peek().getKey() + " " + maxHeap.poll().getValue());
    }

    static void kTopFrequentElements(int[] arr, int k) {

        println();
    }

    static void frequencySort(int[] arr) {

        printArray(arr);
    }

    static void kClosestPointsToOrigin(int[] arr, int k) {

        printArray(arr);
    }

    static int connectRopesToMinimizeCost(int[] arr) {
        int cost = 0;

        return cost;

    }

    static int sumOfElementsBetweenK1SmallestAndK2Smallest(int[] arr, int k1, int k2) {
        int sum = 0;

        return sum;
    }


}
