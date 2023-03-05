/*
 * 
 * 
 * 1. void g(int n){
 *  for(int i=0;i<n;++i) f();
 * }
 * 
 * 2. void g(int n){
 *  for(int i=0;i<n;++i)
 * for(int j=0;j<n;++j) f();
 * }
 * 
 * 3. void g(int n){
 *  for(int i=0;i<n;++i)
 * for(int j=0;j<=i;++j) f();
 * }
 * 
 * 
 * 4. void g(int n){
 *  for(int i=0;i<m;++i)
 * for(int j=0;j<n;++j)
 * for(int k=0;k<p;++k) f();
 * }
 * 
 * 5. if(condition){
 *   O(n)  
 * } else{
 *      O(n^2)     
 * }
 * 
 * 
6.
int a = 0, b = 0;
for (i = 0; i < N; i++) {
	a = a + rand();
}
for (j = 0; j < M; j++) {
	b = b + rand();
}
7.
int a = 0;
for (i = 0; i < N; i++) {
	for (j = N; j > i; j--) {
		a = a + i + j;
	}
}
8.
int i, j, k = 0;
for (i = n / 2; i <= n; i++) {
    for (j = 2; j <= n; j = j * 2) {
        k = k + n / 2;
    }
}
9.
int a = 0, i = N;
while (i > 0) {
    a += i;
    i /= 2;
}
10.
for(int i=0;i<n;i++){
  i*=k;
}
11.
int value = 0;
for(int i=0;i<n;i++)
    for(int j=0;j<i;j++)
      value += 1;
12.
function isPrime(n) {
  for (let i = 2; i <= Math.sqrt(n); ++i) {
      if (n % i === 0) 
          return false;
  }
  return true;
}
13.
let a = 0, b = 0;
for (let i = 0; i < n; ++i) {
    a = a + i;
}
for (let j = 0; j < m; ++j) {
    b = b + j;
}
14.
let a = 0, b = 0;
for (let i = 0; i < n; ++i) {
    for (let j = 0; j < n; ++j) {
        a = a + j;
    }
}
for (let k = 0; k < n; ++k) {
    b = b + k;
}
15.
let a = 0;
for (let i = 0; i < n; ++i) {
    for (let j = n; j > i; --j) {
        a = a + i + j;
    }
}
16.
for (let i = n; i > 0; i = i / 2) {
    console.log(i);
}
17.
for (let i = 1; i < n; i = i * 2) {
    console.log(i);
}
18.
for (let i = 0; i < n; ++i) {
    for (let j = 1; j < n; j = j * 2) {
        console.log(j);
    }
}
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
23.
if(i > j ){
   j>23 ? cout<<j : cout<<i;
}


24.
for(i= 0; i < n; i++){
   for(j = 1; j < n; j = j*2){
      cout << i << " ";
   }
}

25. 
   5n^3+200n^2+15
   3n^2+2^200
   5log2 n+15ln n
   2log n^3
   4n+log n
   2^64
   log n^10 +2root n
   2^n+ n^1000
 */