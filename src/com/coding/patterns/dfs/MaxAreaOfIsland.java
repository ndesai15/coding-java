class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        int max = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                max = Math.max(max, dfs(j, i, grid));
            }
        }
        
        return max;
    }
    
    public int dfs(int x, int y, int[][] grid){
        if(x < 0 || y < 0 || x >= grid[0].length || y >= grid.length || grid[y][x] == 0){
            return 0;
        }
        
        grid[y][x] = 0;
        
        return dfs(x + 1, y, grid) + dfs(x - 1, y, grid) +
               dfs(x, y + 1, grid) + dfs(x, y - 1, grid) + 1;
        
    }
}
