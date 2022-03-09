package com.amazon.interview.linkedList;

public class Leet138 {
    public Node copyRandomList(Node head) {
        Node node = head;
        while (node != null) {
            Node copy = new Node(node.val);
            copy.next = node.next;
            node.next = copy;
            node = node.next.next;
        }
        node = head;
        while (node != null) {
            Node random = node.random;
            if (random == null) {
                node.next.random = null;
            } else {
                node.next.random = random.next;
            }
            node = node.next.next;
        }
        Node newHead = new Node(-1);
        node = head;
        Node newNode = newHead;
        while (node != null) {
            Node next = node.next.next;
            newNode.next = node.next;
            node.next = next;
            node = node.next;
            newNode = newNode.next;
        }
        return newHead.next;
    }
}
