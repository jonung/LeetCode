
void help(unordered_set<string>& wordDict,vector<string> res, string path, string s,int start){
	if(start == s.length()){
		res.push_back(path);
		return ;
	}

	
	for(int j = start + 1; j <= s.length(); j ++){
		string sub = s.substr(start,j-start);

		if(wordDict.find(sub) != wordDict.end()){
			if(start == 0){
				help(wordDict,res,sub,s,j);
			}
			else{
				help(wordDict,res,path+ " " + sub,s,j);
			}
			
		}

	}
	
}

bool * mark;
vector<vector<string> > * aux;

void help2unordered_set<string>& wordDict, string s,int start){
	vector<vector<string> > res;

	for(int i = s.length() ; i> 0; i -- ){
		string sub = s.substr(start,i);

		if(wordDict.find(sub) != wordDict.end()){
			vector<string> bac;
			if(mark[i]){
				bac = aux[i];
			}
			else{
				bac = help2unordered_set(wordDict,s,i);
			}
			
			if(i == s.length()){
				bac.push_back(sub);
				
			}

		}

	}

	return res;
}

vector<string> wordBreak(string s, unordered_set<string>& wordDict) {
	int N = s.length();
	aux = new vector<vector<string> >[N + 1];
	mark = new bool[N + 1];

	memset(mark,0,(N + 1) * sizeof(bool));
	mark[N] = true;
	
	vector<string> last;
	aux[N].push_back(last);


}

