#include<cstdio>
#include<vector>
#include<cstring>

using namespace std;

int maxProfit(vector<int>& prices) {
	if(prices.empty())	return 0;
	
	int N = prices.size();
	int * pre = new int[N];
	int * res = new int[N];

	memset(pre,0,N * sizeof(int));
	memset(res,0,N * sizeof(int));

	int posPreMin = 0;
	for(int i = 1; i < prices.size(); i ++){
		res[i] = prices[i] - prices[posPreMin];

		if(prices[i] > prices[posPreMin]){			
			pre[i] = posPreMin;
		}
		else {
			pre[i] = i;
			posPreMin = i;
		}
		
	}

	int max = res[0];
	int posMax = 0;
	for(int i = 0;i < N; i ++){
		if(res[i] > max){
			max = res[i];
			posMax = i;
		}

	}

	int secondChoice = 0;
	for(int i = 0; i < pre[posMax]; i ++)
		if(res[i] > secondChoice)
			secondChoice =  res[i];

	int secondPreMin = prices[posMax];
	for(int i = posMax; i < N; i ++){
		if(prices[i] - secondPreMin > secondChoice){
			secondChoice = prices[i] - secondPreMin;
		}

		if(prices[i] < secondPreMin)
			secondPreMin = prices[i];
	}

	return max + secondChoice;       
}

int main(){
	vector<int> p;
	p.push_back(4);
	p.push_back(2);
	p.push_back(1);
	printf("%d\n", maxProfit(p));
	return 0;
}