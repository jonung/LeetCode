#include<cstdio>

using namespace std;


ListNode* removeElements(ListNode* head, int val) {
	ListNode * L = new ListNode(0);
	L->next = head;
	ListNode * pre = L;
	ListNode * pos = head;

	while(pos != NULL){
		if(pos->val == val){
			pre->next = pos->next;
			
		}
		else{
			pre = pre->next;
		}
		pos = pos->next;
	}

	return L->next;      
}

int main(){

	return 0;
}