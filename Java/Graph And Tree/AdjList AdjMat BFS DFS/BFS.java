
import java.util.Scanner;
class BFS{
    public static void main(String[] args) {
        System.out.println("BFS");
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the number: ");
        int a=input.nextInt();
        System.out.println("Print the value is: "+a);
    
        for(int i=0;i<a;i++){
            System.out.print("BFS! ");
        }
    }
}