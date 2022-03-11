package com.gopher.leetcode.types.structure.design;

import java.util.*;

/**
 * @Title Template1
 * @Author fyw
 * @Date 2022-03-09 22:11
 * @Description 设计题
 */
public class Template1 {
    static class Code981 {
        class TimeMap {
            /**
             * Initialize your data structure here.
             */
            HashMap<String, TreeMap<Integer, String>> hash;
            public TimeMap() {
                hash = new HashMap<>();
            }
            public void set(String key, String value, int timestamp) {
                if (!hash.containsKey(key)) {
                    hash.put(key, new TreeMap<>());
                }
                hash.get(key).put(timestamp, value);
            }
            public String get(String key, int timestamp) {
                if (!hash.containsKey(key)) return "";
                TreeMap<Integer, String> bst = hash.get(key);
                Integer pre = bst.floorKey(timestamp);
                if (pre == null || pre.intValue() > timestamp) return "";
                return bst.get(pre);
            }
        }
    }
    static class Code622{
        // 数组模拟循环队列
        class MyCircularQueue {

            int[] q;
            int front = 0, rear = 0;
            int n;

            public MyCircularQueue(int k) {
                q = new int[k+1];
                n = k + 1;
            }


            public boolean enQueue(int value) {
                if((rear+1) % n == front) return false;
                q[rear] = value;
                rear = (rear + 1) % n;
                return true;
            }

            public boolean deQueue() {
                if(front == rear) return false;
                front = (front+1)%n;
                return true;
            }

            public int Front() {
                if(front == rear) return -1;
                return q[front];
            }

            public int Rear() {
                if(front == rear) return -1;
                return q[(rear-1+n) % n];
            }

            public boolean isEmpty() {
                return front == rear;
            }

            public boolean isFull() {
                return (rear+1) % n == front;
            }
        }
    }
    static class Code284{
        class PeekingIterator implements Iterator<Integer> {
            boolean hasNext;
            int cur;
            Iterator<Integer> iterator;
            public PeekingIterator(Iterator<Integer> iterator) {
                // initialize any member here.
                this.iterator=iterator;
                hasNext=this.iterator.hasNext();
                if (hasNext){
                    cur=this.iterator.next();
                }
            }

            public Integer peek() {
                return cur;
            }

            @Override
            public Integer next() {
                int t=cur;
                hasNext=iterator.hasNext();
                if (hasNext){
                    cur=iterator.next();
                }
                return t;
            }
            @Override
            public boolean hasNext() {
                return hasNext;
            }
        }
    }
}