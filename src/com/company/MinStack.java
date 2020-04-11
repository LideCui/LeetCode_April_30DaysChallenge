package com.company;

import java.util.EmptyStackException;

public class MinStack {
    //this one passed compare the difference
    class Elem{
        public int value;
        public int min;
        public Elem next;

        public Elem(int value, int min){
            this.value = value;
            this.min = min;
        }
    }

    public Elem top;

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        if(top == null){
            top = new Elem(x, x);
        }else{
            Elem e = new Elem(x, Math.min(x,top.min));
            e.next = top;
            top = e;
        }

    }

    public void pop() {
        if(top == null)
            return;
        Elem temp = top.next;
        top.next = null;
        top = temp;

    }

    public int top() {
        if(top == null)
            return -1;
        return top.value;
    }

    public int getMin() {
        if(top == null)
            return -1;
        return top.min;
    }
//    int min;
//    int size;
//    Node head;
//
//    class Node {
//        int value;
//        Node next;
//        Node(int v){this.value= v;}
//    }
//
//    /** initialize your data structure here. */
//    public MinStack() {
//        int min;
//        int size =0;
//        Node head = null;
//    }
//
//    public void push(int x) {
//        Node n = new Node(x);
//        if(this.min > x) min = x;
//        else if(size==0) min = x;
//        n.next = this.head;
//        this.head = n;
//        size++;
//    }
//
//    public void pop() {
//        if(size==0) return;
//
//        min = findMin(head.next, min);
//
//        this.head = this.head.next;
//        size--;
//    }
//
//    private int findMin(Node n, int min) {
//        min = n.value;
//
//        if(n.next==null){
//            min = n.value;
//        }
//
//        while(n!=null && n.next!=null){
//            int v = Math.min(n.value,n.next.value);
//            if(min > v){
//                min = v;
//            }
//            n = n.next;
//        }
//
//        return min;
//    }
//
//    public int top() {
//        if(size==0) throw new EmptyStackException();
//        return this.head.value;
//    }
//
//    public int getMin() {
//        return this.min;
//    }
}
