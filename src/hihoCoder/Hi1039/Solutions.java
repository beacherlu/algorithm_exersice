package hihoCoder.Hi1039;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by luyan on 17/3/19.
 */
public class Solutions {

    public static void main(String[] args) {
        //        Scanner sc = new Scanner(System.in);
        //        int testTimes = sc.nextInt();
        int testTimes = 1;

        for (int i = 0; i < testTimes; i++) {
            //            String s = sc.nextLine();
            String s = "ABCBCCCAA";
            int res = 0;
            for (int j = 0; j < s.length() + 1; j++) {
                String modifyStr = getModifyStr(s, j, 'A');
                res = Math.max(res, xiaoxiaoHappy(modifyStr));
                System.out.println("modifyStr:" + modifyStr + " " + res);
                modifyStr = getModifyStr(s, j, 'B');
                res = Math.max(res, xiaoxiaoHappy(modifyStr));
                System.out.println("modifyStr:" + modifyStr + " " + res);
                modifyStr = getModifyStr(s, j, 'C');
                res = Math.max(res, xiaoxiaoHappy(modifyStr));
                System.out.println("modifyStr:" + modifyStr + " " + res);
                System.out.println("result:" + s + ":" + res);
            }
        }

    }

    private static String getModifyStr(String s, int index, char c) {
        return s.substring(0, index) + c + s.substring(index, s.length());
    }

    private static int xiaoxiaoHappy(String input) {
        Queue<Character> charsQueue = new LinkedList<Character>();
        for (char c : input.toCharArray()) {
            charsQueue.offer(c);
        }
        int maxRemoveNum = 0;
        maxRemoveNum = Math.max(maxRemoveNum, FIFO(charsQueue));
        return maxRemoveNum;

    }

    private static int FIFO(Queue<Character> charsQueue) {
        if (charsQueue.size() < 0) {
            return 0;
        }
        Queue<Character> nextCharsQueue = new LinkedList<Character>();
        int charQueueSize = charsQueue.size();
        Character first = charsQueue.poll();
        int removeNums = 0;
        while (!charsQueue.isEmpty()) {
            if (first.equals(charsQueue.peek())) {
                removeNums = 1;
                while (first.equals(charsQueue.peek())) {
                    charsQueue.poll();
                    removeNums++;
                }
                first = charsQueue.poll();
            } else {
                nextCharsQueue.add(first);
                first = charsQueue.poll();
            }
        }
        if (first != null) {
            nextCharsQueue.add(first);
        }
        int nextCharsQueueSize = nextCharsQueue.size();
        if (nextCharsQueueSize == charQueueSize) {
            return 0;
        } else {
            return removeNums + FIFO(nextCharsQueue);
        }

    }
}
