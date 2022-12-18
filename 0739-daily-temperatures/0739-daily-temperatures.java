class Solution {
    public int[] dailyTemperatures(int[] arr) {
       int n=arr.length;
        
        Stack<Integer> s=new Stack<>();
        int[] result=new int[n];
        s.push(n-1);
        result[n-1]=0;
        
        for(int i=n-2;i>=0;i--){
            while(!s.isEmpty() && arr[i]>=arr[s.peek()])
                s.pop();
            
            result[i]=s.isEmpty()?0:s.peek()-i;
            
            s.push(i);
        }
        
        return result; 
    }
}