class Solution {
    List<List<String>> ans;
    public List<List<String>> partition(String s) {
        ans=new ArrayList<>();
        helper(s,0,new ArrayList<>());
        return ans;
    }
    
    private void helper(String s,int start,List<String> list){
        if(start==s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }
        
        for(int i=start;i<s.length();i++){
            if(checkPalindrome(s,start,i)){
                list.add(s.substring(start,i+1));
                helper(s,i+1,list);
                list.remove(list.size()-1);
            }
        }
    }
    
    private boolean checkPalindrome(String s,int start,int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)) return false;
            start++;
            end--;
        }
        
        return true;
    }
}