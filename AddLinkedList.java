import java.util.*;

class Solution {
    public static Node reverseList(Node x) {
        Node prev = null;
        Node current = x;
        Node next = null;
        
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
    
    public static Node addTwoLists(Node first, Node second) {
        first = reverseList(first);
        second = reverseList(second);
        
        Node dummyHead = new Node(0);
        Node current = dummyHead;
        int carry = 0;
        
        while (first != null || second != null || carry != 0) {
            int sum = carry;
            if (first != null) {
                sum += first.data;
                first = first.next;
            }
            if (second != null) {
                sum += second.data;
                second = second.next;
            }
            
            carry = sum / 10;
            current.next = new Node(sum % 10);
            current = current.next;
        }
        
        return reverseList(dummyHead.next);
    }
}

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      
        int n = sc.nextInt();
        int val = sc.nextInt();
            
        Node first = new Node(val);
        Node tail = first;
        for(int i = 0; i < n - 1; i++) {
            val = sc.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }
            
        int m = sc.nextInt();
        val = sc.nextInt();
            
        Node second = new Node(val);
        tail = second;
        for(int i = 0; i < m - 1; i++) {
            val = sc.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }
            
        Solution g = new Solution();
        Node res = g.addTwoLists(first, second);
        printList(res);
    }

    static void printList(Node n) {
        while(n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }
}
