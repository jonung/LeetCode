#include<cstdio>
#include<string>
#include<iostream>

using namespace std;

/*
 *	返回字符串s第d个位置的字符，若超出字符串长度返回-1
 *
 */
int charAt(string s, int d){
	if(d < s.length())
		return s.at(d);
	else
		return -1;
}

/*
 *	交换两个元素
 *
 */
void exch(string data[],int i, int j){
	string tmp = data[i];
	data[i] = data[j];
	data[j] = tmp;
}


/*
 *	对第lo到hi个之间的字符串按第d个字符进行排序
 *
 */
void helpQuick3StringSort(string data[],int lo, int hi, int d){
	if(hi <= lo)
		return;
	int lt = lo,gt = hi;
	int v = charAt(data[lo],d);
	int i = lo + 1;

	while(i <= gt){
		int t = charAt(data[i],d);
		if(t < v){
			exch(data,lt++,i++);
		}
		else if(t > v){
			exch(data,gt --, i);
		}
		else
			i ++;
	}

	helpQuick3StringSort(data,lo,lt-1,d);
	if(v >= 0){
		helpQuick3StringSort(data,lt,gt,d + 1);
	}
	helpQuick3StringSort(data,gt + 1,hi,d);

}


/*
 *	三向字符串快速排序
 *	能够很好的处理等值键，有较长公共前缀的键，取值范围较小的键和小数组
 *
 *
 */

void quick3StringSort(string data[], int N){
	helpQuick3StringSort(data,0,N-1,0);
}

int main(){
	string str[3] = {"aa","ac","ad"};
	int N = sizeof(str) / sizeof(string);
	quick3StringSort(str,N);
	for(int i = 0; i < 3; i ++)
		cout<<str[i]<<endl;
	return 0;
}