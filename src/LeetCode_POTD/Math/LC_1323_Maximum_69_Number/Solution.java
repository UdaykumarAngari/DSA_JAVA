package LeetCode_POTD.Math.LC_1323_Maximum_69_Number;

public class Solution {
    public int maximum69Number (int num) {
        String s = Integer.toString(num);
        char[] arr = s.toCharArray();
        int max = num;

        for (int i = 0; i < arr.length; i++) {
            char original = arr[i];

            // Flip digit
            arr[i] = (arr[i] == '6') ? '9' : '6';

            // Convert back
            int newNum = Integer.parseInt(new String(arr));
            max = Math.max(max, newNum);

            // Restore
            arr[i] = original;
        }

        return max;
    }

}

