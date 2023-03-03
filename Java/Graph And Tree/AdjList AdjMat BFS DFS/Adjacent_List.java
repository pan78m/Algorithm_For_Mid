 
import java.util.Scanner;
 class Adjacent_List{
    public static void main(String[] args) {
       int a,b;
       Scanner input=new Scanner(System.in);
      System.out.println("Enter the node: ");
       int node=input.nextInt();
      int v=node;

    /*    vector as like as a array
       vector<int> array[v];
         A
     |       |
     B       C
   |   |    |  |  
   D   E    F   G
   |   |    |   |
         H  
         
*/ 
     System.out.println("Enter the Edges: ");
     int Edges=input.nextInt();

     for(int i=1;i<=e;i++)
     {
        a=input.nextInt();
        b=input.nextInt();
        addEdges(a,b,array);
     }  
     System.out.println("Print The Adjacency Matrix: ");
     printMatrix(node,array);

    }
 
   // Add Edges
   public static void addEdges(int a,int b,vector<int> array[]){
      array[a].push_back(b);
      array[b].push_back(a);
   }
   //Print List
   public static void printMatrix(int node,vector<int> array[]){
      int i,j;
      for(i=0;i<node;i++){
         System.out.pritln("Vertex"+ i +";");
          for(j=0;j<array[i].size();j++){
              System.out.print(array[i][j]+" ");
          }
          System.out.println();
      }
  }

 }