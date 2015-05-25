#include<cstdio>
#include<string>
#include<iostream>

using namespace std;

struct TrieNode{
	bool isWord;
	TrieNode* next[26];

	TrieNode():isWord(false){
		for(int i = 0; i < 26; i ++)
			next[i] = NULL;
	}

};

TrieNode * root = new TrieNode();

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

int main(){
	insert("aa");
	insert("ab");
	cout<<search("ab")<<endl;
	cout<<search("abc")<<endl;
	return 0;
}