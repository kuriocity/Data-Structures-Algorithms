package dsa.dynamicProgramming.adityaVerma;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static com.utility.Utility.*;

public class Knapsack {
    static int a = 10;
    static int[][] table;// = new int[][]{};
    static boolean[][] tableBoolean;

    public static void main(String[] args) {
        /*a = 7;
        println(a);
        println(knapsack0_1());
        println(a);
        a = 5;
        println(a);*/

        //[] arr = new int[]{3, 6};
        //println("list initial " + list);
        //findUniqueSubsets(arr, 0, new ArrayList<Integer>());
        //println("list final " + list);
        //println(knapsack0_1_Recursive(new int[]{24, 10, 10, 7}, new int[]{24, 18, 18, 10}, 25, 4));
        table = new int[4 + 1][25 + 1];
        //Arrays.stream(table).forEach(arr -> Arrays.fill(arr, -1));
        //println(knapsack0_1_RecursiveMemoized(new int[]{24, 10, 10, 7}, new int[]{24, 18, 18, 10}, 25, 4));
        //println(knapsack0_1_BottomUp(new int[]{24, 10, 10, 7}, new int[]{24, 18, 18, 10}, 25, 4));
        //println(subsetSum(new int[]{2, 3, 4, 8, 10}, 11, 5));
        //println(countOfSubsetsSum(new int[]{3, 4, 5, 6, 11}, 14, 5));
        //println(countOfSubsetsSumBottomUp(new int[]{3, 4, 5, 6, 11}, 14, 5));
        //println(minimumSubsetSum(new int[]{1, 6, 11, 5}));
        println(coinChangeMinimumNumberOfCoins(new int[]{1, 2, 3}, 5, 3));
    }

    static int knapsack0_1_Recursive(int[] wt, int[] val, int C, int n) {
        if (n == 0 || C == 0) return 0;
        if (wt[n - 1] <= C) {
            return Math.max(val[n - 1] + knapsack0_1_Recursive(wt, val, C - wt[n - 1], n - 1),
                    knapsack0_1_Recursive(wt, val, C, n - 1));
        } else return knapsack0_1_Recursive(wt, val, C, n - 1);
    }

    static int knapsack0_1_RecursiveMemoized(int[] wt, int[] val, int C, int n) {
        if (n == 0 || C == 0) return 0;
        if (table[n][C] != -1) return table[n][C];
        if (wt[n - 1] <= C) {
            return table[n][C] = Math.max(val[n - 1] + knapsack0_1_RecursiveMemoized(wt, val, C - wt[n - 1], n - 1),
                    knapsack0_1_RecursiveMemoized(wt, val, C, n - 1));
        } else return table[n][C] = knapsack0_1_RecursiveMemoized(wt, val, C, n - 1);
    }

    static int knapsack0_1_BottomUp(int[] wt, int[] val, int C, int n) {
        //if (n == 0 || C == 0) return 0;
        for (int i = 0; i < table.length; i++) table[i][0] = 0;
        for (int j = 0; j < table[0].length; j++) table[0][j] = 0;
        for (int i = 1; i < table.length; i++) {
            for (int j = 1; j < table[0].length; j++) {
                if (wt[i - 1] <= j) {
                    table[i][j] = Math.max(val[i - 1] + table[i - 1][j - wt[i - 1]],
                            table[i - 1][j]);
                } else table[i][j] = table[i - 1][j];
            }
        }
        return table[n][C];

    }

    static boolean subsetSum(int[] arr, int sum, int n) {
        if (sum == 0) return true;
        if (n == 0) return false;
        if (arr[n - 1] <= sum) {
            return subsetSum(arr, sum - arr[n - 1], n - 1) | subsetSum(arr, sum, n - 1);
        } else return subsetSum(arr, sum, n - 1);
    }

