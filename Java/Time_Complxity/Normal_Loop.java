/*
 * 
 * 
 * 1. void g(int n){
 *  for(int i=0;i<n;++i) f();
 * }
 * Ans:O(n)
 * 
 * 2. void g(int n){
 *  for(int i=0;i<n;++i)
 * for(int j=0;j<n;++j) f();
 * }
 * Ans:O(n^2)
 * 3. void g(int n){
 *  for(int i=0;i<n;++i)
 * for(int j=0;j<=i;++j) f();
 * }
 * * Ans:O(n^2)
 * 
 * 
 * 4. void g(int n){
 *  for(int i=0;i<m;++i)
 * for(int j=0;j<n;++j)
 * for(int k=0;k<p;++k) f();
 * * Ans:O(mnp)
 * }
 * 
 * 5. if(condition){
 *   O(n)  
 * } else{
 *      O(n^2)     
 * }
 * * Ans:between O(n) to O(n^2)
 * 
 * 
6.
int a = 0, b = 0;
for (i = 0; i < N; i++) {
	a = a + rand();
}
* Ans:O(N)
for (j = 0; j < M; j++) {
	b = b + rand();
}
* Ans:O(M)
Ans is: O(N+M)
7.
int a = 0;
for (i = 0; i < N; i++) {
	for (j = N; j > i; j--) {
		a = a + i + j;
	}
}
* Ans:O(n^2)
8.
int i, j, k = 0;
for (i = n / 2; i <= n; i++) { N
    for (j = 2; j <= n; j = j * 2) {
        k = k + n / 2;
        log2 (N)
    }
}
* Ans:O n(log2 n)
9.
int a = 0, i = N;
while (i > 0) {
    a += i;
    i /= 2;
}
Ans:O(log2 n)
10.
for(int i=0;i<n;i++){
  i*=k;
}
Ans:O n(log k base n)
11.
int value = 0;
for(int i=0;i<n;i++)
    for(int j=0;j<i;j++)
      value += 1;
Ans O(n^2)
12.
function isPrime(n) {
  for (let i = 2; i <= Math.sqrt(n); ++i) {
      if (n % i == 0) 
          return false;
  }
  return true;
}
The time complexity of your function is O(sqrt(n)). 
To prove this, you need to count how many times the loop runs as a function of n.

The loop starts with i = 2 and ends when i > sqrt(n). 
In each iteration, i is incremented by 1. Therefore, 
the number of iterations of the loop is:

sqrt(n) - 2 + 1 = sqrt(n) - 1

This is because we need to subtract 2 from sqrt(n)
 to account for the initial value of i and add 1 to include the last value of i. 
 The statement n % i === 0 takes constant time. 
 Therefore, the total number of basic operations performed by your function is:

(sqrt(n) - 1) * 1 = sqrt(n) - 1

To express this using big O notation, we ignore coefficients and lower order terms
 and focus on the highest order term. In this case, it is sqrt(n). 
 Therefore, your function has a time complexity of O(sqrt(n)).

13.
let a = 0, b = 0;
for (let i = 0; i < n; ++i) {
    a = a + i;
}
for (let j = 0; j < m; ++j) {
    b = b + j;
}
Ans is: O(N+M)
14.
let a = 0, b = 0;
for (let i = 0; i < n; ++i) {
    for (let j = 0; j < n; ++j) {
        a = a + j;
    }
    O(n^2)
}
for (let k = 0; k < n; ++k) {
    b = b + k;
    O(n)
}
Ans : O(n+n^2)
15.
let a = 0;
for (let i = 0; i < n; ++i) {
    for (let j = n; j > i; --j) {
        a = a + i + j;
    }
}
Ans:O(n^2)
16.
for (let i = n; i > 0; i = i / 2) {
    console.log(i);
}
Ans is: O(log 2 N)
17.
for (let i = 1; i < n; i = i * 2) {
    console.log(i);
}
Ans is: O(log 2 N)
18.
for (let i = 0; i < n; ++i) {
    for (let j = 1; j < n; j = j * 2) {
        console.log(j);
    }
}
Ans is: O N(log 2 N)
19.
function search (list, item, start, end) {
    if (start > end)
        return false;
    const mid = Math.floor((start + end) / 2);
    if (list[mid] < item)
        return search(list, item, mid + 1, end);
    if (list[mid] > item)
        return search(list, item, start, mid - 1);
    return true;
}
Ans is: O(log 2 N)
20.
function count (list, item, start, end) {
    if (start > end) {
        return 0;
    }
    const mid = Math.floor((start + end) / 2);
    if (list[mid] < item) {
        return count(list, item, mid + 1, end);
    }
    if (list[mid] > item) {
        return count(list, item, start, mid - 1);
    }
    return count(list, item, start, mid - 1) + 1 + count(list, item, mid + 1, end);
}
Ans is: O(log 2 N)
21.
// Fibonacci of nth element
function fibonacci (n) {
    if (n <= 1)
        return 1;
    return fibonacci(n - 1) + fibonacci(n - 2);
}
22.
for(i= 0 ; i < n; i++){
   cout<< i << " " ;
   i++;
}
Ans O(n)
23.
if(i > j ){
   j>23 ? cout<<j : cout<<i;
}
O(1)


24.
for(i= 0; i < n; i++){
   for(j = 1; j < n; j = j*2){
      cout << i << " ";
   }
}
Ans is: O N(log 2 N)

25. 
   5n^3+200n^2+15
   find time complexity and proved it mathematically?
   3n^2+2^200
   find time complexity and proved it mathematically?
   5log2 n+15ln n
   find time complexity and proved it mathematically?
   2log n^3
   find time complexity and proved it mathematically?
   4n+log n
   find time complexity and proved it mathematically?
   2^64
   find time complexity and proved it mathematically?
   log n^10 +2root n
   find time complexity and proved it mathematically?
   2^n+ n^1000
   find time complexity and proved it mathematically?
 */