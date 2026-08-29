package com.agriculture.farmer.controller;

import com.agriculture.farmer.model.Farmers;
import com.agriculture.farmer.service.FarmerService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("farms")
@Data
public class FarmerController {
    @Autowired
    private FarmerService farmObj;
    @GetMapping
    public List<Farmers> baseMap(){
        return farmObj.base();
    }
}
