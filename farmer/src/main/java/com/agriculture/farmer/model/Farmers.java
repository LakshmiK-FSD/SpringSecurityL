package com.agriculture.farmer.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class Farmers {
    @Id
    private int id;
    private int age;
    private String name;
    public Farmers(int age,int id,String name){
        this.age=age;
        this.id=id;
        this.name=name;
    }
    public Farmers(){

    }
}
