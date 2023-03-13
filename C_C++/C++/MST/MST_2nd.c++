 #include<bits/stdc++.h>
using namespace std;
const int N=9999;
vector <int>p(N);

void MakeSet(int v){
    p[v]=v;
}

int FindSet(int v){
    if(v==p[v])
        return v;
    return FindSet(p[v]);
}
  
void UnionSet(int a,int b){
    int x=FindSet(a);
    int y=FindSet(b);
    if(x!=y)
        p[b]=a;
}

int main(){
    int Cycle=0;
    int cost=0;
    int vertex,e;
    cin>>vertex>>e;
    for(int i=0;i<N;i++){
        MakeSet(i);
    }
    vector<vector<int>> edges;
    // cout<<"Enter the Edges two points: ";
    int u,v,w;
    for(int i=0;i<e;i++){
        cin>>w>>u>>v;
        edges.push_back({w,u,v});
    }
    
    sort(edges.begin(),edges.end());
    
    // Step 1: Calculate the minimum spanning tree
    for(auto i : edges){
        int w=i[0];
        int u=i[1];
        int v=i[2];
        int x=FindSet(u);
        int y=FindSet(v);
        if(x==y){
            continue;
            Cycle++; 
        }
        else{
            cost+=w;
            UnionSet(x,y);
        }
    }
    int minCost = cost;
    int secondMinCost = INT_MAX;
    // Step 2 and 3: Calculate the cost of each minimum spanning tree
    for(int i=0;i<edges.size();i++){
        // Remove the i-th edge from the graph
        int removedW = edges[i][0];
        int removedU = edges[i][1];
        int removedV = edges[i][2];
        p[removedV] = removedV;
        p[removedU] = removedU;
        int newCost = 0;
        int count = 0;
        for(int j=0;j<edges.size();j++){
            if(i == j)
                continue;
            int w = edges[j][0];
            int u = edges[j][1];
            int v = edges[j][2];
            int x = FindSet(u);
            int y = FindSet(v);
            if(x == y)
                continue;
            newCost += w;
            UnionSet(x,y);
            count++;
            if(count == vertex-1)
                break;
        }
        // Step 4: Find the second minimum cost among all the minimum spanning trees
        if(count == vertex-1 && newCost < secondMinCost && newCost > minCost)
            secondMinCost = newCost;
    }
    
        cout << "Second minimum cost: " << secondMinCost << endl;
    return 0;
}

/* 
5 8
75 1  3
51 3  4
19 2  4
95 3  2
42 2  5
31 5  4
9 1  2
66 3  5


        1
13   /  |   \7
    /28 | 2   \
  2 ----6-----3
  \27  /  \14  /
 39\ / 34   \  / 7
   4  ------- 5
       36

node  wight
6 10
1 2 13
1 3 7
1 6 28
2 6 27
2 4 39
3 6 2
3 5 7
4 5 36
4 6 34
5 6 14 


   #include <bits/stdc++.h>
using namespace std;

#define MAXN 100005

int parent[MAXN], r[MAXN];
vector<pair<int, pair<int, int>>> edges;

// Disjoint-set operations
void makeSet(int n) {
    for (int i = 0; i <= n; i++) {
        parent[i] = i;
        r[i] = 0;
    }
}

int findSet(int x) {
    if (parent[x] != x)
        parent[x] = findSet(parent[x]);
    return parent[x];
}

void unionSets(int x, int y) {
    int px = findSet(x), py = findSet(y);
    if (r[px] < r[py])
        parent[px] = py;
    else if (r[px] > r[py])
        parent[py] = px;
    else {
        parent[py] = px;
        r[px]++;
    }
}

// Kruskal's algorithm
int kruskal(int n) {
    makeSet(n);
    sort(edges.begin(), edges.end());
    int cost = 0;
    for (auto e : edges) {
        int u = e.second.first, v = e.second.second, w = e.first;
        if (findSet(u) != findSet(v)) {
            cost += w;
            unionSets(u, v);
        }
    }
    return cost;
}

// Find second best MST
int secondBestMST(int n) {
    int mst = kruskal(n); // find the MST first
    cout<<"1st MST: "+mst;
    int secondBest = INT_MAX;
    for (int i = 0; i < edges.size(); i++) {
        int u = edges[i].second.first, v = edges[i].second.second, w = edges[i].first;
        if (findSet(u) != findSet(v)) {
            int oldWeight = w;
            unionSets(u, v);
            int newWeight = kruskal(n);
            if (newWeight < secondBest && newWeight > mst) {
                secondBest = newWeight;
            }
            parent[u] = u; parent[v] = v; // undo union
            r[u] = r[v] = 0;
        }
    }
    return secondBest;
}

int main() {
    int n, m;
    cin >> n >> m; // number of vertices and edges
    for (int i = 0; i < m; i++) {
        int u, v, w;
        cin >> u >> v >> w;
        edges.push_back({w, {u, v}});
    }
    int secondBest = secondBestMST(n);

    cout << "The weight of the second-best minimum spanning tree is: " << secondBest << endl;
    return 0;
}
           













7 12
8 1 2
18 1 5
2 1 3
10 1 4
5 2 4
12 5 3
4 5 6
3 4 3
  4 7
  7 3
  7 6
  6 3




*/