package ctci.chapter2;

public class ListNode {
    int data;
    ListNode next;

    public static void main(String... theArgs) {
        ListNode test = ListNode.listFrom(new int[]{1, 4, 2, 5 ,3, 6});
        System.out.println(test);
        System.out.println(mergeSort(test));
    }

    public static ListNode listFrom(int[] list) {
        if (list.length == 0 || list == null) throw new IllegalArgumentException();
        ListNode result = new ListNode(list[0]);
        ListNode current = result;
        for (int i = 1; i < list.length; i++) {
            current.next = new ListNode(list[i]);
            current = current.next;
        }
        return result;
    }

    public static ListNode mergeSort(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode middle = getMiddleNode(head);
        ListNode nextAfterMiddle = middle.next;
        middle.next = null;
        
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(nextAfterMiddle);

        return mergeSortedLinkedLists(left, right);
    }

    private static ListNode mergeSortedLinkedLists(ListNode left, ListNode right) {
        if (left == null) return right;
        if (right == null) return left; 
        ListNode result, current;
        if (left.data <= right.data) {
            result = new ListNode(left.data);
            left = left.next;
        } else {
            result = new ListNode(right.data);
            right = right.next;
        }
        current = result;
        while (left != null && right != null) {
            if (left.data >= right.data) {
                current.next = new ListNode(right.data);
                right = right.next;
            } else {
                current.next = new ListNode(left.data);
                left = left.next;
            }
            current = current.next;
        }
        if (left == null) current.next = right;
        if (right == null) current.next = left;
        return result;
    }

    private static ListNode getMiddleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode(int data) {
        this.data = data;
    }

    public ListNode(int data, ListNode next) {
        this(data);
        this.next = next;
    }

    public String toString() {
        StringBuilder result = new StringBuilder("{");
        ListNode current = this;
        while (true) {
            result.append(current.data);
            if (current.next != null) result.append(", ");
            else break;
            current = current.next;
        }
        result.append("}");
        return result.toString();
    }
}