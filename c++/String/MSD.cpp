#include<cstdio>
#include<iostream>
#include<string>
#include<cstring>

using namespace std;

const int M = 15;
const int R = 256;
string * aux;

int  MSD_charAt(string s, int d){
	if(d < s.length()){
		return s.at(d);
	}
	else{
		return -1;//字符串长度不足d
	}
}

void helpMSDsort(string data[],int lo, int hi, int d) {

	if(hi <= lo)//可在此切换到插入排序
		return;

	int count[R+2];
	memset(count,0,sizeof(count));

	for(int i = lo; i <= hi; i ++){
		count[MSD_charAt(data[i],d) + 2] ++;
	}

	for(int i = 1; i < R + 1; i ++){
		count[i] = count[i-1] + count[i];
	}

	for(int i = lo; i <= hi; i ++){
		aux[count[MSD_charAt(data[i], d) + 1] ++ ] = data[i];
	}

	for(int i = lo; i <= hi; i ++){
		data[i] = aux[i - lo];
	}

	for(int r = 0; r < R; r ++){
		helpMSDsort(data,lo + count[r],lo + count[r+1] - 1,d + 1);
	}
}


void MSDSort(string data[],int N){
	aux = new string[N];
	memset(aux,0,N * sizeof(string));
	helpMSDsort(data,0,N-1,0);
}

int main(){
	
	string str[3] = {"aa","ac","ad"};
	int N = sizeof(str) / sizeof(string);
	MSDSort(str,N);
	for(int i = 0; i < 3; i ++)
		cout<<str[i]<<endl;
	

	return 0;
}