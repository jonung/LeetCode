#include<cstdio>
#include<string>
#include<iostream>

using namespace std;

class Quick3Way{

public:
	static void exch(string * a, int p, int q){
		string tmp = a[p];
		a[p] = a[q];
		a[q] = tmp;
	}

	static void sort(string * a, int len){
		sort(a,0,len - 1);
	}

	static void sort(string * a,int start, int end){
		if(end <= start)
			return;

		int lp = start;
		int lt = end;
		string key = a[lp];

		int pos = lp + 1;

		while(pos <= lt){
			if(a[pos] == key){
				pos ++;
			}
			else if(a[pos] < key){
				exch(a,pos,lp);
				lp ++;
				pos ++;
			}
			else{
				exch(a,pos,lt);
				lt --;
			}

		}

		sort(a,start,lp-1);
		sort(a,lt+1,end);

	}
};

class SuffixArray{

private:
	string str;
	string * suffixes;
	int N;

public:

	SuffixArray(string str){
		this->str = str;
		N = str.length();

		suffixes = new string[N];

		for(int i = 0; i < N; i ++){
			suffixes[i] = str.substr(i);
		}

		Quick3Way::sort(suffixes,N);
	}

	int lenght(){
		return N;
	}

	string select(int i){
		return suffixes[i];
	}

	int index(int i){
		return N - suffixes[i].length();
	}

	int lcp(int i){
		return lcp(suffixes[i-1],suffixes[i]);
	}

	int lcp(string p,string q){
		int n = p.length();
		if(n > q.length())
			n = q.length();

		for(int i = 0; i < n; i ++){
			if(p.at(i) != q.at(i)){
				return i;
			}
		}

		return n;
	}


	int rank(string key){
		int lo = 0;
		int hi = N - 1;

		while(lo <= hi){
			int mid = lo + (hi - lo) / 2;
			if(suffixes[mid] == key){
				return mid;
			}
			else if(suffixes[mid] < key){
				lo = mid + 1;
			}
			else{
				hi = mid -1;
			}
		}

		return lo;

	}

	string lrs(){
		string res = "";
		for(int i = 1; i < N; i ++){
			int curlcp = lcp(i);

			if(curlcp > res.length()){
				res = suffixes[i].substr(0,curlcp);
			}
		}

		return res;
	}

	vector<string> findRepeatedDnaSequences(int k) {
		vector<string> res;
        for(int i = 1; i < N; i ++){
			int curlcp = lcp(i);
			if(curlcp == k)
				res.push_back(suffixes[i].substr(0,curlcp));
			
		}

		return res;
    }	

	void show(){
		for(int i = 0; i < N; i ++){
			cout<<suffixes[i]<<endl;
		}
	}
};

int main(){

	SuffixArray sa("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
	//sa.show();
	cout<<sa.lrs()<<endl;
	sa.findRepeatedDnaSequences(10);
	return 0;
}