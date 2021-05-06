// happy coding 👻
console.log("hello world");

export class Shape {
    private _x: number;
    private _y: number;


	constructor(x: number, y: number) {
		this._x = x;
		this._y = y;
	}

    /**
     * Getter x
     * @return {number}
     */
	public get x(): number {
		return this._x;
	}

    /**
     * Setter x
     * @param {number} value
     */
	public set x(value: number) {
		this._x = value;
	}

    /**
     * Getter y
     * @return {number}
     */
	public get y(): number {
		return this._y;
	}

    /**
     * Setter y
     * @param {number} value
     */
	public set y(value: number) {
		this._y = value;
	}
    
    toString(): string {
        return `(x: ${this._x}, y: ${this._y})`
    }
}