// https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
// Approach : https://www.youtube.com/watch?v=Lav6St0W_pQ&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=10

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        int i = 0 ;
        int j = 0 ; 
        int max =-1 ;
        HashMap<Character,Integer> map = new HashMap<>();
        while(j<s.length()){
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);           
            if(map.size()==k){
                max = Math.max(max,j-i+1);
            }
            else if(map.size()>k){
                while(map.size()>k){
                    map.put(s.charAt(i),map.get(s.charAt(i))-1);
                    if(map.get(s.charAt(i))==0){
                        map.remove(s.charAt(i));
                      
                    }
                      i++;
                }
            }
            j++;
        }
        return max;
    }  
