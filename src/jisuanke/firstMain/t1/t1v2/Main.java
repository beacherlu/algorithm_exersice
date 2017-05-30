package jisuanke.firstMain.t1.t1v2;

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
        Point[][] points = { { new Point(0, 6), new Point(3, 6), new Point(6, 6) },
                { new Point(1, 5), new Point(3, 5), new Point(5, 5) },
                { new Point(2, 4), new Point(3, 4), new Point(4, 4) },
                { new Point(0, 3), new Point(1, 3), new Point(2, 3) },
                { new Point(4, 3), new Point(5, 3), new Point(6, 3) },
                { new Point(2, 2), new Point(3, 2), new Point(4, 2) },
                { new Point(1, 1), new Point(3, 1), new Point(5, 1) },
                { new Point(0, 0), new Point(3, 0), new Point(6, 0) },

                { new Point(0, 6), new Point(0, 3), new Point(0, 0) },
                { new Point(1, 5), new Point(1, 3), new Point(1, 1) },
                { new Point(2, 4), new Point(2, 3), new Point(2, 2) },
                { new Point(3, 6), new Point(3, 5), new Point(3, 4) },
                { new Point(3, 2), new Point(3, 1), new Point(3, 0) },
                { new Point(4, 4), new Point(4, 3), new Point(4, 2) },
                { new Point(5, 5), new Point(5, 3), new Point(5, 1) },
                { new Point(6, 6), new Point(6, 3), new Point(6, 0) }, };

        int xiaohong = 0;
        for (int i = 0; i < points.length; i++) {
            int c = 0;
            for (int j = 0; j < points[i].length; j++) {
                if (array[points[i][j].x][points[i][j].y] == 1) {
                    c++;
                }
            }
            if (c == 3) {
                xiaohong++;
            }

        }
        System.out.println(xiaohong);

    }

    public static int testV2(int[][] array) {
        Point[][] points = {
                { new Point(0, 6), new Point(3, 6), new Point(6, 6) },
                { new Point(1, 5), new Point(3, 5), new Point(5, 5) },
                { new Point(2, 4), new Point(3, 4), new Point(4, 4) },
                { new Point(0, 3), new Point(1, 3), new Point(2, 3) },
                { new Point(4, 3), new Point(5, 3), new Point(6, 3) },
                { new Point(2, 2), new Point(3, 2), new Point(4, 2) },
                { new Point(1, 1), new Point(3, 1), new Point(5, 1) },
                { new Point(0, 0), new Point(3, 0), new Point(6, 0) },

                { new Point(0, 6), new Point(0, 3), new Point(0, 0) },
                { new Point(1, 5), new Point(1, 3), new Point(1, 1) },
                { new Point(2, 4), new Point(2, 3), new Point(2, 2) },
                { new Point(3, 6), new Point(3, 5), new Point(3, 4) },
                { new Point(3, 2), new Point(3, 1), new Point(3, 0) },
                { new Point(4, 4), new Point(4, 3), new Point(4, 2) },
                { new Point(5, 5), new Point(5, 3), new Point(5, 1) },
                { new Point(6, 6), new Point(6, 3), new Point(6, 0) }, };

        int xiaohong = 0;
        for (int i = 0; i < points.length; i++) {
            int c = 0;
            for (int j = 0; j < points[i].length; j++) {
                if (array[points[i][j].x][points[i][j].y] == 1) {
                    c++;
                }
            }
            if (c == 3) {
                xiaohong++;
            }

        }
        return xiaohong;
    }

    public static class Point {

        public int x;
        public int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
