import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


// There is a much better Apporach than finding the lenght of the linked list 

// Using the Cycle finding detection in a graph alogirthm .
// just join the listA head to tail and Run Cycle detection Algoithm on the ListB will be 
// Able to find the link.

// Now this node both pointers point to has an additional property, 
//the distance from this node to the beginning of the cycle 
// (and therefore the merging node of the list) is equal to the distance the beginning of the list 
//has to the beginning of the cycle

public class Solution {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    // Complete the findMergeNode function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        int size2 = 0;int size1 = 0;
        SinglyLinkedListNode temp1 = head1;
        SinglyLinkedListNode temp2 = head2;

        while(temp1 != null) {
            size1++;
            temp1 = temp1.next;
        }

        while(temp2 != null) {
            size2++;
            temp2 = temp2.next;
        }

        int diff = size1 - size2;

        if (diff >= 0) {
            temp1 = head1;
            temp2 = head2;
        }else {
            temp1 = head2;
            temp2 = head1;
        }

        diff = Math.abs(diff);
        while(diff > 0) {
            temp1 = temp1.next;
            diff--;
        }

        while (temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return temp1.data;
    }

    private static final Scanner scanner = new Scanner(System.in);