class Slution{
struct TreeNode{
	int val;
	TreeNode * left;
	TreeNode * right;
	TreeNode(int x) : val(x),left(NULL), right(NULL){}
};

public :
	TreeNode* invertTree(TreeNode* root){
		if(root == NULL)	return NULL;

		TreeNode * left = root->left;
		TreeNode * right = root->right;

		root->left = invertTree(right);
		root->right = invertTree(left);
			
		return root;	

	}
}
