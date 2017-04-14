package hihoCoder.OfferWeekTest.TEST20170319.Solution2;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by luyan on 17/3/19.
 */
public class Main {

    private static final long NUM = 1000000007L;

    private static long res = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int maxLength = sc.nextInt();
        Stack<Character> stack = new Stack<>();
        boolean isHasA = false;
        boolean isLastL = false;
        int delayTimes = 0;
        dfs(stack, maxLength, isHasA, delayTimes, isLastL);
        res = res % NUM;
        System.out.println(res);

    }

    private static boolean checkContinue3L(Stack<Character> stack) {
        if (stack.size() < 3) {
            return false;
        }
        Character first = stack.pop();
        Character second = stack.pop();
        Character third = stack.pop();
        boolean re = false;
        if (first.equals('L') && second.equals('L') && third.equals('L')) {
            re = true;
        }
        stack.push(third);
        stack.push(second);
        stack.push(first);
        return re;

    }

    private static void dfs(Stack<Character> stack, int maxLength, boolean isHasA, int delayTimes,
            boolean isLastL) {
        if (stack.size() == maxLength) {
            String record = "";
            Stack<Character> stack1 = (Stack<Character>) stack.clone();
            while (!stack1.isEmpty()) {
                record += stack1.pop();
            }

            res += getSuccess(record);
        } else if (stack.size() < maxLength) {
            if (!isHasA) {
                isHasA = true;
                stack.add('A');
                dfs(stack, maxLength, isHasA, delayTimes, isLastL);
                stack.pop();
                isHasA = false;
            }

            if (!checkContinue3L(stack)) {
                stack.add('L');
                dfs(stack, maxLength, isHasA, delayTimes, isLastL);
                stack.pop();
            }

            stack.add('O');
            dfs(stack, maxLength, isHasA, delayTimes, isLastL);
            stack.pop();
        }

    }

    private static int getSuccess(String record) {
        int absent = 0;
        int delay3TimesContinue = 0;
        for (int j = 0; j < record.length(); j++) {
            if (record.charAt(j) == 'A') {
                absent++;
            }
            if (record.charAt(j) == 'L' && j + 1 < record.length() && record.charAt(j + 1) == 'L'
                    && j + 2 < record.length() && record.charAt(j + 2) == 'L') {
                delay3TimesContinue++;
            }
        }

        if (absent <= 1 && delay3TimesContinue == 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
