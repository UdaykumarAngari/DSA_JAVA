class Solution {

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();

        generate(0, s, list, ans);
        
        return ans;
    }
    public void generate(int ind , String s,List<String> list,  List<List<String>> ans ){
        if(ind == s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = ind ; i< s.length() ; i++){
            String sub = s.substring(ind, i + 1);

            if(isPalindrome(sub)){
                list.add(sub);

                generate(i+1, s, list, ans);

                list.remove(list.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s){
        int n = s.length();
        for(int i = 0 ; i <n/2 ; i++ ){
            if(s.charAt(i) != s.charAt(n - i - 1) ){
                return false;
            }
        }
        return true;
    }
}