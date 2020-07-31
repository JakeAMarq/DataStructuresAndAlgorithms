package ctci.chapter1;

import java.util.Arrays;

public class Problem1_7 {
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    
    public static void main(String[] theArgs) {
        if (theArgs.length == 0) {
            theArgs = new String[]{
                //Insert test cases here
            };
        }


        int[][][] matricies = new int[][][]{
            {{1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}}
        };
        for (int[][] matrix : matricies) {
            System.out.println(matrixToString(matrix));
            rotate(matrix, LEFT);
            System.out.println(matrixToString(matrix));
        }
    }

    public static void rotate(int[][] matrix, int direction) {
        int[][] copy = copyMatrix(matrix);
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (direction == LEFT) {
                    matrix[i][j] = copy[j][i];
                } else {

                }
                
            }
        }
        if (direction == LEFT) {

        } else {

        }
    }

    public static int[][] copyMatrix(int[][] matrix) {
        int[][] copy = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                copy[i][j] = matrix[i][j];
            }
        }
        return copy;
    }

    public static String matrixToString(int[][] matrix) {
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = 0; i < matrix.length; i++) {
            result.append("[");
            for (int j = 0; j < matrix[i].length; j++) {
                result.append(matrix[i][j]);
                if (j < matrix[i].length - 1) result.append(", ");
            }
            result.append("]");
            if (i < matrix.length - 1) result.append(",\n");
        }
        result.append("]");
        return result.toString();
    }
}