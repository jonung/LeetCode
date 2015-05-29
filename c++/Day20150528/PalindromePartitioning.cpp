#include<cstdio>
#include<vector>
#include<string>
#include<iostream>
#include<cstring>
using namespace std;

bool ** isPalindrome;

void isPalindromeFun(string s){
	isPalindrome = new bool*[s.length()];
	for(int i = 0; i < s.length(); i ++){
		isPalindrome[i] = new bool[s.length()];
		memset(isPalindrome[i],0,s.length() * sizeof(bool));
	}

	for(int i = s.length() - 1; i >= 0; i --){

		for(int j = i; j < s.length(); j ++){
			if( ( s.at(i) == s.at(j) )  && ( (j -i <= 1) || isPalindrome[i+1][j-1]) ){
				isPalindrome[i][j] = true;
			}
		}

	}

	for(int i = 0; i < s.length(); i ++ ){
		for(int j = 0; j < s.length(); j ++){
			cout<<isPalindrome[i][j]<<"  ";
		}
		cout<<endl;
	}
}



vector<vector<string> > * aux;
bool * flag;

vector<vector<string> > partition(string s,int start , int end) {
	vector<vector<string> > res;

	if(start > end){
		return res;
	}

	for(int i = end; i >= start; i --){

		if(isPalindrome[start][i]){
			
			string tmp = s.substr(start,i + 1 - start);		

			//vector<vector<string> > bac = partition(s,i + 1,end);
			vector<vector<string> > bac;
			if(flag[i+1] ) {
				 bac = aux[i+1];
			}
			else{
				 bac = partition(s,i + 1,end);
				 aux[i+1] = bac;
				 flag[i+1] = true;
 			}
			
			
			if(bac.size()== 0){
				vector<string> ele;
				ele.push_back(tmp);
				res.push_back(ele);
			}
			else{
				for(int j = 0; j < bac.size(); j ++){
					vector<string> ele;
					ele.push_back(tmp);
					for(int m = 0; m < bac[j].size(); m ++){
						ele.push_back(bac[j][m]);
					}

					res.push_back(ele);
				}

			}

		}

	}

	
	return res;
}

vector<vector<string> > partition(string s) {
	
	aux = new vector<vector<string> >[s.length() + 1];
	vector<string> last;
	aux[s.length()].push_back(last);
	flag = new bool[s.length() + 1];
	memset(flag,0,(s.length() + 1) * sizeof(bool) );

	flag[s.length()] = true;

	isPalindromeFun(s);
	return partition(s,0,s.length() - 1);
}



int main(){
	string s("amanaplanacanalpanama");
	vector<vector<string> > res = partition(s);
	return 0;
}