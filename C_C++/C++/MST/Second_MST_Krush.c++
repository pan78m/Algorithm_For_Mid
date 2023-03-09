#include<bits/stdc++.h>
using namespace std;
const int N=9999;
vector<int>p(N);

void MakeSet(int v){
    p[v]=v;
}

int FindSet(int v){
    if(v==p[v])
        return v;
    return p[v]=FindSet(p[v]);
}

void UnionSet(int a,int b){
    int x=FindSet(a);
    int y=FindSet(b);
    if(x!=y)
        p[b]=a;
}

// function to find the second minimum spanning tree
int secondMST(vector<vector<int>>& edges, int n) {
    int mincost2 = INT_MAX;
    int mincost = kruskal(edges, n);
    for (int i = 0; i < mst_edges.size(); i++) {
        int u = mst_edges[i][1];
        int v = mst_edges[i][2];
        int w = mst_edges[i][0];
        vector<vector<int>> temp_edges;
        for (int j = 0; j < edges.size(); j++) {
            if (edges[j][1] == u && edges[j][2] == v && edges[j][0] == w) {
                continue;
            }
            temp_edges.push_back(edges[j]);
        }
        int cost = kruskal(temp_edges, n);
        if (cost < mincost2 && cost > mincost) {
            mincost2 = cost;
        }
    }
    return mincost2;
}
int main(){
    int Cycle=0;
    int cost=0;
    vector<vector<int>>edges;

    int vertex,e;
    cin>>vertex>>e;
    for(int i=0;i<N;i++){
        MakeSet(i);
    }

    int u,v,w;
    for(int i=0;i<e;i++){
        cin>>w>>u>>v;
        edges.push_back({w,u,v});
    }

    sort(edges.begin(),edges.end());

    // Find the minimum spanning tree
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
    cout<<"\nMinimum Cost: "<<cost<<endl;

    

    cout<<"Second minimum cost: "<<second_cost<<endl;
}
