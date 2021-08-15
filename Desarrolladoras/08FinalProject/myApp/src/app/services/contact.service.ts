import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Person } from '../interface/person';

@Injectable({
  providedIn: 'root'
})
export class ContactService {

  contact: Person;
  agenda: Person[];
  readonly URL_API = 'http://localhost:3000/users/';

  constructor(private http: HttpClient) {

    this.contact = {} as Person;
    this.agenda = [];

  }

  getContact(id: string) {
    return this.http.get(this.URL_API + `/${id}`);
  }

  getContacts()  {
    return this.http.get(this.URL_API);
  }

  postContact(person: Person) {
    return this.http.post(this.URL_API, person);
  }

  putContact(person: Person) {
    return this.http.put(this.URL_API + `/${person._id}`, person);
  }

  deleteContact(_id: string) {
    return this.http.delete(this.URL_API + `/${_id}`);
  }
}


