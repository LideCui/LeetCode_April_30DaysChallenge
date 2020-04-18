package com.company;/*
 * Date: 2020/apr/12
 * Problem #12:
 * We have a collection of stones, each stone has a positive integer weight.
 *
 * Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.
 * The result of this smash is:
 *
 * If x == y, both stones are totally destroyed;
 * If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 *
 * At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
 */

/*
 * Thinking
 * Use a min heap to get last two stuffs,
 * make a new node and add to heap again
 * iterate
 */

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public class MaxHeap{
        private int[] Heap;
        private int size;
        private int maxsize;

        // Constructor to initialize an
        // empty max heap with given maximum
        // capacity.
        public MaxHeap(int maxsize)
        {
            this.maxsize = maxsize;
            this.size = 0;
            Heap = new int[this.maxsize + 1];
            Heap[0] = Integer.MAX_VALUE;
        }

        // Returns position of parent
        private int parent(int pos)
        {
            return pos / 2;
        }

        // Below two functions return left and
        // right children.
        private int leftChild(int pos)
        {
            return (2 * pos);
        }
        private int rightChild(int pos)
        {
            return (2 * pos) + 1;
        }

        // Returns true of given node is leaf
        private boolean isLeaf(int pos)
        {
            if (pos >= (size / 2) && pos <= size) {
                return true;
            }
            return false;
        }

        private void swap(int fpos, int spos)
        {
            int tmp;
            tmp = Heap[fpos];
            Heap[fpos] = Heap[spos];
            Heap[spos] = tmp;
        }

        // A recursive function to max heapify the given
        // subtree. This function assumes that the left and
        // right subtrees are already heapified, we only need
        // to fix the root.
        private void maxHeapify(int pos)
        {
            if (isLeaf(pos))
                return;

            if (Heap[pos] < Heap[leftChild(pos)] ||
                    Heap[pos] < Heap[rightChild(pos)]) {

                if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    maxHeapify(leftChild(pos));
                }
                else {
                    swap(pos, rightChild(pos));
                    maxHeapify(rightChild(pos));
                }
            }
        }

        // Inserts a new element to max heap
        public void insert(int element)
        {
            Heap[++size] = element;

            // Traverse up and fix violated property
            int current = size;
            while (Heap[current] > Heap[parent(current)]) {
                swap(current, parent(current));
                current = parent(current);
            }
        }

        public void print()
        {
            for (int i = 1; i <= size / 2; i++) {
                System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " +
                        Heap[2 * i] + " RIGHT CHILD :" + Heap[2 * i + 1]);
                System.out.println();
            }
        }

        // Remove an element from max heap
        public int extractMax()
        {
            int popped = Heap[1];
            Heap[1] = Heap[size--];
            maxHeapify(1);
            return popped;
        }
    }

    public int lastStoneWeight(int[] stones) {
        if(stones==null) return 0;
        MaxHeap mh = new MaxHeap(31);
        for(int i = 0; i < stones.length; i++){
            mh.insert(stones[i]);
        }
        mh.print();
        while(mh.size>1){
            int first = mh.extractMax();
            mh.print();
            int second = mh.extractMax();

            System.out.println(first + " | " + second);
            if(first!=second){
                mh.insert(Math.abs(first-second));
            }
        }
        return mh.size==1? mh.extractMax():0;
    }

//    public static int solution(int[] stones){
//        if(stones==null)
//            return 0;
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
//        for (int i = 0; i < stones.length; i++) {
//            pq.offer(stones[i]);
//        }
//        while (pq.size() > 1) {
//            int first = pq.poll();
//            int second = pq.poll();
//            if (first != second) {
//                int rem = Math.abs(first - second);
//                pq.offer(rem);
//            }
//        }
//        return pq.size()==1 ? pq.poll() : 0;
//    }


//    public static void main(String[] args) {
//        int[] stones = {10,4,2,10};
//
//        System.out.println(new LastStoneWeight().lastStoneWeight(stones));
//    }
}

/*
 * At first, I tried to use min heap to solve the problem and prove to be fool
 * the extract max method of max heap can save trouble of dealing with empty node.
 * Notice: the parent of a node in heap is bigger than the node in max heap
 *          but not a guarantee that nodes are stored in order
 */
