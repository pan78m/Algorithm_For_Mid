import java.util.*;
public class Task_Three {
    private int V; // number of vertices
    private LinkedList<Integer>[] adjList; // adjacency list

    public Task_Three(int v) {
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
        Task_Three graph = new Task_Three(9);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);
        graph.addEdge(3, 7);
        graph.addEdge(4, 8 );
        graph.addEdge(5, 8 );
        graph.addEdge(6, 8 );
        graph.addEdge(7, 8 );
       
        System.out.println("DFS Traversal:");
        graph.DFS(1);

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