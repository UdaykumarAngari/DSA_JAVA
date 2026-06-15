class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;

        Stack<Integer> st = new Stack<>();

        int maxArea = 0;

        for(int i = 0; i <= n; i++) {

            // Sentinel 0 at the end
            int currHeight = (i == n) ? 0 : heights[i];

            while(!st.isEmpty() && currHeight < heights[st.peek()]) {

                // Current bar becomes right boundary
                int height = heights[st.pop()];

                // Previous smaller element
                int leftSmall = st.isEmpty() ? -1 : st.peek();

                // Current index is next smaller element
                int rightSmall = i;

                int width = rightSmall - leftSmall - 1;

                int area = height * width;

                maxArea = Math.max(maxArea, area);
            }

            st.push(i);
        }

        return maxArea;
    }
}