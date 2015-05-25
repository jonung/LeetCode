#include<cstdio>
#include<iostream>
#include<string>
#include<cstring>

using namespace std;

/*
 *	字符串低位优先排序
 *
 *
 */
void LSDSort(string str[], int w, int N){
	
	int R = 256;
	string * aux = new string[N];
	memset(aux,0,N * sizeof(string));

	for(int i = w -1; i >= 0; i --){
		int * count = new int[R + 1];
		memset(count,0,(R + 1) * sizeof(int));

		for(int j = 0; j < N; j ++){
			count[str[j].at(i) + 1] ++;
		}

		for(int j =1; j < R; j ++){
			count[j] = count[j] + count[j-1];
		}

		for(int j = 0; j < N; j ++){
			aux[ count[str[j].at(i)] ++] = str[j];
		}

		for(int j = 0; j < N; j ++)
			str[j] = aux[j];
	}
}


int main(){
	return 0;
}