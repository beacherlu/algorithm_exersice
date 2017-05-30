package jisuanke.firstMain.t1;

import java.util.Scanner;

/**
 * Created by luyan on 17/5/28.
 */
public class Main {

    public static void main(String[] args) {
        Scanner out = new Scanner(System.in);
        int n = out.nextInt();
        int m = out.nextInt();
        int[][] array = new int[7][7];
        for (int i = 0; i < n; i++) {
            int x = out.nextInt();
            int y = out.nextInt();
            x += 3;
            y += 3;
            array[x][y] = 1;
        }
        for (int i = 0; i < m; i++) {
            int x = out.nextInt();
            int y = out.nextInt();
            x += 3;
            y += 3;
            array[x][y] = 2;
        }
        int xiaohong = 0;
        for (int x = 0; x < 7 && x != 3; x++) {
            int column = 0;
            for (int y = 0; y < 7; y++) {
                if (array[x][y] != 0) {
                    if (array[x][y] == 1) {
                        column++;
                    }
                }
            }
            if (column == 3) {
                xiaohong++;
            }
        }
        {
            int column = 0;
            for (int y = 0; y < 3; y++) {
                if (array[3][y] == 1) {
                    column++;
                }
            }
            if (column == 3) {
                xiaohong++;
            }
        }
        {
            int column = 0;
            for (int y = 4; y < 7; y++) {
                if (array[3][y] == 1) {
                    column++;
                }
            }
            if (column == 3) {
                xiaohong++;
            }
        }

        for (int y = 0; y < 7 && y != 3; y++) {
            int row = 0;
            for (int x = 0; x < 7; x++) {
                if (array[x][y] != 0) {
                    if (array[x][y] == 1) {
                        row++;
                    }
                }
            }
            if (row == 3) {
                xiaohong++;
            }
        }
        {
            int row = 0;
            for (int x = 0; x < 3; x++) {
                if (array[x][3] == 1) {
                    row++;
                }
            }
            if (row == 3) {
                xiaohong++;
            }
        }
        {
            int row = 0;
            for (int x = 4; x < 7; x++) {
                if (array[x][3] == 1) {
                    row++;
                }
            }
            if (row == 3) {
                xiaohong++;
            }
        }
        System.out.println(xiaohong);

    }

    public static int testV1(int[][] array) {
        int xiaohong = 0;
        for (int x = 0; x < 7; x++) {
            if(x== 3)continue;
            int column = 0;
            for (int y = 0; y < 7; y++) {
                if (array[x][y] != 0) {
                    if (array[x][y] == 1) {
                        column++;
                    }
                }
            }
            if (column == 3) {
                xiaohong++;
            }
        }
        {
            int column = 0;
            for (int y = 0; y < 3; y++) {
                if (array[3][y] == 1) {
                    column++;
                }
            }
            if (column == 3) {
                xiaohong++;
            }
        }
        {
            int column = 0;
            for (int y = 4; y < 7; y++) {
                if (array[3][y] == 1) {
                    column++;
                }
            }
            if (column == 3) {
                xiaohong++;
            }
        }

        for (int y = 0; y < 7 ; y++) {
            if(y== 3)continue;
            int row = 0;
            for (int x = 0; x < 7; x++) {
                if (array[x][y] != 0) {
                    if (array[x][y] == 1) {
                        row++;
                    }
                }
            }
            if (row == 3) {
                xiaohong++;
            }
        }
        {
            int row = 0;
            for (int x = 0; x < 3; x++) {
                if (array[x][3] == 1) {
                    row++;
                }
            }
            if (row == 3) {
                xiaohong++;
            }
        }
        {
            int row = 0;
            for (int x = 4; x < 7; x++) {
                if (array[x][3] == 1) {
                    row++;
                }
            }
            if (row == 3) {
                xiaohong++;
            }
        }

        return xiaohong;
    }
}
