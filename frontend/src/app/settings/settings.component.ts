import { Component, inject, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { Router } from '@angular/router';
import { User } from '../models/User';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-settings',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './settings.component.html',
  styleUrl: './settings.component.css'
})
export class SettingsComponent implements OnInit{
  private service = inject(UserService)
  private router = inject(Router)
  private navig = this.router.getCurrentNavigation()
  u :User = new User()
  password= ""
  message = ""

  ngOnInit(): void {
    if(this.navig?.extras?.state){
      this.u = this.navig.extras.state['user']
    }
  }


  changePassword(){
    //alert(this.password)
    //alert(this.u.username)
    if(this.password==""){
      return
    }
    this.u.password = this.password
    this.service.changePassword(this.u.username, this.u.password).subscribe(data=>{
      if(data==null){
        this.message="Invalid data"
      } else{
        this.message = "Successfully changed password!"
      }
    })

  }

  goBack(){
    this.router.navigate([`/${this.u.type}`], {
      state: {user: this.u}
    })
  }

}
