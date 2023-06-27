class Solution {
    public int climbStairs(int n) {
        // Base cases
        if (n == 0 || n == 1) {
            return 1;
        }
        
        // Initialize the array to store distinct ways
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        // Calculate distinct ways bottom-up
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        // Return the result
        return dp[n];
    }
}