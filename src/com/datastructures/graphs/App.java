package com.datastructures.graphs;

import java.util.Set;

public class App {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(2,3);
        graph.addEdge(3,1);
        graph.addEdge(4,0);
        graph.addEdge(4,3);

        Object[] values = graph.adj(0);
        for(Object o: values){
            System.out.println(o);
        }

        System.out.println("======= Better Graph ========");
        BetterGraph bgraph = new BetterGraph();
        bgraph.addEdge("Alice", "Bob");
        bgraph.addEdge("Alice", "George");
        bgraph.addEdge("Alice", "David");
        bgraph.addEdge("George", "Charlie");
        bgraph.addEdge("George", "David");
        bgraph.addEdge("David", "Charlie");
        bgraph.addEdge("Charlie", "Bob");

        System.out.println("******Alice's Adjacent Nodes******");
        Set<String> aliceFriends = bgraph.getAdjacents("Alice");
        for(String friend: aliceFriends) {
            System.out.println(friend);
        }

        System.out.println("******George's Adjacent Nodes******");
        Set<String> georgeFriends = bgraph.getAdjacents("George");
        for(String friend: georgeFriends) {
            System.out.println(friend);
        }

        System.out.println("----------Printing a Graph---------");
        bgraph.print();

        System.out.println("*******Depth First Search*******");
        BetterGraph bgraph1 = new BetterGraph();
        bgraph1.addEdge("A", "B");
        bgraph1.addEdge("A", "G");
        bgraph1.addEdge("G", "F");
        bgraph1.addEdge("G", "H");
        bgraph1.addEdge("F", "E");
        bgraph1.addEdge("F", "C");
        bgraph1.addEdge("C", "D");
        bgraph1.addEdge("C", "B");
        bgraph1.addEdge("C", "E");
        bgraph.dfs("Alice");
        System.out.println();
        System.out.println("*******Breadth First Search*******");
        bgraph.bfs("Alice");
    }
}
