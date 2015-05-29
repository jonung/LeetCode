#include<cstdio>
#include<string>
#include<iostream>
#include<stack>
#include<vector>
#include<cstring>
#include<queue>

using namespace std;

//存储有向图
class Digraph{

private:
	int V;
	int E;
	vector<vector<int> > adj;


public:

	Digraph(int V){
		this->V = V;
		for(int i = 0 ; i < V; i ++){
			vector<int> ele;
			adj.push_back(ele);
		}
	}

	//增加一条边v->w
	void addEdge(int v, int w){
		adj[v].push_back(w);
		E ++;
	}

	//得到顶点s可达的顶点集合
	vector<int> singleReachableVertex(int s){
		vector<int> res;
		bool * mark = new bool[V];
		memset(mark,0,V * sizeof(bool));

		int p  = s;
		queue<int> next;

		while(p != -1 || !next.empty()){
			if(p != -1){
				mark[p] = true;
				res.push_back(p);

				for(int i = 0; i < adj[p].size(); i ++){
					if(!mark[adj[p][i]]){
						next.push(adj[p][i]);
					}
				}
			}
			
			if(!next.empty()){
				p = next.front();
				next.pop();
			}
			else
				break;

		}

		return res;

	}

	vector<int> multiReachableVertex(vector<int>& s){
		vector<int> res;
		bool * mark = new bool[V];
		memset(mark,0,V * sizeof(bool));

		for(int i = 0; i < s.size(); i ++){
			multiReachableVertex(s[i],mark);
		}

		for(int i = 0; i < V; i ++){
			if(mark[i]){
				res.push_back(i);
			}
		}
		return res;
	}

	void multiReachableVertex(int s, bool * mark){
		int p = s;
		queue<int> next;

		while(p != -1 || !next.empty()){
			if(p != -1 && !mark[p]){
				mark[p] = true;
				for(int i = 0; i < adj[p].size(); i ++){
					if(!mark[adj[p][i]]){
						next.push(adj[p][i]);
					}
				}

				
			}

			if(!next.empty()){
				p = next.front();
				next.pop();
			}
			else
				break;
		}

	}

};

class NFA{

private:
	string regexp;
	Digraph* G;

public:

	NFA(string regexp){
		this->regexp = regexp;

		int M = regexp.length();
		G = new Digraph(M+1);//包含终态
		stack<int> sk;

		for(int i = 0; i < M; i ++){
			char cur = regexp.at(i);

			int lp = i;

			if(cur == '(' || cur == '|'){
				sk.push(i);
			}
			else if(cur == ')'){

				vector<int> orCollection;//多个或运算
				while(!sk.empty() ){
					int or = sk.top();
					sk.pop();

					if(regexp.at(or) == '|'){
						G->addEdge(or,i);
						orCollection.push_back(or + 1);
					}
					else{
						lp = or;
						break;
					}
				}

				for(int or_i = 0; or_i < orCollection.size(); or_i ++){
					G->addEdge(lp,orCollection[or_i]);
				}


			}

			if(i < M - 1 && regexp.at(i+1) == '*'){
				G->addEdge(i+1,lp);
				G->addEdge(lp,i+1);
			}

			if(cur == '(' || cur == ')' || cur == '*'){
				G->addEdge(i,i+1);
			}
		}
	}

	bool recongnizes(string txt){
		int N = txt.length();
		vector<int> start;
		start.push_back(0);
		start = G->multiReachableVertex(start);

		for(int i = 0; i < N; i ++){
			vector<int> then;
			for(int j = 0; j < start.size(); j ++){
				if(txt.at(i) == regexp.at(start[j]) || regexp.at(start[j]) == '.' ) {
					then.push_back(start[j] + 1);
				}
			}

			start.clear();
			start = G->multiReachableVertex(then);
			
		}

		for(int i = 0; i < start.size(); i ++){
			if(start[i] == regexp.length()){
				return true;
			}
		}

		return false;
	}

};

int main(){

	NFA nfa("(A*B|A.|AE)D");
	cout<<nfa.recongnizes("AFD")<<endl;
	return 0;
}
