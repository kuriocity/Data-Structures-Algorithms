package dsa.strings;

import static com.utility.Utility.*;

public class Strings {
    public static void main(String[] args) {
        //println(isSubSequence("ABCDEF", 0, "ADE", 0));

    }

    static boolean isPalindrome(String str) {

        return false;
    }

    static boolean isSubSequence(String str1, String str2) {
        return false;
    }

    //recursive
    static boolean isSubSequence2(String str1, int i, String str2, int j) {
        if (j == str2.length()) return true;
        else if (i == str1.length()) return false;
        println(i + " : " + j);
        if (str1.charAt(i) == str2.charAt(j)) {
            j++;
        }
        i++;
        return isSubSequence2(str1, i, str2, j);
        //return false;
    }

    //do + & -* in 1 loop only
    static boolean isAnagram(String str1, String str2) {
        return false;
    }

    // int array and boolean array
    static int leftMostRepeatingCharacter(String str) {

        return -1;
    }

    static int leftMostNonRepeatingCharacter(String str) {

        return -1;
    }

    //wow! never thought of this!!! use reverse function!
    static void reverseWordsInSentence(char[] chars) {

    }

    static int patternSearchDistinct(String text, String pattern) {

        return -1;
    }

    static int rabinKarp(String text, String pattern) {
        return -1;
    }

    static int[] lpsArray(String str) {

        return new int[]{};
    }

    static int KMP(String text, String pattern) {
        return -1;
    }

    static boolean isRotation(String str1, String str2) {

        return false;
    }

    static int anagramSearch(String text, String pattern) {

        return -1;
    }

    static int lexicographicRank(String str) {

        return -1;
    }

    static String longestSubtringDistinctCharacters(String str) {

        return str;
    }

}