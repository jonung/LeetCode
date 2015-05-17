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

TreeNode * help(vector<int>& inorder, int istart,int iend,vector<int>& postorder,int pstart,int pend,map<int,int> m);

TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
	if(inorder.size() == 0 || postorder.size() == 0)
		return NULL;
	map<int,int> m;
	for(int i = 0; i < inorder.size(); i ++){
		m.insert(pair<int,int>(inorder[i],i));
	}

	return help(inorder,0,inorder.size() - 1, postorder, 0 , postorder.size() - 1, m);
}

TreeNode * help(vector<int>& inorder, int istart,int iend,vector<int>& postorder,int pstart,int pend,map<int,int> m){
	if(istart > iend || pstart > pend)
		return NULL;
	TreeNode * root = new TreeNode(postorder[pend]);
	int index = m.find(root->val)->second;
	root->left = help(inorder,istart,index - 1, postorder,pstart,pstart + index - istart - 1,m);
	root->right = help(inorder,index + 1,iend,postorder,pstart + index - istart,pend - 1,m);

	return root;
}

void traverse(TreeNode * root){
	if(root == NULL)	return ;
	printf("%d\n", root->val);
	traverse(root->left);
	traverse(root->right);
}


int main(){
	int inarray[5] = {4,2,5,1,3};
	vector<int> preorder(inarray,inarray + 5);
	int postarray[5] = {4,5,2,3,1};
	vector<int> inorder(postarray,postarray + 5);
	TreeNode * root = buildTree(preorder,inorder);
	traverse(root);

	return 0;
}