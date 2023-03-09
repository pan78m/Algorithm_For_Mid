#include<bits/stdc++.h>
using namespace std;


const int N=999;
int v,e;
vector<vector<int>>g[N];

int main(){
 cin>>v>>e;
 for(int i=0;i<e;i++){
     int u,v,w;
     cin>>u>>v>>w;
     g[u].push_back({v,w});
     g.[v].push_back({u,w});
 }


    primMST(0);
    cout<<cost;
    return 0;
}
/*
#include<bits/stdc++.h>
using namespace std;

const int N = 999;
const int INF = 1e9;
int n,m;
int cost;
vector <vector<int>> g[N];
vector <bool> vis(N);

vector <int> dist(N);

void primMST(int source)
{
    for(int i =0;i<=n;i++)
        dist[i] = INF;
    
    dist[source] = 0;

    set <vector<int>> s;

    // cost, vertex
    s.insert({0,source});

    while (!s.empty())
    {
        auto x = *(s.begin());
        s.erase(x);

        int w = x[0];
        int u = x[1]; 

        vis[x[1]] = true;
        cost = cost + w;

        for (auto i: g[x[1]])
        {
            if(vis[i[0]])
            continue;
            if(dist[i[0]]>i[1]) 
            {
                s.erase({dist[i[0]],i[0]});
                dist[i[0]] = i[1];
                s.insert({dist[i[0]],i[0]});
            }
        }
    }

}


int main()
{
    cin >> n >> m;

    for(int i=0;i<m;i++)
    {
        int u,v,w;
        cin >> u>>v >>w;

        g[u].push_back({v,w});
        g[v].push_back({u,w});
        
    }

    primMST(1);

    cout << cost;
}

cost: 0+5+10+2
*/