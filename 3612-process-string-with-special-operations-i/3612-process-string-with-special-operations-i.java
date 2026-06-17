class Solution {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();

        int n = s.length();

        for(char ch : s.toCharArray()){
            if(Character.isLetter(ch)){
                sb.append(ch);
            }
            else if(!sb.isEmpty() && ch == '*'){
                sb.deleteCharAt(sb.length()-1);
            }
            else if(ch == '#'){
                sb.append(sb);
            }
            else{
                sb.reverse();
            }
        }
        return sb.toString();
    }
}