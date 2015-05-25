

/*
 *	实际上就是找递增序列
 *
 */
int maxProfit(vector<int>& prices) {
	if(prices.empty())	return 0;

	int max = 0;
	int start = prices[0];

	for(int i = 1; i < prices.size(); i ++){
		if(prices[i] >= start){
			max = max + prices[i] - start;
		}
		
		start = prices[i];
		
	}

	return max;        
}