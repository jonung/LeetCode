#include<cstdio>
#include<stack>

using namespace std;

struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x):val(x),left(NULL),right(NULL){}
};

/*
 * 中序遍历，判断是否有序，关键是中序遍历的实现，要熟练
 *
 */
bool isValidBST(TreeNode* root){
	if(root == NULL) return true;
	stack<TreeNode*> stack;

	TreeNode* p = root;
	int cmp;
	bool flag = true;
	while(p != NULL || !stack.empty()){
		
		if(p != NULL ){
			stack.push(p);
			p = p->left;
		}
		else{
			TreeNode* top = stack.top();
			if(flag){
				cmp = top->val;
				flag = false;
			}
			else{
			    if(top->val <= cmp){
				    return false;
    			}
    			else{
    				cmp = top->val;
    			}
			}
			stack.pop();	
			p = top->right;

		}
	}
	return true;
}

int main(){

	return 0;
}