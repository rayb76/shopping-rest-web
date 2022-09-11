package com.shopping.rest.web.shoppingrestweb.item;

import com.shopping.rest.web.shoppingrestweb.item.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ShopResource {

    @Autowired
    private ItemHardcodedService itemService;

    @GetMapping("/users/{username}/items")
    public List<Item> getAllItems(@PathVariable String username){

        return itemService.findAll();
    }

    @GetMapping("/users/{username}/items/{id}")
    public Item getItem(@PathVariable String username, @PathVariable long id) {

        return itemService.findById(id);
    }

    //DELETE/users/{username}/items/{id}
    @DeleteMapping("/users/{username}/items/{id}")
    public ResponseEntity<Void> deleteItem(
            @PathVariable String username, @PathVariable long id) {

        Item item = itemService.deleteById(id);

        if(item!=null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    //PUT/users/{user_name}/todos/{todos_id}
    @PutMapping("/users/{username}/items/{id}")
    public ResponseEntity<Item> updateTodo(
            @PathVariable String username,
            @PathVariable long id, @RequestBody Item item){
        Item itemUpdated = itemService.save(item);

        return new ResponseEntity<Item>(item, HttpStatus.OK);
    }

    @PostMapping("/users/{username}/items")
    public ResponseEntity<Void> createItem(
            @PathVariable String username, @RequestBody Item item){

        Item createdItem = itemService.save(item);
        //todo.setUsername(username);
        //Todo createdTodo = todoJpaRepository.save(todo);

        //Location
        //Get current resource url
        ///{id}
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdItem.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}



