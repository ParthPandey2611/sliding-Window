// https://practice.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1#
// Approach -> https://www.youtube.com/watch?v=KtpqeN0Goro

class Solution{
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        // code here
        int start = 0 ;
        int end = 0 ;
        long maxSum = Long.MIN_VALUE ;
        long sum = 0 ;
        while(end<N){
            sum = sum + Arr.get(end);
             if(end-start+1==K){
                maxSum = Math.max(maxSum,sum);   // checking which is greater between maxSum and sum .
                sum = sum - Arr.get(start);     // we are using Arr.get because int ArrayList we used to return the element at a given index from specified array .
                
                start++;
                end++;
            }
            else{
                end++;
            }
        }
        return maxSum ;
    }
}

