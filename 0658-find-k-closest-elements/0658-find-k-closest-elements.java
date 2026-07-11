class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
       int low = 0;
       int high = arr.length-k;
       while(low<high)
       {
            int mid = low+(high-low)/2;
            if (x - arr[mid] > arr[mid + k] - x)
            {
                low = mid+1;
            }
            else
            {
                high = mid;
            }
       }
       List<Integer> list = new ArrayList<>();
       for(int i=low; i<low+k; i++)
       {
        list.add(arr[i]);
       }
       return list;
    }
}
/*
multiple ans 
  List<Integer> res = new ArrayList<>();

        // Edge case: x is smaller than all elements
        if (x <= arr[0]) {
            for (int i = 0; i < k; i++) {
                res.add(arr[i]);
            }
            return res;
        }

        // Edge case: x is greater than all elements
        if (x >= arr[arr.length - 1]) {
            for (int i = arr.length - k; i < arr.length; i++) {
                res.add(arr[i]);
            }
            return res;
        }

        // Edge case: take whole array
        if (k == arr.length) {
            for (int num : arr) {
                res.add(num);
            }
            return res;
        }

        // Binary search for first element >= x
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] < x) {
                low = mid + 1;
                
            } else {
                high = mid;
            }
        }

        int right = low;
        int left = low - 1;

        int count = 0;

        while (count < k) {

            if (left < 0) {
                right++;
            }
            else if (right >= arr.length) {
                left--;
            }
            else if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                left--;
            }
            else {
                right++;
            }

            count++;
        }

        for (int i = left + 1; i < right; i++) {
            res.add(arr[i]);
        }

        return res;



List<Integer> list = new ArrayList<>();
        for(int i=0; i<arr.length; i++)
        {
            list.add(arr[i]);
        }
        Collections.sort(list,(a,b) -> {
            int adistx = Math.abs(a-x);
            int bdistx = Math.abs(b-x);
            if(adistx == bdistx)
            {
                return a-b;
            } 
            return adistx - bdistx;
        });
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<k; i++)
        {
            res.add(list.get(i));
        }
        Collections.sort(res);
        return res;
        */