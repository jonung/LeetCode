#include<cstdio>
#include<string>
#include<iostream>

using namespace std;


class Trie {

public:

	struct TrieNode{
		char c;
		bool isWord;
		TrieNode * left;
		TrieNode * mid;
		TrieNode * right;

		TrieNode(char ch):c(ch),isWord(false),left(NULL),mid(NULL),right(NULL){}
	};

public:
	Trie(){
		root = NULL;//key point
	}

	// Inserts a word into the trie.
	TrieNode * insert(TrieNode * p, string word,int d){
		char ch = word.at(d);
		if(p == NULL){
			p = new TrieNode(ch);
		}

		if(ch < p->c){
			p->left = insert(p->left,word,d);
		}
		else if(ch > p->c){
			p->right = insert(p->right,word,d);
		}
		else if(d < word.length() - 1){
			p->mid = insert(p->mid,word,d+1);
		}
		else{
			p->isWord = true;
		}

		return p;//
	}

	void insert(string word){
		root = insert(root,word,0);
	}

	// Returns if the word is in the trie.
	bool search(TrieNode * p, string word,int d){
		if(p == NULL)	return false;
		char ch = word.at(d);

		if(ch < p->c){
			return search(p->left,word,d);
		}
		else if(ch > p->c){
			return search(p->right,word,d);
		}
		else if(d < word.length() - 1){
			return search(p->mid,word,d +1);
		}
		else
			return p->isWord;
	}

	bool search(string word){
		return search(root,word,0);
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	bool startsWith(TrieNode * p,string prefix, int d){
		if(p == NULL)
			return false;
		char ch = prefix.at(d);

		if(ch < p->c){
			return startsWith(p->left,prefix,d);
		}
		else if(ch > p->c){
			return startsWith(p->right,prefix,d);
		}
		else if(d < prefix.length() - 1){
			return startsWith(p->mid,prefix,d + 1);
		}
		else{
			return true;
		}
	}

	bool startsWith(string prefix) {
		return startsWith(root,prefix,0);    
	}

private:
	TrieNode* root;

};

int main(){

	Trie trie;
	trie.insert("somestring");
	trie.search("key");
	
	cout<<trie.search("a")<<endl;
	cout<<trie.search("abc")<<endl;
	cout<<trie.startsWith("b")<<endl;
	return 0;
}