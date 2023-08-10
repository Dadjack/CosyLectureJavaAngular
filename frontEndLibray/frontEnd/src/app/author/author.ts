export class Author{

    public id!: number;
    public firstName!: string;
    public lastName!: string;
    public bio!: string;
    public birthday!: Date;
    public deathday: Date | null = null;
};