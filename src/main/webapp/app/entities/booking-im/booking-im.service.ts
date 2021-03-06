import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse, HttpHeaders } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IBookingIm } from 'app/shared/model/booking-im.model';

type EntityResponseType = HttpResponse<IBookingIm>;
type EntityArrayResponseType = HttpResponse<IBookingIm[]>;

@Injectable({ providedIn: 'root' })
export class BookingImService {
    private resourceUrl = SERVER_API_URL + 'api/bookings';

    public newBookingId: BehaviorSubject<string> = new BehaviorSubject<string>(null);

    constructor(private http: HttpClient) {}

    addNewBookingId(newBookingId: string) {
        this.newBookingId.next(newBookingId);
    }

    create(booking: IBookingIm): Observable<EntityResponseType> {
        return this.http.post<IBookingIm>(this.resourceUrl, booking, { observe: 'response' });
    }

    update(booking: IBookingIm): Observable<EntityResponseType> {
        return this.http.put<IBookingIm>(this.resourceUrl, booking, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IBookingIm>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IBookingIm[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    findByCriteria(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.post<IBookingIm[]>(this.resourceUrl + '/findByCriteria', req, { observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    search(data: string): Observable<HttpResponse<any>> {
        return this.http.post<any>(this.resourceUrl + '/search', data, { observe: 'response' });
    }
}
