#include<cstdio>
#include<map>
#include<string>
#include<iostream>
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<assert.h>
#include<vector>
#include<algorithm>

using namespace std;

char* bigIntMinus( const char* numstr1, const char* numstr2 )
{
        assert( numstr1 != NULL && numstr2 != NULL );

        int len1 = strlen( numstr1 );
        int len2 = strlen( numstr2 );
        
        
        int resultLen = ( len1 > len2 ) ? ( len1 + 2 ) : ( len2 + 2 );
        char* minusResult = new char[ resultLen ];
        bool bFirstIsBigger = true;
        // 首先处理结果符号
        if ( len1 > len2 )
        {
                *minusResult = '+';
        }
        else if ( len1 < len2 )
        {
                *minusResult = '-';
                bFirstIsBigger = false;
        }
        else
        {
                int cmpResult = strcmp( numstr1, numstr2 );
                if ( cmpResult > 0 )
                {
                        *minusResult = '+';
                }
                else
                {
                        *minusResult = '-';
                        bFirstIsBigger = false;
                }
        }

        int tmpBigger[ resultLen ];
        int tmpSmaller[ resultLen ];
        int tmpResult[ resultLen ];

        memset( tmpBigger, 0, resultLen * sizeof( int ) );
        memset( tmpSmaller, 0, resultLen * sizeof( int ) );
        memset( tmpResult, 0, resultLen * sizeof( int ) );

        int i, j, k;
        if ( bFirstIsBigger )
        {
                for ( i = 0; i < len1; i++ )
                {
                        tmpBigger[ i ] = *( numstr1 + len1 - i - 1 ) - '0';
                }
                for ( j = 0; j < len2; j++ )
                {
                        tmpSmaller[ j ] = *(numstr2 + len2 - j - 1 ) - '0';
                }
        }
        else
        {
                for ( i = 0; i < len2; i++ )
                {
                        tmpBigger[ i ] = *( numstr2 + len2 - i - 1 ) - '0';
                }
                for ( j = 0; j < len1; j++ )
                {
                        tmpSmaller[ j ] = *( numstr1 + len1 -j -1 ) - '0';
                }
        }

        // 求差
        int currMINUS = 0;
        for ( k = 0; k < resultLen; k++ )
        {
                currMINUS = tmpBigger[ k ] - tmpSmaller[ k ];
                if ( currMINUS >= 0 )
                {
                        tmpResult[ k+1 ] = currMINUS;
                }
                else // 当前相减为负
                {
                        tmpBigger[ k+1 ] -= 1; // 高位借位
                        tmpResult[ k+1 ] = 10 + currMINUS;
                }
        }

        k = resultLen -1;
        while( !tmpResult[ k ] )
        {
                k--;
        }

        for ( i = 0; i <= k; i++ )
        {
                *( minusResult + i + 1 ) = tmpResult[ k-i ] + '0';
        }
        *( minusResult + i ) = '\0';

        return minusResult;
}


char * fun(string s1, char c){
	cout<<"s1 size : "<<s1.size()<<" value: "<<c<<endl;
	
	char * s2 = (char *)malloc(s1.size()*sizeof(char));
	for(int j = 0; j < s1.size(); j ++)
		s2[j] = c;
		
	cout<<"new size: "<<strlen(s2)<<endl;
	for(int j = 0; j < strlen(s2); j ++)
		cout<<s2[j]<<" ";
	cout<<endl;
	
	char * res1 = bigIntMinus((char*)s1.data(),s2);
	return res1;
}

int main(){
	string s;
	int k;
	
	getline(cin,s);
	scanf("%d",&k);
	
	int count = 0;
	int i = 0;
	vector<char > v;
	
	char pre = s.at(0);
	 
	for(i = 0; i < s.size(); i ++){
		
		if(count < k){
			bool flag = false;
			pre = s.at(i);
			for(int j = 0; j < v.size(); j ++){
				if(v[j] == s.at(i)){
					flag = true;
					break;
				}
			}
			if(!flag){
				v.push_back(s.at(i));
				count ++;
				
			}
			
			
		}
		else{
			break;
		}
		
	}
	
	if(i == s.size()){
		printf("%d\n",0);
		return 0;
	}
	
	char cur = s.at(i);
		
	char min = v[0];
	
	for(int j = 1; j < v.size(); j ++){
		if(abs(v[j] - cur) < abs(min - cur)){
			min = v[j];
		}
	}

	char * res1 = fun(s.substr(i),min);
	
	char * res2 = fun(s.substr(i - 1),pre);
	
	string last (res1);
	cout<<last<<endl;
	
	return 0;
}
