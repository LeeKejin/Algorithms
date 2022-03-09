package com.google.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {
    class Node {
        int key;
        int value;
        int freq;
        Node next;
        Node prev;

        public Node() {
        }

        public Node(int key, int val) {
            this.key = key;
            this.value = val;
            this.freq = 1;
        }
    }

    class FreqNode {
        Node freqHead = new Node();
        Node freqTail = new Node();

        public FreqNode() {
            freqHead.next = freqTail;
            freqTail.prev = freqHead;
        }

        public void remove(Node node) {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
        }

        public void addToHead(Node node) {
            Node next = freqHead.next;
            freqHead.next = node;
            node.prev = freqHead;
            node.next = next;
            next.prev = node;
        }
    }

    int capacity;
    int min = 0;
    Map<Integer, Node> map = new HashMap<>();
    Map<Integer, FreqNode> freqMap = new HashMap<>();

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        int val = node.value;

        incFreq(node);


        return val;
    }

    private void incFreq(Node node) {
        int freq = node.freq;
        FreqNode freqNode = freqMap.get(freq);

        freqNode.remove(node);
        node.freq++;
        freqMap.putIfAbsent(node.freq, new FreqNode());
        freqMap.get(node.freq).addToHead(node);

        FreqNode minFreqNode = freqMap.get(min);
        if (minFreqNode.freqHead.next.next == null && node.freq - 1 == min) {
            min = node.freq;
        }
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            incFreq(node);
            return;
        }
        Node node = new Node(key, value);
        freqMap.putIfAbsent(node.freq, new FreqNode());
        if (map.size() < capacity) {
            addNewNodeToFreq(key, node);
        } else {
            Node nodeToRemove = freqMap.get(min).freqTail.prev;
            map.remove(nodeToRemove.key);
            freqMap.get(min).remove(nodeToRemove);


            addNewNodeToFreq(key, node);
        }

    }

    private void addNewNodeToFreq(int key, Node node) {
        map.put(key, node);
        freqMap.get(node.freq).addToHead(node);
        min = 1;
    }
}
