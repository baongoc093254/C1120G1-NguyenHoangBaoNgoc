// happy coding 👻
console.log("hello world");

function isPrime(number: number): boolean {
    let isPrime = true;
    if (number < 2) {
        isPrime = false;
    }else if (number > 2) {
        for (let i = 2; i <= Math.sqrt(number); i++){
            if (number % i == 0) {
                isPrime = false;
                break;
            }
           
        }
        return isPrime;
    }
    
}
let array = [1,3,5,9,2,6,15,19,21,35,51,53,101,207]
let sum = 0; 
for(let number of array) {
    if (isPrime(number)) {
        sum += number;
    }
}
console.log("Total Prime in array : " + sum);