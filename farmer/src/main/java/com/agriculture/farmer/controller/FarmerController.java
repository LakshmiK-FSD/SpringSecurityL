package com.agriculture.farmer.controller;
import com.agriculture.farmer.model.Farmers;
import com.agriculture.farmer.model.Users;
import com.agriculture.farmer.service.FarmerService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Data
@RestController
//@RequestMapping("farms")
public class FarmerController {
    @Autowired
    public FarmerService farmObj;
    @GetMapping("/admin/all")
    public List<Farmers> baseMap(){
        return farmObj.base();
    }
    @GetMapping("/users/farms/home")
    public CsrfToken token(HttpServletRequest http){
        return (CsrfToken) http.getAttribute("_csrf");
    }
    @PostMapping("/admin/farms")
    public String add(@RequestBody Farmers farm){
        return farmObj.adder(farm);
    }
    @GetMapping ("/users/farms/get")
    public String show(HttpSession http){
        return http.getId().toString();
    }
    @PostMapping("/admin/pass")
    public String passAdd(@RequestBody Users user){
        return farmObj.passAdd(user);
    }

}

