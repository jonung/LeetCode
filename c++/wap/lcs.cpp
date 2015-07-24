#include<cstdio>
#include<vector>
#include<iostream>

using namespace std;

vector<int> lcs(vector<int>& nums){
	vector<int> res;
	if(nums.size() == 0)	return res;

	int before = 1;
	int max = 1;
	int pos = 0;

	for(int i = 1; i < nums.size(); i ++){
		if((nums[i] xor nums[i-1]) == 1){
			
			int temp = before + 1;
			if(temp > max){
				max = temp;
				pos = i;
			}
			before = temp;
		}	
		else{
			before = 1;	
		}
		
	}

	for(int i = max - 1; i >= 0; i --)
		res.push_back(nums[pos - i]);
	return res;
}

void show(vector<int>& res){
	for(int i = 0; i < res.size(); i ++)
		cout<<res[i]<<" ";
	cout<<endl;
}
int main(){
	vector<int> nums;
	vector<int> res;

	res = lcs(nums);
	show(res);
	
	//
	nums.push_back(1);
	nums.push_back(1);
	nums.push_back(0);
	nums.push_back(1);
	res = lcs(nums);
	show(res);
	//
	nums.clear();
	nums.push_back(1);
	res = lcs(nums);
	show(res);
	return 0;
}
