package leetcode.MagicSquaresInGrid;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by luyan on 18/5/27.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println(numMagicSquaresInside(
                new int[][] { { 4, 3, 8, 4 }, { 9, 5, 1, 9 }, { 2, 7, 6, 2 } }));
        System.out.println(
                numMagicSquaresInside(new int[][] { { 10, 3, 5 }, { 1, 6, 11 }, { 7, 9, 2 } }));
    }

    public static int numMagicSquaresInside(int[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[i].length - 2; j++) {
                if (subNumMagicSquaresInside(grid, i, j)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static boolean subNumMagicSquaresInside(int[][] grid, int i, int j) {
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> isllegalNum = new HashSet<Integer>();
        for (int k = i; k < i + 3; k++) {
            int sum = 0;
            for (int l = j; l < j + 3; l++) {
                sum += grid[k][l];
                isllegalNum.add(grid[k][l]);
            }
            set.add(sum);
        }
        for (int k = j; k < j + 3; k++) {
            int sum = 0;
            for (int l = i; l < i + 3; l++) {
                sum += grid[l][k];
            }
            set.add(sum);
        }
        set.add(grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2]);
        set.add(grid[i + 2][j] + grid[i + 1][j + 1] + grid[i][j + 2]);
        for (int k = 1; k < isllegalNum.size() + 1; k++) {
            if (!isllegalNum.contains(k)) {
                return false;
            }
        }

        return set.size() == 1 ? true : false;
    }
}
