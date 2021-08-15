export class Address{
    constructor(
        private _street:string,
        private _streetNumber:number,
        private _floor:number,
        private _letter:string,
        private _postcode:number,
        private _town:string,
        private _province:string,
    ){}

    toString(){
        return `{calle: ${this._street}, número: ${this._streetNumber}, piso: ${this._floor}, letra: ${this._letter}, código postal: ${this._postcode}, población: ${this._town}, provincia: ${this._province}}`
    }
    
    get street():string{
        return this._street;
    }

    set street(newStreet:string){
        this._street = newStreet;
    }
    
    get streetNumber():number{
        return this._streetNumber;
    }

    set streetNumber(newStreetNumber:number){
        this._streetNumber = newStreetNumber;
    }

    get floor():number{
        return this._floor;
    }

    set floor(newFloor:number){
        this._floor = newFloor;
    }
    
    get letter():string{
        return this._letter;
    }

    set letter(newLetter:string){
        this._letter = newLetter;
    }

    get postcode():number{
        return this._postcode;
    }

    set postcode(newPostCode:number){
        this._postcode = newPostCode;
    }

    get town():string{
        return this._town;
    }

    set town(newTown:string){
        this._town = newTown;
    }

    get province():string{
        return this._province;
    }

    set province(newProvince:string){
        this._province = newProvince;
    }
}



export const defaultAddress = new Address(
    'street',
    24,
    1,
    'A',
    29024,
    'city',
    'province'
)