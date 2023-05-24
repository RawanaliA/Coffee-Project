package com.example.week4database.Controller;

import com.example.week4database.Model.Cofee;
import com.example.week4database.Services.CoffeeServices;
import jakarta.servlet.http.PushBuilder;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/coffee")
@RequiredArgsConstructor
public class CoffeeController {
//عشان اوصل للميثود عندي ا كذا اسي لنك
    private final CoffeeServices coffeeServices;

    @GetMapping("/get")
    public ResponseEntity get() {
        List<Cofee> cofeeList = coffeeServices.getAllCOffee();
        return ResponseEntity.status(200).body(cofeeList);
    }
    @PostMapping("/add")
    public ResponseEntity addCoffe(@Valid @RequestBody Cofee cofee, Errors errors) {

        coffeeServices.addCoffee(cofee);
        return ResponseEntity.status(200).body("add sucssuffuly");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCoffee(@Valid @RequestBody Cofee cofee, @PathVariable Integer id, Errors errors) {

        coffeeServices.updateCoffee(id,cofee);
            return ResponseEntity.status(200).body("update succssufoly");
        }
    @DeleteMapping ("/delete/{id}")

    public ResponseEntity deleteCofee( @PathVariable Integer id){
        coffeeServices.deleteCoffee(id);
            return ResponseEntity.status(200).body("delete succssufoly");
    }

    @GetMapping("/get-id/{id}")
    public ResponseEntity getCoffeeById(@PathVariable Integer id){

        return ResponseEntity.status(200).body("sucssuflly");
}
  @GetMapping("/get-catogry/{id}")
    public ResponseEntity getCoffeeById(@PathVariable String catogry){
  List<Cofee> cofees=coffeeServices.getCoffeesByCatogry(catogry);
        return ResponseEntity.status(200).body(cofees);
    }
  @GetMapping("/get2/{id}")
  public ResponseEntity getById2(@PathVariable Integer id){
    Cofee cofee=coffeeServices.getCofeeByIde2(id);
    return ResponseEntity.status(200).body(cofee);

}
   @GetMapping("/get-price/{id}")

    public ResponseEntity getByPrice(@PathVariable Integer id){
        Cofee cofee=coffeeServices.getCofeeByPrice(id);
        return ResponseEntity.status(200).body(cofee);
}
  @GetMapping("/get-name/{name}")

  public Cofee getByName(@PathVariable String name){
        Cofee cofeeN=coffeeServices.getCofeeByName(name);

        return ResponseEntity.status(200).body(cofeeN).getBody();
}
}