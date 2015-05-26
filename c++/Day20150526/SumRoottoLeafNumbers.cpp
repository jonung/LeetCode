
int sumNumbers(TreeNode* root) {
	if(root == NULL)
        return 0;
	
 	int res = 0;
 	return sumNumbers(root,0);
}

int sumNumbers(TreeNode * root,int res){

	res = res * 10 + root->val;
	int left = 0;
	int right = 0;
	if(root->left == NULL && root->right == NULL){
		return res;
		
		
	}

	if(root->left != NULL)
		left = sumNumbers(root->left,res);

	if(root->right != NULL)
		right = sumNumbers(root->right,res);
	

	return left + right;
}