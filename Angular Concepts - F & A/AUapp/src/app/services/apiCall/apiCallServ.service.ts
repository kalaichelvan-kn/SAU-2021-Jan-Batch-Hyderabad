import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiCallServService {

constructor(private http:HttpClient) { }

getRecords():Observable<any>{
  return this.http.get('https://jsonplaceholder.typicode.com/todos');
}

}
