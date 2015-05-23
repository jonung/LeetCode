#include<cstdio>
#include<vector>
#include<iostream>


using namespace std;

vector<vector<int> > data;
vector<vector<int> > aux;

vector<vector<int> > reverseData;

int maxScore(vector<vector<int> >& data, vector<vector<int> >& aux){
	int r = aux.size();
	int c  = aux[0].size();

	for(int i = c - 2; i >= 0; i --){//从第i列开始
		for(int j = 0; j < r; j ++){//第j行

			if(data[j][i] == -1){
				aux[j][i] = -1;
			}
			else{
				int max = -1;
				int sum = data[j][i];
				if(aux[j][i+1] + 1 == 0){
					sum = -1;
				}
				else{
					sum = sum + aux[j][i+1];
				}

				if(sum > max)
					max = sum;

				sum = data[j][i];
				//向上走
				for(int m = j -1; m >= 0; m --){
					if( data[m][i]  + 1 == 0){
						break;
					}
					else{
						sum = sum + data[m][i];
						if(aux[m][i+1] != -1 && sum + aux[m][i+1] > max){
							max = sum + aux[m][i+1];
						}
					}
				}
				//向下走
				sum = data[j][i];
				for(int m = j + 1; m < r; m ++){
					if(data[m][i] == -1){
						break;
					}
					else{
						sum = sum + data[m][i];

						if(aux[m][i+1] != -1 && sum + aux[m][i+1] > max){
							max = sum + aux[m][i+1];
						}
					}
				}

				aux[j][i] = max;//
			}

		}
	}

	int res = -1;
	for(int i = 0; i < r; i ++){
		if(aux[i][0] > res)
			res = aux[i][0];
	}
	return res;
}

int maxAmongThree(int x,int y, int z){
	int tmp;
	if(x > y){
		tmp = x;
	}
	else{
		tmp = y;
	}

	if(tmp > z)
		return tmp;
	else{
		return z;
	}


}

/*
 *	用一个数组aux来保存状态，初始化为0
 * 	aux[i][j] 表示从第i行j个数开始移动能得到的最大值
 *  注意aux比原数组data多了一列，这使得对data最后一列不用做特殊处理
 *  
 *  从data最后一列开始，计算aux[i][j]
 * 	这里用到了两个辅助数组，up和down来帮助减少计算
 *  p[i]表示元素往上走能到的最大值，p[i] = max(data[i-1][j] + aux[i-1][j+1],up[i-1]) + data[i][j]
 *  down[i]表示元素往下走能得到的最大值,down[j] = max(data[i+1][j] + aux[i+1][j+1] ,down[i+1]) + data[i][j]
 *  这里要注意考虑各个元素为-1的情况
 *
 *  再算出down[i]的值时即可计算aux[i][j]，aux[i][j] = max(up[i],down[i],data[i][j] + aux[i][j+1])
 *
 *	最后，算法总得时间复杂度为O(n * (2 * n)) = O(n^2),应该算是最优解了  
 *
 */
