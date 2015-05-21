#include<cstdio>
#include<vector>
#include<queue>

using namespace std;

vector<vector<int> > graph;
vector<int> fest;//fest[i] == 1表示city i是festive city，否则等于0
vector<int> dist;//dist[i]表示city i 到festive city的最小距离
vector<bool> flag;//定义在前面，防止栈溢出，标记节点是否被访问过了
queue<int> q;//记录受影响的节点

void update(int c,int size){
	
	for(int i = 0; i < size; i ++)
		flag.push_back(false);

	
	dist[c] = 0;

	while(!flag[c]){
		if(!flag[c]) {
			flag[c] = true;
			for(int i = 0; i < graph[c].size(); i ++){
				if(dist[c] + 1 < dist[graph[c][i]] && !flag[graph[c][i]]){
					dist[graph[c][i]] = dist[c] + 1;
					q.push(graph[c][i]);
				}
			}
			c = q.front();
			q.pop();
		}
		else{
			if(q.empty()){
				break;
			}
			else{
				c = q.front();
				q.pop();
			}
		}


	}
}

int main(){
	int n,m;
	scanf("%d%d",&n,&m);
	//初始化
	for(int i = 0; i < n + 1; i ++){
		vector<int> adj;
		graph.push_back(adj);
		fest.push_back(0);
		dist.push_back(n);
	}

	//用邻接矩阵来存储图
	for(int i = 0; i < n - 1; i ++){
		int first,second;
		scanf("%d%d",&first,&second);
		graph[first].push_back(second); //first - > second
		graph[second].push_back(first); //second - > first
	}

	int size = graph.size();
	//city 1是festive city
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
