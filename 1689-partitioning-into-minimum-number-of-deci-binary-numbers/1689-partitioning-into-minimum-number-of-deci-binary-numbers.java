class Solution {
    public int minPartitions(String n) {
        String str = String.valueOf(n);
        char first = str.charAt(0);

        char second = first;

        for (char c : str.toCharArray()) {
            if (c > second) second = c;
        }

        return first - '0' + (second - first > 0 ? second - first : 0);
    }
}