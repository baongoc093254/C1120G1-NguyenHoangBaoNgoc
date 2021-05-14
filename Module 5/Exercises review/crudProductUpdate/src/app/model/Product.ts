import {Country} from './Country';

export interface Product {
   id: number;
   name: string;
   cost: number;
   dateStart: string;
   country: Country;
   quantity: number;
}
