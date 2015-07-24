#include<iostream>
#include<vector>
#include<stack>
#include<algorithm>
using namespace std;

int largestRectangleAreaImproved(vector<int>& height){
	stack<int> num;
	int area = 0;
	
	for(int i = 0; i < height.size(); i ++){
		if(num.empty() || height[i] >= height[num.top()] ){
			num.push(i);
		}
		else{
			int top = num.top();
			num.pop();
			int width = num.empty() ? i : (i - num.top() - 1);
			cout<<" width: "<<width<<" height: " << height[top]<<" area: " <<width*height[top]<<endl;
			area = max(area,width * height[top]);
			i --;

		}
	}

	while(!num.empty()){
		int top = num.top();
		num.pop();
		int width = num.empty() ? height.size() : (height.size() - num.top() - 1);
		area = max(area,width * height[top]);
		
	}
	return 0;
}
int largestRectangleArea(vector<int>& height){
	stack<int> num;
	int area = 0;
	for(int i = 0; i < height.size(); i ++){
		if(num.empty() || height[i] >= num.top() ){
			num.push(height[i]);
		}
		else{
			int m = 0;
			while(!num.empty() && num.top() > height[i]){
				int top = num.top();
				num.pop();
				m ++;
				
				area = max(area,top * m);

			}

			while(m >= 0){
				num.push(height[i]);
				m --;
			}
		}			
	}
	
	int m = 0;
	while(!num.empty()){
		int top = num.top();
		num.pop();
		m ++;
		
		area = max(area,top * m);
	}
	return area;
}
int main(){
	vector<int> height;
	int n;
	scanf("%d",&n);
	for(int i = 0; i < n; i ++){
		int tmp;
		scanf("%d",&tmp);
		height.push_back(tmp);
	}

	int area = largestRectangleArea(height);
	cout<<"max area is : " << area<<endl;

	int area1 = largestRectangleAreaImproved(height);
	cout<<"improved: "<<area1 <<endl;

	return 0;
}

