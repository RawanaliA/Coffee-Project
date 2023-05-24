package com.example.week4database.Services;

import com.example.week4database.ApiExeption.ApiExeption;
import com.example.week4database.Model.Cofee;
import com.example.week4database.Repository.CoffeeRepsitry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CoffeeServices {
    //انا مسميتمه كوقفي سيرفيس
//    private final CoffeeService coffeeService;

    private final CoffeeRepsitry coffeeRepsitry;
    public List<Cofee> getAllCOffee(){
        return coffeeRepsitry.findAll();
    }
    public  void addCoffee(Cofee cofee){
        coffeeRepsitry.save(cofee);
    }

    public void updateCoffee(Integer id,Cofee cofee) {
//        Cofee oldCoffee = coffeeRepsitry.findCofeeById(id);
        Cofee oldCoffee = coffeeRepsitry.getById(id);
        if (oldCoffee == null){
            throw new ApiExeption("Coffe not found");
    }
        oldCoffee.setName(cofee.getName());
        oldCoffee.setCategory(cofee.getCategory());
        oldCoffee.setPrice(cofee.getPrice());
        coffeeRepsitry.save(oldCoffee);
    }
    public void deleteCoffee(Integer id){
        Cofee oldCoffee=coffeeRepsitry.getById(id);

        if(oldCoffee==null){
            throw new ApiExeption("Coffe delete");
        }
        coffeeRepsitry.delete(oldCoffee);


    }public Cofee findCofeeById(Integer id){
        Cofee ccoffee=coffeeRepsitry.findCofeeById(id);
        if(ccoffee==null){
           throw new ApiExeption("not found");
        }
        return ccoffee;

    }public List<Cofee> getCoffeesByCatogry(String catogry){
        List<Cofee> cofees=coffeeRepsitry.findCofeeByCategory(catogry);
        if(cofees==null)
            throw new ApiExeption("not found");
  return  cofees;
    }public Cofee getCofeeByIde2(Integer id){
        Cofee ccoffee=coffeeRepsitry.pleaseGetById(id);
if (ccoffee==null)
    throw new ApiExeption("notFound");
return ccoffee;

    }public Cofee getCofeeByPrice(Integer id){
        Cofee cofeeP=coffeeRepsitry.getCofeeByPrice(id);
        if(cofeeP==null)
            throw new ApiExeption("Not Found");
        return cofeeP;
    }public Cofee getCofeeByName(String name){
        Cofee coffeeN=coffeeRepsitry.findCofeeByName(name);
        if(coffeeN==null)
            throw new ApiExeption("not Exist");
        return coffeeN;
    }
}
