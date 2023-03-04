
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class BFS {
    private int Vertex;
    private ArrayList<Integer> v;
    private boolean[][] Arr;

    public BFS(int V) {
        Vertex = V;
        this.v = new ArrayList<Integer>();
        this.Arr = new boolean[Vertex][Vertex];
    }

    public void addVertex(int n) {
        v.add(n);
    }

    public void addEdge(int s, int d) {
        int i = v.indexOf(s);
        int j = v.indexOf(d);
        Arr[i][j] = true;
        Arr[j][i] = true;

    }

    public void BFS(int source) {
        boolean[] visited = new boolean[Vertex];
        Queue<Integer> q = new LinkedList<>();
        int startIndex = v.indexOf(source);
        visited[startIndex] = true;
        q.offer(startIndex);
        while (!q.isEmpty()) {
            int VertexIndex = q.poll();
            System.out.print(v.get(VertexIndex)+" ");
            for (int i = 0; i < Vertex; i++) {
                if (Arr[VertexIndex][i]&& !visited[i]) {
                   visited[i]=true;
                   q.offer(i);
                }
            }
        }
    }
}

public class Graph_BFS {

    public static void main(String[] args) {
        BFS ob = new BFS(6);

        ob.addVertex(1);
        ob.addVertex(2);
        ob.addVertex(3);
        ob.addVertex(4);
        ob.addVertex(5);
        ob.addVertex(6);
        ob.addEdge(1, 2);
        ob.addEdge(1, 3);
        ob.addEdge(2, 4);
        ob.addEdge(2, 5);
        ob.addEdge(3, 5);
        ob.addEdge(3, 6);
        // BFS Starting point
        System.out.println("BFS Traversal: ");
        ob.BFS(1);
        System.out.println();
    }
}
