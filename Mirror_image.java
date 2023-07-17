import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;


class Solution {
    // Function to convert a binary tree into its mirror tree.
    void Mirror(Node node) {
        // Your code goes here
        if(node==null){
            return;
        }
        if(node.left!=null&&node.right!=null){
            Node temp=node.left;
        node.left=node.right;
        node.right=temp; 
        }
        else if(node.left==null&&node.right!=null){
            node.left=node.right;
            node.right=null;
        }
        else if(node.left!=null&&node.right==null){
           node.right= node.left;
            node.left=null;
        }
        Mirror(node.left);
        Mirror(node.right);
    }
}



class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Main {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
    void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.data + " ");

        inOrder(node.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

            String s = br.readLine();
            Node root = buildTree(s);

            Solution g = new Solution();
            g.Mirror(root);
            Main mt = new Main();
            mt.inOrder(root);
            System.out.println();
    }
}
