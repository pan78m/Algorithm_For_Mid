package Kruskal;

import java.util.Scanner;
import java.util.Vector;

public class CycleD {
    static final int N = 9999;
    static Vector<Integer> p = new Vector<Integer>(N);

    // every vertex is parent initialized
    static void MakeSet(int v) {
        p.set(v, v);
    }

    // Check parent same or not??
    static int FindSet(int v) {
        if (v == p.get(v))
            return v;
        return p.set(v, FindSet(p.get(v)));
    }

    // ALL parent are making same?
    static void UnionSet(int a, int b) {
        int x = FindSet(a);
        int y = FindSet(b);
        if (x != y)
            p.set(b, a);
    }

    public static void main(String[] args) {
        int Cycle = 0;
        Vector<Vector<Integer>> edges = new Vector<Vector<Integer>>();
        boolean flag = false;
        Scanner input = new Scanner(System.in);
        int vertex = input.nextInt();
        int e = input.nextInt();
        for (int i = 0; i < N; i++) {
            p.add(i);
        }
        for (int i = 0; i < e; i++) {
            Vector<Integer> ed = new Vector<Integer>();
        
            int u = input.nextInt();
            int v = input.nextInt();
            ed.add(u);
            ed.add(v);
            edges.add(ed);

        }

        for (Vector<Integer> i : edges) {

            int u = i.get(0);
            int v = i.get(1);
            int x = FindSet(u);
            int y = FindSet(v);
            if (x == y){
                flag = true;
            Cycle++;
            }else{
                UnionSet(x, y);
            }
                
        }

        if (flag) {
            System.out.println("Cycle: " + Cycle);
        } else {
            System.out.println("No Cycle!!");
        }
    }

}

