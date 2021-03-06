import { IProductIm } from 'app/shared/model/product-im.model';
import { IProviderIm } from 'app/shared/model/provider-im.model';
import { IVariation } from 'app/shared/model/variation.model';

export interface IProductByBooking {
    id?: number;
    bookingId?: number;
    reserveLocatorJuniperProduct?: IProductIm;
    reserveLocatorJuniperProvider?: IProviderIm;
    idReserveLocatorJuniper?: string;
    idReserveLocatorExternal?: string;
    variations?: IVariation[];
}

export class ProductByBooking implements IProductByBooking {
    constructor(
        public id?: number,
        public bookingId?: number,
        public reserveLocatorJuniperProduct?: IProductIm,
        public reserveLocatorJuniperProvider?: IProviderIm,
        public idReserveLocatorJuniper?: string,
        public idReserveLocatorExternal?: string,
        public variations?: IVariation[]
    ) {}
}
