#include <bits/stdc++.h>
using namespace std;

// Function to find the total number of spanning trees and minimum spanning trees
void findSpanningTreesAndMSTs(int **adjacencyMatrix, int **degreeMatrix, int n) {
    int **laplacianMatrix = new int*[n];
    for (int i = 0; i < n; i++) {
        laplacianMatrix[i] = new int[n];
        for (int j = 0; j < n; j++) {
            laplacianMatrix[i][j] = degreeMatrix[i][j] - adjacencyMatrix[i][j];
        }
    }

    // Finding the determinant of the sub-matrix M_11
    int det = laplacianMatrix[0][0];
    if (n > 1) {
        int **subMatrix = new int*[n-1];
        for (int i = 0; i < n-1; i++) {
            subMatrix[i] = new int[n-1];
            for (int j = 0; j < n-1; j++) {
                subMatrix[i][j] = laplacianMatrix[i+1][j+1];
            }
        }
        det = det * pow(-1, 2) * subMatrix[0][0];
    }

    // Finding the number of spanning trees
    int numSpanningTrees = det;
    cout << "Number of Spanning Trees is " << numSpanningTrees << endl;

    // Finding the minimum spanning tree(s)
    vector<int> minSpanningTrees;
    vector<pair<int, int>> edgeList;
    for (int i = 0; i < n; i++) {
        for (int j = i+1; j < n; j++) {
            if (adjacencyMatrix[i][j] > 0) {
                edgeList.push_back(make_pair(i, j));
            }
        }
    }
    for (int i = 0; i < edgeList.size(); i++) {
        int sumWeights = 0;
        for (int j = 0; j < n-1; j++) {
            int u = edgeList[i].first;
            int v = edgeList[i].second;
            if (j == u) {
                u = v;
            } else if (j > u) {
                j++;
            }
            sumWeights += adjacencyMatrix[u][j];
        }
        if (sumWeights == minSpanningTrees.empty() || sumWeights < minSpanningTrees[0]) {
            minSpanningTrees.clear();
            minSpanningTrees.push_back(sumWeights);
        } else if (sumWeights == minSpanningTrees[0]) {
            minSpanningTrees.push_back(sumWeights);
        }
    }

    // Finding the total number of minimum spanning trees
    int numMSTs = minSpanningTrees.size();
    cout << "Total number of MSTs is " << numMSTs << endl;
}

// Driver code
int main() {
    int n, m;
    cout << "Enter the number of vertices in the graph: ";
    cin >> n;
    cout << "Enter the number of edges in the graph: ";
    cin >> m;
    int **adjacencyMatrix = new int*[n];
    int **degreeMatrix = new int*[n];
    for (int i = 0; i < n; i++) {
        adjacencyMatrix[i] = new int[n];
        degreeMatrix[i] = new int[n];
          for (int j = 0; j < n; j++) {
        adjacencyMatrix[i][j] = 0;
        degreeMatrix[i][j] = 0;
    }
}
cout << "Enter the edges of the graph and their weights: " << endl;
for (int i = 0; i < m; i++) {
    int u, v, w;
    cin >> u >> v >> w;
    adjacencyMatrix[u-1][v-1] = w;
    adjacencyMatrix[v-1][u-1] = w;
    degreeMatrix[u-1][u-1]++;
    degreeMatrix[v-1][v-1]++;
}
findSpanningTreesAndMSTs(adjacencyMatrix, degreeMatrix, n);
return 0;

}