class Solution {
    public int trap(int[] height) {
        // logic is not like largest rectangle in a histogram
        // for a element at index i, here we need to find globalmax on left and globalmax on right
        
        int[] leftGlobalMax = getLeftMax(height);
        int[] rightGlobalMax = getRightMax(height);
        
        int ans = 0;
        for(int i=0;i<height.length;i++){
            int leftMax = leftGlobalMax[i];
            int rightMax = rightGlobalMax[i];
            
            int minHeight = Math.min(leftMax, rightMax);
            int localAns = minHeight-height[i];
            
            ans += localAns;
        }
        
        return ans;
    }
    
    private int[] getLeftMax(int[] height){
        int[] ans = new int[height.length];
        
        ans[0] = height[0];
        for(int i=1;i<height.length;i++){
            ans[i] = Math.max(ans[i-1], height[i]);
        }
        return ans;
    }
    
    private int[] getRightMax(int[] height){
        int[] ans = new int[height.length];
        
        ans[height.length-1] = height[height.length-1];
        for(int i=height.length-2;i>=0;i--){
            ans[i] = Math.max(ans[i+1], height[i]);
        }
        return ans;
    }
}
