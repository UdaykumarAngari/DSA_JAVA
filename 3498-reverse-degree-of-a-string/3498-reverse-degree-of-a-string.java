class Solution {
    public int reverseDegree(String s) {
       HashMap<Character,Integer> alpha=new HashMap<>();
        for(char ch='a';ch<='z';ch++){
            alpha.put(ch,'z'-ch+1);
        }
        
        int sum=0;
        int n=s.length();
        for(int i=1;i<n+1;i++){
            sum+=i*alpha.get(s.charAt(i-1));
        }
        return sum;
    }
}