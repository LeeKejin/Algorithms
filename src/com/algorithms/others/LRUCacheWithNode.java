package com.algorithms.others;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheWithNode {
    class Node {
        int key;
        int val;
        Node next;
        Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    int capacity;
    Map<Integer, Node> map = new HashMap<>();

    public LRUCacheWithNode(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        int val = node.val;
        removeNode(node);
        addToHead(node);
        return val;
    }

    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void addToHead(Node node) {
        Node next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            removeNode(node);
            addToHead(node);
            return;
        }
        Node node = new Node(key, value);
        if (map.size() < capacity) {
            map.put(key, node);
            addToHead(node);
        } else {
            int removedKey = tail.prev.key;
            map.remove(removedKey);
            removeNode(tail.prev);
            map.put(key, node);
            addToHead(node);
        }
    }

}
