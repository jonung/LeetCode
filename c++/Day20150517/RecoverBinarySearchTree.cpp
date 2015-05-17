#include<cstdio>
#include<stack>

using namespace std;

struct TreeNode{
	int val;
	TreeNode * left;
	TreeNode * right;
	TreeNode(int x):val(x),left(NULL),right(NULL){}
};

void recoverTree(TreeNode * root){
	if(root == NULL)	return;
	stack<TreeNode*> stack;

	TreeNode * p = root;
	TreeNode * pre = NULL;
	TreeNode * misPre = NULL;
	TreeNode * misBac = NULL;
	TreeNode * adj = NULL;

	bool flag = true;
	while(p != NULL || !stack.empty()){
		if(p != NULL){
			stack.push(p);
			p = p->left;
		}
		else{
			TreeNode * top = stack.top();
			stack.pop();

			if(flag){
				
				flag = false;
			}
			else{
				if(top->val <= pre->val){
					if(misPre == NULL){
						misPre = pre;
						adj = top;
					}
					else
						misBac = top;
				}
			}
			pre = top;
			p = top->right;

			if(misBac == NULL && p == NULL && stack.empty()){
				misBac  = adj;
				printf("last\n");
			}
		}
		
		
	}

	int tmp = misPre->val;
	misPre->val = misBac->val;
	misBac->val = tmp;
}

int main(){
	TreeNode p = TreeNode(1);
	TreeNode q = TreeNode(2);
	TreeNode m = TreeNode(3);
	p.left = &q;
	p.right = & m;

	recoverTree(&p);
	TreeNode * pos = &p;
	printf("%d\n",pos->val );
	printf("%d\n",pos->left->val );
	printf("%d\n",pos->right->val );
	return 0;
}
