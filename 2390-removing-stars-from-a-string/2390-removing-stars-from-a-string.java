class Solution {
    public String removeStars(String s) {
       Stack<Character> stack=new Stack<>();
        
       for(char c:s.toCharArray()){
           
           if(c=='*') stack.pop();
           else stack.push(c);
           
       } 
        
       StringBuilder ans=new StringBuilder();
        
       while(stack.size()>0){
           ans.append(stack.pop());
       } 
        
       
        return ans.reverse().toString();
    }
}