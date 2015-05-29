bool containsDuplicate(vector<int>& nums) {
	map<int,int> m;
	for(int i = 0; i < nums.size(); i ++){
		if(m.find(nums[i]) != m.end()){
			return true;
		}
		else{
			m.insert(pair<int,int>(nums[i],1));
		}
	}     

	return false;   
}