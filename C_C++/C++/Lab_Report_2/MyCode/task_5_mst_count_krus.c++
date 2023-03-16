/*
Write a program to find the number of distinct minimum spanning trees
 for a given weighted graph using Kruskal algorithm.

*/
#include<bits/stdc++.h>
using namespace std;

// using kruskal algorithm find how many distinct minimum
 // spanning trees for a given weighted graph

int kruskal(int V, vector<int> adj[], vector<int> &wt){
    int n = V;
    vector<bool> visited(n, false);
    vector<int> dist(n, INT_MAX);
    dist[0] = 0;
    for(int i = 1; i < n; i++){
        dist[i] = INT_MAX;
    }
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            if(adj[i][j] &&!visited[j]){
                visited[j] = true;
                dist[j] = min(dist[j], dist[i] + wt[j]);
            }
        }
    
        cout << dist[i] << " ";
    }
    return dist[n-1];

}

int main(){
    int V, E;
    cin >> V >> E;
    vector<int> adj[V];
   // vector<int> wt[V];
   int wt[V];
    for(int i = 0; i < E; i++){
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    cout << kruskal(V, adj, wt) << endl;
    return 0;
}
