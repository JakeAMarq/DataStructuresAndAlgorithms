package ctci.chapter2;

public class ListNode {
    int data;
    ListNode next;

    public static void main(String... theArgs) {
        ListNode test = new ListNode(0);
        ListNode current = test;
        for (int i = 1; i <= 5; i++) {
            current.next = new ListNode(i);
            current = current.next;
        }
        
        System.out.println(test);
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