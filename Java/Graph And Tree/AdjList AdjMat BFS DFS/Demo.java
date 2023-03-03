import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private int V; // number of vertices
    private LinkedList<Integer>[] adjList; // adjacency list

    // constructor
    public Graph(int V) {
        this.V = V;
        adjList = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // add an edge to the graph
    public void addEdge(int src, int dest) {
        adjList[src].add(dest);
    }

    // BFS traversal
    public void BFS(int start) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            System.out.print(curr + " ");

            for (int neighbor : adjList[curr]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }

    // DFS traversal
    public void DFS(int start) {
        boolean[] visited = new boolean[V];
        DFSUtil(start, visited);
    }

    private void DFSUtil(int curr, boolean[] visited) {
        visited[curr] = true;
        System.out.print(curr + " ");

        for (int neighbor : adjList[curr]) {
            if (!visited[neighbor]) {
                DFSUtil(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 7);

        System.out.print("BFS traversal: ");
        graph.BFS(0);

        System.out.println();

        System.out.print("DFS traversal: ");
        graph.DFS(0);
    }
}
///

// DFS traversal to find path between two nodes
public int[] DFSPath(int start, int end) {
    boolean[] visited = new boolean[V];
    int[] path = new int[V];
    int pathIndex = 0;
    DFSPathUtil(start, end, visited, path, pathIndex);
    return path;
}

private boolean DFSPathUtil(int curr, int end, boolean[] visited, int[] path, int pathIndex) {
    visited[curr] = true;
    path[pathIndex] = curr;

    if (curr == end) {
        return true;
    }

    for (int neighbor : adjList[curr]) {
        if (!visited[neighbor]) {
            if (DFSPathUtil(neighbor, end, visited, path, pathIndex + 1)) {
                return true;
            }
        }
    }

    return false;
}
//////
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    private int numVertices;
    private ArrayList<Character> vertices;
    private boolean[][] adjMatrix;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        this.vertices = new ArrayList<Character>();
        this.adjMatrix = new boolean[numVertices][numVertices];
    }

    public void addVertex(char vertex) {
        vertices.add(vertex);
    }

    public void addEdge(char source, char destination) {
        int srcIndex = vertices.indexOf(source);
        int destIndex = vertices.indexOf(destination);
        adjMatrix[srcIndex][destIndex] = true;
        adjMatrix[destIndex][srcIndex] = true;
    }

    public void printAdjMatrix() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjMatrix[i][j] ? "1 " : "0 ");
            }
            System.out.println();
        }
    }

    public void printAdjList() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print(vertices.get(i) + " -> ");
            for (int j = 0; j < numVertices; j++) {
                if (adjMatrix[i][j]) {
                    System.out.print(vertices.get(j) + " ");
                }
            }
            System.out.println();
        }
    }

    public void BFS(char startVertex) {
        boolean[] visited = new boolean[numVertices];
        Queue<Integer> queue = new LinkedList<Integer>();
        int startIndex = vertices.indexOf(startVertex);
        visited[startIndex] = true;
        queue.offer(startIndex);
        while (!queue.isEmpty()) {
            int vertexIndex = queue.poll();
            System.out.print(vertices.get(vertexIndex) + " ");
            for (int i = 0; i < numVertices; i++) {
                if (adjMatrix[vertexIndex][i] && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
        System.out.println();
    }

    public void DFS(char startVertex) {
        boolean[] visited = new boolean[numVertices];
        int startIndex = vertices.indexOf(startVertex);
        DFSHelper(startIndex, visited);
        System.out.println();
    }

    private void DFSHelper(int vertexIndex, boolean[] visited) {
        visited[vertexIndex] = true;
        System.out.print(vertices.get(vertexIndex) + " ");
        for (int i = 0; i < numVertices; i++) {
            if (adjMatrix[vertexIndex][i] && !visited[i]) {
                DFSHelper(i, visited);
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addVertex('G');
        graph.addVertex('H');
        graph.addEdge('A', 'B');
        graph.addEdge('A', 'C');
        graph.addEdge('B', 'D');
        graph.addEdge('B', 'E');
        graph.addEdge('C', 'F');
        graph.addEdge('C', 'G');
        graph.addEdge('G', 'H');

        System.out.println("Adjacency Matrix:");
        graph.printAdjMatrix();
        System.out.println();

        System.out.println("Adjacency List:");
        graph.printAdjList();
        System.out.println();

        System.out.println();
    }
}
/////////////////
import java.util.*;

public class Graph {
    private int V; // number of vertices
    private LinkedList<Integer>[] adjList; // adjacency list

    public Graph(int v) {
        V = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // add edge to the graph
    public void addEdge(int u, int v) {
        adjList[u].add(v);
        adjList[v].add(u);
    }

    // print the adjacency list
    public void printAdjList() {
        for (int i = 0; i < V; i++) {
            System.out.print(i + " -> ");
            for (int j : adjList[i]) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    // DFS traversal of the vertices reachable from v
    private void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        // recursively visit all adjacent vertices
        Iterator<Integer> iterator = adjList[v].listIterator();
        while (iterator.hasNext()) {
            int n = iterator.next();
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    // DFS traversal starting from vertex v
    public void DFS(int v) {
        boolean[] visited = new boolean[V];
        DFSUtil(v, visited);
    }

    // DFS to find path between two nodes
    private boolean DFSPathUtil(int v, int dest, boolean[] visited, ArrayList<Integer> path) {
        visited[v] = true;
        path.add(v);

        if (v == dest) {
            return true;
        }

        Iterator<Integer> iterator = adjList[v].listIterator();
        while (iterator.hasNext()) {
            int n = iterator.next();
            if (!visited[n]) {
                if (DFSPathUtil(n, dest, visited, path)) {
                    return true;
                }
            }
        }

        path.remove(path.size() - 1);
        return false;
    }

    // find path between two nodes using DFS
    public ArrayList<Integer> DFSPath(int src, int dest) {
        boolean[] visited = new boolean[V];
        ArrayList<Integer> path = new ArrayList<>();

        DFSPathUtil(src, dest, visited, path);

        return path;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(8);

        graph.addEdge(0, 1);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(0, 2);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);
        graph.addEdge(4, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);

        System.out.println("Adjacency List:");
        graph.printAdjList();

        System.out.println("DFS Traversal:");
        graph.DFS(0);

        System.out.println("DFS Path between 1 and 4:");
        ArrayList<Integer> path = graph.DFSPath(1, 4);
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            if (i != path.size() - 1) {
                System.out.print(" -> ");
            }
        }
    }
}

/*

import java.util.*;

public class Graph {
    private int V;   // number of vertices
    private LinkedList<Integer>[] adj; // adjacency list

    // constructor to create a graph with V vertices
    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; i++)
            adj[i] = new LinkedList<Integer>();
    }

    // function to add an edge between two vertices
    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // function to perform BFS traversal
    public void BFS(int s) {
        boolean[] visited = new boolean[V]; // mark all vertices as unvisited
        LinkedList<Integer> queue = new LinkedList<Integer>(); // create a queue for BFS
        visited[s] = true; // mark the source vertex as visited and enqueue it
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll(); // dequeue a vertex from the queue and print it
            System.out.print(s + " ");

            Iterator<Integer> i = adj[s].listIterator(); // get all adjacent vertices of the dequeued vertex
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) { // if an adjacent vertex is not visited, mark it as visited and enqueue it
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    // function to perform DFS traversal
    public void DFS(int v, boolean[] visited) {
        visited[v] = true; // mark the current vertex as visited and print it
        System.out.print(v + " ");

        Iterator<Integer> i = adj[v].listIterator(); // get all adjacent vertices of the current vertex
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) // if an adjacent vertex is not visited, recursively call DFS on it
                DFS(n, visited);
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(8); // create a graph with 8 vertices

        // add edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);
        graph.addEdge(4, 7);

        // print the adjacency list representation of the graph
        System.out.println("Adjacency List:");
        for (int i=0; i<graph.V; i++) {
            System.out.print(i + ": ");
            for (int j : graph.adj[i])
                System.out.print(j + " ");
            System.out.println();
        }

        // perform BFS traversal starting from vertex 0
        System.out.println("BFS Traversal:");
        graph.BFS(0);
        System.out.println();

        // perform DFS traversal starting from vertex 0
        System.out.println("DFS Traversal:");
        boolean[] visited = new boolean[graph.V];
        graph.DFS(0, visited);
        System.out.println();

        // find the path between vertices 1 and 4 using DFS
        System.out.println("Path between 1 and 4 using DFS:");
        visited = new boolean[graph.V];
        graph.DFS(1, visited);
        System.out.println();
    }
}
////
 * 
 */