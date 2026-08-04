class Solution {
    public int largestRectangleArea(int[] arr) {
        int max=0;
        int n=arr.length;

        //left
        int []ls = new int[n];
        Stack<Integer> st = new Stack<>();
        ls[0]=-1;
        st.push(0);
        for(int i=1;i<n;i++){
            while(!st.isEmpty() && arr[i]<=arr[st.peek()]){
                st.pop();
            }
            ls[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }


        //right
        int rs[] = new int[n];
        st=new Stack<>();
        rs[n-1]=n;
        st.push(n-1);
        for(int j=n-2;j>=0;j--){
            while(!st.isEmpty() && arr[j]<=arr[st.peek()]){
                st.pop();
            }
            rs[j]=st.isEmpty()?n:st.peek();
            st.push(j);
        }

        //area
        for(int i=0;i<n;i++){
             int height=arr[i];
        int w=rs[i]-ls[i]-1;
        int area=height*w;
        max=Math.max(area,max);
        }

        return max;
    }
}