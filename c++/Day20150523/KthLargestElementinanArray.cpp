#include<cstdio>
#include<vector>
#include<algorithm>

using namespace std;
int helpQuickSort(vector<int>& nums,int l,int r, int k);
/*
 * 快速排序
 */
int findKthLargest(vector<int>& nums, int k) {
	return helpQuickSort(nums,0,nums.size() - 1,k);
	
}

int helpQuickSort(vector<int>& nums,int l,int r, int k){
	int low = l;
	int high = r;
	int key = nums[l];

	while(low < high){
		while(low < high && nums[high] < key){
			high --;
		}
		nums[low] = nums[high];

		while(low < high && nums[low] >= key){
			low ++;
		}
		nums[high] = nums[low];
	}
	nums[low] = key;
	if(low == k - 1){
		return nums[low];
	}
	else if(low < k -1){
		return helpQuickSort(nums,low + 1,r,k);
	}
	else
		return helpQuickSort(nums,l,low -1,k);

	
}

/*
 *	堆排序
 *
 *
 */

bool inc_cmp(int a,int b){
	return a > b;
}

int findKthLargestHeap(vector<int>& nums, int k) {
	vector<int> heap;
	for(int i =0; i < k; i ++){
		heap.push_back(nums[i]);
	}

	for(int i = k ; i < nums.size(); i ++){
		heap.push_back(nums[i]);
		make_heap(heap.begin(),heap.end(),inc_cmp);
		pop_heap(heap.begin(),heap.end(),inc_cmp);
		heap.pop_back();
	}
	return heap[0];
}

int main(){
	vector<int> nums;
	nums.push_back(2);
	nums.push_back(1);
	nums.push_back(3);
	nums.push_back(-1);
	printf("%d\n", findKthLargest(nums,1));
	printf("%d\n",findKthLargestHeap(nums,1) );
	return 0;
}