package Day20150520;

 
/**
 * @ClassName: Trie
 * @Description: 
 * @author GongJun
 * @date 2015-5-20 下午10:05:57
 * @version V1.0  
 */

public class Trie {
	
	class TrieNode {
	    // Initialize your data structure here.
		public boolean flag;
		public TrieNode[] next;
		
	    public TrieNode() {
	        next = new TrieNode[26];
	        for(int i = 0; i < 26; i ++)
	        	next[i] = null;
	        
	        flag = false;
	    }
	}
	
	private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        char[] array = word.toCharArray();
        int i = 0;
        TrieNode cur = root;
        while(i < array.length){
        	int pos = array[i] - 'a';
        	if(cur.next[pos] == null){
        		TrieNode tmp = new TrieNode();
        		cur.next[pos] = tmp;
        	}
        	
        	cur = cur.next[pos];
        	i ++;
        }
        cur.flag = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
    	char[] array = word.toCharArray();
    	TrieNode cur = root;
    	int i = 0;
    	while(i < array.length){
    		int pos = array[i] - 'a';
    		if(cur.next[pos] == null)
    			return false;
    		
    		cur = cur.next[pos];
        	i ++;
    	}
    	
    	
    	return cur.flag;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
    	char[] array = prefix.toCharArray();
    	TrieNode cur = root;
    	int i = 0;
    	while(i < array.length){
    		int pos = array[i] - 'a';
    		if(cur.next[pos] == null)
    			return false;
    		
    		cur = cur.next[pos];
        	i ++;
    	}
    	
    
    	return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie trie = new Trie();
		trie.insert("somestring");
		System.out.println(trie.search("somestrin"));
		System.out.println(trie.startsWith("somedd"));
	}

}
