#include<cstdio>
#include<vector>
#include<iostream>


using namespace std;

vector<vector<int> > data;
vector<vector<int> > aux;


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


int maxScoreImproved(vector<vector<int> >& data, vector<vector<int> >& aux){
	int r = aux.size();
	int c = aux[0].size();

	for(int j = c - 2; j >= 0; j --){
		vector<int> up;
		vector<int> down;

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


	int res = maxScoreImproved(data,aux);	
	printf("%d\n", res);
	
	return 0;
}
