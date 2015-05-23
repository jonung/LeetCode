
vector<int> findOrder(int numCourses, vector<pair<int, int>>& prerequisites) {
	vector<int> res;
	vector<vector<int> > graph(numCourses,vector<int>());
	vector<int> inDegree(numCourses,0);

	for(int i = 0; i < prerequisites.size(); i ++){
		int bac = prerequisites[i].first;
		int pre = prerequisites[i].second;
		graph[pre].push_back(bac);
		inDegree[bac] +=  1;
	}

	queue<int> zeroInDegree;
	for(int i = 0; i < inDegree.size(); i ++){
		if(inDegree[i] == 0)
			zeroInDegree.push(i);
	}

	int finish = 0
	while(!zeroInDegree.empty()){
		int v = zeroInDegree.front();
		res.push_back(v);

		zeroInDegree.pop();
		finish += 1;

		for(int i = 0; i < graph[v].size(); i ++){
			inDegree[graph[v][i]] -= 1;
			if(inDegree[graph[v][i]] == 0)
				zeroInDegree.push(graph[v][i]);
		}

	}

	if(finish < numCourses )
		res.clear();

	return res;
}