class Solution {
    public String addBinary(String a, String b) {
            StringBuilder str=new StringBuilder();
        
        int i=a.length()-1,j=b.length()-1,curr=0;
        while(i>=0 || j>=0){
            if(i>=0) curr+=(a.charAt(i--)-'0');
            
            if(j>=0) curr+=(b.charAt(j--)-'0');
            
            str.append(curr%2);
            curr=curr/2;
        }
        
        if(curr==1) str.append(curr);
        
        return str.reverse().toString(); 
    }
}