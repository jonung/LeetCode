#include<cstdio>

using namespace std;

struct ListNode{
	int val;
	ListNode *next;
	ListNode(int x):val(x),next(NULL){}
};

ListNode* reverseList(ListNode* head) {
	if(head == NULL)	return head;
	ListNode * L = new ListNode(-1);
	
	ListNode * p = head;

	while(p != NULL){
		ListNode * q = p;
		p = p->next;
		q->next = L->next;
		L->next = q;
	}

	return L->next;
}

ListNode* reverseListSolution2(ListNode* head) {
	if(head == NULL || head->next == NULL)	return head;
	ListNode * first = head;
	ListNode * next = first->next;

	head = reverseListSolution2(next);
	next->next = first;
	first->next = NULL;
	return head;
}

int main(){

	return 0;
}