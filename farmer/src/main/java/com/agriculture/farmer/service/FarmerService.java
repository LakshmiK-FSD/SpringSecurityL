package com.agriculture.farmer.service;
import com.agriculture.farmer.model.Farmers;
import com.agriculture.farmer.model.Users;
import com.agriculture.farmer.repository.FarmersRepo;
import com.agriculture.farmer.repository.UserRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class FarmerService{
    public BCryptPasswordEncoder bCrypt= new BCryptPasswordEncoder(12);
    @Autowired
    private UserRepo usRep;
    @Autowired
    private FarmersRepo farmRep;
    public List <Farmers> base(){
        return farmRep.findAll();
    }
    public String adder(Farmers farmGet) {
       farmRep.save(farmGet);
       return "Succsessfully added";
    }

    public String passAdd(Users user) {
        user.setPassword(bCrypt.encode(user.getPassword()));
         usRep.save(user);
        return "Added  Admin";
    }
}
