#include<bits/stdc++.h>
using namespace std;

const int N = 999;
const int INF = 1e9;

class Edge {
public:
    int from, to, weight;
    Edge(int from, int to, int weight) : from(from), to(to), weight(weight) {}
};

class Graph {
public:
    int V;
    vector<Edge> g;

    Graph(int V) : V(V) {}

    void addEdge(int u, int v, int w) {
        g.push_back(Edge(u, v, w));
    }
};

vector <vector<int>> g[N];
vector <bool> vis(N);
vector <int> dist(N);
int cost,n,m;
int primMST(int source) {
    for (int i = 0; i <= n; i++)
        dist[i] = INF;

    dist[source] = 0;

    set <vector<int>> s;

    // cost, vertex
    s.insert({0, source});

    while (!s.empty()) {
        auto x = *(s.begin());
        s.erase(x);

        int w = x[0];
        int u = x[1];

        vis[x[1]] = true;
        cost = cost + w;

        for (auto i : g[x[1]]) {
            if (vis[i[0]])
                continue;
            if (dist[i[0]] > i[1]) {
                s.erase({dist[i[0]], i[0]});
                dist[i[0]] = i[1];
                s.insert({dist[i[0]], i[0]});
            }
        }
    }
    return cost;
}

// Count the total number of minimum spanning trees
int countMST(Graph mst) {
    int count = 1;
    for (int i = 0; i < mst.g.size(); i += 2) {
        Edge removed = mst.g[i];
        mst.g.erase(mst.g.begin() + i, mst.g.begin() + i + 2);
        Graph temp(mst.V);
        for (int j = 0; j < mst.g.size(); j++) {
            temp.addEdge(mst.g[j].from, mst.g[j].to, mst.g[j].weight);
        }
        int weight1 = primMST(2);
        if (weight1 == mst.g.size() / 2) {
            count++;
        }
        mst.g.insert(mst.g.begin() + i, removed);
    }
    return count;
}

int main() {
   
    cin >> n >> m;

    for (int i = 0; i < m; i++) {
        int u, v, w;
        cin >> u >> v >> w;

        g[u].push_back({v, w});
        g[v].push_back({u, w});
    }

    int Mst = primMST(2);
    cout << cost;

    Graph mst(n);
    for (auto edge : g[2]) {
        mst.addEdge(2, edge[0], edge[1]);
    }
    int total = countMST(mst);
    cout << "\ntotal Mst: " << total << endl;

    return 0;
}

/*
formal input
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


6 10
1 2 2
1 3 7
1 6 2
2 6 7
2 4 3
3 6 2
3 5 7
4 5 3
4 6 1
5 6 1

*/