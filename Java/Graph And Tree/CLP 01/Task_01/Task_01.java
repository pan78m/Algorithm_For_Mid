/*
 * 
A B C D E F G H
A 0 1 1 0 0 0 0 0
B 1 0 0 1 1 0 0 0
C 1 0 0 0 0 1 1 0
D 0 1 0 0 1 0 0 1
E 0 1 0 1 0 0 0 0
F 0 0 1 0 0 0 1 0
G 0 0 1 0 0 1 0 1
H 0 0 0 1 0 0 1 0

 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
import java.util.*;

public class Task_01 {
    private int[][] adjMatrix;
    private Map<Character, List<Character>> adjList;

    public Graph() {
        adjMatrix = new int[][] {
            {0, 1, 1, 0, 0, 0, 0, 0},
            {1, 0, 0, 1, 1, 0, 0, 0},
            {1, 0, 0, 0, 0, 1, 1, 0},
            {0, 1, 0, 0, 1, 0, 0, 1},
            {0, 1, 0, 1, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 1, 0},
            {0, 0, 1, 0, 0, 1, 0, 1},
            {0, 0, 0, 1, 0, 0, 1, 0}
        };
        adjList = new HashMap<>();
        adjList.put('A', Arrays.asList('B', 'C'));
        adjList.put('B', Arrays.asList('A', 'D', 'E'));
        adjList.put('C', Arrays.asList('A', 'F', 'G'));
        adjList.put('D', Arrays.asList('B', 'E', 'H'));
        adjList.put('E', Arrays.asList('B', 'D'));
        adjList.put('F', Arrays.asList('C', 'G'));
        adjList.put('G', Arrays.asList('C', 'F', 'H'));
        adjList.put('H', Arrays.asList('D', 'G'));
    }

    public void bfs(char start) {
        Set<Character> visited = new HashSet<>();
        Queue<Character> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            char vertex = queue.poll();
            System.out.print(vertex + " ");
            for (int i = 0; i < adjMatrix.length; i++) {
                if (adjMatrix[vertex - 'A'][i] == 1 && !visited.contains((char) (i + 'A'))) {
                    queue.add((char) (i + 'A'));
                    visited.add((char) (i + 'A'));
                }
            }
        }
    }

    public void dfs(char start) {
        dfs(start, new HashSet<>());
    }

    private void dfs(char start, Set<Character> visited) {
        if (visited.contains(start)) {
            return;
        }
        visited.add(start);
        System.out.print(start + " ");
        for (char neighbor : adjList.get(start)) {
            dfs(neighbor, visited);
        }
    }

    public List<Character> findPath(char start, char end) {
        return findPath(start, end, new HashSet<>());
    }

    private List<Character> findPath(char start, char end, Set<Character> visited) {
        if (start == end) {
            return Arrays.asList(start);
        }
        visited.add(start);
        for (char neighbor : adjList.get(start)) {
            if (!visited.contains(neighbor)) {
                List<Character> path = findPath(neighbor, end, visited);
                if (path != null) {
                    List<Character> result = new ArrayList<>();
                    result.add(start);
                    result.addAll(path);
                    return result;
                }
            }
