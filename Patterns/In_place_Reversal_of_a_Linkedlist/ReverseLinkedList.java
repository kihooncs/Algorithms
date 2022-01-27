package Patterns.In_place_Reversal_of_a_Linkedlist;

public class ReverseLinkedList {
    public static ListNode reverseBF(ListNode head) {
        // TODO: Write your code here
        return head;
    }

    public static ListNode reverse(ListNode head) {
        // TODO: Write your code here
        return head;
    }

    public static void main(String[] args) {
        bruteForce();
        //solution();
    }

    public static void bruteForce() {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);

        ListNode result = ReverseLinkedList.reverseBF(head);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }

    public static void solution() {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);

        ListNode result = ReverseLinkedList.reverse(head);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
