class Solution {
    public boolean detectCapitalUse(String word) {
       int n=word.length();
        
        boolean first=false;
        int upper=0;
        for(int i=0;i<n;i++){
            if(i==0 && word.charAt(i)>='A' && word.charAt(i)<='Z') first=true;
            else if(!first && upper>=1) return false;
            else if(word.charAt(i)>='A' && word.charAt(i)<='Z') upper++;
            // System.out.println(first+" "+upper);
        }
        
        if(first && (upper==n-1 || upper==0)) return true;
        else if(!first && upper==0) return true;
        else return false;
    }
}