class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if(digits.length() == 0) {
            return ans;
        }

        String[] map = {
            "", "", "abc", "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"
        };

        generate(0, digits, new StringBuilder(), ans, map);

        return ans;
    }

    public void generate(int ind, String digits, StringBuilder curr,
                         List<String> ans, String[] map) {

        if(ind == digits.length()) {
            ans.add(curr.toString());
            return;
        }

        String letters = map[digits.charAt(ind) - '0'];

        for(int i = 0; i < letters.length(); i++) {
            curr.append(letters.charAt(i));

            generate(ind + 1, digits, curr, ans, map);

            curr.deleteCharAt(curr.length() - 1);
        }
    }
}