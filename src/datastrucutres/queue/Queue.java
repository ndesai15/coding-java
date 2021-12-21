package datastrucutres.queue;

public class Queue {

    private int maxSize;
    private long[] queueArray;
    private int front;
    private int rear;
    private int nItems;

    public Queue(int size){
        this.maxSize = size;
        this.queueArray = new long[size];
        front = 0; // index position of the first array slot
        rear = -1; // no item in the array
        nItems = 0; // don't have element in the array
    }

    public void enqueue(long d) {
        /** Circular Queue */
        if (rear == maxSize - 1) {
            rear = -1;
        }
        rear++;
        queueArray[rear] = d;
        nItems++;
    }

    public long dequeue(){
        long temp = queueArray[front];
        front++;
        if (front == maxSize) {
            front = 0; // reset front in case of an empty queue
        }
        nItems--;
        return temp;
    }

    public long peek(){
        return queueArray[front];
    }

    public boolean isEmpty(){
        return nItems == 0;
    }

    public boolean isFull(){
        return nItems == maxSize;
    }

    public void displayQueue(){
        System.out.print("[");
        for (int i = 0; i < queueArray.length; i++){
            System.out.print(queueArray[i]+ " ");
        }
        System.out.print("]");
    }

}
