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
    p[y]=x;
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
  //  cout<<"Enter the Edges two points: ";
   int u,v,w;
   for(int i=0;i<e;i++){
   // int u,v,w;
    cin>>w>>u>>v;
    edges.push_back({w,u,v});
   }
    
    sort(edges.begin(),edges.end());
    
    

   for(auto i : edges)
   { 
    int w=i[0];
     int u=i[1];
     int v=i[2];
     int x=FindSet(u);
     int y=FindSet(v);
     cout<<"Wight: "<<w<<" source-"<<u<<" Destination-"<<v<<endl;
     if(x==y)
     {
      
      continue;
      Cycle++; 
     }
   
     else
        cost+=w;
        UnionSet(x,y);  
   }

//    if(flag)
// cout << "Cycle : "<<Cycle;
//    else
// cout << "No Cycles";
      
      cout<<"\nMinimum Cost: "<<cost;


 }
/*
9 14
4 0 1
8 0 7
8 1 2
11 1 7
7 2 3
2 2 8
4 2 5
7 7 8
1 7 6
6 8 6
2 6 5
14 3 5 
9 3 4
10 4 5














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
*/