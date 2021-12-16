package linkedList;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
  public ListNode reverseBetween(ListNode head, int m, int n) {
    if (m == n)
      return head;

    // after skipping 'm-1' nodes, current will point to 'm'th node
    ListNode current = head, previous = null;
    for (int i = 0; current != null && i < m - 1; ++i) {
      previous = current;
      current = current.next;
    }

    // we are interested in three parts of the LinkedList, part before index 'm',
    // part between 'm' and
    // 'n', and the part after index 'n'
    ListNode lastNodeOfFirstPart = previous; // points to the node at index 'm-1'
    // after reversing the LinkedList 'current' will become the last node of the
    // sub-list
    ListNode lastNodeOfSubList = current;
    ListNode next = null; // will be used to temporarily store the next node
    // reverse nodes between 'm' and 'n'
    for (int i = 0; current != null && i < n - m + 1; i++) {
      next = current.next;
      current.next = previous;
      previous = current;
      current = next;
    }

    // connect with the first part
    if (lastNodeOfFirstPart != null)
      lastNodeOfFirstPart.next = previous; // 'previous' is now the first node of the sub-list
    else // this means m == 1 i.e., we are changing the first node (head) of the
         // LinkedList
      head = previous;

    // connect with the last part
    lastNodeOfSubList.next = current;

    return head;

  }
}