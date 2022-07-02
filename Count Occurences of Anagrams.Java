// https://practice.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1#
//Approach -> https://www.youtube.com/watch?v=MW4lJ8Y0xXk&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=5


class Solution {
    int search(String pat, String txt) {
        // code here
        HashMap<Character,Integer> map = new HashMap<>();
        for(int k = 0 ; k<pat.length() ; k++){
         //   map.put(pat.charAt(k),map.get(pat.charAt(k),0)+1);
            char c = pat.charAt(k);
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }
            else{
                map.put(c,1);
            }
        }
        int i = 0;
        int j = 0 ; 
        int count = map.size();
        int n = txt.length();
        int k = pat.length();
        int result = 0 ;
        while(j<n){
            char temp = txt.charAt(j);
            if(map.containsKey(temp)){
                map.put(temp,map.get(temp)-1);
                if(map.get(temp)==0)count-- ;
            }
            if(j-i+1 < k) j++;
            else if(j-i+1==k){
                if(count==0)result++ ;
                char r = txt.charAt(i);
                if(map.containsKey(r)){
                    map.put(r,map.get(r)+1);
                    if(map.get(r)==1)count++;
               }  
            }
             i++;
             j++;     
        }
        return result ;
    }
}
