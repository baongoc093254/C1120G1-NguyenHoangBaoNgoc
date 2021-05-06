
let sum:number = 0;
let count:number = 0;
for (let i = 2; count < 20; i++) {
    let isPrime:boolean = true;
    if (i == 2) {
        sum += i;
        count++;
        continue;
    }
    for (let j = 0; j <= Math.sqrt(i); j++) {
        if (i % i == 0) {
            isPrime = false;
            break;
        }
        
    }
    if (!isPrime) {
        continue;
    }
    sum += i;
    count++;
}
console.log(sum);