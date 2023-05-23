package com.example.week4database.Repository;

import com.example.week4database.Model.Cofee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoffeeRepsitry extends JpaRepository<Cofee,Integer> {
Cofee findCofeeById(Integer id);
//  اللي فوق واللي تحت نفس بعض بس وحده بطيريقه الميثود الجاهزه والثانيه لا الjpql مايجبرني على الدوال الجاهزة
    @Query("select s from Cofee  s where s.id=?1")
    Cofee pleaseGetById(Integer id);
  List<Cofee> findCofeeByCategory(String category);
Cofee getCofeeByPrice(Integer id);
   Cofee findCofeeByName(String name);
}
//مخزن او مستودع لازم لكل مودل
