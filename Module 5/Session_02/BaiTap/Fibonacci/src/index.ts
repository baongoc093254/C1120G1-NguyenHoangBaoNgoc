// happy coding 👻
console.log("hello world");


// // in ra 20 so fibonacci dau` tien
// let num1:number = 0;
// let num2:number = 1;
// let sum:number;
// for (let i = 0; i < 18; i++) {
//     sum = num1 + num2;
//     num1 = num2;
//     num2 = sum;
//     console.log(sum);
    
// }
// tinh tong 20 so fibonacci dau` tien
let first:number = 0;
let second:number = 1;
let third:number;
// nhung cai sum khoi tao 1 cai gia tri luon 
let sumtotal:number = 0;
for (let i = 0; i < 18; i++) {
    third = first + second;
    first = second;
    second = third;
    sumtotal += third;
    
}
console.log("Total 20 num Fibonacci: " + sumtotal);


