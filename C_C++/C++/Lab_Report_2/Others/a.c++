#include <bits/stdc++.h>
using namespace std;

const int MAX = 100;

int adj[MAX][MAX], deg[MAX][MAX], L[MAX][MAX];
vector<pair<int, int>> edgeList;
int N, minMST;

void count(int arr[], int n, int mst, int &countMST)
{
    for (int i = 0; i < n; i++)
    {
        if (arr[i] == mst)
        {
            countMST++;
        }
    }
}

int det(int mat[MAX][MAX], int n)
{
    int D = 0;
    if (n == 1)
    {
        return mat[0][0];
    }
    int sign = 1;
    int submat[MAX][MAX];
    for (int k = 0; k < n; k++)
    {
        int i = 0, j = 0;
        for (int p = 0; p < n; p++)
        {
            for (int q = 0; q < n; q++)
            {
                if (p != 0 && q != k)
                {
                    submat[i][j++] = mat[p][q];
                    if (j == n - 1)
                    {
                        i++;
                        j = 0;
                    }
                }
            }
        }
        D += sign * mat[0][k] * det(submat, n - 1);
        sign = -sign;
    }
    return D;
}

int main()
{
    int n, m;
    // cout << "Enter the number of vertices: ";
    // cin >> n;
    // cout << "Enter the number of edges: ";
    // cin >> m;
    cin >> n >> m;
    for (int i = 0; i < m; i++)
    {
        int u, v, w;
        // cout << "Enter edge " << i + 1 << " and its weight: ";
        cin >> u >> v >> w;

        adj[u][v] = w;
        adj[v][u] = w;
        deg[u][u]++;
        deg[v][v]++;
        edgeList.push_back(make_pair(u, v));
        v--;
        u--;
    }
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            L[i][j] = deg[i][j] - adj[i][j];
        }
    }
    N = pow(-1, n - 1) * det(L, n - 1);
    cout << "Number of spanning trees: " << N << endl;
    vector<int> minList;
    for (int i = 0; i < edgeList.size(); i++)
    {
        int u = edgeList[i].first;
        int v = edgeList[i].second;
        int wt = adj[u][v];
        adj[u][v] = adj[v][u] = 0;
        for (int j = 0; j < n; j++)
        {
            deg[u][u] = deg[v][v] = 0;
            for (int k = 0; k < n; k++)
            {
                deg[j][j] += adj[j][k];
            }
        }
        for (int j = 0; j < n; j++)
        {
            for (int k = 0; k < n; k++)
            {
                L[j][k] = deg[j][k] - adj[j][k];
            }
        }
        int mst = pow(-1, n - 1) * det(L, n - 1);

        if (mst < minMST)
        {
            minMST = mst;
            minList.clear();
            minList.push_back(i + 1);
        }
        else if (mst == minMST)
        {
            minList.push_back(i + 1);
        }
        adj[u][v] = adj[v][u] = wt;
    }

    cout << "Minimum number of spanning trees: " << minMST << endl;
    cout << "Edges forming minimum spanning tree(s): ";
    for (int i = 0; i < minList.size(); i++)
    {
        cout << minList[i];
        if (i < minList.size() - 1)
        {
            cout << ", ";
        }
    }
    cout << endl;

    return 0;
}

/*
Time Complexity: O(n^2)
Space Complexity: O(n^2)
 Let us create following weighted graph
                   10
              0--------1
              |  \     |
             6|   5\   |15
              |      \ |
              2--------3
                  4
    sample input data
     4 5
     0 1 10
     0 3 5
     0 6 2
     1 3 15
     2 3 4

*/

/*
1         7      6
2         8      2
2         6      5
4         0      1
4         2      5
6         8      6
7         2      3
7         7      8
8         0      7
8         1      2
9         3      4
10        5      4
11        1      7
14        3      5
*/