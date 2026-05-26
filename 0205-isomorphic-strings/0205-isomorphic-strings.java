class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        int[] mapS = new int[256];
        int[] mapT = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (mapS[c1] != mapT[c2]) {
                return false;
            }
            mapS[c1] = i + 1;
            mapT[c2] = i + 1;
        }

        return true;
        // HashMap<Character, Character> map = new HashMap<>();
        // HashSet<Character> used= new HashSet<>();

        // int n = s.length();
        // for(int i = 0 ; i < n; i++){
            
        //     char a = s.charAt(i);
        //     char b = t.charAt(i);

        //     if(map.containsKey(a)){
        //         if(map.get(a) != b){
        //             return false;
        //         }
        //     }

        //     else {
        //         if(used.contains(b)){
        //             return false;
        //         }
        //         map.put(a,b);
        //         used.add(b);
        //     }
        // }
        // return true;
    }
}