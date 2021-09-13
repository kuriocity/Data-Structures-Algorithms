package dsa.dynamicProgramming.adityaVerma;

import static com.utility.Utility.*;

public class MatrixChainMultiplication {
    static int[][] table;
    static int rc = 0; //Recursion calls

    public static void main(String[] args) {
        table = new int[Integer.MAX_VALUE / 100000][Integer.MAX_VALUE / 100000];
        fill2DArray(table, -1);
        //println(eggDroppingProblem(2, 4));
        //println(matrixChainMultiplication(new int[]{4, 2, 3, 1, 3}, 1, 4));
        //println(palindromePartition("nitik", 0, 4));
        //println(evaluateExpressionTrueParenthesizationNumberOfWays("T|F&T^F", 0, 6, true));
        println(scrambledString("great", "rgeat"));
        println("RC :" + rc);
    }

    static int matrixChainMultiplication(int[] dimensions, int i, int j) {
        rc++;
        if (i == j) return 0;
        int minimumCost = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int cost = matrixChainMultiplication(dimensions, i, k)
                    + matrixChainMultiplication(dimensions, k + 1, j)
                    + dimensions[i - 1] * dimensions[k] * dimensions[j];
            minimumCost = Math.min(minimumCost, cost);
            if (i == 1 && j == 4) println("k :" + k + " _ " + cost);
        }
        return minimumCost;
    }

    static int matrixChainMultiplicationMemoized(int[] dimensions, int i, int j) {
        rc++;
        if (i == j) return 0;
        int minimumCost = Integer.MAX_VALUE;
        if (table[i][j] != -1) return table[i][j];
        for (int k = i; k <= j - 1; k++) {
            int cost = matrixChainMultiplicationMemoized(dimensions, i, k)
                    + matrixChainMultiplicationMemoized(dimensions, k + 1, j)
                    + dimensions[i - 1] * dimensions[k] * dimensions[j];
            minimumCost = Math.min(minimumCost, cost);
            if (i == 1 && j == 4) println("k :" + k + " _ " + cost);
        }
        return table[i][j] = minimumCost;
    }

    //indexed
    static boolean isPalindrome(String str, int i, int j) {
        while (i <= j) {
            if (str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    static int palindromePartition(String str, int i, int j) {
        if (i == j) return 0;
        if (isPalindrome(str, i, j)) return 0; //memoize this also
        int minimumPartitions = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int partitions = 1 + palindromePartition(str, i, k) + palindromePartition(str, k + 1, j);
            minimumPartitions = Math.min(minimumPartitions, partitions);
        }
        return minimumPartitions;

    }

    static int evaluateExpressionTrueParenthesizationNumberOfWays(String str, int i, int j, boolean toFind) {
        if (i == j)
            return toFind == (str.charAt(i) == 'T') ? 1 : 0;
        int numberOfWays = 0;
        for (int k = i + 1; k <= j - 1; k += 2) {
            int leftTrue = evaluateExpressionTrueParenthesizationNumberOfWays(str, i, k - 1, true);
            int leftFalse = evaluateExpressionTrueParenthesizationNumberOfWays(str, i, k - 1, false);
            int rightTrue = evaluateExpressionTrueParenthesizationNumberOfWays(str, k + 1, j, true);
            int rightFalse = evaluateExpressionTrueParenthesizationNumberOfWays(str, k + 1, j, false);
            int ways = 0;
            //AND
            if (str.charAt(k) == '&') {
                if (toFind)
                    ways = rightTrue * leftTrue;
                else
                    ways = leftFalse * rightFalse + leftTrue * rightFalse + leftFalse * rightTrue;
            }
            //OR
            else if (str.charAt(k) == '|') {
                if (toFind)
                    ways = leftFalse * rightTrue + leftTrue * rightFalse + leftTrue * rightTrue;
                else
                    ways = leftFalse * rightFalse;
            }
            //XOR
            else if (str.charAt(k) == '^') {
                if (toFind)
                    ways = leftTrue * rightFalse + leftFalse * rightTrue;
                else
                    ways = leftTrue * rightTrue + leftFalse * rightFalse;
            }
            if (i == 0 && j == 6) {
                println("leftTrue :" + leftTrue + " leftFalse :" + leftFalse + " rightTrue :" + rightTrue + " rightFalse :" + rightFalse);
                println("k :" + k + " ways :" + ways);
            }
            numberOfWays += ways;
        }
        //println("numberOfWays :" + numberOfWays);
        return numberOfWays;
    }

    //find all scrambled string?
    static boolean scrambledString(String str, String str2) {
        if (str.equals(str2))
            return true;
        if (str.length() == 1)
            return false;
        for (int i = 1; i < str.length(); i++) {
            if (scrambledString(str.substring(0, i), str2.substring(0, i)) &
                    scrambledString(str.substring(i), str2.substring(i))
                    ||
                    scrambledString(str.substring(0, i), str2.substring(str2.length() - i)) &
                            scrambledString(str.substring(i), str2.substring(0, str2.length() - i))
            )
                return true;

        }
        return false;
    }

    static int eggDroppingProblem(int e, int f) {
        rc++;
        //println(e + " " + f);
        if (e == 1) return f;
        if (f == 0 || f == 1) return f;
        //memoized
        if (table[e][f] != -1) return table[e][f];
        int minAttempts = Integer.MAX_VALUE;
        for (int k = 1; k <= f; k++) {
            int worstCase = Math.max(1 + eggDroppingProblem(e - 1, k - 1),
                    1 + eggDroppingProblem(e, f - k));
            minAttempts = Math.min(minAttempts, worstCase);
        }

        return table[e][f] = minAttempts;

    }

}
