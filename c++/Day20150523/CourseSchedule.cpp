#include<cstdio>
#include<vector>
#include<iostream>
#include<queue>

using namespace std;

/*
 *	DFS  超时
 *
 */
bool isCyclic(int root,vector<vector<int> > graph, bool * hasVali,bool * visit){
	if(visit[root]){
		return true;
	}

	if(hasVali[root])
		return false;

	visit[root] = true;
	for(int i = 0; i < graph[root].size(); i ++){
		if(isCyclic(graph[root][i],graph,hasVali,visit)){
			return true;
		}
	}

	hasVali[root] = true;
	visit[root] = false;
	return false;
}

bool canFinish(int numCourses, vector<pair<int, int> >& prerequisites) {
	vector<vector<int> > graph(numCourses,vector<int>());

	for(int i = 0; i < prerequisites.size(); i ++){
		int bac = prerequisites[i].first;
		int pre = prerequisites[i].second;
		graph[pre].push_back(bac); // pre - > bac
	}

	bool hasVali[numCourses];
	memset(hasVali, 0, numCourses * sizeof(bool));
	bool visit[numCourses];
	memset(visit, 0, numCourses * sizeof(bool));

	for(int i = 0; i < graph.size(); i ++){

		if(isCyclic(i,graph,hasVali,visit)){
			return false;
		}
	}

	return true;
}

/*
 *	模拟拓扑排序的过程来判断
 * 
 */
bool canFinishSolution2(int numCourses, vector<pair<int, int> >& prerequisites) {
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

	int finish = 0;
	while(!zeroInDegree.empty()){
		int v = zeroInDegree.front();
		zeroInDegree.pop();
		finish += 1;

		for(int i = 0; i < graph[v].size(); i ++){
			inDegree[graph[v][i]] -= 1;
			if(inDegree[graph[v][i]] == 0)
				zeroInDegree.push(graph[v][i]);
		}

	}

	return finish == numCourses;

}
int main(){
	vector<pair<int,int> > pre;
	pre.push_back(pair<int,int>(1,0));
	pre.push_back(pair<int,int>(2,0));
	pre.push_back(pair<int,int>(0,2));
	cout<<canFinishSolution2(3,pre)<<endl;
	return 0;
}