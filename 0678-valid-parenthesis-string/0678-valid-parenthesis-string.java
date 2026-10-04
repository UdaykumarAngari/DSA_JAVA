class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> open = new Stack<>();
        Stack<Integer> star = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                open.push(i);
            }

            else if (ch == '*') {
                star.push(i);
            }

            else { // ch == ')'
                if (!open.isEmpty()) {
                    open.pop();
                }
                
                else if (!star.isEmpty()) {
                    star.pop();
                }
                else {
                    return false;
                }
            }
        }

        // Match remaining '(' with '*' appearing after them
        while (!open.isEmpty() && !star.isEmpty()) {
            if (open.peek() > star.peek()) {
                return false;
            }

            open.pop();
            star.pop();
        }

        // Any remaining '(' cannot be matched
        return open.isEmpty();
    }
}