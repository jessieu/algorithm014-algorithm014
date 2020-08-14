class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                current.next = l2;

                l2 = l2.next;
            } else {
                current.next = l1;
                l1 = l1.next;
            }

            current = current.next;

        }

        current.next = (l1 == null) ? l2 : l1;

        return dummy.next;
    }
}

/**
 * Resive Solution:
 * {
 *  list1[0]+mergeTwoLists(list1[1:],list2) | list1[0]<list2[0]
 *  list2[0]+mergeTwoLists(list1,list2[1:]) | otherwise
 * ​	}
 */

//class Solution {
//
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if (l1 == null) return l2;
//        else if (l2 == null) return l1;
//
//        else if (l1.val < l2.val) {
//            l1.next = mergeTwoLists(l1.next, l2);
//            return l1;
//        } else {
//            l2.next = mergeTwoLists(l1, l2.next);
//            return l2;
//        }
//    }
//}
