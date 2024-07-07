package com.example.splitwise.dsa;
//
//import java.util.ArrayList;
//import java.util.List;
//
//class Solution {
//
//    public void solve(int n, int i, String s,  List<String> arr){
//        if(i == n) {
//            arr.add(new String(s));
//            return;
//        }
//
//        if (i>=1 && s.charAt(i-1) =='0') {
//            solve(n, i+1, s + "1", arr);
//        }
//        else {
//            solve(n, i+1, s + "1", arr);
//            solve(n, i+1, s + "0", arr);
//        }
//
//
//    }
//    public List<String> validStrings(int n) {
//
//
//        List<String> ans = new ArrayList<>();
//        solve(n,0,"",ans);
//        return ans;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(new Solution().validStrings(3));
//    }
//}
//
//import lombok.Data;
//import lombok.ToString;
//
//import java.lang.reflect.Array;
//import java.util.Arrays;
//
//@Data
//@ToString
//class Pairs {
//    public int x;
//    public int y;
//    public boolean isEmpty;
//
//    public Pairs() {
//        this.x = 0;
//        this.y = 0;
//        this.isEmpty = false;
//    }
//
//}
//
//class Solution {
//
//
//    public static int solve(char[][] grid) {
//        int count = 0;
//        int rows = grid.length;
//        int cols = grid[0].length;
//        Pairs[][] matrix = new Pairs[rows][cols];
//
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                matrix[i][j] = new Pairs();
//            }
//        }
//
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//
//
//                if (grid[i][j] == 'x') {
//                    matrix[i][j].x += 1;
//                } else if (grid[i][j] == 'y') {
//                    matrix[i][j].y += 1;
//                }
//
//
//                if (i != 0 && j != 0) {
//                    matrix[i][j].x = matrix[i][j].x + matrix[i - 1][j].x + matrix[i][j - 1].x - matrix[i-1][j-1].x;
//                    matrix[i][j].y = matrix[i][j].y + matrix[i - 1][j].y + matrix[i][j - 1].y - matrix[i-1][j-1].y;
//                } else if (i == 0) {
//                    if (j > 0) {
//                        matrix[i][j].x = matrix[i][j].x + matrix[i][j - 1].x;
//                        matrix[i][j].y = matrix[i][j].y + matrix[i][j - 1].y;
//                    }
//                } else {
//                    matrix[i][j].x = matrix[i][j].x + matrix[i - 1][j].x;
//                    matrix[i][j].y = matrix[i][j].y + matrix[i - 1][j].y;
//                }
//            }}
//
//            for (int i = 0; i < rows; i++) {
//                for (int j = 0; j < cols; j++) {
//                    if (matrix[i][j].x == matrix[i][j].y && matrix[i][j].x > 0) {
//                        ++count;
//                    }
//                }
//            }
//
//        return count;
//    }
//
//    public int numberOfSubmatrices(char[][] grid) {
//        return solve(grid);
//    }
//
//    public static void main(String[] args) {
//        char[][] grid = {{'x', 'y', '.'}, {'y', '.', '.'}};
//        System.out.println(new Solution().numberOfSubmatrices(grid));
//    }
//}

import java.util.Arrays;

class Solution {

    public static int solve(char[][] grid) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        // 2D arrays to store cumulative counts of 'x' and 'y'
        int[][] xCount = new int[rows][cols];
        int[][] yCount = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 'x') {
                    xCount[i][j] = 1;
                } else if (grid[i][j] == 'y') {
                    yCount[i][j] = 1;
                }

                if (i > 0) {
                    xCount[i][j] += xCount[i - 1][j];
                    yCount[i][j] += yCount[i - 1][j];
                }
                if (j > 0) {
                    xCount[i][j] += xCount[i][j - 1];
                    yCount[i][j] += yCount[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    xCount[i][j] -= xCount[i - 1][j - 1];
                    yCount[i][j] -= yCount[i - 1][j - 1];
                }
            }
        }
        for(int[] arr: xCount){
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("=======================");
        for(int[] arr: yCount){
            System.out.println(Arrays.toString(arr));
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (xCount[i][j] == yCount[i][j] && xCount[i][j] > 0) {
                    ++count;
                }
            }
        }

        return count;
    }

    public int numberOfSubmatrices(char[][] grid) {
        return solve(grid);
    }

    public static void main(String[] args) {
        char[][] grid = { {'x', 'y', ','}, {'y', '.', '.'} };
        System.out.println(new Solution().numberOfSubmatrices(grid));
    }
}
