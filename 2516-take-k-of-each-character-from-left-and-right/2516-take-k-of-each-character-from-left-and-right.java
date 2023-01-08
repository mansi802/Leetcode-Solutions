class Solution {
    public int takeCharacters(String s, int k) {
        int n=s.length();
        
        int a=0,b=0,c=0;
        
        for(char ch:s.toCharArray()){
            if(ch=='a') a++;
            else if(ch=='b') b++;
            else c++;
        }
        
        a-=k;
        b-=k;
        c-=k;
        
        // System.out.println(a+" "+b+" "+c);
        
        if(a<0 || b<0 || c<0) return -1;
        if(a==0 && b==0 && c==0) return n;
        
        int ans=0;
        for(int i=0,j=0;j<n;j++){
            
            char ch=s.charAt(j);
            if(ch=='a') a--;
            else if(ch=='b') b--;
            else c--;
            
            while(i<j && (a<0 || b<0 || c<0)){
                if(s.charAt(i)=='a') a++;
                else if(s.charAt(i)=='b') b++;
                else c++;
                
                i++;
            }
            
            ans=Math.max(ans,j-i+1);
        }
        
        return n-ans;
    }
}