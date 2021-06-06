package com.utility;

import java.util.Scanner;

public class Utility {
    public static Scanner scanner = new Scanner(System.in);

    public static void println(Object str) {
        System.out.println(str.toString());
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
