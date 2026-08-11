class Solution {
    public boolean canPartition(int[] arr) {
        int sum=0;
        for(int a:arr){
            sum+=a;
        }
       
        if(sum%2!=0) return false;
         int tar=sum/2;
       Boolean dp[][] = new Boolean[arr.length][tar+1];
        return solve(arr,0,0,tar,dp);
    }
    public static boolean solve(int []arr , int idx , int sum , int target,Boolean [][]dp){
       
            if(sum==target) return true;
            
        
        if(idx == arr.length || sum > target) {
            return false;
        }


        if(dp[idx][sum] != null) {
            return dp[idx][sum];
        }


        boolean take = solve(arr,idx+1,sum+arr[idx] ,target,dp);
        boolean not = solve(arr, idx+1 , sum , target,dp);
        return dp[idx][sum] =take || not;
    }
}