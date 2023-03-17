#include <bits/stdc++.h>
using namespace std;
struct Edge {
    int u, v, w;
    Edge(int uu, int vv, int ww) : u(uu), v(vv), w(ww) {}
};

bool cmp(Edge& a, Edge& b) {
    return a.w < b.w;
}

vector<Edge> kruskal(vector<Edge>& edges, int n) {
    vector<Edge> mst;
    vector<int> parent(n);
    for (int i = 0; i < n; i++) {
        parent[i] = i;
    }
    sort(edges.begin(), edges.end(), cmp);
    for (Edge e : edges) {
        int pu = parent[e.u];
        int pv = parent[e.v];
        if (pu != pv) {
            mst.push_back(e);
            for (int i = 0; i < n; i++) {
                if (parent[i] == pv) {
                    parent[i] = pu;
                }
            }
        }
    }
    return mst;
}

int count_msts(vector<Edge>& edges, int n) {
    int mst_weight = 0;
    vector<Edge> mst = kruskal(edges, n);
    for (Edge e : mst) {
        mst_weight += e.w;
    }
    int count = 0;
    for (int i = 0; i < mst.size(); i++) {
        vector<Edge> new_edges = edges;
        new_edges.erase(new_edges.begin() + i);
        vector<Edge> new_mst = kruskal(new_edges, n);
        int new_weight = 0;
        for (Edge e : new_mst) {
            new_weight += e.w;
        }
        if (new_weight == mst_weight) {
            count++;
        }
    }
    return count;
}

int main() {
    int n = 4;
    vector<Edge> edges;
    edges.push_back(Edge(0, 1, 2));
    edges.push_back(Edge(0, 2, 2));
    edges.push_back(Edge(1, 2, 1));
    edges.push_back(Edge(1, 3, 3));
    edges.push_back(Edge(2, 3, 5));
    int count = count_msts(edges, n);
    cout << "Number of distinct minimum spanning trees: " << count << endl;
    return 0;
}