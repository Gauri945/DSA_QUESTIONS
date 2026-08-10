class Solution {

    public String LCS(String s1 , String s2){
        int m=s1.length();
        int n=s2.length();
        int dp[][] = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
          for(int j=1;j<=n;j++){
             if(s1.charAt(i-1)==s2.charAt(j-1)){
                dp[i][j]=1+dp[i-1][j-1];
             }else{
                dp[i][j]=Math.max(dp[i-1][j] , dp[i][j-1]);
             }
          }
        }
        StringBuilder sb = new StringBuilder();
        int i=m , j=n;
        while(i>0 && j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            }else if(dp[i-1][j]>dp[i][j-1]){
                i--;

            }else{
                j--;
            }
        }
        sb.reverse();
        return sb.toString();
    }





    public String shortestCommonSupersequence(String s1, String s2) {
        String lcs = LCS(s1,s2);
        StringBuilder sb = new StringBuilder();
        int i=0;
        int j=0;
        int k=0;
        while(k<lcs.length()){
            while(s1.charAt(i)!=lcs.charAt(k)){
                sb.append(s1.charAt(i));
                i++;
            }
             while(s2.charAt(j)!=lcs.charAt(k)){
                sb.append(s2.charAt(j));
                j++;
            }
            sb.append(lcs.charAt(k));
            k++;
            i++;
            j++;
        }

        while(i<s1.length()){
            sb.append(s1.charAt(i));
            i++;
        }
        while(j<s2.length()){
            sb.append(s2.charAt(j));
            j++;
        }
        return sb.toString();
    }
}