
import java.util.Scanner;
public class Adjacent_Matrix{
 
   
    public static void main(String[] args) {
     System.out.println("Hello Start Matrix problem!!");
     int a,b; 
        
     Scanner input=new Scanner(System.in);
    // System.out.println("Enter the node: ");
     int n=input.nextInt();
     int [][]array;
         array=new int[n+1][n+1];
    // System.out.println("Enter the Edges: ");
     int e=input.nextInt();

     for(int i=1;i<=e;i++)
     {
        a=input.nextInt();
        b=input.nextInt();
        addEdges(a,b,array);
     }  

     //System.out.println("Print The Adjacency Matrix: ");
      printMatrix(n,array);
     // Main Body
    }

    public static void addEdges(int a,int b,int [][]array){
     array[a][b]=1;
     array[b][a]=1;
    }
  
    public static void printMatrix(int node,int [][]array){
        int i,j;
        for(i=1;i<=node;i++){
            for(j=1;j<=node;j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }

}