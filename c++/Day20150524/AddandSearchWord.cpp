#include<cstdio>
#include<iostream>

using namespace std;

struct TrieNode{
	TrieNode* ch[26];
	bool isWord;

	TrieNode():isWord(false){
		for(int i = 0;i < 26; i ++)
			ch[i] = NULL;
	}

};

TrieNode * root = new TrieNode();

void addWord(string word){
	TrieNode * p = root;
	for(int i = 0; i < word.length(); i ++){
		int pos = word.at(i) - 'a';
		if(p->ch[pos] == NULL){
			p->ch[pos] = new TrieNode();
		}
		p = p->ch[pos];
	}
	p->isWord = true;
}

bool help(string word, int pos, TrieNode * p){
	if(pos == word.length() ){
		return p->isWord;
	}

	char cur = word.at(pos);
	if(cur == '.'){
		for(int i = 0; i < 26; i ++){
			if(p->ch[i] != NULL){
				if( help(word,pos + 1,p->ch[i]) )
					return true;
			}
		}
		return false;
	}
	else{
		int m = cur - 'a';
		if(p->ch[m] == NULL)
			return false;
		p = p->ch[m];
		return help(word,pos + 1,p);
	}
}

bool search(string word){
	TrieNode * p = root;
	return help(word,0,p);
}

int main(){
	addWord("bad");
	addWord("dad");
	addWord("mad");

	cout<<search("pad")<<endl;
	cout<<search("bad")<<endl;
	cout<<search(".ad")<<endl;
	cout<<search("b..")<<endl;
	return 0;
}