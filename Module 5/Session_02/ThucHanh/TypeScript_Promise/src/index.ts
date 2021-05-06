// happy coding 👻
import * as module from "module";
import {resolve} from "dns";
import {rejects} from "assert";
import {constants} from "os";


let  money = 10000;
const buyACar = (car: any) => {
    return new Promise (((resolve, rejects) => {
        setTimeout(() => {
            if (money >= 10000) {
                resolve("can buy " + car);
            }else {
                rejects("Do not enough money");
            }
        }, 100);
    }))
}
money = 1000001;
    const promise = buyACar("Vinfast").then(value => {
        console.log(value);
    }, error => {
        console.log(error);
    })
