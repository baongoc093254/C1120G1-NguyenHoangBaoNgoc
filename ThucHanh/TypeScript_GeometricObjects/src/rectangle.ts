import { Shape } from './shape';
export class Rectangle extends Shape implements IArea {

    private _width:number;
    private _height:number;
	constructor(x: number, y: number, _width: number,_height:number) {
        super(x,y);
    }

    area(): number {
        return this._width*this._height;
    }
    
    

    /**
     * Getter width
     * @return {number}
     */
	public get width(): number {
		return this._width;
	}
	

    /**
     * Getter height
     * @return {number}
     */
	public get height(): number {
		return this._height;
	}

    /**
     * Setter height
     * @param {number} value
     */
	public set height(value: number) {
		this._height = value;
	}


}