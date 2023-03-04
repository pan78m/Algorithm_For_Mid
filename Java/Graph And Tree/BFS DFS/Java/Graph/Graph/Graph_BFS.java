package Graph And Tree.BFS_DFS;
import java.util.ArrayList;

class BFS {
    private int Vertex;
    private ArrayList<Integer>v;
    private int [][]Arr;
    
    public BFS(int V) {
       Vertex=V;
       this.v=new ArrayList<Integer>();
       this.Arr=new int[Vertex][Vertex];
    }
    public void addVertex(int n){
        v.add(n);
    }

    public void addEdge(int s,int d){
        int i=v.indexOf(s);
        int j=v.indexOf(d);
        Arr[i][j]=1;
        Arr[j][i]=1;


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
    }
}
