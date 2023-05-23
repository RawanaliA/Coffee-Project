package com.example.week4database.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@Table
@NoArgsConstructor
//هذا التيبلز عندي كيف ممكن احوله لتيبل اولا اضيف الانتينتي
public class Cofee {
    //هذا هو البرايمر كي
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //انوتيشن لكل اي دي عندي يكون برايمري كي
    private Integer id;
    @NotEmpty(message = "the name cannot be null")
    //اسوي فالديشن على التو ليفل
    @Column(columnDefinition = "varchar(20) not null")
    private  String name;
    @NotEmpty(message = "category cannot be null")
    @Column(columnDefinition = "varchar(20) not null check (category ='drink' or category = 'sweet')")
    private String category;
    @NotNull(message = "price cannot be empty")
    @Min(3)
    @Max(50)
    @Column(columnDefinition = "varchar(20) not null")
    private Integer price;
}
