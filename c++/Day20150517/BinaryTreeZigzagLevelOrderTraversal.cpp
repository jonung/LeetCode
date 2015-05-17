#include<cstdio>
#include<vector>
#include<stack>
#include<queue>

using namespace std;

struct TreeNode{
	int val;
	TreeNode * left;
	TreeNode * right;
	TreeNode(int x):val(x),left(NULL),right(NULL){}
};

/*
 * 没想到能一次过，在写代码中没有出现任何错误
 * 
 */
vector<vector<int> > zigzagLevelOrder(TreeNode* root) {
    vector<vector<int> > res;
    if(root == NULL)	return res;
    queue<TreeNode*> queue;
    queue.push(root);

    int numOfCurrentLevel = 1;
    int nextNum = 0;

    bool flag = true;
    vector<int> v;
    stack<int> s;

    while(!queue.empty()){
    	TreeNode * cur = queue.front();
    	queue.pop();
    	numOfCurrentLevel --;

    	if(flag){
    		v.push_back(cur->val);
    	}
    	else{
    		s.push(cur->val);
    	}

    	if(cur->left != NULL){
    		queue.push(cur->left);
    		nextNum ++;
    	}

    	if(cur->right != NULL){
    		queue.push(cur->right);
    		nextNum ++;
    	}

    	if(numOfCurrentLevel == 0){
    		numOfCurrentLevel = nextNum;
    		nextNum = 0;

    		if(flag){
    			res.push_back(v);
    			
    			flag = false;
    		}
    		else{
    			while(!s.empty()){
    				int tmp = s.top();
    				s.pop();
    				v.push_back(tmp);
    			}
    			res.push_back(v);
    			flag = true;
    		}
    		v.clear();
    	}
    }

    return res;
}

int main(){

	return 0;
}