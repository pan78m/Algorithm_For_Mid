// minimum depth
#include <bits/stdc++.h>
using namespace std;
struct Node
{
    int data;
    Node *left, *right;
    Node(int value){
        value=data;
        left=right=NULL;
    }
};
int minDepth(Node *root){
    if(root==NULL)
    return 0;
    // create queue which type is node
    queue<Node *>q; 
    // push root node first
    q.push(root);
    // initialize depth is 1
    int depth=1;
    while(!q.empty()){
        int size=q.size();
      //  cout<<size<<endl;
        while(size-->0){
            Node *root=q.front();
            q.pop();
         //   cout<<"root: "<<root->data<<endl;
            if(root->left==NULL && root->right==NULL)
              // return depth find for leaf node
              return depth;
              // check left node element is exist if exist then push it
            if(root->left!=NULL)
            q.push(root->left);
            // check right node element is exist if exist then push it
            if(root->right!=NULL)
            q.push(root->right);
        }
        // increment depth after processing all nodes at the current level
        depth++;
    }
    // return final depth
    return depth;
 }
int main()
{   Node *root;
     root=new Node(3);
     root->left=new Node(9);
     root->right=new Node(20);
     root->right->left=new Node(15);
     root->right->right=new Node(9);
     cout<<"Minimum depth:\n";
     cout<<minDepth(root)<<endl;
    return 0;
}
/*
input graph
    3
   / \
  /   \
 9     20
      /  \
     /    \
    15     7
    
    output graph: 2

  */