package com.clp.ecommerce.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clp.ecommerce.daos.ItemRepo;
import com.clp.ecommerce.models.Item;

@RestController
@RequestMapping("/item")
@CrossOrigin(origins="http://localhost:4200/", allowCredentials="true")
public class ItemController {
    
    private final ItemRepo itemRepo;

    @Autowired
    public ItemController(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    @PostMapping
    public ResponseEntity <Item> addItem(Item items){
        items.setId(UUID.randomUUID());
        Item i = itemRepo.save(items);
        return ResponseEntity.ok(i);
    }

    @GetMapping
    public ResponseEntity<List<Item>> allItems(){
        List<Item> items = itemRepo.findAll();
        return ResponseEntity.ok(items);
    }
    
}
