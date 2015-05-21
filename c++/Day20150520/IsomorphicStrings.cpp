#include<cstdio>
#include<string>
#include<map>
#include<iostream>

using namespace std;

bool isIsomorphic(string s, string t) {
	map<char,char> m;//保证一个值只映射为一个唯一的值
	map<char,char> m2;//保证一个值只能被一个值映射
	for(int i = 0; i < s.size(); i ++){
		char a = s.at(i);
		char b = t.at(i);

	
		if(m.find(a) == m.end()){
			if(m2.find(b) == m2.end()){
				m.insert(pair<char,char>(a,b));
				m2.insert(pair<char,char>(b,a));
			}			
			else
				return false;
		}
		else{
			char value = m.find(a)->second;
			if(value != b)
				return false;
		}
	}

	return true;
}

int main(){
	cout<<isIsomorphic("abb","caa");
	return 0;
}
