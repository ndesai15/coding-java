package datastrucutres.graphs;

import java.util.ArrayList;

public class Graph {
    private int vCount;  // number of vertices
    private int eCount;  // number of edges

    private ArrayList[] adjacents; // array of integer lists
    public Graph(int vCount) {
        this.vCount = vCount;
        this.eCount = 0;

        adjacents = new ArrayList[vCount];
        for(int i = 0; i < vCount; i++) {
            adjacents[i] = new ArrayList();
        }
    }

    public int getVertexCount() {
        return vCount;
    }

    public int getEdgeCount(){
        return eCount;
    }

    public void addEdge(int src, int dest) {
        adjacents[src].add(dest);
    }

    public Object[] adj(int src) {
        return adjacents[src].toArray();
    }

}
