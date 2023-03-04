
import java.util.Scanner;
import java.util.ArrayList;

class Adjacent_List {

   private int V;
   private int E;
   private ArrayList<Integer> vertices;
   private int[][] Arr;

   public Adjacent_List(int V) {
      this.V = V;
      this.vertices = new ArrayList<Integer>();
      this.Arr = new int[V][V];
   }

   public void addVertex(int n) {
      vertices.add(n);
   }

   public void addEdge(int s, int d) {
      int i = vertices.indexOf(s);
      int j = vertices.indexOf(d);
      Arr[i][j] = 1;
      Arr[j][i] = 1;
   }

   public void PrintList() {
      for (int i = 0; i < V; i++) {
         System.out.print("Vertex " + vertices.get(i) + ":");
         for (int j = 0; j < V; j++) {
            if (Arr[i][j] == 1 || Arr[j][i] == 1) {
               System.out.print(vertices.get(j) + "->");
            }
         }
         System.out.println();
      }
   }
/* 
   public void PrintArr() {
      for (int i = 0; i < V; i++) {
         for (int j = 0; j < V; j++) {
            System.out.print(Arr[i][j] + " ");
         }
         System.out.println();
      }
   }
*/
   public static void main(String[] args) {
      int a, b;
      Scanner input = new Scanner(System.in);
      System.out.println("Enter the Vertex: ");
      int vertex = input.nextInt();
      System.out.println("Enter the Edges: ");
      int Edges = input.nextInt();
      Adjacent_List ob = new Adjacent_List(vertex);
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
      System.out.println("Adjacency List: ");

      ob.PrintList();
      System.out.println();
/* 
      System.out.println("Adjacency Matrix: ");
      ob.PrintArr();
      System.out.println();
*/
      /*
       * Graph
       * A
       * | |
       * B C
       * | | | |
       * D E F G
       * | | | |
       * H
       */
   }

}