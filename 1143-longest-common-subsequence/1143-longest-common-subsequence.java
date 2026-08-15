class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m][n];


        

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return lcs(m , n, text1, text2, dp);
    }

    public int lcs(int i, int j, String s1, String s2, int[][] dp){
        
        if(i == 0 || j == 0) return 0;

        if(dp[i-1][j-1] != -1) return dp[i-1][j-1];

        if(s1.charAt(i-1) == s2.charAt(j-1)){
            return dp[i-1][j-1] = 1 + lcs(i - 1, j - 1, s1, s2, dp);
        }

        return dp[i-1][j-1] = Math.max(lcs(i-1, j, s1, s2, dp), lcs(i, j-1, s1, s2, dp));
    }
}