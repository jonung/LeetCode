#include<cstdio>
#include<stack>
#include<queue>

using namespace std;

struct TreeNode{
	int val;
	TreeNode * left;
	TreeNode * right;
	TreeNode(int x):val(x),left(NULL),right(NULL){}
};

void preOrderRecursion(TreeNode * root);
void preOrderIterative(TreeNode * root);

void inOrderRecursion(TreeNode * root);
void inOrderIterative(TreeNode * root);

void postOrderRecursion(TreeNode * root);
void postOrderIterative(TreeNode * root);

/*
 *
 */
void preOrderRecursion(TreeNode * root){
	if(root == NULL)
		return;
	printf("%d ", root->val);
	preOrderRecursion(root->left);
	preOrderRecursion(root->right);
}

void preOrderIterative(TreeNode * root){
	if(root == NULL)
		return;
	stack<TreeNode*> stack;
	TreeNode * p = root;
	while(p != NULL || !stack.empty()){
		if(p != NULL){
			printf("%d ", p->val);
			stack.push(p);
			p = p->left;
		}
		else{
			TreeNode * top = stack.top();
			stack.pop();
			p = top->right;
		}
	}
}

 /*
  *
  */
void inOrderRecursion(TreeNode * root){
	if(root == NULL)
		return;
	inOrderRecursion(root->left);
	printf("%d ", root->val);
	inOrderRecursion(root->right);
}

void inOrderIterative(TreeNode * root){
	if(root == NULL)
		return;
	stack<TreeNode *> stack;
	TreeNode * p = root;
	while(p != NULL || !stack.empty()){
		if(p != NULL){
			stack.push(p);
			p = p->left;
		}
		else{
			TreeNode *top = stack.top();
			stack.pop();
			printf("%d ", top->val);

			p = top->right;
		}
	}
}

 /*
  *
  */
void postOrderRecursion(TreeNode * root){
	if(root == NULL)
		return;
	postOrderRecursion(root->left);
	postOrderRecursion(root->right);
	printf("%d ", root->val);
}

void postOrderIterative(TreeNode * root){
	if(root == NULL)
		return;
	stack<TreeNode*> stack;
	TreeNode * p = root;
	TreeNode * pre; //关键
	while(p != NULL || !stack.empty()){
		if(p != NULL){
			stack.push(p);
			p = p->left;
		}
		else{
			TreeNode * top = stack.top();
			if(top->right == NULL){
				printf("%d ", top->val);
				stack.pop();
				pre = top;
			}
			else{
				
				if(top->right == pre){
					printf("%d ", top->val);
					stack.pop();
					pre = top;
				}
				else{
					p = top->right;
				}

			}

		}
	}
}

int main(){
	TreeNode * root = new TreeNode(1);
	TreeNode * n1 = new TreeNode(2);
	TreeNode * n2 = new TreeNode(3);
	TreeNode * n3 = new TreeNode(4);
	TreeNode * n4 = new TreeNode(5);

	root->left = n1;
	root->right = n2;
	n1->left = n3;
	n1->right = n4;

	printf("preorder\n");
	preOrderRecursion(root);
	printf("\n");
	preOrderIterative(root);
	printf("\n");

	printf("inorder\n");
	inOrderRecursion(root);
	printf("\n");
	inOrderIterative(root);
	printf("\n");

	printf("postorder\n");
	postOrderRecursion(root);
	printf("\n");
	postOrderIterative(root);
	printf("\n");

	return 0;
}