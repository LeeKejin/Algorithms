package com.crackingcodeinterview.chapter3;


import java.util.LinkedList;
import java.util.Queue;

public class AnimalShelf_3_6 {
    public AnimalShelf_3_6() {

    }

    Queue<int[]> queue = new LinkedList<>();
    Queue<Integer> cats = new LinkedList<>();
    Queue<Integer> dogs = new LinkedList<>();

    public void enqueue(int[] animal) {
        if (animal[1] == 0) {
            cats.add(animal[0]);
        } else {
            dogs.add(animal[0]);
        }
        queue.add(animal);
    }

    public int[] dequeueAny() {
        if (queue.isEmpty()) return new int[]{-1, -1};
        int[] arr = queue.peek();
        while (!queue.isEmpty()) {
            if (arr[1] == 0) {
                if (!cats.isEmpty() && cats.peek() == arr[0]) {
                    cats.poll();
                    queue.poll();
                    return arr;
                }
            } else {
                if (!dogs.isEmpty() && dogs.peek() == arr[0]) {
                    dogs.poll();
                    queue.poll();
                    return arr;
                }
            }
            queue.poll();
            arr = queue.peek();
        }
        return new int[]{-1, -1};
    }

    public int[] dequeueDog() {
        if (dogs.isEmpty()) return new int[]{-1, -1};
        return new int[]{dogs.poll(), 1};
    }

    public int[] dequeueCat() {
        if (cats.isEmpty()) return new int[]{-1, -1};
        return new int[]{cats.poll(), 0};
    }

    public static void main(String[] args) {
        AnimalShelf_3_6 animalShelf_3_6 = new AnimalShelf_3_6();
        animalShelf_3_6.enqueue(new int[]{0, 0});
        animalShelf_3_6.enqueue(new int[]{1, 0});
        animalShelf_3_6.dequeueCat();
        animalShelf_3_6.dequeueDog();
        animalShelf_3_6.dequeueAny();
    }
}
