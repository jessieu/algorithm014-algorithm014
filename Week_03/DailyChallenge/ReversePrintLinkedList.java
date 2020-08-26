class Solution {
    public int[] reversePrint(ListNode head) {
        // calculate how many nodes in the linked list
        ListNode current = head;
        int num = 0;
        while (current != null) {
            num++;
            current = current.next;
        }

        int[] result = new int[num];
        current = head;
        for (int i = num - 1; i >= 0; i--) {
            result[i] = current.val;
            current = current.next;
        }
        return result;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//class Solution {
//    public int[] reversePrint(ListNode head) {
//        LinkedList<ListNode> stack = new LinkedList();
//
//        while (head != null) {
//            stack.add(head);
//            head = head.next;
//        }
//        int[] result = new int[stack.size()];
//        for (int i = 0; i < result.length; i++) {
//            result[i] = stack.pollLast().val;
//        }
//
//        return result;
//    }
//}
