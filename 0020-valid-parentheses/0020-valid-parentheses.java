class Solution {
   public char pair(char c){
        switch(c) {
            case ')':
                return '(';
            case ']':
                return '[';
            default:
                return '{';
        }
    }
    
    public boolean isValid(String str) {
        if(str.length()==1) return false;
        Stack<Character> s=new Stack<>();
        int i;
        for(i=0;i<str.length();i++){
            if(str.charAt(i)=='(' || str.charAt(i)=='{' || str.charAt(i)=='[')
                s.push(str.charAt(i));
            else if(s.isEmpty())
                return false;
            else if(str.charAt(i)==')' || str.charAt(i)=='}' || str.charAt(i)==']'){
                char peek=s.peek();
                if(peek==pair(str.charAt(i)))
                    s.pop();
                else
                    return false;
            }
        }

        return s.isEmpty();
    }
}