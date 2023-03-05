import java.util.Scanner;
import java.util.ArrayList;

class Graph {
    private int Vertex;
    private ArrayList<Character> v;
    private boolean[][] Arr;

    public Graph(int Vertex) {
        this.Vertex = Vertex;
        this.v = new ArrayList<Character>();
        this.Arr = new boolean[Vertex][Vertex];
    }

    public void addVertex(char n) {
        v.add(n);
    }

    public void addEdge(char s, char d) {
        int i = v.indexOf(s);
        int j = v.indexOf(d);
        Arr[i][j] = true;
        Arr[j][i] = true;
    }

    public void DFS(char s) {
        boolean[] visited = new boolean[Vertex];
        int startI = v.indexOf(s);
        DFSHelper(startI, visited);
        System.out.println();
    }

    private void DFSHelper(int st, boolean[] visited) {
        visited[st] = true;
        System.out.print(v.get(st) + " ");
        for (int i = 0; i < Vertex; i++) {
            if (Arr[st][i] && !visited[i]) {
                visited[i] = true;
                DFSHelper(i, visited);
            }
        }
    }
}

public class Graph_DFS {
    public static void main(String[] args) {
        System.out.println("Enter the Vertex: ");
        Scanner input = new Scanner(System.in);
        int Vertex = input.nextInt();
        Graph ob = new Graph(Vertex);
        // Add Vertex
        ob.addVertex('S');
        ob.addVertex('A');
        ob.addVertex('B');
        ob.addVertex('C');
        ob.addVertex('D');
        ob.addVertex('E');
        ob.addVertex('F');
        ob.addVertex('G');
        // Add Edges
        ob.addEdge('S', 'A');
        ob.addEdge('S', 'B');
        ob.addEdge('S', 'C');
        ob.addEdge('A', 'D');
        ob.addEdge('B', 'E');
        ob.addEdge('C', 'F');
        ob.addEdge('D', 'G');
        ob.addEdge('E', 'G');
        ob.addEdge('F', 'G');

        // DFS Traversel
        System.out.println("DFS Traversal: ");
        ob.DFS('S');

    }
}
