

/*
 *	d[i] 表示在i这个点卖出能得到的最大收益，
 *  每次都更新在今天之前（包括今天）里成交价格的最小值
 */
int maxProfit(vector<int>& prices) {
	int max = 0;
	if(prices.empty())	return 0;
	int preMin = prices[0];

	for(int i = 0; i < prices.size(); i ++){
		if(prices[i] - preMin > max)
			max = prices[i] - preMin;

		if(prices[i] < preMin)
			preMin = prices[i];
	}

	return max;        
}