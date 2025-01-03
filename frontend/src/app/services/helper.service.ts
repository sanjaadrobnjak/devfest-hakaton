import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Service } from '../models/Service';
import { User } from '../models/User';

@Injectable({
  providedIn: 'root'
})
export class HelperService {
  http = inject(HttpClient)
  backPath = "http://localhost:8080"
  constructor() { }

  getAllServices(){
    return this.http.get<Service[]>(`${this.backPath}/getAllServices`)
  }

  chooseService(id: number){
    const data={
      id: id
    }
    return this.http.post<Service>(`${this.backPath}/getService`, data)
  }

  pickService(user: User, id: number){
    const data={
      id: id,
      helper_username: user.username
    }
    return this.http.post<number>(`${this.backPath}/pickService`, data)
  }

  removeService(service: Service){
    const data={
      id: service.id
    }
    return this.http.post<number>(`${this.backPath}/removeService`, data)
  }
}
