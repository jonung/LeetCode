#include<cstdio>
#include<vector>

using namespace std;

void help(vector<vector<int> >& res, int level, vector<int> path,int n, int sum,int start){
	if(level == 0){
		if(sum == n){
			vector<int> ele(path.begin(),path.end());
			res.push_back(ele);
		}		
		return;
	}

	for(int i = start; i <= 9; i ++){
		path.push_back(i);
		if(sum <= n)
			help(res,level - 1,path,n,sum + i,i + 1);
		path.pop_back();
	}
}

vector<vector<int>> combinationSum3(int k, int n) {
    vector<vector<int> > res;
    vector<int> path;
    help(res,k,path,n,0,1,);
    return res;
}

int main(){

	return 0;
}