#include<cstdio>
#include<stack>
#include<iostream>

using namespace std;

struct TreeNode{
	int val;
	TreeNode * left;
	TreeNode * right;
	TreeNode(int x):val(x),left(NULL),right(NULL){}
};

/*
 * 在先序遍历的基础上操作，先把二叉树变为由left相连的链表，再按照题意变为由right相连的链表
 *
 */
void flatten(TreeNode * root){
	if(root == NULL)	return;

	TreeNode * p = root;
	TreeNode * pre;
	bool flag = true;
	stack<TreeNode * > stack;

	while(p != NULL || !stack.empty()){
		if(p != NULL){
			if(flag){
				pre = p;
				flag = false;
			}
			else{
				pre->left = p;
				pre = p;
			}
			stack.push(p);
			p = p->left;
		}
		else{
			TreeNode * top = stack.top();
			stack.pop();
			p = top->right;
		}
	}

	p = root;
	while(p->left != NULL){
		TreeNode * q = p->left;
		p->right = q;
		p->left = NULL;
		p = q;
	}
}


void build(TreeNode * root){
	if(root == NULL){
		root = new TreeNode(0);
	}
}
int main(){
	TreeNode* root= NULL;
	build(root);
	if(root == NULL)
		cout<<"LLLLL"<<endl;
	return 0;
}