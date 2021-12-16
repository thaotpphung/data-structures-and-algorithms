/*
EASY
Problem Statement #
Given the head of a Singly LinkedList, reverse the LinkedList. Write a function to return the new head of the reversed LinkedList.
*/

class Node {
  constructor(value, next=null){
    this.value = value;
    this.next = next;
  }

  get_list() {
    result = "";
    temp = this;
    while (temp !== null) {
      result += temp.value + " ";
      temp = temp.next;
    }
    return result;
  }
};


const reverse = function(head) {
  let current = head, previous = null;
  while (current != null) {
    next = current.next; // temporarily store the next node
    current.next = previous;  // reverse the current node to point to the opposit direction
    previous = current; // now set the previous to current node so the next node can point back to the current node
    current = next; // move on to the next node
  }
  return previous;
};

head = new Node(2);
head.next = new Node(4);
head.next.next = new Node(6);
head.next.next.next = new Node(8);
head.next.next.next.next = new Node(10);

console.log(`Nodes of original LinkedList are: ${head.get_list()}`)
console.log(`Nodes of reversed LinkedList are: ${reverse(head).get_list()}`)

/*
Time complexity #
The time complexity of our algorithm will be O(N) where ‘N’ is the total number of nodes in the LinkedList.

Space complexity #
We only used constant space, therefore, the space complexity of our algorithm is O(1)
*/

