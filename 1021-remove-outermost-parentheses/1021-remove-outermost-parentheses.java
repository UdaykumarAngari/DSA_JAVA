class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();  
        // Initialize nesting level counter
        int level = 0;  

        // Traverse the string
        for (char ch : s.toCharArray()) {
            // If we encounter '(', increase the level
            if (ch == '(') {
                // If we're inside a primitive, add '(' to result
                if (level > 0) result.append(ch);
                 // Increase the nesting level for '('
                level++; 
            } 
            // If we encounter ')', decrease the level
            else if (ch == ')') {
                // Decrease the nesting level for ')'
                level--;  
                // If we're inside a primitive, add ')' to result
                if (level > 0) result.append(ch);
            }
        }

        // Return the result as a string after removing the outer parentheses
        return result.toString();
    }
}