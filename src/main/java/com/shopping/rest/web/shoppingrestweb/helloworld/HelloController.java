package com.shopping.rest.web.shoppingrestweb.helloworld;




import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class HelloController {

    @GetMapping(path = "/hello-world")
    public String helloWorld(){

        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloBean helloBean(){
        //throw new RuntimeException("Some Error has Happened! Contact Support at ***-***");
        return new HelloBean("Hello World - updated");
    }

    //hello-world/path-variable/shopping
    @GetMapping(path = "/hello-world/path-variable/{name}")
        public HelloBean helloPathVariable(@PathVariable String name){
        return new HelloBean(String.format("Hello World, %s", name));
    }
}
