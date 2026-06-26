class Solution {
    public static int[] merge(int[] a, int[] b)
    {
        int right = 0; 
        int left = 0;
        int res[] = new int[a.length+b.length];
        int size =0;
        while(left<a.length && right<b.length)
        {
            if(a[left]<=b[right])
            {
                res[size] = a[left];
                size++;
                left++;
            }
            else
            {
                res[size] = b[right];
                size++;
                right++;
            }
        }
        while(left<a.length)
            {
                res[size] = a[left];
                size++;
                left++;
            }
            while(right<b.length)
            {
                res[size] = b[right];
                size++;
                right++;
            }
        return res;
    }
    public int kthSmallest(int[][] matrix, int k) {
        // merge pair wise 
        while(matrix.length!=1)
        {
            int count = matrix.length%2 == 0 ? matrix.length/2 : (matrix.length+1)/2;
            int[][] store = new int[count][];
            for(int i=0,j=0; i<matrix.length; i+=2,j+=1)
            {
                if(i<matrix.length-1)
                {
                store[j] = merge(matrix[i],matrix[i+1]);
                }
                else
                {
                    store[j] = matrix[i];
                }
            }
            matrix = store;
        }
        return matrix[0][k-1];
    }
}
/*PriorityQueue<int[]>heap = new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i=0; i<matrix.length;i++)
        {
            heap.add(new int[]{matrix[i][0],i,0});
        }
        int size =0;
        int []arr = new int[3];
        while(!heap.isEmpty())
        {
            
            if(size == k)
            {
                break;
            }
            arr = heap.poll();
            int val = arr[0];
            int list = arr[1];
            int index = arr[2];
            size++;
            if(index+1<matrix[list].length)
            {
                heap.add(new int[]{matrix[list][index+1],list,index+1});
            }
        }
        return arr[0];*/