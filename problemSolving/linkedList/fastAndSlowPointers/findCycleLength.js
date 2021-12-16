/*
EASY
Problem 1: Given the head of a LinkedList with a cycle, find the length of the cycle.

*/

class Node {
  constructor(value, next = null) {
    this.value = value;
    this.next = next;
  }
}


function find_cycle_length(head) {
  let slow = head, fast = head;
  while (fast !== null && fast.next !== null) {
    fast = fast.next.next;
    slow = slow.next;
    if (slow === fast) {
      return calculate_cycle_length(slow);
    }
  }
}

function calculate_cycle_length (stillPointer) {
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

const head = new Node(1);
head.next = new Node(2);
head.next.next = new Node(3);
head.next.next.next = new Node(4);
head.next.next.next.next = new Node(5);
head.next.next.next.next.next = new Node(6);
head.next.next.next.next.next.next = head.next.next;
console.log(`LinkedList cycle length: ${find_cycle_length(head)}`);

head.next.next.next.next.next.next = head.next.next.next;
console.log(`LinkedList cycle length: ${find_cycle_length(head)}`);


