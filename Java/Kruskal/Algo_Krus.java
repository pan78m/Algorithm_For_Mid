package Kruskal;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

public class Algo_Krus {

    static final int N = 9999;
   static  Vector<Integer> p = new Vector<Integer>(N);

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
            p.set(y, x);

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
            MakeSet(i);
        }
        for (int i = 0; i < e; i++) {
            Vector<Integer> ed = new Vector<Integer>();
             int w = input.nextInt();
            int u = input.nextInt();
            int v = input.nextInt();
         
            ed.add(u);
            ed.add(v);
            ed.add(w);
            edges.add(ed);
            /*
             * 
             * 
             * Star16001Hash
8 9
1 2 5
2 3 6
4 3 2
1 4 9
3 5 5
5 6 10
6 7 7
7 8 1
8 5 1


8 9
5 1 2 
6 2 3 
2 4 3 
9 1 4 
5 3 5 
10 5 6 
7 6 7 
1 7 8 
1 8 5 
             */

        }


        for (int i = 0; i < e - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < e; j++) {
                if (edges.get(j).get(0) < edges.get(minIndex).get(0)) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Collections.swap(edges, i, minIndex);
            }
        }
        
       /* Collections.sort(edges, new Comparator<Vector<Integer>>() {
            @Override
            public int compare(Vector<Integer> w, Vector<Integer> j) {
                System.out.println(w.get(0)-j.get(0));
              return w.get(0) - j.get(0);
                
            }
        });
         */
       int cost = 0;
        for (Vector<Integer> i : edges) {
            int w = i.get(0);
            int u = i.get(1);
            int v = i.get(2);
            int x = FindSet(u);
            int y = FindSet(v);
            if (x == y) {
                Cycle++;
                flag = true;
                continue;
            } else {
                cost =cost+w;
                System.out.println("Wight: "+ w +" Cost :"+cost);
                UnionSet(x, y);

            }

        }

        if (flag) {
            System.out.println("Cycle: " + Cycle);
        } else {
            System.out.println("No Cycle!!");
        }
        System.out.println("Minimum Cost: " + cost);
    }

}
