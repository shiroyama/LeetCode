package dfs_adjacent_matrix;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[][] adjacentMatrix = createAdjacentMatrix();
        // dfsStack(adjacentMatrix);
        // dfsRecursion(adjacentMatrix);
        // bfs(adjacentMatrix);
        bfs(adjacentMatrix, 3);
        bfsWithRoute(adjacentMatrix, 3);
    }

    private static void dfsStack(int[][] adjacentMatrix) {
        int[] visited = new int[adjacentMatrix.length];
        Arrays.fill(visited, -1);

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        while (!stack.isEmpty()) {
            Integer node = stack.pop();
            if (visited[node] != 1) {
                visited[node] = 1;
                System.out.println("node: " + node);
            }
            int[] column = adjacentMatrix[node];
            for (int i = column.length - 1; i >= 0; i--) {
                int adjacent = column[i];
                if (adjacent == 1 && visited[i] != 1) {
                    stack.push(i);
                }
            }
        }
    }

    private static void dfsRecursion(int[][] adjacentMatrix) {
        int[] visited = new int[adjacentMatrix.length];
        Arrays.fill(visited, -1);

        dfsRecursionGo(adjacentMatrix, visited, 0);
    }

    private static void dfsRecursionGo(int[][] adjacentMatrix, int[] visited, int vertex) {
        System.out.println("node: " + vertex);
        visited[vertex] = 1;
        int[] column = adjacentMatrix[vertex];
        for (int i = 0; i < column.length; i++) {
            int adjacent = column[i];
            if (adjacent == 1 && visited[i] != 1) {
                dfsRecursionGo(adjacentMatrix, visited, i);
            }
        }
    }

    private static void bfs(int[][] adjacentMatrix) {
        int[] visited = new int[adjacentMatrix.length];
        Arrays.fill(visited, -1);

        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(0);

        while (!queue.isEmpty()) {
            int node = queue.remove();
            if (visited[node] != 1) {
                visited[node] = 1;
                System.out.println("node: " + node);
            }

            int[] column = adjacentMatrix[node];
            for (int i = 0; i < column.length; i++) {
                if (column[i] == 1 && visited[i] != 1) {
                    queue.add(i);
                }
            }
        }
    }

    private static void bfs(int[][] adjacentMatrix, int target) {
        int[] visited = new int[adjacentMatrix.length];
        Arrays.fill(visited, -1);

        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(0);

        while (!queue.isEmpty()) {
            int node = queue.remove();
            if (visited[node] != 1) {
                visited[node] = 1;
                System.out.println("node: " + node);

                if (node == target) {
                    System.out.println("Target found!");
                    return;
                }
            }

            int[] column = adjacentMatrix[node];
            for (int i = 0; i < column.length; i++) {
                if (column[i] == 1 && visited[i] != 1) {
                    queue.add(i);
                }
            }
        }
    }

    private static void bfsWithRoute(int[][] adjacentMatrix, int target) {
        int[] visited = new int[adjacentMatrix.length];
        int[] route = new int[adjacentMatrix.length];
        Arrays.fill(visited, -1);
        Arrays.fill(route, -1);

        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        visited[0] = 1;

        while (!queue.isEmpty()) {
            int node = queue.remove();
            System.out.println("node: " + node);

            if (node == target) {
                System.out.println("Target found!");

                int start = node;
                List<Integer> resultList = new ArrayList<>();
                resultList.add(node);
                while (start != 0) {
                    int prev = route[start];
                    resultList.add(prev);
                    start = prev;
                }

                Collections.reverse(resultList);
                System.out.println("Route: " + resultList);
                return;
            }

            int[] column = adjacentMatrix[node];
            for (int i = 0; i < column.length; i++) {
                if (column[i] == 1 && visited[i] != 1) {
                    visited[i] = 1;
                    route[i] = node;
                    queue.add(i);
                }
            }
        }
    }

    private static int[][] createAdjacentMatrix() {
        int[][] adjacentMatrix = new int[][]{
                {0, 1, 0, 0, 1, 0},
                {1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0},
        };
        return adjacentMatrix;
    }
}
