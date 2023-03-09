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
     vector<vector<int>>edges;
    bool flag=false;
   int v,e;
   cin>>v>>e;
   for(int i=0;i<N;i++){
    MakeSet(i);

   }
  //  cout<<"Enter the Edges two points: ";
   for(int i=0;i<e;i++){
    int u,v;
    cin>>u>>v;
    edges.push_back({u,v});
   }

   for(auto i : edges)
   {
     int u=i[0];
     int v=i[1];
     int x=FindSet(u);
     int y=FindSet(v);
     if(x==y)
     {
       flag=true;
     Cycle++; 
     }
   
     else
     
        UnionSet(x,y);  
   }

   if(flag)
cout << "Cycle : "<<Cycle;
   else
cout << "No Cycles";
 }
/*
9 14
0 1
0 7
1 2
1 7
2 3
2 8
2 5
7 8
7 6
8 6
6 5
3 5 
3 4
4 5

*/