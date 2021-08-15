export class Mail{
    constructor(
        private _mailType: string,
        private _mailAddress: string,
    ){}

    toString(){
        return `{tipo: ${this._mailType}, dirección: ${this._mailAddress}}`
    }

    get mailType():string{
        return this._mailType;
    }

    set mailType(newMailType:string){
        this._mailType = newMailType;
    }

    get mailAddress():string{
        return this._mailAddress;
    }
    
    set mailAddress(newMailAddress:string){
        this._mailAddress = newMailAddress;
    }
}



export const defaultMail = new Mail(
    'type',
    'mail@mail.com'
)