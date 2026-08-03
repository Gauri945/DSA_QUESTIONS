class Solution {
    public long solve(int [] coin , int amt , int i, long [][] dp){
        if(i==coin.length){
            if(amt==0) return 0;
            else return Integer.MAX_VALUE;
        }
   if(dp[i][amt]!=-1) return dp[i][amt];
        //skip
       long skip= solve(coin,amt,i+1,dp);
        if(amt-coin[i]<0) return  dp[i][amt]=skip;

        //take
      long take=  1+solve(coin , amt-coin[i],i,dp);
        return  dp[i][amt]=Math.min(skip,take);
    }
    public int coinChange(int[] coins, int amount) {
       int n=coins.length;
        long dp[][] = new long[n][amount+1];


        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }


        int ans=(int) solve(coins,amount,0,dp);
        if(ans==Integer.MAX_VALUE) return -1;
        return ans;
    }
}