class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] fq=new int[26];
        for(char c:tasks)
        {
            fq[c-'A']++;
        }
        int maxfq=0;
        int count=0;
        for(int f:fq)
        {
            maxfq=Math.max(maxfq,f);
        }
        for(int f:fq)
        {
            if(f==maxfq)
            {
                count++;
            }
        }
        int ans=(maxfq-1)*(n+1)+count;
        return Math.max(ans,tasks.length);
        // int[] map = new int[26];

        // for(char ch : tasks ){
        //     map[ch-'A']++;
        // }   

        // int time =0 ;

        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // for(int num : map){
        //     if(num!=0){
        //         pq.offer(num);
        //     }
        // }

        // while(!pq.isEmpty()){
        //     ArrayList<Integer> temp = new ArrayList<>();

        //     for(int i = 1 ; i <= n + 1 ; i++){
        //         if(!pq.isEmpty()){
        //             int freq = pq.poll();
        //             freq--;
        //             temp.add(freq);
        //         }
        //     }

        //     for(int i = 0 ; i < temp.size() ; i++ ){
        //         if(temp.get(i) > 0 ){
        //             pq.offer(temp.get(i));
        //         }
        //     }

        //     if(pq.isEmpty()){
        //         time+=temp.size();
        //     }else{
        //         time+= n+1;
        //     }
        // }
        // return time;
    }
}