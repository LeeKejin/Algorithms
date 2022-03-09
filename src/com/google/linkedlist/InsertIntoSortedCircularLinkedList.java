package com.google.linkedlist;

public class  InsertIntoSortedCircularLinkedList {
    class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node newNode = new Node(insertVal, null);
            newNode.next = newNode;
            return newNode;
        }

        Node slow = head;
        Node fast = head.next;
        while (true) {
            if (insertVal <= fast.val && insertVal >= slow.val) {

                Node node = new Node(insertVal, fast);
                slow.next = node;
                return head;
            } else if (slow.val > fast.val) {
                if (insertVal >= slow.val || insertVal <= fast.val) {
                    Node node = new Node(insertVal, fast);
                    slow.next = node;
                    return head;
                }
            }


            slow = fast;
            fast = fast.next;
//This must happen after above steps!
            if (slow == head) {
                Node node = new Node(insertVal, fast);
                slow.next = node;
                return head;
            }
        }

    }

}
