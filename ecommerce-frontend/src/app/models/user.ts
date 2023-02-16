import { Item } from "./item";

export class User {

    constructor(
        public email:string,
        public password:string,
        public firstName:string,
        public lastName:string,
        public cardNum:number,
        public item?:Item,
        public id?:string,
    ) { }
}
