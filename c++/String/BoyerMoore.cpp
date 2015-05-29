#include<cstdio>
#include<iostream>
#include<string>

using namespace std;

const int R = 256;

class BoyerMoore{

private:

	string pat;
	int right[R];

public:

	BoyerMoore(string pat){
		this->pat = pat;

		for(int i = 0; i < R; i ++){
			right[i] = -1;
		}

		for(int i = 0 ; i < pat.length(); i ++){
			right[pat.at(i)] = i;
		}

	}

	int search(string txt){
		int N = txt.length();
		int M = pat.length();

		int skip = 0;

		for(int i = 0; i <= N - M; ){
			skip = 0;
			for(int j = M-1; j >= 0; j --){
				if(pat.at(j) != txt.at(i + j)){
					skip = j - right[txt.at(i + j)];
					if(skip < 0)	skip = 1;

					break;
				}
			}

			if(skip == 0)	return i;

			i = i +skip;

		}

		return N;
	}


};

int main(){

	BoyerMoore bm("aab");
	cout<<bm.search("babb")<<endl;;

	return 0;
}
