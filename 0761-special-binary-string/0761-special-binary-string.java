class Solution {
    public String makeLargestSpecial(String s) {
        int balance=0;
        int left=0;
        List<String> list = new LinkedList<>();
        for(int right=0; right<s.length(); right++){
            if(s.charAt(right) == '0'){
                balance--;
            } else{
                balance++;
            }

            if(balance == 0){
                list.add("1" + makeLargestSpecial(s.substring(left+1, right))+ "0");
                left = right+1;
            }
        }
        Collections.sort(list, Collections.reverseOrder());

        return String.join("", list);
    }
}