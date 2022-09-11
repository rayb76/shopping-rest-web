package com.shopping.rest.web.shoppingrestweb.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ShopJpaResource {

    @Autowired
    private ItemHardcodedService itemService;

    @Autowired
    private ItemJpaRepository itemJpaRepository;


    @GetMapping("/jpa/users/{username}/items")
    public List<Item> getAllItems(@PathVariable String username){
        return itemJpaRepository.findByUsername(username);
        //return itemService.findAll();
    }

    @GetMapping("/jpa/users/{username}/items/{id}")
    public Item getItem(@PathVariable String username, @PathVariable long id) {
        return itemJpaRepository.findById(id).get();
        //return itemService.findById(id);
    }

    //DELETE/users/{username}/items/{id}
    @DeleteMapping("/jpa/users/{username}/items/{id}")
    public ResponseEntity<Void> deleteItem(
            @PathVariable String username, @PathVariable long id) {

        //Item item = itemService.deleteById(id);
        itemJpaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
        }

        //return ResponseEntity.notFound().build();


    //PUT/users/{user_name}/todos/{todos_id}
    @PutMapping("/jpa/users/{username}/items/{id}")
    public ResponseEntity<Item> updateTodo(
            @PathVariable String username,
            @PathVariable long id, @RequestBody Item item){
        //Item itemUpdated = itemService.save(item);
        Item itemUpdated = itemJpaRepository.save(item);

        return new ResponseEntity<Item>(item, HttpStatus.OK);
    }

    @PostMapping("/jpa/users/{username}/items")
    public ResponseEntity<Void> createItem(
            @PathVariable String username, @RequestBody Item item){

        item.setUsername(username);
        Item createdItem = itemJpaRepository.save(item);

        //Todo createdTodo = todoJpaRepository.save(todo);

        //Location
        //Get current resource url
        ///{id}
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdItem.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}



