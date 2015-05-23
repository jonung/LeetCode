#include<cstdio>
#include<vector>

using namespace std;

struct ListNode{
	int val;
	ListNode * next;
	ListNode(int x):val(x),next(NULL){}
};

struct TreeNode{
	int val;
	TreeNode * left;
	TreeNode * right;
	TreeNode(int x):val(x),left(NULL),right(NULL){}
};

TreeNode * helpSolution2(vector<ListNode*>& v ,int start,int end);

TreeNode * help(vector<int>& nums,int start,int end){
	if(start > end)	return NULL;
	int mid = start + (end - start) / 2;
	TreeNode * node = new TreeNode(nums[mid]);
	node->left = help(nums,start,mid - 1);
	node->right = help(nums,mid + 1,end);
	return node;
}

TreeNode* sortedArrayToBST(vector<int>& nums) {
	if(nums.size() == 0)	return NULL;
	return help(nums,0,nums.size() - 1);
}

TreeNode* sortedListToBST(ListNode* head) {
	if(head == NULL)	return NULL;
	vector<int> v;
	ListNode * p = head;
	while(p != NULL){
		v.push_back(p->val);
		p = p->next;
	}

	return sortedArrayToBST(v);
}

/*
 * solution two
 * 
 */

TreeNode* sortedListToBSTSolution2(ListNode* head) {
	if(head == NULL)	return NULL;
	ListNode * p = head;
	int count = 0;
	while(p != NULL){
		count ++;
		p = p->next;
	}
	vector<ListNode*> v; //参数传递过程中要小心处理，函数栈
	v.push_back(head);
	return helpSolution2(v,0,count - 1);
} 

TreeNode * helpSolution2(vector<ListNode*>& v,int start,int end){
	if(start > end)	return NULL;
	int mid = start + (end - start) / 2;
	printf("%d\n", v[0]->val);
	TreeNode * left = helpSolution2(v,start,mid -1);
	TreeNode * root = new TreeNode(v[0]->val);
	root->left = left;
	
	v[0] = v[0]->next;
	TreeNode * right = helpSolution2(v,mid + 1, end);
	root->right = right;
	
	return root;
}

int main(){
	ListNode * head = new ListNode(3);
	ListNode * n1 = new ListNode(5);
	ListNode * n2 = new ListNode(8);

	head->next = n1;
	n1->next = n2;

	TreeNode * root = sortedListToBSTSolution2(head);
	printf("%d %d %d\n", root->left->val, root->val,root->right->val);
	return 0;
}