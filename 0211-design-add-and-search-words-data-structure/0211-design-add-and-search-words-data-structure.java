class WordDictionary {
    private Node root;
    public WordDictionary() {
        root=new Node();
    }
    
    public void addWord(String word) {
        Node dummy=root;
        
        for(char c:word.toCharArray()){
            if(dummy.empty(c)) dummy.put(c,new Node());
            
            dummy=dummy.get(c);
        }
        
        dummy.setEnd();
    }
    
    public boolean search(String word) {
        return helper(word,root,0);
    }
    
    private boolean helper(String word,Node root,int i){
        if(root==null) return false;
        if(i==word.length()) return root.end;
        char next=word.charAt(i);
        boolean ans=false;
        for(int c=0;c<26;c++){
            if(next=='.' || c==next-'a') ans=ans || helper(word,root.links[c],i+1);
        }
        
        return ans;
    }
}

class Node{
    Node[] links=new Node[26];
    boolean end=false;
    
    boolean empty(char c){
        return links[c-'a']==null;
    }
    
    Node get(char c){
        return links[c-'a'];
    }
    
    void put(char c,Node node){
        links[c-'a']=node;
    }
    
    void setEnd(){
        end=true;
    }
}


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */