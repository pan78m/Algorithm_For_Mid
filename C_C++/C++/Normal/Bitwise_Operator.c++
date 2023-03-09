#include<bits/stdc++.h>
using namespace std;
int main(){
    int a = 1, b = 2, c = 3, d = 4, e = 5;
    int res;
    res = a^b;
    cout<<"Bitwise XOR: ";
   // printf("%d ", res);
    cout<<res;
    cout<<"\nBitwise OR: ";
    res = a | b;
    cout<<res;
    
    cout<<"\nBitwise AND: ";
    res = d & b;
    printf("%d\n", res);

    cout<<"Bitwise 1s compliments: ";
    res = ~20;
    printf("%d \n", res);

    cout<<"Bitwise Right-Shift: ";
    res = 4 >>1;
    printf("%d \n", res);

   cout<<"Bitwise Left-Shift: ";
     res = 4<<1;
    printf("%d \n", res);
    return 0;
}