import { Component } from '@angular/core';
import { Item } from 'src/app/models/item';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-all-items',
  templateUrl: './all-items.component.html',
  styleUrls: ['./all-items.component.css']
})
export class AllItemsComponent {

  constructor(private us: UserService) { }

  ngOnInit(): void {
    this.allItems();
  }

  ordered:boolean = false;

  msg:string='';

  items :Item[] = [];

  allItems() {
    this.us.allItems().subscribe(
      (data:any) => {
        console.log(data)
        this.items = data
        
      }
    )
  }

  order(item:Item){
    this.us.order(item.id).subscribe(
      (data:any) => {
        console.log(data)
        item.msg = data.response;
        console.log(item.msg);
        this.ordered = true;
      }
    )
  }
}
