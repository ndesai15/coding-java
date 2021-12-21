package datastrucutres.adt;

import java.util.LinkedList;

public class App {
    public static void main(String[] args) {
        Counter mycounter = new Counter("Counter 1");
        mycounter.increment();
        mycounter.increment();
        System.out.println(mycounter.toString());

        LinkedList<String> mylist = new LinkedList<>();
    }
}
