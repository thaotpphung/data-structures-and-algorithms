/*
MEDIUM
Problem Statement #
Given the head of a Singly LinkedList that contains a cycle, write a function to find the starting node of the cycle.

*/

class Node {
  constructor(value, next=null){
    this.value = value;
    this.next = next;
  }
}

const find_cycle_start = function(head){
  let slow = head, fast = head, cycleLen = 0;
  while (fast !== null && fast.next !== null) {
    slow = slow.next;
    fast = fast.next.next;
    if (slow === fast) {
      cycleLen = calculate_cycle_length(slow);
      break;
    }
  }
  return find_start (head, cycleLen);
};

const calculate_cycle_length = function(stillPointer) {
  let movingPointer = stillPointer, cycleLen = 0;
  while (true) {
    movingPointer = movingPointer.next;
    cycleLen += 1;
    if (movingPointer === stillPointer) {
      break;
    }
  }
  return cycleLen;
}

const find_start = function (head, cycleLen) {
  let pointer1 = head, pointer2 = head;

  // move pointer2 ahead 'cycle_length' nodes
  for (let i = 0; i < cycleLen; i++) {
    pointer2 = pointer2.next;
  }
  // increment both pointers until they meet at the start of the cycle
  while (pointer1 !== pointer2) {
    pointer1 = pointer1.next;
    pointer2 = pointer2.next;
  }
  return pointer1;
}

head = new Node(1)
head.next = new Node(2)
head.next.next = new Node(3)
head.next.next.next = new Node(4)
head.next.next.next.next = new Node(5)
head.next.next.next.next.next = new Node(6)

head.next.next.next.next.next.next = head.next.next
console.log(`LinkedList cycle start: ${find_cycle_start(head).value}`)

head.next.next.next.next.next.next = head.next.next.next
console.log(`LinkedList cycle start: ${find_cycle_start(head).value}`)

head.next.next.next.next.next.next = head
console.log(`LinkedList cycle start: ${find_cycle_start(head).value}`)

/*
Time Complexity #
As we know, finding the cycle in a LinkedList with ‘N’ nodes and also finding the length of the cycle requires O(N). Also, as we saw in the above algorithm, we will need O(N) to find the start of the cycle. Therefore, the overall time complexity of our algorithm will be O(N).

Space Complexity #
The algorithm runs in constant space O(1)O(1).
*/