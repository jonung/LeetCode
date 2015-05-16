#include<cstdio>
#include<iostream>
#include<string>


using namespace std;


/*
 *  递归解法
 *  超时
 */

bool help(string s1,string s2, string s3){
	if(s1.size() == 0)
		return s2 == s3;

	if(s2.size() == 0)
		return s1 == s3;

	if(s3.size() == 0)
		return false;

	char c1 = s1.at(0);
	char c2 = s2.at(0);
	char c3 = s3.at(0);

	if(c1 != c3 && c2 != c3)
		return false;
	if(c1 == c3 && c2 == c3){
		return help(s1.substr(1),s2,s3.substr(1)) || help(s1,s2.substr(1),s3.substr(1));
	}
	else{
		if(c1 == c3){
			return help(s1.substr(1),s2,s3.substr(1));
		}

		if(c2 == c3){
			return help(s1,s2.substr(1),s3.substr(1));
		}
	}

	return true;
}

bool isInterleave(string s1, string s2, string s3) {
	return help(s1,s2,s3);
}

/*
 * 动态规划
 * aux[i][j]表示用s1的前i个字符和s2的前j个字符能不能按照规则表示出s3的前i+j个字符
 * 时间复杂度为： O(m * n)，空间复杂度为 ：O(m * n)
 */
bool isInterleaveSolution2(string s1, string s2, string s3) {
	int m = s1.size();
	int n = s2.size();
	int len = s3.size();

	if((m + n) != len)
		return false;

	if(m == 0)
		return s2 == s3;
	if(n == 0)
		return s1 == s3;


	int aux[m+1][n+1];
	memset(aux,0,sizeof(aux));
	
	for(int i = 0; i < m + 1; i ++){
		for(int j = 0; j < n + 1; j ++){
			if(i == 0 && j == 0)
				aux[i][j] = 1;
			else if(i == 0){
				if(aux[i][j-1] == 1 && s2.at(j - 1) == s3.at(j - 1) ){
					aux[i][j] = 1;
				}
				else
					aux[i][j] = 0;
			}
			else if(j == 0){
				if(aux[i-1][j] == 1 && s1.at(i-1) == s3.at(i-1) )
					aux[i][j] = 1;
				else
					aux[i][j] = 0;
			}
			else{
				if( (aux[i][j-1] == 1 && s2.at(j-1) == s3.at(i + j - 1)) ||
				    (aux[i-1][j] == 1 && s1.at(i-1) == s3.at(i + j - 1)) ){
					aux[i][j] = 1;
				}
				else
					aux[i][j] = 0;
			}
		}
	}

	return aux[m][n] == 1;
}

/*
 * 接上一个解法，对动态规划所用的空间进行优化
 * 空间复杂度为O(n)
 *
 */
bool isInterleaveSolution3(string s1, string s2, string s3) {
	int m = s1.size();
	int n = s2.size();
	int len = s3.size();

	if((m + n) != len)
		return false;

	if(m == 0)
		return s2 == s3;
	if(n == 0)
		return s1 == s3;

	bool aux[n+1];
	aux[0] = true;
	for(int j = 1; j < n + 1; j ++){
		aux[j] = aux[j-1] && (s2.at(j-1) == s3.at(j-1));
	}

	for(int i = 1; i < m + 1 ; i ++){
		
		for(int j = 0; j < n + 1; j ++){
			aux[j] = aux[j] && s1.at(i-1) == s3.at(i + j -1);
		}

		for(int j = 1; j < n + 1; j ++){
			aux[j] = aux[j] || (aux[j - 1] && s2.at(j - 1) == s3.at(i + j - 1));
		}
	}

	return aux[n];

}


int main(){
	string s[3];
	for(int i = 0; i < 3; i ++){
		getline(cin,s[i]);
	}
	cout<<isInterleave(s[0],s[1],s[2])<<endl;
	cout<<isInterleaveSolution3(s[0],s[1],s[2]);
	return 0;
}