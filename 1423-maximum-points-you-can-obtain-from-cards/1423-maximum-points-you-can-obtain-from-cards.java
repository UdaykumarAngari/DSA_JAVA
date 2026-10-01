class Solution {
    public int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;
        int size = n - k;

        int left = 0;
        int right = n - 1;

        int leftSum = 0;
        int rightSum = 0;

        // Take all n-k cards from the left initially
        while (left < k) {
            leftSum += cardPoints[left];
            left++;
        }

        left--;

        int max = leftSum;

        // Gradually replace left cards with right cards
        while (right >= size && left >= 0) {

            rightSum += cardPoints[right];
            leftSum -= cardPoints[left];

            max = Math.max(max, leftSum + rightSum);

            left--;
            right--;
        }

        return max;
    }
}