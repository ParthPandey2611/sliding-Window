// https://practice.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1#
// https://leetcode.com/problems/subarray-sum-equals-k/

class Solution{
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr (int arr[], int N, int k) {
        //Complete the function
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;
        int sum = 0;
        
        for(int i=0;i<N;i++){
            sum += arr[i];
            if(sum == k){
                max = Math.max(i+1 , max);
            }
            else if(map.containsKey(sum-k)){
                max = Math.max(i-map.get(sum-k) , max);
            }
            if(!(map.containsKey(sum))){
                map.put(sum, i);
                
            }
        }
        
        return max;
    }
}
