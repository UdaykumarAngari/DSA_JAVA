class Solution {
    public int totalFruit(int[] fruits) {
        int maxlen = 0;
        
        // Track last and second last fruit types
        int lastFruit = -1, secondLastFruit = -1;
        
        // Count of current window and streak of last fruit
        int currCount = 0, lastFruitStreak = 0;

        // Traverse through each fruit
        for (int fruit : fruits) {
            
            // If fruit matches last two, expand window
            if (fruit == lastFruit || fruit == secondLastFruit) {
                currCount++;
            } else {
                // Reset window size to streak + 1
                currCount = lastFruitStreak + 1;
            }

            // Update lastFruit streak and fruit types
            if (fruit == lastFruit) {
                lastFruitStreak++;
            } else {
                lastFruitStreak = 1;
                secondLastFruit = lastFruit;
                lastFruit = fruit;
            }

            // Update max window size
            maxlen = Math.max(maxlen, currCount);
        }

        return maxlen;
    }
}