    static boolean subsetSumBottomUp(int[] arr, int sum, int n) {
        tableBoolean = new boolean[n + 1][sum + 1];

        Arrays.fill(tableBoolean[0], false);
        for (int i = 0; i <= n; i++) tableBoolean[i][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    tableBoolean[i][j] = tableBoolean[i - 1][j - arr[i - 1]] | tableBoolean[i - 1][j];
                } else
                    tableBoolean[i][j] = tableBoolean[i - 1][j];
            }
        }
        return tableBoolean[n][sum];
    }

    static boolean equalSumPartition(int[] arr) {
        int sum = 0;
        for (int i : arr) sum += i;
        if ((sum & 1) != 0) return false;
        else return subsetSum(arr, sum / 2, arr.length);
    }

    static HashMap<Integer, Integer> map = new HashMap<>();

    static int countOfSubsetsSum(int[] arr, int sum, int n) {
        if (sum == 0) return 1;
        if (n == 0) return 0;
        if (map.containsKey(n) && map.get(n) == sum) print("Overlapped! ");
        else map.put(n, sum);
        println("" + n + " " + sum);
        if (arr[n - 1] <= sum) {
            return countOfSubsetsSum(arr, sum - arr[n - 1], n - 1) + countOfSubsetsSum(arr, sum, n - 1);
        } else return countOfSubsetsSum(arr, sum, n - 1);
    }

    static int countOfSubsetsSumBottomUp(int[] arr, int sum, int n) {
        table = new int[n + 1][sum + 1];
        //fill2DArray(table,-1);
        //for (int i : table[0]) i = 44;
        Arrays.fill(table[0], 0);
        for (int j = 0; j <= n; j++) table[j][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j)
                    table[i][j] = table[i - 1][j - arr[i - 1]] + table[i - 1][j];
                else
                    table[i][j] = table[i - 1][j];
            }
        }

        print2DArray(table);

        return table[n][sum];

    }

    static int minimumSubsetSum(int[] arr) {
        int arraySum = 0;
        for (int i : arr) arraySum += i;
        subsetSumBottomUp(arr, arraySum / 2, arr.length);
        int j = arraySum / 2;
        while (!tableBoolean[arr.length][j]) j--;
        return arraySum - 2 * j;
    }

    static int countOfSubsetSumGivenDifference(int[] arr, int diff) {
        int range = 0;
        for (int i : arr) range += i;
        //s1 =(range+diff)/2
        return countOfSubsetsSum(arr, (range + diff) / 2, arr.length);
    }

    //leetcode
    static int targetSum(int[] arr, int sum, int n) {
        return countOfSubsetSumGivenDifference(arr, sum);
    }

    static int unboundedKnapsack(int[] wt, int[] val, int n, int C) {
        if (C == 0 || n == 0) return 0;
        if (wt[n - 1] <= C) {
            return Math.max(val[n - 1] + unboundedKnapsack(wt, val, n, C - wt[n - 1]),
                    unboundedKnapsack(wt, val, n - 1, C));
        } else
            return unboundedKnapsack(wt, val, n - 1, C);
    }

    static int rodCuttingProblem(int[] lengthOfPieces, int[] price, int n, int rodLength) {
        return -1;
    }

    static int coinChangeMaximumNumberOfWays(int[] coins, int change, int n) {

        return -1;
    }

    static int coinChangeMinimumNumberOfCoins(int[] coins, int change, int n) {
        //println(n+" "+change);
        if (change == 0) return 0;
        if (n == 0) return Integer.MAX_VALUE - 1;
        if (coins[n - 1] <= change) {
            return Math.min(1 + coinChangeMinimumNumberOfCoins(coins, change - coins[n - 1], n),
                    coinChangeMinimumNumberOfCoins(coins, change, n - 1));
        } else
            return coinChangeMinimumNumberOfCoins(coins, change, n - 1);
    }


    static List<List<Integer>> list = new ArrayList<List<Integer>>();

    /*static void findSubsets(int[] arr, int n, List<Integer> temp) {
        println("temp (to add) " + temp);
        list.add(new ArrayList<>(temp));
        println("#" + list + "#");
        if (n < arr.length) {
            temp.add(arr[n]);
            println("temp after add " + temp);
            findSubsets(arr, n + 1, temp);
            temp.remove(temp.size() - 1);
            println("temp after remove " + temp);
            findSubsets(arr, n + 1, temp);
        }
    }*/

    static void findUniqueSubsets(int[] arr, int n, List<Integer> temp) {
        println("temp (to add)! " + temp);
        //println("#" + list + "#");

        if (n == arr.length) {
            println(n + ":" + arr.length);
            list.add(new ArrayList<>(temp));
            println("#" + list + "added #");
        }
        println("#" + list + "#");
        if (n < arr.length) {
            temp.add(arr[n]);
            println("temp after add " + temp);
            findUniqueSubsets(arr, n + 1, temp);
            temp.remove(temp.size() - 1);
            println("temp after remove " + temp);
            findUniqueSubsets(arr, n + 1, temp);
        }
    }

}
