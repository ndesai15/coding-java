package com.datastructures.stacks;

public class Stack {
    private int maxSize;
    private char[] stackArray;
    private int top;  // top element of stack

    public Stack(int maxSize){
        this.maxSize = maxSize;
        this.stackArray = new char[maxSize];
        this.top = -1;
    }

    public void push(char data){
        if (this.isFull()) {
            System.out.println("Stack is full! You can't push more elements");
            return;
        }
        top++;
        stackArray[top] = data;
    }

    public char pop(){
        if (this.isEmpty()) {
            System.out.println("Stack is Empty!");
            return '0';
        }
        char temp = stackArray[top];
        top--;
        return temp;
    }

    public char peek(){
        return stackArray[top];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize -1;
    }
}
