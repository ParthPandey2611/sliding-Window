// https://leetcode.com/problems/fruit-into-baskets/
// APPROACH -> https://leetcode.com/problems/fruit-into-baskets/discuss/170740/JavaC%2B%2BPython-Sliding-Window-for-K-Elements
// APPROACH -> https://www.youtube.com/watch?v=seOKHXB_w74&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=12


class Solution {
    public int totalFruit(int[] fruits) {
        int max = 0 ;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int start = 0 , end = 0 ; end<fruits.length ; ++end){
           map.put(fruits[end],map.getOrDefault(fruits[end],0)+1);
             if(map.size() <= 2){
                max = Math.max(max, end-start+1);
            }
            while(map.size()>2){
               map.put(fruits[start],map.get(fruits[start])-1);
                if(map.get(fruits[start])==0){
                    map.remove(fruits[start]);
                    
                }
                start++;
            } 
            
        }
        return max ;
   }
}
