package com.gopher.leetcode.order.or700;

/**
 * @Title Code707
 * @Author fyw
 * @Date 2022/2/9 14:05
 * @Description:
 */
public class Code707 {

   class MyLinkedList{
       class Node {
           int val;
           Node next;

           public Node(int val) {
               this.val = val;
           }
       }

       /**
        * Initialize your data structure here.
        */

       Node head;
       int size;

       public MyLinkedList() {
           head = new Node(-1);
           size = 0;
       }

       /**
        * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
        */
       public int get(int index) {
           if (index < 0 || index >= size) {
               return -1;
           }
           Node p = head;
           for (int i = 0; i <= index; i++) {
               p = p.next;
           }
           return p.val;
       }

       /**
        * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
        */
       public void addAtHead(int val) {
           addAtIndex(0, val);
       }

       /**
        * Append a node of value val to the last element of the linked list.
        */
       public void addAtTail(int val) {
           addAtIndex(size, val);
       }

       /**
        * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
        */
       public void addAtIndex(int index, int val) {
           if (index > size) {
               return;
           }
           if (index < 0) {
               index = 0;
           }
           size++;
           Node p = head;
           for (int i = 0; i < index; i++) {
               p = p.next;
           }
           Node node = new Node(val);
           node.next = p.next;
           p.next = node;
       }

       /**
        * Delete the index-th node in the linked list, if the index is valid.
        */
       public void deleteAtIndex(int index) {
           if (index < 0 || index >= size) {
               return;
           }
           Node p = head;
           for (int i = 0; i < index; i++) {
               p = p.next;
           }
           size--;
           p.next = p.next.next;
       }
   }

}
