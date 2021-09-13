package dsa.dynamicProgramming.adityaVerma;

import java.util.Arrays;

import static com.utility.Utility.*;

public class LongestCommonSubsequence {
    static int[][] table;

    public static void main(String[] args) {
        String str = "AXYT";
        String str2 = "AYZX";
        println(longestCommonSubsequence(str, str2, str.length(), str2.length()));
        //table = new int[str.length() + 1][str2.length() + 1];
        //fill2DArray(table, -1);
        //println(longestCommonSubsequenceMemoizedTopDown(str, str2, str.length(), str2.length()));
        //println(longestCommonSubsequenceTabulizedBottomUp(str, str2, str.length(), str2.length()));
        //println(printLongestCommonSubsequence(str, str2, str.length(), str2.length()));
        printShortestCommonSupersequence("dcbcf", "abcdaf");
    }

    static int longestCommonSubsequence(String str, String str2, int m, int n) {
        if (m == 0 || n == 0) return 0;
        if (str.charAt(m - 1) == str2.charAt(n - 1))
            return 1 + longestCommonSubsequence(str, str2, m - 1, n - 1);
        else
            return Math.max(longestCommonSubsequence(str, str2, m - 1, n),
                    longestCommonSubsequence(str, str2, m, n - 1));
    }

    static int longestCommonSubsequenceMemoizedTopDown(String str, String str2, int m, int n) {
        if (m == 0 || n == 0) return 0;
        if (table[m][n] != -1) return table[m][n];
        else {
            if (str.charAt(m - 1) == str2.charAt(n - 1))
                return table[m][n] = 1 + longestCommonSubsequence(str, str2, m - 1, n - 1);
            else
                return table[m][n] = Math.max(longestCommonSubsequence(str, str2, m - 1, n),
                        longestCommonSubsequence(str, str2, m, n - 1));
        }

    }

    static int longestCommonSubsequenceTabulizedBottomUp(String str, String str2, int m, int n) {
        table = new int[str.length() + 1][str2.length() + 1];
        //Arrays are already intialized by 0 default!!!
        /*Arrays.fill(table[0], 0);
        for (int[] arr : table) arr[0] = 0;*/
        print2DArray(table);
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str.charAt(i - 1) == str2.charAt(j - 1))
                    table[i][j] = 1 + table[i - 1][j - 1];
                else
                    table[i][j] = Math.max(table[i][j - 1], table[i - 1][j]);
            }
        }
        print2DArray(table);
        return table[str.length()][str2.length()];
    }

    static String printLongestCommonSubsequence(String str, String str2, int m, int n) {
        StringBuilder builder = new StringBuilder();
        longestCommonSubsequenceTabulizedBottomUp(str, str2, str.length(), str2.length());
        int i = str.length();
        int j = str2.length();
        while (i > 0 && j > 0) {
            if (str.charAt(i - 1) == str2.charAt(j - 1)) {
                i--;
                j--;
                builder.append(str.charAt(i));
            } else if (table[i][j - 1] > table[i - 1][j]) {
                j--;
            } else
                i--;
        }


        return builder.reverse().toString();
    }

    static int longestCommomSubstring(String str, String str2) {
        return -1;

    }

    static int shortestCommonSupersequence(String str, String str2) {
        return str.length() + str2.length() - longestCommonSubsequenceTabulizedBottomUp(str, str2, str.length(), str2.length());
    }

    static String printShortestCommonSupersequence(String str, String str2) {
        //return str.length() + str2.length() - longestCommonSubsequenceTabulizedBottomUp(str, str2, str.length(), str2.length());
        StringBuilder builder = new StringBuilder();
        longestCommonSubsequenceTabulizedBottomUp(str, str2, str.length(), str2.length());
        int i = str.length();
        int j = str2.length();
        while (i > 0 && j > 0) {
            if (str.charAt(i - 1) == str2.charAt(j - 1)) {
                i--;
                j--;
                builder.append(str.charAt(i));
            } else if (table[i][j - 1] > table[i - 1][j]) {
                j--;
                builder.append(str2.charAt(j));
            } else {
                i--;
                builder.append(str.charAt(i));
            }
        }
        while (i > 0) {
            i--;
            builder.append(str.charAt(i));
        }
        while (j > 0) {
            j--;
            builder.append(str2.charAt(j));
        }
        println(builder.reverse());
        return builder.reverse().toString();
    }

    static int[] minimumInsertionsAndDeletionsToConvertAStringToAnother(String str, String str2) {
        int lcs = longestCommonSubsequenceTabulizedBottomUp(str, str2, str.length(), str2.length());
        int deletions = str.length() - lcs;
        int insertions = str2.length() - lcs;
        return new int[]{insertions, deletions};
    }

    static int longestPalindromicSubsequence(String str) {
        return longestCommonSubsequenceTabulizedBottomUp(str, new StringBuilder(str).reverse().toString(), str.length(), str.length());
    }

    static int minimumNumberOfDeletionsToMakeStringPalindrome(String str) {
        return str.length() - longestPalindromicSubsequence(str);
    }

    //same as deletions!!!
    static int minimumNumberOfInsertionsToMakeStringPalindrome(String str) {
        return str.length() - longestPalindromicSubsequence(str);
    }

    //This is a very confusing question...
    static int longestRepeatingSubsequence(String str) {
        return -1;
    }

    //a would be smallest string
    static boolean sequencePatternMatch(String a, String b) {
        return longestCommonSubsequenceTabulizedBottomUp(a, b, a.length(), b.length()) == a.length();
    }


}
