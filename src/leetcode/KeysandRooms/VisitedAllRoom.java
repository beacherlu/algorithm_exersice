package leetcode.KeysandRooms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by luyan on 18/5/27.
 */
public class VisitedAllRoom {

    private Set<Integer> visitedRoom = new HashSet<>();

    public static void main(String[] args) {
        List<List<Integer>> chains = new ArrayList<>();
        List<Integer> list0 = new ArrayList();
        list0.add(1);
        list0.add(3);
        chains.add(list0);
        List<Integer> list1 = new ArrayList();
        list1.add(1);
        list1.add(3);
        list1.add(0);
        chains.add(list1);
        List<Integer> list2 = new ArrayList();
        list2.add(2);
        chains.add(list2);
        List<Integer> list3 = new ArrayList();
        list3.add(0);
        chains.add(list3);
        VisitedAllRoom visitedAllRoom = new VisitedAllRoom();
        System.out.println(visitedAllRoom.canVisitAllRooms(chains));
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visitedRoom.add(0);
        for (int i = 0; i < rooms.get(0).size(); i++) {
            visit(rooms.get(0).get(i), rooms);
        }
        return visitedRoom.size() == rooms.size() ? true : false;
    }
    //    Input: [[1,3],[3,0,1],[2],[0]]
    //    Output: false
    //    Explanation: We can't enter the room with number 2.

    private void visit(int roomIndex, List<List<Integer>> rooms) {
        List<Integer> chains = rooms.get(roomIndex);
        if (!visitedRoom.contains(roomIndex)) {
            visitedRoom.add(roomIndex);
            for (int i = 0; i < chains.size(); i++) {
                visit(chains.get(i), rooms);
            }
        }
    }
}
