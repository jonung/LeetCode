#include<iostream>
#include<deque>
#include<vector>
#include<stack>

using namespace std;

stack<int> inMax;
stack<int> outMax;

stack<int> inData;
stack<int> outData;

int maxValue(int x ,int y){
	return x > y ? x : y;
}

void pushValue(stack<int>& inData, stack<int>& inMax,int value){
	inData.push(value);
	if(inMax.empty())
		inMax.push(value);
	else{
		inMax.push(maxValue(inMax.top(),value));
	}
}

void popValue(stack<int>& inData, stack<int>& outMax, stack<int>& inMax){
	if(!outMax.empty()){
		outMax.pop();
		outData.pop();
	}
	else{
		while(!inData.empty()){
			int top = inData.top();
			pushValue(outData,outMax,top);

			inData.pop();
			inMax.pop();
		}
		outMax.pop();
		outData.pop();
	}
}

int getMaxValue(stack<int>& inMax, stack<int>& outMax){
	int max = -1<<30;

	if(!outMax.empty() && outMax.top() > max )
		max = outMax.top();
	if(!inMax.empty() && inMax.top() > max)
		max = inMax.top();
	cout<<"max: " <<max<<endl;	
	return max;
}

vector<int> fun(vector<int>& nums, int k ){
	vector<int> res;
	if(nums.size() == 0 ) 	return res;

	for(int i = 0; i < k; i ++){
		pushValue(inData,inMax,nums[i]);
	}

	int j = getMaxValue(inMax,outMax);
	res.push_back(j);

	for(int i = k; i < nums.size(); i ++){
		popValue(inData,outMax,inMax);
		pushValue(inData,inMax,nums[i]);

		res.push_back(getMaxValue(inMax,outMax));
	}

	return res;
}	

vector<int> solution2(vector<int>& nums, int k){
	vector<int> res;
	if(nums.size() == 0 ) 	return res;

	deque<int> deque;
	for(int i = 0; i < k; i ++){
		while(!deque.empty() && deque.back() < nums[i] ){
			deque.pop_back();
		}
		deque.push_back(nums[i]);
	}
	res.push_back(deque.front());

	for(int i = k; i < nums.size(); i ++){

		while(!deque.empty() && deque.back() < nums[i] ){
			deque.pop_back();
		}
		deque.push_back(nums[i]);

		if(deque.front() == nums[i - k])
			deque.pop_front();
		res.push_back(deque.front());
	}
	return res;
}

int main(){
	vector<int> nums;
	int n,k;
	scanf("%d%d",&n,&k);

	for(int i = 0; i < n; i ++){
		int temp;
		scanf("%d", &temp);
		nums.push_back(temp);
	}
	
	/* vector<int> res = fun(nums,k); */
	vector<int> res = solution2(nums,k);

	for(int i = 0; i < res.size(); i ++)
		cout<<res[i]<<" ";
	cout<<endl;

	return 0;
}
