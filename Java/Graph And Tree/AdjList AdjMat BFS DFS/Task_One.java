import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Task_One {

    private int numVertices;
    private ArrayList<Character> vertices;
    private boolean[][] adjMatrix;

    public Task_One(int numVertices) {
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
        Task_One graph = new Task_One(8);
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
        graph.addEdge('D', 'H');
        graph.addEdge('E', 'H');
        graph.addEdge('F', 'H');
        graph.addEdge('G', 'H');

        System.out.println("Adjacency Matrix:");
        graph.printAdjMatrix();
        System.out.println();

        System.out.println("Adjacency List:");
        graph.printAdjList();
        System.out.println();
        System.out.println("BFS:");
        graph.BFS('A');
        
        System.out.println();
        
        System.out.println("DFS:");
        graph.DFS('A');
        System.out.println();
    }
}














