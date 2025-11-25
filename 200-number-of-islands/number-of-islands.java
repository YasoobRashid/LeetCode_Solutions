class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0){
            return 0;
        }

        int count = 0;
        int rows = grid.length;
        int cols=grid[0].length;

        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        for (int i =0; i<rows;i++){
            for (int j = 0; j<cols;j++){
                if(grid[i][j]=='1'){
                    count++;
                    bfs(grid, i, j, directions);
                }
            }
        }
        return count;

    }

    void bfs(char[][] grid, int row , int col, int[][] directions){
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(row,col));

        grid[row][col] = 0; //mark as visited

        while(!q.isEmpty()){
            Pair p = q.poll();

            for(int[] d: directions){
                int nr = p.row + d[0];
                int nc = p.col + d[1];

                if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == '1') {
                    q.offer(new Pair(nr, nc));
                    grid[nr][nc] = '0'; 
                }
            }
        }
    }
}

class Pair{
    int row;
    int col;

    Pair(int r, int c){
        this.row=r;
        this.col=c;
    }
}