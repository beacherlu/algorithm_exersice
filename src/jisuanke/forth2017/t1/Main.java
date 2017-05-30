package jisuanke.forth2017.t1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by luyan on 17/5/28.
 */
public class Main {

    private static int inputn;
    private static int inputm;
    private static int maxCnt;

    public static void main(String[] args) {
        Scanner out = new Scanner(System.in);
        inputn = out.nextInt(); // y
        inputm = out.nextInt(); // x
        int k = out.nextInt();

        boolean[][] array = new boolean[inputn][inputm];
        init(array);
        for (int i = 0; i < k; i++) {
            int d = out.nextInt();
            int c = out.nextInt();
            if (d == 1) {
                markColumn(array, c - 1);
            }
            if (d == 0) {
                markRow(array, c - 1);
            }
        }
        Set<String> visited = new HashSet<>();
        dfs(array, 0, 0, 0, visited);
        System.out.println(maxCnt);

    }

    private static void markRow(boolean[][] array, int row) {
        for (int i = 0; i < array[row].length; i++) {
            array[row][i] = false;
        }
    }

    private static void markColumn(boolean[][] array, int column) {
        for (int i = 0; i < array.length; i++) {
            array[i][column] = false;
        }
    }

    private static void init(boolean[][] array) {
        maxCnt = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = true;
            }
        }
    }

    private static void printArray(boolean[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == true) {

                    System.out.print(1 + ",");
                } else {

                    System.out.print(0 + ",");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int dfs(boolean[][] array, int startx, int starty, int chipCnt,
            Set<String> visited) {
        if (visited.contains(String.valueOf(startx) + "," + String.valueOf(starty))) {
            return chipCnt;
        } else {
            visited.add(String.valueOf(startx) + "," + String.valueOf(starty));
        }
        printArray(array);
        maxCnt = Math.max(maxCnt, chipCnt);
        if (startx >= inputm || starty >= inputn || startx < 0 || starty < 0) {
            return chipCnt;
        }
        if (array[starty][startx] == false) {
            return chipCnt;
        }
        if (startx < inputm && starty < inputn && array[starty][startx] == true) {
            // 横向向前
            if (startx + 1 < inputm && array[starty][startx + 1] == true) {
                array[starty][startx] = false;
                array[starty][startx + 1] = false;
                dfs(array, startx + 1, starty, chipCnt + 1, visited);
                array[starty][startx] = true;
                array[starty][startx + 1] = true;
            }
            // 横向向后
            if (startx - 1 >= 0 && array[starty][startx - 1] == true) {
                array[starty][startx] = false;
                array[starty][startx - 1] = false;
                dfs(array, startx - 1, starty, chipCnt + 1, visited);

                array[starty][startx] = true;
                array[starty][startx - 1] = true;
            }
            // 纵向向上
            if (starty + 1 < inputn && array[starty + 1][startx] == true) {
                array[starty][startx] = false;
                array[starty + 1][startx] = false;
                dfs(array, startx, starty + 1, chipCnt + 1, visited);
                array[starty][startx] = true;
                array[starty + 1][startx] = true;
            }
            // 纵向向下
            if (starty - 1 >= 0 && array[starty - 1][startx] == true) {
                array[starty][startx] = false;
                array[starty - 1][startx] = false;
                dfs(array, startx, starty - 1, chipCnt + 1, visited);
                array[starty][startx] = true;
                array[starty - 1][startx] = true;
            }
        }

        dfs(array, startx + 1, starty, chipCnt, visited);
        dfs(array, startx, starty + 1, chipCnt, visited);
        dfs(array, startx - 1, starty, chipCnt, visited);
        dfs(array, startx, starty - 1, chipCnt, visited);
        return  chipCnt;
    }
}
