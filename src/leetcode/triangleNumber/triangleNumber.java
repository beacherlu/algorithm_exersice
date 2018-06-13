package leetcode.triangleNumber;

import static java.lang.Math.abs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by luyan on 17/8/22.
 */
public class triangleNumber {

    public static void main(String[] args) {
        int[] array = new int[] { 16, 24, 29, 6, 48, 24, 44, 27, 7, 6, 17, 51, 37, 19, 23, 0, 20,
                42, 49, 41, 46, 35, 24, 52, 47, 32, 1, 14, 30, 51, 30, 38, 2, 30, 14, 27, 4, 23, 10,
                11, 50, 52, 4, 41, 13, 54, 32, 6, 44, 48, 16, 26, 28, 51, 34, 24, 19, 31, 45, 40,
                44, 0, 25, 11, 20, 33, 37, 15, 43, 41, 20, 38, 54, 35, 43, 53, 13, 20, 6, 20, 0, 34,
                54, 54, 20, 20, 32, 3, 9, 9, 1, 54, 11, 24, 51, 42, 29, 41, 3, 48, 5, 11, 33, 40,
                52, 25, 4, 12, 18, 0, 2, 1, 23, 38, 3, 44, 34, 11, 29, 51, 40, 53, 5, 13, 51, 24, 4,
                0, 13, 9, 2, 52, 50, 43, 10, 8, 11, 36, 19, 5, 13, 19, 15, 47, 29, 24, 42, 34, 14,
                32, 46, 35, 23, 39, 2, 26, 3, 43, 9, 55, 32, 46, 6, 25, 24, 35, 15, 27, 47, 52, 54,
                37, 8, 4, 21, 26, 37, 24, 3, 51, 1, 42, 54, 28, 2, 52, 11, 3, 15, 6, 36, 13, 50, 15,
                4, 35, 35, 34, 23, 18, 30, 7, 8, 20, 51, 10, 14, 29, 17, 31, 20, 49, 10, 50, 37, 42,
                36, 38, 46, 47, 5, 1, 12, 42, 28, 31, 44, 6, 22, 28, 42, 9, 37, 20, 39, 3, 52, 1,
                39, 41, 27, 0, 39, 20, 18, 3, 19, 41, 20, 32, 54, 48, 28, 22, 33, 52, 51, 51, 33,
                27, 46, 11, 48, 37, 32, 35, 23, 3, 52, 33, 54, 15, 39, 40, 49, 3, 3, 16, 43, 1, 11,
                2, 53, 15, 53, 19, 48, 6, 28, 48, 13, 51, 11, 10, 49, 21, 31, 50, 18, 37, 41, 39,
                43, 29, 32, 34, 39, 18, 24, 54, 15, 47, 18, 11, 23, 36, 26, 24, 29, 36, 9, 51, 35,
                20, 32, 33, 46, 3, 10, 37, 18, 25, 22, 36, 27, 22, 3, 40, 49, 1, 16, 26, 5, 26, 51,
                33, 5, 1, 28, 40, 18, 17, 40, 27, 41, 12, 36, 54, 47, 19, 40, 22, 0, 49, 29, 47, 13,
                29, 37, 34, 55, 49, 41, 50, 42, 49, 13, 42, 42, 6, 54, 25, 4, 12, 26, 26, 19, 24, 8,
                13, 10, 16, 46, 53, 13, 37, 11, 31, 3, 26, 13, 47, 18, 10, 18, 39, 29, 46, 34, 10,
                12, 47, 15, 35, 6, 5, 0, 51, 42, 55, 30, 7, 37, 24, 55, 20, 0, 5, 13, 42, 48, 33,
                49, 28, 45, 16, 27, 20, 33, 4, 19, 48, 18, 48, 30, 30, 22, 55, 31, 32, 8, 41, 47, 3,
                26, 48, 36, 19, 33, 23, 11, 12, 10, 6, 45, 41, 30, 34, 21, 41, 21, 27, 23, 18, 24,
                43, 52, 49, 25, 30, 52, 10, 3, 1, 46, 27, 33, 16, 8, 15, 38, 55, 32, 45, 41, 50, 28,
                36, 4, 36, 49, 7, 3, 29, 52, 1, 8, 33, 48, 45, 49, 6, 32, 6, 18, 50, 5, 15, 30, 47,
                42, 47, 45, 26, 41, 40, 25, 14, 25, 8, 12, 32, 6, 32, 43, 6, 43, 26, 51, 39, 32, 5,
                29, 40, 25, 12, 32, 10, 51, 8, 23, 9, 4, 11, 8, 30, 38, 46, 12, 1, 32, 51, 22, 50,
                31, 50, 46, 52, 33, 45, 33, 37, 34, 53, 3, 7, 24, 28, 32, 36, 42, 30, 13, 34, 6, 24,
                21, 16, 37, 27, 30, 31, 18, 48, 14, 4, 8, 53, 6, 26, 23, 28, 40, 14, 18, 0, 9, 8,
                44, 13, 46, 8, 22, 48, 26, 4, 54, 9, 17, 34, 42, 24, 11, 7, 40, 40, 2, 12, 40, 1,
                10, 48, 13, 47, 5, 30, 5, 2, 24, 16, 24, 51, 52, 45, 24, 47, 50, 53, 41, 52, 10, 16,
                26, 54, 45, 4, 5, 1, 5, 12, 36, 18, 11, 29, 39, 51, 25, 47, 28, 2, 50, 3, 37, 10,
                29, 43, 46, 40, 1, 54, 44, 38, 21, 34, 4, 43, 4, 30, 50, 4, 51, 13, 24, 14, 10, 32,
                45, 34, 43, 14, 50, 3, 42, 43, 30, 30, 51, 24, 8, 11, 33, 8, 22, 43, 52, 51, 9, 25,
                19, 49, 2, 32, 44, 52, 50, 29, 35, 33, 29, 55, 45, 35, 42, 24, 14, 55, 43, 16, 30,
                32, 40, 19, 47, 7, 11, 36, 15, 9, 49, 20, 31, 16, 6, 17, 21, 31, 47, 39, 46, 54, 35,
                46, 52, 50, 27, 55, 6, 0, 32, 8, 0, 47, 32, 51, 55, 24, 52, 27, 25, 42, 5, 51, 40,
                29, 10, 41, 6, 51, 43, 12, 32, 4, 14, 1, 36, 20, 11, 30, 50, 31, 26, 3, 14, 25, 15,
                40, 3, 7, 23, 4, 42, 19, 38, 7, 0, 32, 18, 43, 40, 21, 35, 8, 47, 31, 32, 9, 33, 2,
                7, 19, 53, 9, 9, 42, 49, 12, 33, 25, 51, 32, 54, 15, 6, 16, 12, 42, 12, 25, 48, 37,
                17, 24, 54, 43, 54, 8, 11, 43, 2, 54, 8, 13, 45, 36, 50, 52, 29, 21, 23, 8, 38, 48,
                36, 44, 5, 2, 50, 32, 25, 26, 43, 25, 52, 53, 16, 41, 26, 34, 23, 52, 48, 55, 14,
                12, 8, 27, 31, 53, 10, 17, 28, 35, 33, 12, 29, 44, 25, 39, 35, 49, 40, 18, 49, 9,
                46, 42, 3, 38, 37, 44, 36, 34, 23, 11, 27, 37, 54, 24, 29, 35, 20, 36, 29, 28, 40,
                4, 11, 13, 51, 41, 5, 51, 35, 12, 19, 24, 15, 22, 14, 30, 36, 33, 38, 6, 27, 1, 40,
                13, 44, 40, 47, 44, 2, 16, 48, 33, 38, 35, 28, 5, 22, 11, 27, 49, 2, 22, 50, 30, 2,
                40, 40, 54, 48, 23, 4, 22, 35, 4, 55, 5, 10, 33, 0, 48, 55, 10, 17, 29, 55, 33 };

        //        System.out.println(triangleNumberI(array));
        //        System.out.println(triangleNumber(array));
        array = new int[] { 1, 1, 2, 2, 3, 3, 4, 4 };
        System.out.println(triangleNumberI(array));
        System.out.println(triangleNumber(array));

    }

