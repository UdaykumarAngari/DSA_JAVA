class StockSpanner {
   // Stack stores:
    // [0] -> stock price
    // [1] -> span of that stock price
    //
    // Example:
    // (75, 4)
    // means price = 75 and its span = 4
    Stack<int[]> st;

    public StockSpanner() {
        st = new Stack<>();
    }

    public int next(int price) {

        // Current day itself contributes 1 to span
        int span = 1;

        // Remove all previous prices that are
        // less than or equal to current price
        //
        // Why?
        // They can be included in current span.
        //
        // Example:
        // Stack:
        // (80,1), (70,2), (60,1)
        //
        // Current price = 75
        //
        // 60 <= 75  => add its span
        // 70 <= 75  => add its span
        //
        // span becomes:
        // 1 + 1 + 2 = 4
        while (!st.isEmpty() && st.peek()[0] <= price) {

            // Instead of counting days one by one,
            // directly add the stored span
            span += st.pop()[1];
        }

        // Push current price and its computed span
        st.push(new int[]{price, span});

        // Return span for current day
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */