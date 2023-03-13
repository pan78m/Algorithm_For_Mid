#include <bits/stdc++.h>
using namespace std;

const int N=999;
const int INF=1e9;
int vertex,e;
int cost;
vector <vector<int>> g[N];
vector <int> d(N);
vector <bool> visited(N);
void primMST(int st){

   for (int i=0;i<=vertex;i++)
         d[i]=INF;

         d[st]=0;

         //cost,Node
         set <vector<int>> s;

         s.insert({0,st});

         while(!s.empty()){
            auto x= *(s.begin());
            s.erase(x);
            int w=x[0];
            int u=x[1];

            visited[x[1]]=true;

            cost=cost+w;

            for(auto i: g[x[1]])
            {
                if(visited[i[0]])
                continue;
                if(d[i[0]]>i[1])
                {
                    s.erase({d[i[0]],i[1]});
                    d[i[0]]=i[1];
                    s.insert({d[i[0]],i[1]});
                }
            }
         }
 }
int main(){
  cin >> vertex >> e;
  for(int i=0;i<e;i++){

    int u,v,w;
    cin >>u >>v >>w;
    g[u].push_back({v,w});
    g[v].push_back({u,w});
  }
    
        primMST(2);

       cout<<cost;
    return 0;
}