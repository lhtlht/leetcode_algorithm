package medium;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Solution251 {
    private Deque<Integer> arr = new LinkedList<Integer>();
    public Solution251(int[][] v) {
        for (int[] row : v) {
            for (int col : row) {
                this.arr.add(col);
            }
        }
    }

    public int next() {
        Integer poll = arr.poll();
        System.err.println(poll);
        return poll;
    }

    public boolean hasNext() {
        boolean hasNext = !arr.isEmpty();
        System.err.println(hasNext);
        return hasNext;
    }

    public static void main(String[] args) {
        Solution251 iterator = new Solution251(new int[][] {{1,2},{3},{4}});
        iterator.next(); // 返回 1
        iterator.next(); // 返回 2
        iterator.next(); // 返回 3
        iterator.hasNext(); // 返回 true
        iterator.hasNext(); // 返回 true
        iterator.next(); // 返回 4
        iterator.hasNext(); // 返回 false

    }
}
