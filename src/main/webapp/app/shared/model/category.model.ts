import { IProperty } from 'app/shared/model/property.model';

export interface ICategory {
  id?: number;
  name?: string;
  description?: string;
  parent?: ICategory;
  properties?: IProperty[];
}

export class Category implements ICategory {
  constructor(
    public id?: number,
    public name?: string,
    public description?: string,
    public parent?: ICategory,
    public properties?: IProperty[]
  ) {}
}
