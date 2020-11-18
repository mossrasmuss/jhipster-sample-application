import { ICategory } from 'app/shared/model/category.model';

export interface IProperty {
  id?: number;
  totalArea?: number;
  description?: string;
  status?: string;
  categories?: ICategory[];
}

export class Property implements IProperty {
  constructor(
    public id?: number,
    public totalArea?: number,
    public description?: string,
    public status?: string,
    public categories?: ICategory[]
  ) {}
}
