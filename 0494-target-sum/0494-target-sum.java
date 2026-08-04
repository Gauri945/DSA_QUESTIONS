class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        int dp[][] = new int[n][4001];
         for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return ways(0,nums,target,dp);
    }

    public int ways(int idx , int [] arr , int target, int[][] dp){
        if(idx==arr.length){
            if(target==0) return 1;
            else return 0;
        }
        if(dp[idx][target+2000]!=-1){
            return dp[idx][target+2000];
        }

        int add = ways(idx+1,arr,target-arr[idx],dp);
        int sub = ways(idx+1,arr,target+arr[idx],dp);
        return dp[idx][target+2000] = add+sub;
    }
}