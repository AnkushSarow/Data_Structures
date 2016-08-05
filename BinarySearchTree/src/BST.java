/**
 * The purpose of this class is to practice the implementation of a generic binary search tree. In
 * the current implementation of this BST, duplicates are ignored.
 */

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;


public class BST<E extends Comparable<E>> {
    private Node root;
    private int size; //The number of nodes in the binary search tree

    private class Node {
        private E data;
        private Node left;
        private Node right;

        public Node(E data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public Node(E data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public BST() {
        this.root = null;
        this.size = 0;
    }

    /**
     * Inserts a new element into the BST
     * @param data - holds the element to be added
     */
    public void insert(E data) {
        root = insert(data, root);
    }
    /**
     * Helper function for insert(E data). Based on the structure of this method,
     * duplicate entries will be ignored.
     * @param data - holds the element to be added
     * @param node - root node of the subtree
     */
    private Node insert(E data, Node node) {
        if (node == null) {
            node = new Node(data);
            ++size;
        }
        else if (node.data.compareTo(data) > 0) {
            node.left = insert(data, node.left);
        }
        else if (node.data.compareTo(data) < 0) {
            node.right = insert(data, node.right);
        }
        else {
            return node;
        }
        return node;
    }

    /**
     * Delete an element from the BST. Private helper removes the element from the BST
     * if it's found. If it's not found, the tree is unchanged.
     * @param data - desired element to be removed
     */
    public void delete(E data) {
        delete(data, root, null);
    }
    /**
     * Delete helper function
     * @param data - desired element to be removed
     * @param node - Root of the subtree
     * @param parent - parent of the node parameter
     * @return True if element removed, false if not removed
     */
    private void delete(E data, Node node, Node parent) {
        if (node == null) {
            return;
        }
        //Data match
        //Now, must check for the 3 cases
        //1: the node is a leaf
        //2: the node has only one child (right OR left) - Set parent's link to the node's child
        //3: the node has two children - replace the data with the minimum data in the right subtree
        //3: - then call delete with this data value in the nodes right subtree (it will encounter case 1 or 2)
        //Also note, the parent check is to determine if the node is to the left or to the right of the parent
        if (node.data.compareTo(data) == 0) {
            //Case 1
            if (node.left == null && node.right == null) {
                if (node == root) {
                    root = null;

                }
                else if (parent.left == node) {
                    parent.left = node.left;
                } else {
                    parent.right = node.right;
                }
                --size;
                return;
            } else if (node.left == null) {   //Case 2
                if (node == this.root) {      //If the node is the root, make the root point to the next node
                    root = null;
                    root = node.right;
                } else if (node == parent.left) {
                    parent.left = node.right;
                } else {
                    parent.right = node.right;
                }
                --size;
                return;
            } else if (node.right == null) {
                if (node == this.root) {
                    root = null;
                    root = node.left;

                } else if (node == parent.left) {
                    parent.left = node.left;
                } else {
                    parent.right = node.left;
                }
                --size;
                return;
            } else {                         //Case 3
                node.data = min(node.right);
                delete(node.data, node.right, node);
            }
        //Compare the data within the the node to the search data
        //If search data is less than the data in the node, proceed to the left node only if it is not null
        //If search data is greater than the data in the node, proceed to the right node only if it is not null
        //If the node is null, the item is not in the BST, use return to end the method
        } else if (node.data.compareTo(data) > 0) {
            if (node.left == null) {
                return;
            }
            delete(data, node.left, node);
        } else {
            if (node.right == null) {
                return;
            }
            delete(data, node.right, node);
        }
    }

    /**
     * Searches the BST for the element
     * @param data - Desired element to be searched for
     * @return - returns result of private helper function - True if found, false if not found
     */
    public boolean search(E data) {
        return search(data,this.root);
    }
    private boolean search(E data, Node node) {
        if (node == null) {
            return false;
        }
        if (node.data.compareTo(data) == 0) {
            return true;
        } else if (node.data.compareTo(data) > 0) {
            return search(data, node.left);
        } else {
            return search(data, node.right);
        }
    }

    /**
     * @return - Returns the max element in the BST given the root
     */
    public E max() {
        if (isEmpty()) {
            throw new NoSuchElementException("BST is empty");
        }
        return max(root);
    }
    /**
     * @param node - Root of the subtree
     * @return Returns the maximum value in the BST with the given node parameter
     */
    private E max(Node node) {
        if(node.right == null) {
            return node.data;
        } else {
            return max(node.right);
        }
    }

    /**
     * @return - Returns the minimum element in the BST
     */
    public E min() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return min(root);
    }
    /**
     * @param node - Root of the subtree
     * @return - Returns the minimum value in the BST with the given node parameter
     */
    private E min(Node node) {
        if (node.left == null) {
            return node.data;
        } else {
            return min(node.left);
        }
    }

    /**
     * Display the tree (in order)
     */
    public void displayInOrder() {
        displayInOrder(root);
    }
    private void displayInOrder(Node node) {
        if (node == null) {
            return;
        }
        displayInOrder(node.left);
        System.out.print(node.data + " ");
        displayInOrder(node.right);
    }

    /**
     * Display the tree (post order)
     */
    public void displayPostOrder() {
        displayPostOrder(root);
    }
    private void displayPostOrder(Node node) {
        if (node == null) {
            return;
        }
        displayPostOrder(node.left);
        displayPostOrder(node.right);
        System.out.print(node.data + " ");
    }

    /**
     * Display the tree (level order)
     */
    public void displayLevelOrder() {
        displayLevelOrder(root);
    }
    private void displayLevelOrder(Node node) {
        if (root == null) {
            return;
        }

        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(node);

        while (!nodeQueue.isEmpty()) {
            Node current = nodeQueue.peek();
            System.out.print(current.data + " ");

            if (current.left != null) {
                nodeQueue.add(current.left);
            }
            if (current.right != null) {
                nodeQueue.add(current.right);
            }
            nodeQueue.remove();
        }
    }

    /**
     * @return True if the BST is empty - False if it contains at least one element
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * @return size - number of nodes in the BST
     */
    public int size() {
        return size;
    }

    /**
     * @return returns the height of the BST
     */
    public int height() {
        if (isEmpty()) {
            return 0;
        }
        return height(root);
    }
    private int height(Node node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }
}
