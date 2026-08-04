class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
         int n = nums.length;
        int[] res = new int[n-k+1]; //extra nhi bnana size

        for (int i=0; i<=n-k; i++) {
            int max = nums[i];
            for (int j =i; j<i+k; j++) {    //k tk ki hi window size lena  hhh
                max = Math.max(max, nums[j]);  
            }
            res[i] = max;
        }
        return res;
    }
}