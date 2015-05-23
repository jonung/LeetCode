#include<cstdio>
#include <cassert>
#include <cstring>
#include <string>
#include <algorithm>
#include<iostream>

using namespace std;


/*
 *
 *	naive solution 
 *	TLE
 */
bool isPalindrome(string s,int l, int r){
	

	while(l < r){
		if(s[l++] != s[r--])
			return false;
	}

	return true;
}
string shortestPalindrome(string s) {
	string front = "";
	for(int i = s.length() -1; i >= 0; i --){
		
		if(isPalindrome(s,0,i)){
			return front + s;
		}

		front = front + s[i];

		//cout<<"front: " <<front<<endl;
		
	}

	return front + s;
}

/*
 *
 *	
 *
 */
string shortestPalindromeSolution2(string s) {
	string front = "";

	int l = 0;
	int r = s.length() -1;

	while(l < r){		
		if(s[l] == s[r]){			
			l ++;			
		}
		else{//关键 回退
		    if(s[r] != s[l-1])
		        l = 0;
		}
		
		front = front + s[r];
		r --;
	}

	for(int i = l; i < s.length(); i ++)
		front += s[i];

	return front;
}

int main(){

	string s("baa");
	
	cout<<shortestPalindromeSolution2(s)<<endl;


	return 0;
}