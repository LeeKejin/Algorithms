package com.educative.graph;

public class DoublyLinkedList<T> {

    //Node inner class for DLL
    public class Node {
        public T data;
        public Node nextNode;
        public Node prevNode;
    }

    public Node headNode;
    public Node tailNode;
    public int size;

    public DoublyLinkedList() {
        this.headNode = null;
        this.tailNode = null;
    }

    public boolean isEmpty() {
        return headNode == null && tailNode == null;
    }

    public Node getHeadNode() {
        return headNode;
    }

    public Node getTailNode() {
        return tailNode;
    }

    public int getSize() {
        return size;
    }

    public void insertAtHead(T data) {
        Node node = new Node();
        node.data = data;
        node.nextNode = headNode;
        if (headNode != null) {
            headNode.prevNode = node;
        } else {
            tailNode = node;
        }
        headNode = node;
        size++;
    }

    public void insertAtEnd(T data) {
        Node node = new Node();
        node.data = data;
        if (tailNode != null) {
            tailNode.nextNode = node;
            node.prevNode = tailNode;
        } else {

            headNode = node;
        }
        tailNode = node;
        size++;
    }

    public void printList() {

    }

    public void printListReverse() {

    }

    public void deleteAtHead() {

    }

    public void deleteAtTail() {

    }

}
