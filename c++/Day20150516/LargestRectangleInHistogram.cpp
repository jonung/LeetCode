#include<cstdio>
#include<vector>
#include<stack>
#include<algorithm>

using namespace std;

vector<int> v;

int largestRectangleArea(vector<int>& height) {
	if( height.size() == 0)
		return 0;
	int area = 0;
	stack<int> stack;
	

	for(int i = 0; i < height.size(); i ++){
		
		if(stack.empty() || height[i] >= height[stack.top()]){
			stack.push(i);
		}
		else{
			int topEle = stack.top();
			stack.pop();
			int width = stack.empty() ? i : i - stack.top() - 1;

			printf("%d  %d\n", height[topEle], width);
			area = max(area,height[topEle] * width);
			i --;
		}

	}

	while(!stack.empty()){
		int topEle = stack.top();
		stack.pop();
		int width = stack.empty() ? height.size() : height.size() - stack.top() - 1;
		printf("ele and width : %d  %d\n", height[topEle], width);
		area = max(area,height[topEle] * width);
	}

	return area;
}

int main(){
	int n;
	while(scanf("%d",&n) == 1){
		v.clear();
		for(int i = 0; i < n; i ++){
			int tmp;
			scanf("%d",&tmp);
			v.push_back(tmp);
			//printf(" %d ", v[i]);
		}


		int area = largestRectangleArea(v);
		printf("largest area is : %d\n", area);
	}

	return 0;
}