package com.coding.patterns.graphs;

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
public class CloneGraph {
    public Node cloneGraph(Node node) {
        // If the start node is null then we cannot do any cloning
        if (node == null) return node;

        /*
         * map: Map the original node reference to its clone
         * queue: Our queue for Breadth First Search
         */

        Queue<Node> queue = new LinkedList<>();
        Map<Node, Node> map = new HashMap<>();//
        // Add the node to the queue. Give the start node a clone in the vertexMap
        Node head = new Node(node.val, new ArrayList<>());//
        map.put(node, head);
        queue.add(node);

        /*
         * The breadth first search continues until we have processed all vertices in
         * the original graph. We know this is done when the queue is empty
         */
        while (!queue.isEmpty()) {
            // We grab a node. We will express all of the edges coming off of this node.
            Node tmp = queue.remove();

            // Iterate over all adjacents
            for (Node n : tmp.neighbors) {
                // Has this neighbor been given a clone?
                if (!map.containsKey(n)) {
                    /*
                     * No? Give it a mapping and add the original neighbor to the search queue so we
                     * can express ITS edges later
                     */
                    map.put(n, new Node(n.val, new ArrayList<>()));
                    queue.add(n);
                }
                /*
                 * Draw the edge from currVertex's clone to neighbor's clone. Do you see how our
                 * hashtable makes this quick access possible?
                 */
                map.get(tmp).neighbors.add(map.get(n));
            }
        }
        return head;
    }
}
