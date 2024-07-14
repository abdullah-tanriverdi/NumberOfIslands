import java.util.*;

class Solution {
    public int numIslands(char[][] grid) {
        // Eğer grid boşsa veya null ise 0 döndür
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rowNumber = grid.length;
        int columnNumber = grid[0].length;

        // Ziyaret edilen hücreleri takip etmek için bir boolean matrisi oluştur
        boolean[][] visited = new boolean[rowNumber][columnNumber];

        int islandCounter = 0;

        // Tüm hücreleri gez
        for (int row = 0; row < rowNumber; row++) {
            for (int column = 0; column < columnNumber; column++) {
                // Eğer hücre '1' ise ve ziyaret edilmediyse BFS başlat
                if (grid[row][column] == '1' && !visited[row][column]) {
                    bfs(grid, visited, row, column);
                    islandCounter++; // Ada sayacını artır
                }
            }
        }

        return islandCounter; // Toplam ada sayısını döndür
    }

    private void bfs(char[][] grid, boolean[][] visited, int row, int column) {
        int rowNumber = grid.length;
        int columnNumber = grid[0].length;

        // Hareket edilecek dört yön: aşağı, yukarı, sağ, sol
        int[][] directions = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };

        // BFS için bir kuyruk (queue) oluştur
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { row, column });
        visited[row][column] = true; // Bu hücreyi ziyaret edildi olarak işaretle

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentRow = current[0];
            int currentColumn = current[1];

            // Dört yönde hareket et
            for (int[] direction : directions) {
                int newRow = currentRow + direction[0];
                int newColumn = currentColumn + direction[1];

                // Eğer yeni hücre grid içinde ve '1' ise ve ziyaret edilmediyse kuyruk içine ekle
                if (newRow >= 0 && newRow < rowNumber && newColumn >= 0 && newColumn < columnNumber
                        && grid[newRow][newColumn] == '1' && !visited[newRow][newColumn]) {
                    queue.offer(new int[] { newRow, newColumn });
                    visited[newRow][newColumn] = true; // Bu hücreyi ziyaret edildi olarak işaretle
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

        // Testler
        System.out.println(solution.numIslands(grid1));  // Çıktı: 1
        System.out.println(solution.numIslands(grid2));  // Çıktı: 3
    }
}
