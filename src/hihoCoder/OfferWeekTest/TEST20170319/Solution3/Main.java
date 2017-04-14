package hihoCoder.OfferWeekTest.TEST20170319.Solution3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by luyan on 17/3/19.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testTimes = sc.nextInt();
        for (int i = 0; i < testTimes; i++) {
            int numCount = sc.nextInt();
            int lastNSmall = sc.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < numCount; j++) {
                list.add(sc.nextInt());
            }
            System.out.println(getResult(list, lastNSmall));
        }
    }

    private static int getResult(ArrayList<Integer> list, int lastNSmall) {
        ArrayList<Integer> valueList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            ArrayList<Integer> extractList = new ArrayList<>();
            for (int j = i; j < list.size(); j++) {
                extractList.add(list.get(j));
                valueList.add(getValue(extractList));
            }
        }

        Collections.sort(valueList);
        return valueList.get(lastNSmall - 1);

    }

    private static int getFactor(int n) {
        if (n % 2 == 0) {
            return (n / 2) * (n - 1);
        } else {
            return (n - 1) / 2 * n;
        }
    }

    private static int getValue(ArrayList<Integer> extractList) {
        if (extractList.size() <= 1) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < extractList.size(); i++) {
            if (map.containsKey(extractList.get(i))) {
                map.put(extractList.get(i), map.get(extractList.get(i)) + 1);
            } else {
                map.put(extractList.get(i), 1);
            }
        }
        int value = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                value += getFactor(entry.getValue());
            }
        }
        return value;

    }
}
