// https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1#
// https://www.youtube.com/watch?v=uUXXEgK2Jh8&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=4


class Compute {
   
   public long[] printFirstNegativeInteger(long arr[], int N, int K)
   {

       long [] ans=new long[N-K+1];
       int index=0;
       int start=0;
       int end=0;
       ArrayDeque<Long> queue=new ArrayDeque<>();
       while(end<N){
           if(end-start+1<K){
               if(arr[end]<0){
                   queue.offer(arr[end]);
               }
               end++;
           }
           else if(end-start+1==K){
               if(arr[end]<0){
                   queue.offer(arr[end]);
               }
               if(queue.size()==0){
                   ans[index]=0;
               }
               else{
                   ans[index]=queue.getFirst();
               }
               index++;
               if(queue.size()!=0 && arr[start]==queue.getFirst()){
                   queue.remove();
               }
               end++;
               start++;
           }
       }
       return ans;
   }
}
