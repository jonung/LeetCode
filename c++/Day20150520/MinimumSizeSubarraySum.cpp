#include<cstdio>
#include<vector>
#include<algorithm>

using namespace std;

int minSubArrayLen(int s, vector<int>& nums) {
	int pre = 0;
	int min = 0;

	int sum = 0;
	int i = 0;
	for(; i < nums.size(); i ++){
		if(nums[i] >= s)
			return 1;
		sum += nums[i];
		if(sum >= s){
			min = i+ 1;
			break;
		}
	}

	if(min == 0)
		return 0;
	else{

		for(int j  = pre; j < i; j ++){
			if(sum - nums[j] >= s){
				sum = sum - nums[j];
			}
			else{
				pre = j;
				if(i - pre + 1 < min)
					min = i -pre + 1;
				break;
			}
		}

		for(int j = i + 1; j < nums.size(); j ++){
			if(nums[j] >= s)
				return 1;
			sum = sum + nums[j];
			int m = pre;
			for(; m < j; m ++){
				if(sum - nums[m] >= s){
					sum = sum - nums[m];
				}
				else{
					break;
				}
			}

			pre = m;
			if(j -pre + 1 < min)
			    min = j - pre + 1;
		}
	}

	return min;
}

/*
 *	O(n)
 *	
 */
int minSubArrayLenModified(int s, vector<int>& nums) {
	int min = 0;

	int first = 0;
	int second = 0;

	int sum = 0;
	for(int i = 0; i < nums.size(); i ++){
		if(nums[i] >= s)
			return 1;
		sum = sum + nums[i];
		if(sum >= s){
			second = i;
			min = second - first + 1;
			break;
		}

	}

	while(second < nums.size()){
		for(int i = first; i < second; i ++){
			if(sum - nums[i] >= s){
				sum = sum - nums[i];
			}
			else{
				first = i;
				if(second - first + 1 < min)
					min = second - first + 1;
				break;
			}
		}

		second = second + 1;
		if(second < nums.size())
			sum = sum + nums[second];
	}

	return min;
}

/*
 * O(nlog(n))
 * 
 */
int minSubArrayLenSolution2(int s, vector<int>& nums) {
	vector<int> sums;
	sums.push_back(0);
	for(int i = 0; i < nums.size(); i ++){
		sums.push_back(sums[i] + nums[i]);
	}
	int res = sums.size();
	for(int i = 0; i < sums.size(); i ++){
		int right = help(i + 1, sums.size() - 1, sums[i] + s, sums);
		if(right == sums.size())	break;//在第i个sum时已经找不到满足条件的值，后续也找不到了
		if(right - i < res)
			res = right - i;
	}

	return res == sums.size() ? 0 : res;
}


int help(int l, int r,int key, vector<int>& sums){
	while(l <= r){
		int mid = l + (r - l) / 2;
		if(sums[mid] < key){
			l = mid + 1;
		}
		else{
			r = mid - 1;
		}
	}
	return l;//注意返回值
}

int main(){

	return 0;
}