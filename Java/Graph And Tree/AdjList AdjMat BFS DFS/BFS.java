
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class BFS {
    private int NumberOFNodes;
    private ArrayList<Character> verties;
    private boolean[][] adjMatrix;

    public BFS(int node) {
        NumberOFNodes = node;
        this.verties = new ArrayList<Character>();
        this.adjMatrix = new boolean[node][node];

    }

    public void addVertex(char a) {
        verties.add(a);
    }

    public void addEdge(char a, char b) {
        int i = verties.indexOf(a);
        int j = verties.indexOf(b);
        adjMatrix[i][j] = true;
        adjMatrix[j][i] = true;
    }

    // Print adjacency matrix
    public void printAdjMatrix() {
        for (int i = 0; i < NumberOFNodes; i++) {

            for (int j = 0; j < NumberOFNodes; j++) {

                System.out.print(adjMatrix[i][j] ? "1 " : "0 ");
            }
            System.out.println();
        }
    }

    public void printAdjList() {
        for (int i = 0; i < NumberOFNodes; i++) {
            System.out.print(verties.get(i) + " -> ");
            for (int j = 0; j < NumberOFNodes; j++) {
                if (adjMatrix[i][j]) {
                    System.out.print(verties.get(j) + " ");
                }
            }
            System.out.println();
        }
    }

    public void bfs(char start) {
        boolean[] visited = new boolean[NumberOFNodes];
        Queue<Integer> q = new LinkedList<Integer>();
        int i = verties.indexOf(start);
        visited[i]=true;
        q.offer(i);
        while(!q.isEmpty()){
            int vertexIndex=q.poll();
            System.out.print(verties.get(vertexIndex)+" ");
            for (int m = 0; m <NumberOFNodes; m++) {
                if (adjMatrix[vertexIndex][m] && !visited[m]) {
                    visited[m] = true;
                    q.offer(m);
                }
            }
        }
    }

    public void DFS(char start) {
        boolean[] visited = new boolean[NumberOFNodes];
        Queue<Integer> q = new LinkedList<Integer>();
        int i = verties.indexOf(start);
        DFSHelper(i, visited);
        System.out.println();

    }
    public void DFSHelper(int a,boolean[] v){
        v[a] = true;
        System.out.print(verties.get(a) + " ");
        for (int i = 0; i <NumberOFNodes; i++) {
            if (adjMatrix[a][i] && !v[i]) {
                DFSHelper(i, v);
            }
        }
    }

    public static void main(String[] args) {
        BFS graph = new BFS(8);

        // Add Vertex
        graph.addVertex('S');
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addVertex('G');

        // Add Edges
        graph.addEdge('S', 'A');
        graph.addEdge('S', 'B');
        graph.addEdge('S', 'C');
        graph.addEdge('A', 'D');
        graph.addEdge('D', 'G');
        graph.addEdge('B', 'E');
        graph.addEdge('C', 'F');
        graph.addEdge('F', 'G');
        graph.addEdge('E', 'G');

        System.out.println("Adjacency Matrix: ");
        graph.printAdjMatrix();
        System.out.println();

        System.out.println("Adjacency List: ");
        graph.printAdjList();
        System.out.println();

        System.out.println("BFS: ");
        graph.bfs('S');
        System.out.println();

        System.out.println("DFS: ");
        graph.DFS('S');
        System.out.println();

    }
}