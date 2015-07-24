#include<cstdio>
#include<vector>
#include<algorithm>

using namespace std;
int main(){
	vector<int> a;
	a.push_back(1);
	a.push_back(5);
	a.push_back(2);
	sort(a.begin(),a.end());

	for(int i = 0;i < a.size(); i ++)
		printf("%d\n",a[i] );
	return 0;
}