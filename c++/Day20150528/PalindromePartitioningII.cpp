bool ** isPalindrome;

void isPalindromeFun(string s){
	isPalindrome = new bool*[s.length()];
	for(int i = 0; i < s.length(); i ++){
		isPalindrome[i] = new bool[s.length()];
		memset(isPalindrome[i],0,s.length() * sizeof(bool));
	}

	for(int i = s.length() - 1; i >= 0; i --){

		for(int j = i; j < s.length(); j ++){
			if( ( s.at(i) == s.at(j) )  && ( (j -i <= 1) || isPalindrome[i+1][j-1]) ){
				isPalindrome[i][j] = true;
			}
		}

	}

}

int minCut(string s) {
    if(s.length() == 0)	return 0;

    isPalindromeFun(s);

    int * aux = new int[s.length() + 1];
    for(int i = 0; i < s.length() + 1; i ++)
    	aux[i] = s.length();

    aux[0] = 0;
    aux[1] = 0;

    for(int i = 2; i <= s.length(); i ++){

    	for(int j = 0; j < i; j ++){
    		if(j == 0 && isPalindrome[j][i-1])	aux[i] = 0;
    		else if(isPalindrome[j][i-1]){
    			if(aux[i] > aux[j] + 1)
    				aux[i] = aux[j] + 1;
    		}
    	}

    }

    return aux[s.length()];

}

