package ctci.chapter2;

import java.util.Arrays;
import java.util.HashSet;

public class Problem2_1 {
    public static void main(String[] theArgs) {
        int[][] testCases = new int[][]{
            {1, 2, 3},
            {1, 2, 1},
            {1, 1, 1},
            {1, 1, 2, 2},
            {1, 2, 1, 2}
        };
        for (int[] list : testCases) {
            System.out.println("Input: " + Arrays.toString(list));
            ListNode test = ListNode.listFrom(list);
            removeDuplicates(test);
            System.out.println("Output: " + test);
        }
    }

    //Insert problem function(s) here
    public static void removeDuplicates(ListNode head) {
        // With buffer
        HashSet<Integer> buffer = new HashSet<>();
        ListNode prev = head, current = head.next;
        buffer.add(prev.data);
        while (current != null) {
            if (buffer.contains(current.data)) {
                prev.next = current.next;
            } else {
                buffer.add(current.data);
                prev = current;
            } 
            current = current.next;
        }

        // Without buffer
        
    }
}