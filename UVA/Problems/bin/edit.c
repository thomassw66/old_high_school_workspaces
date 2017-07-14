#include <stdio.h>

int edit(char * a, char * b){
	int alen = strlen(a);
	int blen = strlen(b);
	int d[alen+1][blen+1];
	int i,j;
	for(i = 0; i < alen+1; i++)
		d[i][0] = i;
	for(j = 0; j < blen+1; j++)
		d[0][j] = j;
	for(i = 1; i < alen+1; i++){
		for(j = 1; j < blen+1;j++){
			if(a[i - 1] == b[j - 1])
				d[i][j] = d[i-1][j-1];
		}
	}
	
	return d[alen][blen];
}

int main(){

}