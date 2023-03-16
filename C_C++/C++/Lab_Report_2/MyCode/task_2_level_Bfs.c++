
// find the level
#include <bits/stdc++.h>
using namespace std;

const int N = 999;
vector<int> adj[N];
vector<int> vis(N);
vector<int> level(N);
void addEdge(int u, int v)
{
    adj[u].push_back(v);
    adj[v].push_back(u);
}
void printAdj(int n)
{
    for (int i = 0; i < n; i++)
    {
        cout << "Node->" << i << ": ";
        for (int it : adj[i])
        {
            cout << it << "->";
        }
        cout << "\n";
    }
}
void bfs(int source)
{
    // create pair first position is node and second position is level
    queue<pair<int, int>> q;
    // node,level
    q.push({source, 0});
    // starting node is visited;
    vis[source] = 1;
    while(!q.empty()){
        int node=q.front().first;
        int l=q.front().second;
        q.pop();
        level[node]=l;
        for(int it: adj[node]){
            if(vis[it]==0){
                q.push({it,l+1});
                vis[it]=1;
            }
        }
    }
}

int main()
{
    // add node and edge
    int n, m;
    cin >> n >> m;
    // add every edges
    for (int i = 0; i < m; i++)
    {
        int u, v;
        cin >> u >> v;
        addEdge(u, v);
    }
    // present adjacency list
    printAdj(n);
    bfs(1);
  // print the level for every node

  for(int i=0;i<=n;i++){
    cout<<"node: "<<i<<": "<<"level:"<<level[i]<<endl;
  }
    return 0;
}