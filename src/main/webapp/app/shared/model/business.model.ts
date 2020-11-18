import { Moment } from 'moment';

export interface IBusiness {
  id?: number;
  name?: string;
  type?: string;
  year?: Moment;
}

export class Business implements IBusiness {
  constructor(public id?: number, public name?: string, public type?: string, public year?: Moment) {}
}
