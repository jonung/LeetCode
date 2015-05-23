#include<cstdio>
#include<vector>

using namespace std;
struct TreeNode{
	int val;
	TreeNode * left;
	TreeNode * right;
	TreeNode(int x):val(x),left(NULL),right(NULL){}
};

TreeNode * help(vector<int>& nums,int start,int end){
	if(start > end)	return NULL;
	int mid = start + (end - start) / 2;
	TreeNode * node = new TreeNode(nums[mid]);
	node->left = help(nums,start,mid - 1);
	node->right = help(nums,mid + 1,end);
	return node;
}

TreeNode* sortedArrayToBST(vector<int>& nums) {
	if(nums.size() == 0)	return NULL;
	return help(nums,0,nums.size() - 1);
}

int main(){

	return 0;
}