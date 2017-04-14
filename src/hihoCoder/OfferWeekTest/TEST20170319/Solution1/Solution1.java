package hihoCoder.OfferWeekTest.TEST20170319.Solution1;

import java.util.Scanner;

/**
 * Created by luyan on 17/3/19.
 */
public class Solution1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testTimes = sc.nextInt();
        String record = sc.nextLine();
        for (int i = 0; i < testTimes; i++) {
            record = sc.nextLine();
            int absent = 0;
            int delay3TimesContinue = 0;
            for (int j = 0; j < record.length(); j++) {
                if (record.charAt(j) == 'A') {
                    absent++;
                }
                if (record.charAt(j) == 'L' && j + 1 < record.length()
                        && record.charAt(j + 1) == 'L' && j + 2 < record.length()
                        && record.charAt(j + 2) == 'L') {
                    delay3TimesContinue++;
                }
            }

            if (absent <= 1 && delay3TimesContinue == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
