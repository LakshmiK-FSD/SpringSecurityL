package com.agriculture.farmer.service;
import com.agriculture.farmer.model.Farmers;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Data
public class FarmerService{

    List<Farmers> farm = new ArrayList<>(Arrays.asList(new Farmers(22,33,"lk"),new Farmers(33,44,"VNL")));
    public List <Farmers> base(){
        return farm;
    }

    public String adder(Farmers farmGet) {
       farm.add(farmGet);
       return "Succsessfully added";
    }
}
