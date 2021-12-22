package com.datastructures.graphs;

import java.util.*;

public class BetterGraph {

    private Map<String, Set<String>> map;

    public BetterGraph() {
        map = new HashMap<String , Set<String>>();
    }

    public void addEdge(String key, String value) {
        Set<String> EmptySet = Collections.<String>emptySet();
        if (map.containsKey(key)) {
            Set<String> existingSet = map.get(key);
            existingSet.add(value);
            map.put(key, existingSet);
        }
        else {
            Set<String> newSet = new HashSet<>();
            newSet.add(value);
            map.put(key, newSet);
        }
    }

    public int getNumberOfVertex() {
        return map.keySet().size();
    }
    public int getEdgeCount() {
        return map.values().size();
    }
    public Set<String> getAdjacents(String key) {
        //System.out.println("Map is");
        //System.out.println(map.values());
        if (map.containsKey(key)) {
            //System.out.println(map.get(key));
            return map.get(key);
        }
        else return Collections.<String>emptySet();
    }

    public void print() {
        Set<String> keys = map.keySet();
        for(String key: keys) {
            Set<String> values = map.get(key);
            System.out.println("Node: " + key);
            System.out.println("-------------");
            for(String value: values) {
                System.out.println(value);
            }
            System.out.println("-----Next Node-----");
        }
    }

    public void dfs(String start) {
        Stack<String> stack = new Stack<>();
        Set<String> visited = new HashSet<String>();
        stack.push(start);  // Add start to stack
        while (!stack.isEmpty()) {
            String current = stack.pop();  // pop a stack
            if (!visited.contains(current)) {
                visited.add(current);
                System.out.print(current + ", ");
            }
            for (String adjacent: getAdjacents(current)) {
                //System.out.println("adjacent: " + adjacent);
                if(!visited.contains(adjacent)) {
                    stack.push(adjacent);
                }
            }
        }
    }

    public void bfs(String start) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(start); // Add to the Search
        while (!queue.isEmpty()) {
            String current = queue.remove();  // removes the first element from queue
            if (!visited.contains(current)) {
                visited.add(current);
                System.out.print(current + ", ");
            }
            for (String s: getAdjacents(current)) {
                if(!visited.contains(s)) {
                    queue.add(s);
                }
            }
        }
    }
}
