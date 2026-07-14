class MedianFinder {
    PriorityQueue<Integer> left_pq; 
    PriorityQueue<Integer> right_pq; 

    public MedianFinder() {
        left_pq = new PriorityQueue<>(Collections.reverseOrder()); // max heap on left side
        right_pq = new PriorityQueue<>(); // min heap on right side
    }
    
    public void addNum(int num) {
        //add based on value
        if (left_pq.isEmpty() || num <= left_pq.peek()) {
            left_pq.add(num);
        } else {
            right_pq.add(num);
        }

        // Balance the heaps
        if (left_pq.size() > right_pq.size() + 1) {
            right_pq.add(left_pq.poll());
        } 
        else if (right_pq.size() > left_pq.size()) {
            left_pq.add(right_pq.poll());
        }
    }
    
    public double findMedian() {
        if(left_pq.size() == right_pq.size()){
            return (left_pq.peek() + right_pq.peek())/ 2.0;
        }
        else{
            return left_pq.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */