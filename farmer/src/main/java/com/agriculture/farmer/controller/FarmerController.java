package com.agriculture.farmer.controller;

import com.agriculture.farmer.model.Farmers;
import com.agriculture.farmer.service.FarmerService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Data
@RestController
@RequestMapping("farms")
public class FarmerController {
    @Autowired
    public FarmerService farmObj;
    @GetMapping
    public List<Farmers> baseMap(){
        return farmObj.base();
    }

}
