import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Credentials } from 'src/app/models/credentials';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  constructor(private us: UserService, private router: Router) { }

  ngOnInit(): void {
  }

  credentials: Credentials={
    email: '',
    password: ''
  }

  loginFunction() {
    this.us.login(this.credentials).subscribe(
      (data: any) => {
        console.log(data)
        this.us.user = data.body;
        
          this.router.navigate(['items'])
        
      })
    }
    
}
