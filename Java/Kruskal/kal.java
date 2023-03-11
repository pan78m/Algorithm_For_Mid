package Kruskal;

import java.util.*;

public class kal {

    static final int N = 9999;
    static Vector<Integer> p = new Vector<Integer>(N + 1);

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
        int cost = 0;
        Vector<Vector<Integer>> edges = new Vector<Vector<Integer>>();
        Scanner input = new Scanner(System.in);
        int vertex = input.nextInt();
        int e = input.nextInt();
        for (int i = 0; i <= N; i++) {
            p.add(i);
        }
        for (int i = 0; i < e; i++) {
            Vector<Integer> ed = new Vector<Integer>();
            int w = input.nextInt();
            int u = input.nextInt();
            int v = input.nextInt();
            ed.add(w);
            ed.add(u);
            ed.add(v);
            edges.add(ed);
        }
        Collections.sort(edges, new Comparator<Vector<Integer>>() {
            @Override
            public int compare(Vector<Integer> a, Vector<Integer> b) {
                return a.get(0) - b.get(0);
            }
        });

        for (Vector<Integer> i : edges) {
            int w = i.get(0);
            int u = i.get(1);
            int v = i.get(2);
            int x = FindSet(u);
            int y = FindSet(v);
            if (x == y) {
                continue;
            } else {
                cost += w;
                UnionSet(u, v);
            }
        }

        System.out.println("Minimum Cost: " + cost);
    }

}

