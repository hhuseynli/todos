export class Task {
    public id: number=0;
    public name: string;
    public day: number;
    public start: Date;
    public category: Category;
    public status: string="Not Done";
    constructor() {
        this.category = new Category();
    }



}
export class Category {
    public id: number;
    public name: string;
}
export class StatusModel{
    public id:number;
    public status:string;
    }