    private static boolean isValid(int a, int b, int c) {
        if (a + b > c && a + c > b && b + c > a && abs(a - b) < c && abs(a - c) < b
                && abs(b - c) < a) {
            return true;
        }
        return false;
    }

    public static int triangleNumberI(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.<Integer> toList());
        list.removeIf(s -> s == 0);
        Collections.sort(list);
        int res = 0;
        for (int a = 0; a < list.size(); a++) {
            for (int b = a + 1; b < list.size(); b++) {
                for (int c = b + 1; c < list.size(); c++) {
                    if (isValid(list.get(a), list.get(b), list.get(c))) {
                        res++;
                        System.out.println(list.get(a) + " " + list.get(b) + " " + list.get(c));
                    } else if (list.get(a) + list.get(b) <= list.get(c)) {
                        break;
                    }
                }
            }

        }
        return res;
    }

    public static int triangleNumber(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.<Integer> toList());
        list.removeIf(s -> s == 0);
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> distinct = new ArrayList<>();
        list.stream().forEach(e -> {
            if (map.containsKey(e)) {
                map.put(e, map.get(e) + 1);
            } else {
                map.put(e, 1);
                distinct.add(e);
            }
        });
        Collections.sort(distinct);
        int res = 0;
        System.out.println("distinct list:" + distinct);
        System.out.println("map:" + map);
        for (int a = 0; a < distinct.size(); a++) {
            for (int b = a + 1; b < distinct.size(); b++) {
                for (int c = b + 1; c < distinct.size(); c++) {
                    if (isValid(distinct.get(a), distinct.get(b), distinct.get(c))) {
                        res += map.get(distinct.get(a)) * map.get(distinct.get(b))
                                * map.get(distinct.get(c));
                        System.out.println("distinct " + distinct.get(a) + " " + distinct.get(b)
                                + " " + distinct.get(c) + ":" + map.get(distinct.get(a))
                                        * map.get(distinct.get(b)) * map.get(distinct.get(c)));
                    }

                    if (map.get(distinct.get(a)) >= 2
                            && isValid(distinct.get(a), distinct.get(b), distinct.get(a))) {
                        res += map.get(distinct.get(a)) * (map.get(distinct.get(a)) - 1) / 2
                                * map.get(distinct.get(b));
                        System.out
                                .println(
                                        "a a b :"
                                                + distinct
                                                        .get(a)
                                                + " " + distinct.get(a) + " " + distinct.get(b)
                                                + ":"
                                                + map.get(distinct.get(a))
                                                        * (map.get(distinct.get(a)) - 1) / 2
                                                        * map.get(distinct.get(b)));
                    }
                    if (map.get(distinct.get(a)) >= 2
                            && isValid(distinct.get(a), distinct.get(c), distinct.get(a))) {
                        res += map.get(distinct.get(a)) * (map.get(distinct.get(a)) - 1) / 2
                                * map.get(distinct.get(c));
                        System.out
                                .println(
                                        "a a c :"
                                                + distinct
                                                        .get(a)
                                                + " " + distinct.get(a) + " " + distinct.get(c)
                                                + ":"
                                                + map.get(distinct.get(a))
                                                        * (map.get(distinct.get(a)) - 1) / 2
                                                        * map.get(distinct.get(c)));
                    }

                    //
                    if (map.get(distinct.get(b)) >= 2
                            && isValid(distinct.get(b), distinct.get(b), distinct.get(a))) {
                        res += map.get(distinct.get(b)) * (map.get(distinct.get(b)) - 1) / 2
                                * map.get(distinct.get(a));
                        System.out.println(distinct.get(b) + " " + distinct.get(b) + " "
                                + distinct.get(a) + ":"
                                + map.get(distinct.get(b)) * (map.get(distinct.get(b)) - 1) / 2
                                        * map.get(distinct.get(a)));
                    }
                    if (map.get(distinct.get(b)) >= 2
                            && isValid(distinct.get(b), distinct.get(b), distinct.get(c))) {
                        res += map.get(distinct.get(b)) * (map.get(distinct.get(b)) - 1) / 2
                                * map.get(distinct.get(c));
                        System.out.println(distinct.get(b) + " " + distinct.get(b) + " "
                                + distinct.get(c) + ":"
                                + map.get(distinct.get(b)) * (map.get(distinct.get(b)) - 1) / 2
                                        * map.get(distinct.get(c)));
                    }
                    //
                    //
                    if (map.get(distinct.get(c)) >= 2
                            && isValid(distinct.get(c), distinct.get(c), distinct.get(a))) {
                        res += map.get(distinct.get(c)) * (map.get(distinct.get(c)) - 1) / 2
                                * map.get(distinct.get(a));
                        System.out.println(distinct.get(c) + " " + distinct.get(c) + " "
                                + distinct.get(a) + ":"
                                + map.get(distinct.get(c)) * (map.get(distinct.get(c)) - 1) / 2
                                        * map.get(distinct.get(a)));
                    }
                    if (map.get(distinct.get(c)) >= 2
                            && isValid(distinct.get(c), distinct.get(c), distinct.get(b))) {
                        res += map.get(distinct.get(c)) * (map.get(distinct.get(c)) - 1) / 2
                                * map.get(distinct.get(b));
                        System.out.println(distinct.get(c) + " " + distinct.get(c) + " "
                                + distinct.get(b) + ":"
                                + map.get(distinct.get(c)) * (map.get(distinct.get(c)) - 1) / 2
                                        * map.get(distinct.get(b)));
                    }

                    // System.out.println(list.get(a) + " " + list.get(b) + " " + list.get(c));
                    if (distinct.get(a) + distinct.get(b) <= distinct.get(c)) {
                        break;
                    }
                }
            }

        }
        Integer[] integers = new Integer[] { 0 };
        integers[0] = res;
        map.keySet().stream().forEach(e -> {
            if (map.get(e) >= 3) {
                integers[0] += get(3, map.get(e));
            }
        });
        return integers[0];
    }

    private static int get(int m, int n) {
        // return C m ,n
        long t1 = 1L;
        for (int i = n - 2; i <= n; i++) {
            t1 *= i;
        }
        return (int) (t1 / 6);
    }

    public int triangleNumberII(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] > nums[k] && nums[i] + nums[k] > nums[j]
                            && nums[j] + nums[k] > nums[i])
                        count++;
                }
            }
        }
        return count;
    }
}
