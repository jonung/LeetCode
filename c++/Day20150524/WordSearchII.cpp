#include<cstdio>
#include<vector>
#include<string>
#include<iostream>

using namespace std;

struct TriNode{
	TriNode *ch[26];
	bool isWord;

	TriNode():isWord(false){
		for(int i = 0; i < 26; i ++)
			ch[i] = NULL;
	}

} *root;

void insert(string word){
	TriNode * p = root;
	for(int i = 0; i < word.length(); i ++){
		int pos = word.at(i) - 'a';
		if(p->ch[pos] == NULL){
			p->ch[pos] = new TriNode();
		}

		p = p->ch[pos];
	}

	p->isWord = true;
}

bool isPrefix(string word){
	TriNode * p = root;
	for(int i = 0; i < word.length(); i ++){
		int pos = word.at(i) - 'a';
		if(p->ch[pos] == NULL)
			return false;
		p = p->ch[pos];
	}

	return true;
}

bool isWord(string word){
	TriNode * p = root;
	for(int i = 0; i < word.length(); i ++){
		int pos = word.at(i) - 'a';
		if(p->ch[pos] == NULL)
			return false;
		p = p->ch[pos];
	}

	return p->isWord;
}

bool help(vector<vector<char> >& board, string word, int level, vector<vector<bool> >& visit,int r,int c){
	//printf("in\n");
	if(level == word.length())
		return true;
	if(r < 0 || r >= board.size() || c < 0 || c >= board[0].size())
		return false;
	if(visit[r][c] || board[r][c] != word[level] )
		return false;

	visit[r][c] = true;
	bool down = help(board,word,level + 1,visit,r + 1,c);
	if(down)
		return true;

	bool up = help(board,word,level + 1,visit,r - 1,c);
	if(up)
		return true;
	bool left = help(board,word,level + 1,visit,r,c - 1);
	if(left)
		return true;
	bool right = help(board,word,level + 1,visit,r,c + 1);//
	if(right)
		return true;

	visit[r][c] = false;
	return false;

}

bool exist(vector<vector<char> >& board, string word) {
	vector<vector<bool> > visit;
	for(int i = 0; i < board.size(); i ++){
		vector<bool> ele;
		for(int j = 0; j < board[0].size(); j ++){
			ele.push_back(false);
		}
		visit.push_back(ele);
	}
	for(int i = 0; i < board.size(); i ++){
		for(int j = 0; j < board[0].size(); j ++){
			if(help(board,word,0,visit,i,j))
				return true;
		}
	}
	return false;
}

/*
 *	暴力解法
 *
 *
 */
vector<string> findWords(vector<vector<char> >& board, vector<string>& words) {
	vector<string> res;
	vector<string> success;
	vector<string> failue;

	for(int i = 0; i < words.size(); i ++){
		string word = words[i];
		bool succFlag = false;
		bool failueFlag = false;
		for(int j = 0; j < success.size(); j ++){
			if(success[j].find(word) != string::npos){
				res.push_back(word);
				success.push_back(word);
				succFlag = true;
				break;
			}
		}

		if(succFlag)
			continue;

		for(int j = 0; j < failue.size(); j ++){
			if(word.find(failue[j]) != string::npos){
				failueFlag = true;
				failue.push_back(word);
				break;
			}
		}

		if(failueFlag)
			continue;

		if(exist(board,word)){
			success.push_back(word);
			res.push_back(word);
		}
		else{
			failue.push_back(word);
		}

	}

	return res;
}

vector<string> findWordsSolution2(vector<vector<char> >& board, vector<string>& words) {
	vector<string> res;
	if(board.empty() || board[0].empty() || words.empty())
		return res;
	root = new TriNode();
	for(int i = 0; i < words.size(); i ++)
		insert(words[i]);

	int m = board.size();
	int n = board[0].size();
	vector<vector<bool> > flag(m,vector<bool>(n,false));
	string s;
	set<string> st;
}

int main(){

	test t;
	cout<<t.a<<endl;
	return 0;
}