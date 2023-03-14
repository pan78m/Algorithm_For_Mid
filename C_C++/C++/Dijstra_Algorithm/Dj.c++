#include <bits/stdc++.h>
using namespace std;
const int INF = 1e9;
int main()
{
    int n, m;
    // cout << "Enter node and edges Numbers: \n";
    cin >> n >> m;
    // declear graph for vector one kind of linked list

    vector<int> dist(n + 1, INF);
    
    vector<vector<pair<int, int>>> g(n + 1);

    // enter the edges value
    for (int i = 0; i < m; i++)
    {
        int u, v, w;
        cin >> u >> v >> w;
        // add value for graph
        g[u].push_back({v, w});
        g[v].push_back({u, w});
    }

    // starting node  input here
    int s;
    // cout << "Enter the starting node: \n";
    cin >> s;

    dist[s] = 0;
    // declear set here
    set<pair<int, int>> st;

    // store all value in set
    // first time cost, then node
    // cost,vertex
    st.insert({0, s});

    while (!st.empty())
    {
        auto x = *(st.begin());
        st.erase(st.begin());

        for (auto i : g[x.second])
        {
            if (dist[i.first] > (dist[x.second] + i.second))
            {
                st.erase({dist[i.first], i.first});
                dist[i.first] = (dist[x.second] + i.second);
                st.insert({dist[i.first], i.first});
            }
        }
    }
    cout << "Output Here!!!\n";
    for (int i = 1; i <= n; i++)
    {
        cout << dist[i] << "  ";
    }

    return 0;
}

/*
6 8
1 2 2
1 3 4
2 4 7
3 5 3
4 6 1
5 4 2
5 6 5
2 3 1


*/


