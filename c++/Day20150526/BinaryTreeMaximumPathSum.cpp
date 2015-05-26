int maxValue(int x, int y){
    if(x > y)
        return x;
    else
        return y;
}

int maxPathSum(TreeNode* root) {
	int max[1];
	max[0] = -1<<30;
	maxPathSum(root,max);

	return max[0];
}

int maxPathSum(TreeNode* root,int max[]){
    if(root == NULL)    return 0;
    
    int left = maxPathSum(root->left,max);
    int right = maxPathSum(root->right,max);
    
    int cur = maxValue(root->val,maxValue(root->val + left, root->val + right));
    
    max[0] = maxValue(max[0],maxValue(cur,root->val + left + right));
    
    return cur;
}
