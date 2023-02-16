package com.clp.ecommerce.daos;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clp.ecommerce.models.Item;

@Repository
public interface ItemRepo extends JpaRepository<Item,UUID> {
    
}
