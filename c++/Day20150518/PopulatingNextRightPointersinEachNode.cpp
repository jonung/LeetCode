#include<cstdio>
#include<queue>

using namespace std;

struct TreeLinkNode{
	int val;
	TreeLinkNode * left, * right,*next;
	TreeLinkNode(int x): val(x),left(NULL),right(NULL),next(NULL){}
};

void connect(TreeLinkNode *root) {
	if(root == NULL)	return;
	queue<TreeLinkNode *> queue;
	queue.push(root);

	int numOfCurrentLine = 1;
	int numOfNextLine = 0;

	while(!queue.empty()){
		TreeLinkNode * first = queue.front();
		queue.pop();
		numOfCurrentLine --;

		if(first->left != NULL){
			queue.push(first->left);
			numOfNextLine ++;

		}

		if(first->right != NULL){
			queue.push(first->right);
			numOfNextLine ++;
		}

		if(numOfCurrentLine == 0){
			numOfCurrentLine = numOfNextLine;
			numOfNextLine = 0;
			first->next = NULL;
		}
		else{
			first->next = queue.front();
		}
	}

}

int main(){
	
	return 0;
}
