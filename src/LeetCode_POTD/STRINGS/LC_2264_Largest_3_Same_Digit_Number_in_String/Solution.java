package LeetCode_POTD.STRINGS.LC_2264_Largest_3_Same_Digit_Number_in_String;

public class Solution {
    public String largestGoodInteger(String num) {

        // Approach 1
        /*
        String max = "";
        int n = num.length();
        for(int i = 0; i < n - 2; i++) {
            // Check if three consecutive characters are the same
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                String triplet = num.substring(i, i + 3);
                // Update max if this triplet is larger
                if (triplet.compareTo(max) > 0) max = triplet;
            }
        }
        return max;
        */

        //Approach 2
        // All possible "good integers" in descending order
        // Each is exactly 3 of the same digit
        String[] numbers = {
                "999", "888", "777", "666", "555",
                "444", "333", "222", "111", "000"
        };

        // Check each possible good integer starting from the largest
        for (String s : numbers) {
            // If 'num' contains this triplet, return it immediately
            // Because the array is in descending order, the first match is the largest
            if (num.contains(s)) return s;
        }

        // If none of the possible triplets exist in 'num', return an empty string
        return "";

    }
}
