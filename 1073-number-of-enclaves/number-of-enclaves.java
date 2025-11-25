class Solution {
    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        for (int i = 0; i < rows; i++) {

            if (grid[i][0] == 1) {
                bfs(grid, i, 0, directions);
            }

            if (grid[i][cols - 1] == 1) {
                bfs(grid, i, cols - 1, directions);
            }
        }

        for (int j = 0; j < cols; j++) {

            if (grid[0][j] == 1) {
                bfs(grid, 0, j, directions);
            }

            if (grid[rows - 1][j] == 1) {
                bfs(grid, rows - 1, j, directions);
            }
        }

        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    void bfs(int[][] grid, int r, int c, int[][] directions) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(r, c));
        grid[r][c] = 0;  

        while (!q.isEmpty()) {
            Pair p = q.poll();

            for (int[] d : directions) {
                int nr = p.row + d[0];
                int nc = p.col + d[1];

                if (nr >= 0 && nr < grid.length &&
                    nc >= 0 && nc < grid[0].length &&
                    grid[nr][nc] == 1) {

                    q.offer(new Pair(nr, nc));
                    grid[nr][nc] = 0;
                }
            }
        }
    }
}

class Pair {
    int row;
    int col;

    Pair(int r, int c) {
        this.row = r;
        this.col = c;
    }
}