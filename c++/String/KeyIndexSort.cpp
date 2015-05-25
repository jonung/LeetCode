#include<iostream>
#include<string>
#include<cstring>

using namespace std;

/*  
 *	键索引排序
 *	key的范围是[0,R-1]
 *	
 *
 */
vector< pair<int,string> > keyIndexSort(vector<pair<int,string> >& data,int R){
	int * count = new int[R + 1];
	memset(count,0,(R + 1) * sizeof(int));

	int N = data.size();
	
	for(int i = 0; i < N; i ++){
		count[data[i].first + 1] ++;
	}

	for(int i = 1; i < R; i ++){
		count[i] = count[i-1] + count[i];
	}

	vector<pair<int,string> > aux(data.begin(),data.end());

	for(int i = 0; i < N; i ++){
		
		aux[ count[data[i].first] ++ ] = data[i];
	}

	return aux;
}

int main(){

	return 0;
}