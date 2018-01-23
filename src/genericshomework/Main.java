package genericshomework;

import java.util.*;

public class Main {
    void exampleMyArrayList(){
        MyArrayList<Integer> mas = new MyArrayList<>();
        mas.add(10);
        mas.add(-50);
        mas.add(1);
        for (int i=0; i<mas.size(); i++)
            System.out.println(mas.get(i));
        mas.remove(1);
        for (int i=0; i<mas.size(); i++)
            System.out.println(mas.get(i));
        mas.clear();
        for (int i=0; i<mas.size(); i++)
            System.out.println(mas.get(i));
    }
    void exampleLinkedList(){
        MyLinkedList<Integer> mas2 = new MyLinkedList<>();
        mas2.add(9);
        mas2.add(-5);
        mas2.add(8);
        for (int i=0; i<mas2.size(); i++)
            System.out.println(mas2.get(i));
        mas2.remove(1);
        for (int i=0; i<mas2.size(); i++)
            System.out.println(mas2.get(i));
        mas2.clear();
        for (int i=0; i<mas2.size(); i++)
            System.out.println(mas2.get(i));
    }
    void exampleQueue(){
        MyQueue<Integer> q = new MyQueue<>();
        q.add(9);
        q.add(-4);
        q.add(10);
        q.add(13);
        q.add(-1);
        System.out.println("Removed element: "+q.remove(2));
        System.out.println("poll(): "+q.poll());
        System.out.println("peek(): "+q.peek());
        System.out.println("size(): "+q.size());
        q.clear();
        System.out.println("size(): "+q.size());
    }
    void exampleStack(){
        MyStack<Integer> stack = new MyStack<>();
        stack.push(8);
        stack.push(4);
        stack.push(3);
        stack.push(-1);
        System.out.println("peek(): "+stack.peek());
        System.out.println("Removed element: "+stack.remove(0));
        System.out.println("peek(): "+stack.peek());
        System.out.println("pop(): "+stack.pop());
        System.out.println("peek(): "+stack.peek());
        System.out.println("size(): "+stack.size());
        stack.clear();
        System.out.println("size(): "+stack.size());
    }
    void exampleHashMap(){
        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
        hashMap.put(1, "One");
        hashMap.put(2, "Two");
        hashMap.put(3, "Three");
        hashMap.put(4, "Four");
        hashMap.put(5, "Five");
        hashMap.remove(3);
        for (int i=1; i<=hashMap.size(); i++)
            System.out.println(hashMap.get(i));
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.exampleMyArrayList();
        main.exampleMyArrayList();
        main.exampleQueue();
        main.exampleStack();
        //main.exampleHashMap(); Не сделал

    }
}
