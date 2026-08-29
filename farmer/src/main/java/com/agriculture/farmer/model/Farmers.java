package com.agriculture.farmer.model;
import lombok.Data;
@Data
public class Farmers {
    private int age;
    private int id;
    private String name;

    public Farmers(int age,int id,String name){
        this.age=age;
        this.id=id;
        this.name=name;
    }

}