int maxScoreImproved(vector<vector<int> >& data, vector<vector<int> >& aux){
	int r = aux.size();
	int c = aux[0].size();

	for(int j = c - 2; j >= 0; j --){
		vector<int> up;
		vector<int> down;

		printf("current aux\n" );
		for(int xx = 0; xx < aux.size(); xx ++){

			for(int yy = 0; yy < aux[0].size(); yy ++){
				printf("%d ", aux[xx][yy]);
			}
			printf("\n");
		}

		for(int i = 0; i < r; i ++){

			if(i == 0){
				up.push_back(-1);
			}
			else{
				if(data[i][j] != -1 ){
					if(data[i - 1][j] != -1 && aux[i-1][j+1] != -1 && aux[i-1][j+1] + data[i-1][j] > up[i-1])
						up.push_back(data[i][j] + data[i-1][j] + aux[i-1][j+1]);
					else if(up[i-1] != -1)
						up.push_back(data[i][j] + up[i-1]);
					else
						up.push_back(-1);
				}
				else
					up.push_back(-1);
			}

		}

		for(int i = r - 1; i >= 0; i --){
			if(i == r-1){
				down.push_back(-1);
			}
			else{
				if(data[i][j] != -1){
					
					if(data[i+1][j] != -1 && aux[i+1][j+1] != -1 && aux[i+1][j+1] + data[i+1][j] > down[r-i-2]){
						down.push_back(data[i][j] + data[i+1][j] + aux[i+1][j+1]);
					}
					else if(down[r-i-2] != -1)
						down.push_back(data[i][j] + down[r-i-2]);
					else
						down.push_back(-1);
				}
				else
					down.push_back(-1);
			}

			int directRight = -1;
			if(data[i][j] != -1 && aux[i][j+1] != -1)
				directRight = data[i][j] + aux[i][j+1];

			aux[i][j] = maxAmongThree(directRight,up[i],down[r-i-1]);
		}


	}

	//teleport
	vector<vector<bool> > flag;
	for(int i = 0; i < data.size(); i ++){
		vector<bool> ele;
		for(int j = 0; j < data[0].size(); j ++){
			ele.push_back(false);
		}
		flag.push_back(ele);
	}

	for(int j = 0; j < data[0].size(); j ++){
		for(int i = 0; i < data.size(); i ++){
			if(j == 0){
				if(data[i][j] != -1){
					flag[i][j] = true;
					if(data[i][j+1] != -1)
						flag[i][j+1] = true;
				}
			}
			else{
				if(flag[i][j]){

					int m;
					for(m = i-1; m >= 0; m --){
						if(flag[m][j])
							break;
						else{
							if(data[m][j] != -1)
								flag[m][j] = true;
							else{
								break;
							}
						}
					}

					if(flag[0][j] && data[data.size() -1][j] != -1){
						
						for(m = data.size() -1; m >=0; m --){
							if(flag[m][j])
								break;
							else{
								if(data[m][j] != -1)
									flag[m][j] = true;
								else
									break;
							}
						}
					}

					for(m = i +1; m < data.size(); m ++){
						if(flag[m][j]){
							break;
						}
						else{
							if(data[m][j] != -1)
								flag[m][j] = true;
							else
								break;
						}
					}

					if(flag[data.size() -1][j] && data[0][j] != -1){
						for(m = 0; m < data.size(); m ++){
							if(flag[m][j]){
								break;
							}
							else{
								if(data[m][j] != -1)
									flag[m][j] = true;
								else
									break;
							}
						}
					}

				}
			}
		}

		for(int i = 0; i < data.size(); i ++){
			if(flag[i][j] && j + 1 < data[0].size() && data[i][j+1] != -1)
				flag[i][j+1] = true;
		}

		printf("current flag\n");
		for(int xx = 0; xx < data.size(); xx ++){
			for(int yy = 0; yy< data[0].size(); yy ++)
				cout<<flag[xx][yy]<<" ";
			printf("\n");
		}
	}

	int res = -1;
	for(int i =0; i < r; i ++)
		if(aux[i][0] > res)
			res = aux[i][0];

	for(int j = 0; j < data[0].size(); j ++){
		if(aux[0][j] > res && flag[0][j])
			res = aux[0][j];

		if(aux[r-1][j] > res && flag[r-1][j])
			res = aux[r-1][j];
	}

	return res;

}

