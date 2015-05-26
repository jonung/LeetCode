
int myMin(int x, int y){
	return x > y ? y:x;
}

/*
 *	和杨辉三角那道题类似
 *	aux[j] 表示到达一行第j个元素的最小和
 *	aux[j] = min(aux[j-1],aux[j]) + data[i][j]	
 *	对第一个元素和最后一个元素要特殊处理
 */
int minimumTotal(vector<vector<int> > &triangle) {
	int N = triangle.size();
	int * aux = new int[N];
	memset(aux,0,N * sizeof(int));

	aux[0] = triangle[0][0];

	for(int i = 1; i < N; i ++){
		int j = i;
		aux[j] = aux[j-1] + triangle[i][j];

		for(j = i -1 ; j > 0; j --){
			aux[j] = myMin(aux[j],aux[j-1]) + triangle[i][j];
		}

		aux[0] = aux[0] + triangle[i][0];
	}    

	int min = aux[0];
	for(int i = 1; i < N; i ++){
		if(aux[i] < min)
			min = aux[i];
	}

	return min;
}