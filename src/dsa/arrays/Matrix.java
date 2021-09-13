package dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.utility.Utility.*;

public class Matrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };//new int[4][4];
        //rotate90AntiClockWise(arr);
        println(Arrays.binarySearch(new int[]{5, 10, 20, 30, 40}, 5));
    }

    static void rotate90AntiClockWise(int[][] arr) {
        print2DArray(arr);
    }

    public static List<Integer> spiralTraversal(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int n = matrix.length;
        int r = n;
        int m = matrix[0].length;
        int c = m;
        int i = 0;
        int j = -1;
        boolean right = true, down = false, left = false, up = false;
        r = r - 2;
        while (result.size() < (n * m)) {
            if (right) {
                for (int k = 0; k < c; k++) {
                    j++;
                    result.add(matrix[i][j]);
                }
                right = false;
                down = true;
            } else if (down) {
                for (int k = 0; k < r; k++) {
                    i++;
                    result.add(matrix[i][j]);
                }
                down = false;
                left = true;
            } else if (left) {
                i++;
                for (int k = 0; k < c; k++) {
                    result.add(matrix[i][j]);
                    j--;
                }
                left = false;
                up = true;
            } else if (up) {
                j++;
                for (int k = 0; k < r; k++) {
                    i--;
                    result.add(matrix[i][j]);
                }
                up = false;
                right = true;
                r -= 2;
                c -= 2;
            }
            //System.out.println(result +" i "+i+" j "+j);
        }
        return result;
    }

    //binary search==?
    static int[][] searchRowColumnWiseSorted(int[][] arr) {
        return new int[][]{};
    }

    static int medianRowWiseSorted(int[][] arr) {

        return -1;
    }

}

