#include <bits/stdc++.h>
using namespace std;
const int N = 999;
// initialize adjacency list
vector<int> adj[N];
// initialize indegree 0
vector<int> InDegree(N, 0);

// add edges method
void addEdges(int u, int v)
{
    adj[u].push_back(v);
    InDegree[v]++;
}

// topological method
bool CheckCycle(int n)
{
    // create a queue
    queue<int> q;
    // for(int i=0;i<n;i++){
    //     for(auto in:adj[i]){
    //         InDegree[in]++;
    //     }
    // }
    // push all the node which indegree is 0
    for (int i = 0; i < n; i++)
    {
        if (InDegree[i] == 0)
        {
            q.push(i);
        }
    }
    // this process is perform when the queue is empty
    // just initialize count variable
    int count = 0;
    while (!q.empty())
    {
        int node = q.front();
        q.pop();
        count++;
        cout << node << " ";
        // jara node ar sathe connected tader degree 1 kore komay dibo
        for (auto it : adj[node])
        {
            InDegree[it]--;
            if (InDegree[it] == 0)
            { // again check oi element ar moddhe kader indgree 0 tader ke
                // push it
                q.push(it);
            }
        }
    }
    if (count == n)
        return false;
    return true;
}
int main()
{
    // input vertex and edge
    int n, m;
    cin >> n >> m;
    // input edges
    for (int i = 0; i < m; i++)
    {
        int u, v;
        cin >> u >> v;
        addEdges(u, v);
    }
    // work the main funda topological sort
    bool isCycle;
    isCycle = CheckCycle(n);

    if (isCycle)
    {
        cout << "\nCycle Detect!!\n";
    }
    else
    {
        cout << "\nNo Cycle\n";
    }

    return 0;
}

/*
6 6
5 0
4 0
5 2
4 1
2 3
3 1
*/