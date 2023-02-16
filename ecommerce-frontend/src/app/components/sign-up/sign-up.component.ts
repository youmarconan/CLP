import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent {
  constructor(private us:UserService, private router: Router){}

  user : User ={
    email: '',
    password: '',
    firstName: '',
    lastName: '',
    cardNum: 0
  }

  signup(){
    this.us.signUp(this.user).subscribe(
      (data: any) => {
        console.log(data)
        this.us.user = data.body;
        
          this.router.navigate(['login'])
        
      })
  }
}
