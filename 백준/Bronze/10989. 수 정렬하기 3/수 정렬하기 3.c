#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main() {
    int count, num, j;
    int n[10001]={0};
    scanf("%d", &count);
    for(int i=0; i<count; i++) {
        scanf("%d", &num);
        n[num]++;
    }
    for(int i=1; i<=10000; i++) {
        while(n[i]--!=0)
            printf("%d\n", i);
    }
    return 0;
}