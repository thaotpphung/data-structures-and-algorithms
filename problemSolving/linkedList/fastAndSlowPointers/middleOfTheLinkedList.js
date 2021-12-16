/*
EASY
Given the head of a Singly LinkedList, write a method to return the middle node of the LinkedList.

If the total number of nodes in the LinkedList is even, return the second middle node.

Example 1:

Input: 1 -> 2 -> 3 -> 4 -> 5 -> null
Output: 3

Example 2:

Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
Output: 4

Example 3:

Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> null
Output: 4

*/

class Node {
  constructor(value, next=null){
    this.value = value;
    this.next = next;
  }
}

const find_middle_of_linked_list = function(head) {
              // BRUTE FORCE
  // let pointer = head, len = 0;
  // while (pointer.next != null) {
  //   pointer = pointer.next;
  //   len += 1;
  // }
  // let midLen = 0;
  // if ((len % 2) === 0) {
  //   midLen = (len / 2) + 1;
  // } else {
  //   midLen = len/2;
  // }
  // let pointer2 = head, currLen = 0;
  // while (currLen !== midLen ) {
  //   pointer2 = pointer2.next;
  // }
  // return pointer2;

            // Fast and Slow pointers
  let fast = head, slow = head;
  // since fast move twice as fast as slow, by the time fast reaches the end, after N nodes (2N) 
  // slow would have moved N times, which is half the length of the linked list
  while (fast !== null && fast.next !== null) {
    slow = slow.next;
    fast = fast.next.next;
  }
  // after fast reaches null, then the slow is the middle node
  return slow;
}


head = new Node(1)
head.next = new Node(2)
head.next.next = new Node(3)
head.next.next.next = new Node(4)
head.next.next.next.next = new Node(5)

console.log(`Middle Node: ${find_middle_of_linked_list(head).value}`)

head.next.next.next.next.next = new Node(6)
console.log(`Middle Node: ${find_middle_of_linked_list(head).value}`)

head.next.next.next.next.next.next = new Node(7)
console.log(`Middle Node: ${find_middle_of_linked_list(head).value}`)

/*
Time complexity #
The above algorithm will have a time complexity of O(N) where ‘N’ is the number of nodes in the LinkedList.

Space complexity #
The algorithm runs in constant space O(1).
*/