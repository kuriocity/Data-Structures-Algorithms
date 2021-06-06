package dsa.recursion;

import java.util.ArrayList;
import java.util.List;

import static com.utility.Utility.*;

public class Recursion {
    public static void main(String[] args) {
        String str = "racecar";
        println("Permutations of String " + str);
        //permuteString("",str);
        //println(count);
        println(palindrome(str));
        //println(ropeCutting(8, 0));
        //getSubsetsOfString("", "abc", 0);
        int arr[] = {10, 2, 6};
        println("number of sums: " + subsetSum(arr, 0, 8));
        StringBuilder builder = new StringBuilder();
        //builder.
        permuteString("abc".toCharArray(),0);

    }

    public static void towerOfHanoi(int n, char A, char B, char C) {

    }

    public static void josephus(int num, int k) {

    }

    //"abc"
    public static void permuteString(char str[], int index) {
        if(index==str.length-1){
            for(char ch:str)print(ch);
            println();
        }
        for (int count = index; count < str.length; count++) {
            char temp=str[index];
            str[index]=str[count];
            str[count]=temp;
            permuteString(str,index+1);
            temp=str[count];
            str[count]=str[index];
            str[index]=temp;
        }
    }


    public static int subsetSum(int arr[], int index, int sum) {
        println(index + " " + sum);
        //if(sum<0)return 0; //backtracking ???
        if (index == arr.length) {
            if (0 == sum) {
                println("found ");
                return 1;
            } else return 0;
        }
        return subsetSum(arr, index + 1, sum)
                + subsetSum(arr, index + 1, sum - arr[index]);

    }

    static List<String> subsets = new ArrayList<>();
    static int in = 2;

    public static void getSubsetsOfString(String ans, String str, int index) {
        if (index == str.length()) {
            println(ans);
            return;
        }
        String r = str.substring(0, index) + "" + str.substring(index + 1);
        getSubsetsOfString(ans, str, index + 1);
        getSubsetsOfString(ans + str.charAt(index), str, index + 1);
    }

    public static int part1 = 8, part2 = 2, part3 = 2;

    public static int ropeCutting(int num, int count) {
        if (num < 0) return -1;
        else if (num == 0) return count;
        else
            return Math.max(Math.max(ropeCutting(num - part1, count + 1), ropeCutting(num - part2, count + 1)), ropeCutting(num - part3, count + 1));
    }

    public static boolean palindrome(String str) {
        if (str.length() == 0 || str.length() == 1) return true;
        else return str.charAt(0) == str.charAt(str.length() - 1) && palindrome(str.substring(1, str.length() - 1));
    }

    static int count;

    public static void permuteString(String constructed, String input) {
        if (input.equals("")) {
            println(constructed);
            count++;
        }
        for (int index = 0; index < input.length(); index++) {
            String toConstruct = constructed + input.charAt(index);
            String remaining = input.substring(0, index) + input.substring(index + 1, input.length());
            permuteString(toConstruct, remaining);

        }
    }
}
