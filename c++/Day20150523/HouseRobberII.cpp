#include<cstdio>
#include<vector>
#include<algorithm>

using namespace std;

int rob(vector<int>& nums) {
	if(nums.size() == 0)
		return 0;
	if(nums.size() == 1)
		return nums[0];
	int pre1 = 0;
	int cur1 = 0;
	for(int i = 0; i < nums.size() - 1; i ++){
		int tmp = pre1;
		pre1 = cur1;
		cur1 = max(nums[i] + tmp,pre1); 
	}

	int pre2 = 0;
	int cur2 = 0;
	for(int i = 1; i < nums.size(); i ++){
		int tmp = pre2;
		pre2 = cur2;
		cur2 = max(nums[i] + tmp,pre2); 
	}


	return max(cur1,cur2);
}

int main(){
	vector<int> nums;
	nums.push_back(2);
	nums.push_back(1);
	nums.push_back(3);
	printf("%d\n",rob(nums));
	return 0;
}