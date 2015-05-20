#include<cstdio>
#include<stack>
#include<vector>
#include<iostream>
using namespace std;

struct TreeNode{
	int val;
	TreeNode * left;
	TreeNode * right;
	TreeNode(int x):val(x),left(NULL),right(NULL){}
};

vector<vector<int> > pathSum(TreeNode* root, int sum) {
    vector<vector<int> > v;
    if(root == NULL)	return v;
    stack<TreeNode*> stack;

    TreeNode * p = root;
    TreeNode * pre;
    vector<int> ele;
    int acc = 0;

    while(p != NULL || !stack.empty()){
    	if(p != NULL){
    		pre = p;
    		stack.push(p);
    		ele.push_back(p->val);
    		acc += p->val;
    		p = p->left;
    	}
    	else{
    		TreeNode * top = stack.top();
    		if(top->right != NULL){
    			if(top->right == pre){
    				stack.pop();
    				p = NULL;
    			}
    			else{ 				
    				p = top->right;
    			}
    			
    			
    		}
    		else{
    			if(acc == sum && top->left == NULL){
    				vector<int> v1(ele.begin(),ele.end());
    				v.push_back(v1);
    			}

    			stack.pop();
    			acc = acc - top->val;
    			ele.erase(ele.begin() + ele.size() - 1);
    			p = NULL;
    		}
    		pre = top;
    	}
    }

    return v;
}

void help(vector<vector<int> >& res,vector<int> ele,TreeNode * root,int acc, int sum);
vector<vector<int> > pathSumSolution2(TreeNode* root, int sum) {
	vector<vector<int> > res;
	if(root == NULL)	return res;
	vector<int> v;
	help(res,v,root,0,sum);
	return res;
}

void help(vector<vector<int> >& res,vector<int> ele,TreeNode * root,int acc, int sum){
	
	if(root->left == NULL && root->right == NULL){
		if(acc + root->val == sum){
			vector<int> v(ele.begin(),ele.end());
			v.push_back(root->val);
			res.push_back(v);
		}
		return;
	}
	
	ele.push_back(root->val);
	if(root->left != NULL){
		help(res,ele,root->left,acc + root->val,sum);
	}
	
	if(root->right != NULL){
		help(res,ele,root->right,acc + root->val,sum);
	}
}

int main(){
	TreeNode * root = new TreeNode(1);
	
	TreeNode * n1 = new TreeNode(-2);
	TreeNode * n2 = new TreeNode(-3);
	TreeNode * n3 = new TreeNode(1);
	TreeNode * n4 = new TreeNode(3);
	TreeNode * n5 = new TreeNode(-2);
	TreeNode * n6 = new TreeNode(-1);
	
	root->left = n1;
	root->right = n2;
	n1->left = n3;
	n2->right = n4;
	n2->left = n5;
	n3->left = n6;
	
	int sum = -4;
	vector<vector<int> > res = pathSumSolution2(root,sum);
	cout<<res.size()<<endl;
	
	for(int i = 0; i < res.size(); i ++){
		for(int j = 0; j < res[i].size(); j ++)
			cout<<res[i][j]<<" ";
		cout<<endl;
	}
	
	
	return 0;
}