void solve(vector<vector<int> >& data, vector<vector<int> >& aux, int endColumn){
	aux.clear();
	int r = data.size();
	int c = data[0].size() + 1;

	//init aux
	for(int i = 0; i < r; i ++){
		vector<int> ele;
		for(int j = 0; j < c; j ++){
			ele.push_back(0);
		}
		aux.push_back(ele);
	}

	for(int j = c - 2; j >= endColumn; j --){
		vector<int> up;
		vector<int> down;

		printf("current aux\n" );
		for(int xx = 0; xx < aux.size(); xx ++){

			for(int yy = 0; yy < aux[0].size(); yy ++){
				printf("%d ", aux[xx][yy]);
			}
			printf("\n");
		}

		for(int i = 0; i < r; i ++){

			if(i == 0){
				up.push_back(-1);
			}
			else{
				if(data[i][j] != -1 ){
					if(data[i - 1][j] != -1 && aux[i-1][j+1] != -1 && aux[i-1][j+1] + data[i-1][j] > up[i-1])
						up.push_back(data[i][j] + data[i-1][j] + aux[i-1][j+1]);
					else if(up[i-1] != -1)
						up.push_back(data[i][j] + up[i-1]);
					else
						up.push_back(-1);
				}
				else
					up.push_back(-1);
			}

		}

		for(int i = r - 1; i >= 0; i --){
			if(i == r-1){
				down.push_back(-1);
			}
			else{
				if(data[i][j] != -1){
					
					if(data[i+1][j] != -1 && aux[i+1][j+1] != -1 && aux[i+1][j+1] + data[i+1][j] > down[r-i-2]){
						down.push_back(data[i][j] + data[i+1][j] + aux[i+1][j+1]);
					}
					else if(down[r-i-2] != -1)
						down.push_back(data[i][j] + down[r-i-2]);
					else
						down.push_back(-1);
				}
				else
					down.push_back(-1);
			}

			int directRight = -1;
			if(data[i][j] != -1 && aux[i][j+1] != -1)
				directRight = data[i][j] + aux[i][j+1];

			aux[i][j] = maxAmongThree(directRight,up[i],down[r-i-1]);
		}


	}

}

int maxScoreImproved2(vector<vector<int> >& data, vector<vector<int> >& aux){
	solve(data,aux,0);
	int res = -1;
	for(int i = 0; i < data.size(); i ++)
		if(aux[i][0] > res)
			res = aux[i][0];

	vector<int> rOrdinary;
	vector<int> cOrdinary;
	vector<int> candidateRes;

	int maxColumen = data[0].size();
	for(int j = 1; j < data.size(); j ++){
		if(aux[0][j] > res){
			rOrdinary.push_back(0);
			cOrdinary.push_back(j);
			candidateRes.push_back(aux[0][j]);

			if(j < maxColumen)
				maxColumen = j;
		}

		if(aux[data.size() - 1][j] > res){
			rOrdinary.push_back(data.size() - 1);
			cOrdinary.push_back(j);
			candidateRes.push_back(aux[data.size() - 1][j]);
			if(j < maxColumen)
				maxColumen = j;
		}
	}

	if(rOrdinary.empty() )
		return res;

	
	for(int i = 0; i < data.size(); i ++){
		vector<int> ele;
		for(int j = data[0].size() - 1; j >= 0; j --){
			ele.push_back(data[i][j]);
		}
		reverseData.push_back(ele);
	}

	solve(reverseData,aux,maxColumen);
	for(int i = 0; i < cOrdinary.size(); i ++){
		int rr = cOrdinary[i];
		int cc = cOrdinary[i];

		if(aux[rr][data[0].size() - 1 - cc] != -1 && candidateRes[i] > res){

			res = candidateRes[i];
		}
	}

	return res;
}

int main(){
	int n,m;
	scanf("%d%d",&n,&m);
	for(int i = 0; i < n; i ++){
		vector<int> ele;
		vector<int> aux_ele;
		for(int j = 0; j < m; j ++){
			int tmp;
			scanf("%d",&tmp);
			ele.push_back(tmp);
			aux_ele.push_back(0);
		}
		aux_ele.push_back(0);
		data.push_back(ele);
		aux.push_back(aux_ele);
	}


	for(int i = 0; i < n; i ++){

		for(int j = 0; j < m; j ++){
			printf("%d ", data[i][j]);
		}
		printf("\n");
	}


	printf("aux init \n");
	for(int i = 0; i < aux.size(); i ++){

		for(int j = 0; j < aux[0].size(); j ++){
			printf("%d ", aux[i][j]);
		}
		printf("\n");
	}



	//int res = maxScore(data,aux);
	//printf("max is : %d\n", res);
	int res2 = maxScoreImproved(data,aux);

	
	printf("max is : %d\n", res2);

	for(int i = 0; i < aux.size(); i ++){

		for(int j = 0; j < aux[0].size(); j ++){
			printf("%d ", aux[i][j]);
		}
		printf("\n");
	}
	return 0;
}
