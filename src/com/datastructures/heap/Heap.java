package com.datastructures.heap;

/** MaxHeap **/
public class Heap {
    private Node[] heapArray;
    private int maxSize; // Size of the array
    private int currentSize;  // current number of nodes in Heap

    public Heap(int size) {
        this.maxSize = size;
        currentSize = 0;
        heapArray = new Node[size]; // actually this creates the array
    }

    public int getSize() {
        return currentSize;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean insert(int key) {
        if (currentSize == maxSize) { // array is full
            return false;
        }
        Node newNode = new Node(key);
        heapArray[currentSize] = newNode;

        // Place to correct position
        trickleUp(currentSize);
        currentSize++;
        return true;
    }

    private void trickleUp(int idx) {
        Node nodeToInsert = heapArray[idx];
        int parentIdx = (idx - 1) / 2;
        // loop over heapArray until nodeToInsert is greater than its parent
        while (idx > 0 && nodeToInsert.getKey() > heapArray[parentIdx].getKey()) {
            heapArray[idx] = heapArray[parentIdx]; // swap
            idx = parentIdx;
            parentIdx = (parentIdx - 1) / 2 ;
        }
        heapArray[idx] = nodeToInsert;
    }

    public Node remove() {
        if (currentSize == 0) {
            return null;
        }

        Node root = heapArray[0];
        // Decrement currentSize by 1 because it is pointing to nothing as we are
        // incrementing it at the end of insert method
        heapArray[0] = heapArray[--currentSize];

        trickleDown(0);
        return root;
    }

    private void trickleDown(int idx) {
        int largerChildIdx;
        Node top = heapArray[idx]; // save the last node to top variable

        while (idx > currentSize / 2) {
            int leftChildIdx = 2 * idx + 1; // left child
            int rightChildIdx = leftChildIdx + 1; // Or `2n + 2` for right child

            if (rightChildIdx < currentSize && (heapArray[rightChildIdx].getKey() > heapArray[leftChildIdx].getKey())) {
                largerChildIdx = rightChildIdx;
            }
            else {
                largerChildIdx = leftChildIdx;
            }
            if (top.getKey() >= heapArray[largerChildIdx].getKey()) {
                // successfully made the root the largest key
                break;
            }
            heapArray[idx] = heapArray[largerChildIdx];
            idx = largerChildIdx;
        }
        heapArray[idx] = top;
    }

    public void displayHeap() {
        System.out.println("Heap Array: ");
        for(int m = 0; m < currentSize; m++) {
            if(heapArray[m] != null) {
                System.out.print( heapArray[m].getKey() + " ");
            }
            System.out.println();

            int nBlanks = 32;
            int itemsPerRow = 1;
            int column = 0;
            int j = 0; // current item

            String dots = "...............................";
            System.out.println(dots+dots);
            while(currentSize > 0) {
                if(column == 0) {
                    for(int k = 0; k < nBlanks; k++) {
                        System.out.print(" ");
                    }
                }
                System.out.print(heapArray[j].getKey());
                j++;
                if(j == currentSize) {
                    break;
                }

                column++;
                // end of row
                if(column == itemsPerRow) {
                    nBlanks = nBlanks/2; // half the blanks
                    itemsPerRow = itemsPerRow * 2;     // twice the items
                    column = 0;
                    System.out.println();
                } else {
                    for(int k=0; k<nBlanks*2; k++) {
                        System.out.print(" ");
                    }
                }

            }
            System.out.println("\n"+dots+dots);
        }


    }
}
