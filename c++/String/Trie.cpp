#include<cstdio>
#include<string>
#include<iostream>

using namespace std;

class Trie {

public:
	struct TrieNode{
		bool isWord;
		TrieNode* next[26];

		TrieNode():isWord(false){
			for(int i = 0; i < 26; i ++)
				next[i] = NULL;
		}

	};

	Trie(){
		root = new TrieNode();
	}

	void insert(string word){
		TrieNode * p = root;

		for(int i = 0; i < word.length(); i ++){
			int pos = word.at(i) - 'a';
			if(p->next[pos] == NULL){
				p->next[pos] = new TrieNode();
			}

			p = p->next[pos];
		}

		p->isWord = true;
	}

	bool search(string word){
		TrieNode * p = root;

		for(int i = 0; i < word.length(); i ++){
			int pos = word.at(i) - 'a';
			if(p->next[pos] == NULL)	return false;
			p = p->next[pos];

		}

		return p->isWord;
	}

	bool startsWith(string prefix) {
    	TrieNode * p = root;

		for(int i = 0; i < prefix.length(); i ++){
			int pos = prefix.at(i) - 'a';
			if(p->next[pos] == NULL)	return false;
			p = p->next[pos];

		}

		return true;
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