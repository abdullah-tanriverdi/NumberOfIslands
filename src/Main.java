//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;

class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rowNumber = grid.length;
        int columnNumber = grid[0].length;

        boolean[][] visited = new boolean[rowNumber][columnNumber];

        int islandCounter = 0;

        for (int row = 0; row < rowNumber; row++) {
            for (int column = 0; column < columnNumber; column++) {
                if (grid[row][column] == '1' && !visited[row][column]) {
                    bfs(grid, visited, row, column);
                    islandCounter++;
                }
            }
        }

        return islandCounter;
    }

    private void bfs(char[][] grid, boolean[][] visited, int row, int column) {
        int rowNumber = grid.length;
        int columnNumber = grid[0].length;

        int[][] directions = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { row, column });
        visited[row][column] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentRow = current[0];
            int currentColumn = current[1];

            for (int[] direction : directions) {
                int newRow = currentRow + direction[0];
                int newColumn = currentColumn + direction[1];

                if (newRow >= 0 && newRow < rowNumber && newColumn >= 0 && newColumn < columnNumber
                        && grid[newRow][newColumn] == '1' && !visited[newRow][newColumn]) {
                    queue.offer(new int[] { newRow, newColumn });
                    visited[newRow][newColumn] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println(solution.numIslands(grid1));  // Çıktı: 1
        System.out.println(solution.numIslands(grid2));  // Çıktı: 3
    }
}
