class Solution {
    public String minWindow(String s, String t) {
        String min = "";
        HashMap<Character,Integer> map2 = new HashMap<>();
        for(int i = 0 ; i<t.length() ; i++)
        {
         char ch = t.charAt(i);
         map2.put(ch,map2.getOrDefault(ch,0)+1);  // yaha pae t char ki individual value ka total count kar raha hai and then map mae put kar raha hai
        }
        int match = 0 ;
        int desiredmatch = t.length();
        HashMap<Character,Integer> map1 = new HashMap<>();
        int i = -1 ;
        int j = -1 ;
        while(true)
        {
            boolean f1 = false;
            boolean f2 = false;
            //acquire
            while(i<s.length()-1 && match<desiredmatch)
            {
                i++;
                char ch = s.charAt(i);
                map1.put(ch, map1.getOrDefault(ch,0)+1);  // agar ch hai toh same rahae hai ga warn 0+1 karkae frequency agae badha daengae 
                if(map1.getOrDefault(ch,0)<=map2.getOrDefault(ch,0)){  
                    match++;  // agar map1 chota hai ya equal toh smhj jana kaam ka hai wrna agar chota nhi hai toh koi matlab nhi hai
                }
                f1= true;   // iska matlab is loop mae aya tha 
            }
            // collect answers and release
           while(j<i && match==desiredmatch)
           {
               String potential = s.substring(j+1,i+1);
               if(min.length()==0 || potential.length()<min.length())
               {
                   min=potential;
               }
               j++;
               char ch = s.charAt(j);
               if(map1.get(ch)==1){
                   map1.remove(ch);  // ekdum starting sae check karogae agar ch ki value 1 hai to usko remove kardengae
               }
               else{
                   map1.put(ch,map1.get(ch)-1);   // otherwise last sae ek remove kardengae
               }
               if(map1.getOrDefault(ch,0)<map2.getOrDefault(ch,0))
               {
                   match--;
               }
               f2=true;     // iska matlab is loop mae aya tha
           }
            if(f1==false && f2==false){
             break ;            // or agar kisi loop mae nhi gaya toh break kardo
            }
        }
        return min ;
    }
}
