#include<cstdio>
#include<string>
#include<iostream>
#include<cstring>

using namespace std;

const int R = 256;

/*
 *	KMP算法，适合查找自我重复性的模式字符串
 *
 *
 */

class KMP{

private:

	string pat;//模式字符串
	int * dfa[R];//模式字符串对应的有限状态自动机，大小为R * M,R为字母表大小，
				 //	M为模式字符串长度

public:

	KMP(string pat){
		this->pat = pat;
		int M = pat.length();
		
		//分配空间存储自动机
		for(int i = 0 ; i < R; i ++){
			dfa[i] = new int[M];
			memset(dfa[i],0,M * sizeof(int));
		}
		
		//根据模式字符串构造自动机
		dfa[pat.at(0)][0] = 1;
		for(int X = 0, i = 1; i < M; i ++){
			for(int j = 0; j < R; j ++){
				dfa[j][i] = dfa[j][X];
			}

			dfa[pat.at(i)][i] = i + 1;

			X = dfa[pat.at(i)][X];
		}
	}



	int search(string txt){
		int i,j,N = txt.length(),M = pat.length();

		for(i = 0,j = 0; i < N && j < M; i ++){
			j = dfa[txt.at(i)][j];
		}

		if(j == M){
			return i -M;
		}
		else{
			return N;
		}

	}

};

int main(){

	KMP kmp("ABABAC");
	cout<<kmp.search("BCBAABACAABABABAC")<<endl;
	return 0;
}
