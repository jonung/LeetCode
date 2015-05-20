#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<assert.h>

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


int main()
{
        const char* str1 = "4";
        const char* str2 = "3";
        char* result = bigIntMinus( str1, str2 );
        printf( "%s - %s = %s\n", str1, str2, result );

        // delete
        delete[] result;

        return 0;
}

