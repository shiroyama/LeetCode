package _200.number_of_islands;

import java.util.HashSet;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        int islands = new Solution().numIslands(grid);
        System.out.println(islands);
    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        // return solveWithDFS(grid);
        return solveWithUnionFind(grid);
    }

    int solveWithDFS(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int counter = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, row, col, i, j);
                    counter++;
                }
            }
        }
        return counter;
    }

    void dfs(char[][] grid, int row, int col, int r, int c) {
        grid[r][c] = '*';

        if (c - 1 >= 0 && grid[r][c - 1] == '1') {
            dfs(grid, row, col, r, c - 1);
        }
        if (c + 1 < col && grid[r][c + 1] == '1') {
            dfs(grid, row, col, r, c + 1);
        }
        if (r - 1 >= 0 && grid[r - 1][c] == '1') {
            dfs(grid, row, col, r - 1, c);
        }
        if (r + 1 < row && grid[r + 1][c] == '1') {
            dfs(grid, row, col, r + 1, c);
        }
    }

    int solveWithUnionFind(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        UF uf = new UF(grid);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    dfsUF(grid, row, col, i, j, uf);
                }
            }
        }

        Set<Integer> unique = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    int curr = i * col + j;
                    int root = uf.find(curr);
                    unique.add(root);
                }
            }
        }
        return unique.size();
    }

    void dfsUF(char[][] grid, int row, int col, int r, int c, UF uf) {
        int curr = r * col + c;
        if (c - 1 >= 0 && grid[r][c - 1] == '1') {
            int target = r * col + c - 1;
            uf.union(curr, target);
        }
        if (c + 1 < col && grid[r][c + 1] == '1') {
            int target = r * col + c + 1;
            uf.union(curr, target);
        }
        if (r - 1 >= 0 && grid[r - 1][c] == '1') {
            int target = (r - 1) * col + c;
            uf.union(curr, target);
        }
        if (r + 1 < row && grid[r + 1][c] == '1') {
            int target = (r + 1) * col + c;
            uf.union(curr, target);
        }
    }

    static class UF {
        final int[] bucket;
        final int[] rank;

        UF(char[][] grid) {
            int row = grid.length;
            int col = grid[0].length;
            bucket = new int[row * col];
            rank = new int[row * col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    int current = i * col + j;
                    bucket[current] = current;
                }
            }
        }

        int find(int node) {
            int parent = bucket[node];
            if (parent == node) return parent;
            bucket[parent] = find(parent);
            return bucket[parent];
        }

        boolean same(int node1, int node2) {
            int parent1 = find(node1);
            int parent2 = find(node2);
            return parent1 == parent2;
        }

        void union(int node1, int node2) {
            int parent1 = find(node1);
            int parent2 = find(node2);
            if (same(parent1, parent2)) return;
            if (rank[parent1] < rank[parent2]) {
                bucket[parent1] = parent2;
            } else if (rank[parent1] > rank[parent2]) {
                bucket[parent2] = parent1;
            } else {
                bucket[parent2] = parent1;
                rank[parent2] += 1;
            }
        }
    }
}