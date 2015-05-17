#include<cstdio>
#include<vector>
#include<stack>
#include<map>

using namespace std;

struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x):val(x),left(NULL),right(NULL){}
};

TreeNode * help(vector<int>& preorder, int start,int end, vector<int>& inorder,int istart, int iend,map<int,int>& m);
TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
	if(preorder.size() == 0)	return NULL;
	map<int,int> m;
	for(int i = 0; i < inorder.size(); i ++){
		m.insert(pair<int,int>(inorder[i],i));
	}

	return help(preorder,0,preorder.size() - 1,inorder,0,inorder.size() - 1,m);
	
}

TreeNode * help(vector<int>& preorder, int start,int end, vector<int>& inorder,int istart, int iend,map<int,int> & m){
	
	if(start > end || istart > iend)
		return NULL;
	TreeNode * root = new TreeNode(preorder[start]);
	int index = m.find(preorder[start])->second;
	root->left = help(preorder,start + 1,start + index - istart,inorder,istart,index - 1,m);
	root->right = help(preorder,start + index - istart + 1,end,inorder,index + 1,iend,m);
	//printf("left: %d  right: %d\n", root->left->val,root->right->val);
	return root;
}

void traverse(TreeNode * root){
	if(root == NULL)	return ;
	printf("%d\n", root->val);
	traverse(root->left);
	traverse(root->right);
}


int main(){
	int prearray[5] = {1,2,4,5,3};
	vector<int> preorder(prearray,prearray + 5);
	int inarray[5] = {4,2,5,1,3};
	vector<int> inorder(inarray,inarray + 5);
	TreeNode * root = buildTree(preorder,inorder);
	traverse(root);

	return 0;
}