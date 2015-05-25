#include<cstdio>
#include<string>
#include<iostream>

using namespace std;

struct TrieNode{
	char c;
	bool isWord;
	TrieNode * left,mid,right;

	TrieNode():isWord(false),left(NULL),mid(NULL),right(NULL){}
};

int main(){

	return 0;
}