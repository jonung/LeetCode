#include<cstdio>
#include<vector>
#include<stack>
#include<algorithm>

using namespace std;

vector<vector<char> > matrix;

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

			//printf("%d  %d\n", height[topEle], width);
			area = max(area,height[topEle] * width);
			i --;
		}

	}

	while(!stack.empty()){
		int topEle = stack.top();
		stack.pop();
		int width = stack.empty() ? height.size() : height.size() - stack.top() - 1;
		//printf("ele and width : %d  %d\n", height[topEle], width);
		area = max(area,height[topEle] * width);
	}

	return area;
}

int maximalRectangle(vector<vector<char> >& matrix) {
	if(matrix.size() == 0 || matrix[0].size() == 0) //为空，或只有一行的情况
		return 0;	        
	int row = matrix.size();
	int column = matrix[0].size();
	int area = 0;

	vector<int> aux(column);
	for(int i = 0; i < column; i ++)
		aux[i] = 0;
	for(int i = 0; i < row; i ++){
		for(int j = 0; j < column; j ++){
			if(matrix[i][j] == '0'){
				aux[j] = 0;
			}
			else{
				aux[j] = aux[j] + 1;
			}
		}
		area = max(area,largestRectangleArea(aux));
	}

	return area;
}

/*
 *	本题用到了Largest Rectangle in Histogram的解法
 *	需要弄清楚要求解的矩形区域到底是什么，比如对输入为{1}，结果为1 
 *
 */

int main(){
	int m,n;

	while(scanf("%d%d",&m,&n) == 2 && m && n){
		char data[m][n];
		for(int i = 0; i < m; i ++)
			scanf("%s",data[i]);

		matrix.clear();
		for(int i = 0; i < m; i ++){
			vector<char> v;
			for(int j = 0; j < n; j ++){
				v.push_back(data[i][j]);
			}
			matrix.push_back(v);
		}
		/*
		for(int i = 0; i < m; i ++){
			for(int j = 0; j < n; j ++)
				printf("%c",matrix[i][j]);

			printf("\n");
		}
		*/
		int area = maximalRectangle(matrix);
		printf("largest Rectangle Area is %d\n", area);

	}
	return 0;
}