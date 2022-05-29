/*
      Leetcode link  :  https://leetcode.com/problems/max-area-of-island/
	  Time Complexity:  O(M+N)
	  Space Complexity: O(1)
*/
class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        
        int max = 0;
        int numRows = grid.length;
        int numCols = grid[0].length;
        
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < numCols; j++){
                max = Math.max(max, dfs(j, i, grid));
            }
        }
        
        return max;
    }
    
    public int dfs(int x, int y, int[][] grid){
        int numRows = grid.length;
        int numCols = grid[0].length;
        if(x < 0 || y < 0 || x >= numCols || y >= numRows || grid[y][x] == 0){
            return 0;
        }
        
        grid[y][x] = 0;
        
        return dfs(x + 1, y, grid) + dfs(x - 1, y, grid) +
               dfs(x, y + 1, grid) + dfs(x, y - 1, grid) + 1;
        
    }
}
