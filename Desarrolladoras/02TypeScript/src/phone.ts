export class Phone{

    constructor(
        private _phoneType:string,
        private _phoneNumber:number,
    ){}

    toString(){
        return `{tipo: ${this._phoneType}, número: ${this._phoneNumber}}`
    }

    get phoneType():string{
        return this._phoneType;
    }

    set phoneType(newPhoneType:string){
        this._phoneType = newPhoneType;
    }

    get phoneNumber():number{
        return this._phoneNumber;
    }

    set number(newPhoneNumber:number){
        this._phoneNumber = newPhoneNumber;
    }
}

export const defaultPhone = new Phone(
    'type',
    952111111
)