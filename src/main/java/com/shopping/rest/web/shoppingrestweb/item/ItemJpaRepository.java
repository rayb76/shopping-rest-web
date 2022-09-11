package com.shopping.rest.web.shoppingrestweb.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemJpaRepository extends JpaRepository<Item, Long> {
    List<Item> findByUsername(String username);
}
