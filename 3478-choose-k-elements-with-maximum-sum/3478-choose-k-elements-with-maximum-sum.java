//didnot solve on my own
class Solution {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {

        int n = nums1.length;
        long[] ans = new long[n];

        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums1[i];
            arr[i][1] = nums2[i];
            arr[i][2] = i;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        long sum = 0;

        for (int i = 0; i < n; i++) {

            int idx = arr[i][2];
            int val = arr[i][1];
            if (i == 0) {
                ans[idx] = sum;
            } else if (arr[i][0] != arr[i - 1][0]) {
                ans[idx] = sum;
            } else {
                ans[idx] = ans[arr[i - 1][2]];
            }

            if (k == 0) continue;

            if (heap.size() < k) {
                heap.offer(val);
                sum += val;
            } else if (val > heap.peek()) {
                sum -= heap.poll();
                heap.offer(val);
                sum += val;
            }
        }

        return ans;
    }
}