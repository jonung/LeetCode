#include<cstdio>
#include<vector>
#include<queue>

using namespace std;

vector<vector<int> > graph;
vector<int> fest;
vector<int> dist;
vector<bool> flag;
queue<int> q;

void update(int c,int size){

	for(int i = 0; i < size; i ++)
		flag[i] = false;


	dist[c] = 0;

	while(!flag[c] || !q.empty() ){
		if(!flag[c]) {
			flag[c] = true;

			for(int i = 0; i < graph[c].size(); i ++){
				if(dist[c] + 1 < dist[graph[c][i]] && !flag[graph[c][i]]){
					dist[graph[c][i]] = dist[c] + 1;
					q.push(graph[c][i]);
				}
			}
		}
							
		if(q.empty()){
			break;
		}
		else{
			c = q.front();
			q.pop();
		}

		
	}
}

int main(){
	int n,m;
	scanf("%d%d",&n,&m);
	
	for(int i = 0; i < n + 1; i ++){
		vector<int> adj;
		graph.push_back(adj);
		fest.push_back(0);
		dist.push_back(n);
	}

	
	for(int i = 0; i < n - 1; i ++){
		int first,second;
		scanf("%d%d",&first,&second);
		graph[first].push_back(second); //first - > second
		graph[second].push_back(first); //second - > first
	}

	int size = graph.size();
	
	for(int i = 0; i < size; i ++)
		flag.push_back(false);
		
	fest[1] = 1;
	update(1,size);

	for(int i = 0; i < m; i ++){
		int q,c;
		scanf("%d%d",&q,&c);
		if(q == 1){
			fest[c] = 1;
			update(c,size);
		}

		if(q == 2){
			printf("%d\n", dist[c]);
		}

	}

	return 0;
}
