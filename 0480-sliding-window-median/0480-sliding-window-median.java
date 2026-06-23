class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {

        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        PriorityQueue<Integer> minHeap =
                new PriorityQueue<>();

        Map<Integer,Integer> delayed = new HashMap<>();

        double[] ans = new double[nums.length - k + 1];

        // Build first window
        for(int i = 0; i < k; i++) {

            if(maxHeap.isEmpty() || nums[i] <= maxHeap.peek()) {
                maxHeap.offer(nums[i]);
            } else {
                minHeap.offer(nums[i]);
            }

            while(maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            }

            while(minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }

        ans[0] = (k % 2 == 1)
                ? maxHeap.peek()
                : ((long)maxHeap.peek() + minHeap.peek()) / 2.0;

        int idx = 1;

        for(int i = k; i < nums.length; i++) {

            int incoming = nums[i];
            int outgoing = nums[i - k];

            int balance = 0;

            // mark outgoing for deletion
            delayed.put(outgoing,
                    delayed.getOrDefault(outgoing, 0) + 1);

            if(outgoing <= maxHeap.peek()) {
                balance--;
            } else {
                balance++;
            }

            // add incoming
            if(incoming <= maxHeap.peek()) {
                maxHeap.offer(incoming);
                balance++;
            } else {
                minHeap.offer(incoming);
                balance--;
            }

            // rebalance
            if(balance > 0) {
                minHeap.offer(maxHeap.poll());
            }

            if(balance < 0) {
                maxHeap.offer(minHeap.poll());
            }

            // clean maxHeap
            while(!maxHeap.isEmpty() &&
                  delayed.getOrDefault(maxHeap.peek(), 0) > 0) {

                int x = maxHeap.poll();

                delayed.put(x,
                        delayed.get(x) - 1);

                if(delayed.get(x) == 0) {
                    delayed.remove(x);
                }
            }

            // clean minHeap
            while(!minHeap.isEmpty() &&
                  delayed.getOrDefault(minHeap.peek(), 0) > 0) {

                int x = minHeap.poll();

                delayed.put(x,
                        delayed.get(x) - 1);

                if(delayed.get(x) == 0) {
                    delayed.remove(x);
                }
            }

            ans[idx++] =
                    (k % 2 == 1)
                    ? maxHeap.peek()
                    : ((long)maxHeap.peek()
                       + minHeap.peek()) / 2.0;
        }

        return ans;
    }
}