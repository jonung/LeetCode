#include<cstdio>
#include<iostream>
#include<string>

using namespace std;



int main(){
	int a,b;
	scanf("%d %d",&a,&b);
	int res = 0;
	
	int r4,r100,r400;
	r4 = (b - a + 1) / 4;
	for(int i = a + r4 * 4; i <= b; i ++){
		if(i % 4 == 0)
			r4 = r4 + 1;
	}
	
	if(a == b && a % 100 == 0){
		r100 = 1;
	}
	else
		r100 = b / 100 - a / 100;
	
	r400 = (b - a + 1) / 400;
	for(int i = a + r400 * 400; i <= b; i ++){
		if(i % 400 == 0 )
			r400 += 1;
	}
	
	res = r4 - r100 + r400;
	
	printf("%d\n",res);
	return 0;
}
