class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int x : nums){
            sum += x;
        }
        // Odd sum cannot be divided equally
        if(sum % 2 != 0)
            return false;

        int target = sum / 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for(int num : nums){
            // Traverse backwards to avoid using same number twice
            for(int j = target; j >= num; j--){
                dp[j] = dp[j] || dp[j - num];
            }

        }

        return dp[target];
    }
}