var sum = 0;
var count = 0;
for (var i = 2; count < 20; i++) {
    var isPrime = true;
    if (i == 2) {
        sum += i;
        count++;
        continue;
    }
    for (var j = 0; j <= Math.sqrt(i); j++) {
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
