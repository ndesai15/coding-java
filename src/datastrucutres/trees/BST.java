package datastrucutres.trees;


import java.util.Stack;

public class BST {
    private Node root;

    public void insert(int key, String value) {
        Node newNode = new Node(key, value);
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (key < current.key) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public Node findMin() {
        Node current = root;
        Node last = null;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last;
    }

    public Node findMax() {
        Node current = root;
        Node last = null;
        while (current != null) {
            last = current;
            current = current.rightChild;
        }
        return last;
    }

    /** Delete a node from binary search tree **/
    public boolean remove(int key) {
        // Search a node to be deleted
        Node current = root;
        Node parent = root;
        boolean isLeftChild = false;
        while (current.key != key) {
            parent = current;
            if (key < current.key) {
                // Search in left subtree
                isLeftChild = true;
                current = current.leftChild;
            }
            else {
                // Search in right subtree
                current = current.rightChild;
                isLeftChild = false;
            }
            if (current == null) {
                return false;
            }
        }
        // At this point you should have a node to be deleted and its parent
        Node nodeTobeDeleted = current;

        // Case # 1: Searched Node is a leaf node
        if (nodeTobeDeleted.leftChild == null && nodeTobeDeleted.rightChild == null) {
            if (nodeTobeDeleted == root) {
                root = null;
            }
            if (isLeftChild) {
                parent.leftChild = null;
            }
            else {
                parent.rightChild = null;
            }
        }
        // Case # 2: Searched node has one left/right child
        else if (nodeTobeDeleted.rightChild == null) {
            if (nodeTobeDeleted == root) {
                root = nodeTobeDeleted.leftChild;
            }
            else if (isLeftChild) {
                parent.leftChild = nodeTobeDeleted.leftChild;
            }
            else {
                parent.rightChild = nodeTobeDeleted.leftChild;
            }
        }
        else if (nodeTobeDeleted.leftChild == null) {
            if (nodeTobeDeleted == root) {
                root = nodeTobeDeleted.rightChild;
            }
            else if (isLeftChild) {
                parent.leftChild = nodeTobeDeleted.rightChild;
            }
            else {
                parent.rightChild = nodeTobeDeleted.rightChild;
            }
        }
        // Case # 3: Searched node has both the children
        else {
            // find a successor that has min value
            Node successor = getSuccessor(nodeTobeDeleted);

            // Connect the parent of the node to delete
            if(nodeTobeDeleted == root) {
                root = successor;
            }
            else if (isLeftChild) {
                parent.leftChild = successor;
            }
            else  parent.rightChild = successor;

            successor.leftChild = nodeTobeDeleted.leftChild;
        }
        return true;
    }

    private Node getSuccessor(Node nodeToDelete) {
        Node successor = nodeToDelete;
        Node successorParent = nodeToDelete;

        Node current = nodeToDelete.rightChild;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != nodeToDelete.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = nodeToDelete.rightChild;
        }
        return successor;
    }
    public void displayTree() {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("......................................................");

        while(isRowEmpty==false) {
            Stack localStack = new Stack();
            isRowEmpty = true;
            for(int j=0; j<nBlanks; j++) {
                System.out.print(" ");
            }

            while(globalStack.isEmpty()==false) {
                Node temp = (Node)globalStack.pop();
                if(temp != null) {
                    System.out.print(temp.key);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    if(temp.leftChild != null || temp.rightChild != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }

                for(int j=0; j<nBlanks*2-2; j++) {
                    System.out.print(" ");
                }
            }

            System.out.println();
            nBlanks = nBlanks/2;

            while(localStack.isEmpty()==false)
                globalStack.push( localStack.pop() );
        }
        System.out.println( "......................................................");

    }
}

