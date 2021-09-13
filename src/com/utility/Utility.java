package com.utility;

import java.util.Arrays;
import java.util.Scanner;

public class Utility {
    public static Scanner scanner = new Scanner(System.in);

    public static void println(Object str) {
        System.out.println(str.toString());
    }

    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void printArray(String str, int[] arr) {
        System.out.println(str + ": " + Arrays.toString(arr));
    }

    public static void print2DArray(int[][] arr) {
        //System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.deepToString(arr).
                replace("], ", "]\n")
                .replace("[[", "[")
                .replace("]]", "]"));
    }

    public static void printPretty2DArray(int[][] arr) {
        //System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.deepToString(arr).
                replace("], ", "]\n")
                .replace("[[", "[")
                .replace("]]", "]"));
    }

    public static void fill2DArray(int[][] arrs, int val) {
        Arrays.stream(arrs).forEach(arr -> Arrays.fill(arr, val));
    }

    public static void println() {
        System.out.println();
    }

    public static void print(Object str) {
        System.out.print(str.toString());
    }

    public static void log(Object str) {
        System.out.println(str.toString());
    }

}
