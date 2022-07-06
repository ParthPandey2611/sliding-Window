// https://leetcode.com/problems/sliding-window-maximum/
// Approach -> https://www.youtube.com/watch?v=CZQGRp93K4k&list=PLgUwDviBIf0oSO572kQ7KCSvCUh1AdILj&index=13
//             https://leetcode.com/problems/sliding-window-maximum/discuss/65884/Java-O(n)-solution-using-deque-with-explanation
//             https://www.youtube.com/watch?v=xFJXtB5vSmM&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=6



class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] r = new int[n-k+1] ;
        int ri =0 ;
        Deque<Integer> q = new ArrayDeque<>();
            for(int i = 0 ; i<n ; i++){
                // remove number range out of k 
                if(!q.isEmpty() && q.peek() == i-k ){   // we are checking outofbound here 
                    q.remove();           // matlab jo bhi window kae agae ho usko removekardo
                }
                // remove smaller numbers in k range as they are useless
                while(!q.isEmpty() && nums[q.peekLast()]<nums[i]){
                     q.removeLast();      // matlab jo window kae andar useless or chota ho usko remove kardo
                }
                q.offer(i);
                // q contains index... r contains content
                if(i>=k-1){              // any i which is greater , then start taking it 
                    r[ri++] = nums[q.peek()];
                }
            }
        return r ;
    }
}
