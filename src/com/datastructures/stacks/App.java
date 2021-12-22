package com.datastructures.stacks;

public class App {
    public static void main(String[] args) {
        Stack stack = new Stack(2);
        stack.push('1');
        stack.push('2');
        stack.push('3');
        System.out.println(stack.peek());
        stack.pop();

        System.out.println("---------Display Stack---------");
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
        System.out.println(reverseString("hello"));
    }

    public static String reverseString(String string) {
        Stack stack = new Stack(string.length());
        char[] characters = string.toCharArray();
        for (char c: characters){
            stack.push(c);
        }
        String result = "";
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }
}
