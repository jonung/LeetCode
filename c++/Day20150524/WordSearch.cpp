#include<cstdio>
#include<vector>
#include<string>
#include<iostream>

using namespace std;

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

int main(){
	vector<vector<char> > board;
	vector<char> ele;
	ele.push_back('a');
	ele.push_back('b');
	board.push_back(ele);
	cout<<exist(board,"ab")<<endl;
 	return 0;
}