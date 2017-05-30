package jisuanke.firstMain.t1;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by luyan on 17/5/28.
 */
public class TestTowVersionCode {

    public static void main(String[] args) {
        System.out.println("hello world!");

        int m = 0;
        int n = 0;
        //n,m(3≤n,m≤9)

        int testTimes = 1000;
        Point[] points = { new Point(0, 6), new Point(3, 6), new Point(6, 6), new Point(1, 5),
                new Point(3, 5), new Point(5, 5), new Point(2, 4), new Point(3, 4), new Point(4, 4),
                new Point(0, 3), new Point(1, 3), new Point(2, 3), new Point(4, 3), new Point(5, 3),
                new Point(6, 3), new Point(2, 2), new Point(3, 2), new Point(4, 2), new Point(1, 1),
                new Point(3, 1), new Point(5, 1), new Point(0, 0), new Point(3, 0),
                new Point(6, 0) };
        for (int i = 0; i < testTimes; i++) {
            Set<Integer> isChoosed = new HashSet<>();
            Random random = new Random();
            m = random.nextInt(7) + 3;
            n = random.nextInt(7) + 3;
            int[][] array = new int[7][7];

            while (isChoosed.size() != m) {
                Random randomM = new Random();
                int chooseIndex = randomM.nextInt(24);
                if (!isChoosed.contains(chooseIndex)) {
                    isChoosed.add(chooseIndex);
                    array[points[chooseIndex].x][points[chooseIndex].y] = 2;
                }
            }
            while (isChoosed.size() != m + n) {
                Random randomM = new Random();
                int chooseIndex = randomM.nextInt(24);
                if (!isChoosed.contains(chooseIndex)) {
                    isChoosed.add(chooseIndex);
                    array[points[chooseIndex].x][points[chooseIndex].y] = 1;
                }
            }
            System.out.println(String.format("Test %d case n:%d m:%d", i, n, m));
            if (testV1(array) != testV2(array)) {
                System.out.println(
                        String.format("testV1:%d testV2:%d", testV1(array), testV2(array)));
                printArray(array);
            }

        }

    }

    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + ",");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int testV2(int[][] array) {
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
        return xiaohong;
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

    public static class Point {

        public int x;
        public int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
