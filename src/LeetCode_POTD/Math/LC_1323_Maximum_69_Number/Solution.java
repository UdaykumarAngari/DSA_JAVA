package LeetCode_POTD.Math.LC_1323_Maximum_69_Number;

public class Solution {
    public int maximum69Number (int num) {
      //Approach 1 brute force
       /* String s = Integer.toString(num);
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

        */

        //Approach 2 better
       /* char[] arr = Integer.toString(num).toCharArray();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == '6') {
                    arr[i] = '9'; // flip first 6
                    break;        // only one change allowed
                }
            }
        return Integer.parseInt(new String(arr));   */

        //Approach 3 optimal
        int temp = num;
        int pos = -1, index = 0;

        while (temp > 0) {
            if (temp % 10 == 6) {
                pos = index; // track last 6
            }
            temp /= 10;
            index++;
        }

        if (pos == -1) return num; // no 6 found

        return num + (int)Math.pow(10, pos) * 3;

    }
}

