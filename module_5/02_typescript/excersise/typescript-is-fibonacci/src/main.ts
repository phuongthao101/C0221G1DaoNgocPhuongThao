function isFibonacci(n: number): number {
    if (n == 0) {
        return 0;
    } else if (n == 1) {
        return 1;
    } else {
        return isFibonacci(n - 1) + isFibonacci(n - 2);
    }
}
let sum = 0;
let arr=new Array();
for (let i=0;i<=10;i++){
    sum+=isFibonacci(i);
    arr.push(isFibonacci(i))
}
console.log("Mang fibonacci: "+arr);
console.log("Tổng các số fibonacci trong mảng trên là: " + sum);



