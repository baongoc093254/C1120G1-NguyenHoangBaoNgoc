export class Product {
  private _id: number;
  private _name: string;
  private _cost: number;
  private _dateStart: string;
  private _location: string;
  private _quantity: number;


  constructor(id: number, name: string, cost: number, dateStart: string, location: string, quantity: number) {
    this._id = id;
    this._name = name;
    this._cost = cost;
    this._dateStart = dateStart;
    this._location = location;
    this._quantity = quantity;
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get name(): string {
    return this._name;
  }

  set name(value: string) {
    this._name = value;
  }

  get cost(): number {
    return this._cost;
  }

  set cost(value: number) {
    this._cost = value;
  }

  get dateStart(): string {
    return this._dateStart;
  }

  set dateStart(value: string) {
    this._dateStart = value;
  }

  get location(): string {
    return this._location;
  }

  set location(value: string) {
    this._location = value;
  }

  get quantity(): number {
    return this._quantity;
  }

  set quantity(value: number) {
    this._quantity = value;
  }
}
