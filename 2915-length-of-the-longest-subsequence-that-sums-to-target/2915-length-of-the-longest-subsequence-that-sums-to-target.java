class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n=nums.size();
        int dp[][] = new int[n][target+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

       int ans= solve(nums,target , 0, dp);
        return ans<0?-1:ans;
    }

    public static int solve(List<Integer> nums, int tt , int i , int [][]dp){
        if(i==nums.size()){
            if(tt==0){
                return 0;

            }
            return -10000;
        }

        if(dp[i][tt]!=-1){
            return dp[i][tt];
        }

        int take=-1000;
        if(nums.get(i)<=tt){
            take = 1+ solve(nums , tt-nums.get(i) , i+1 , dp);
        }
        int skip = solve(nums, tt , i+1 , dp);

        return dp[i][tt]=Math.max(skip,take);
    }
}