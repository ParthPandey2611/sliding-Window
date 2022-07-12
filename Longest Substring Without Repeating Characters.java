class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0 ; 
        HashMap<Character , Integer> map = new HashMap<>() ;
        for(int start = 0 , end = 0 ; end<s.length() ; ++end){
            if(s.length()==0){ 
                return 0 ;
            }
            if(map.containsKey(s.charAt(end))){ //agar last wala char miljae toh start ko start ko ekdum agae kardo
               start = Math.max(start,map.get(s.charAt(end))+1) ;
            }
            map.put(s.charAt(end),end);     // or if condition na chalae toh end ko store kardo
            max = Math.max(max,end-start+1); // ismae sabsae badi size select hogi
        }
        return max ;
    }
}
