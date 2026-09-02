package com.agriculture.farmer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class FarmerApplication {
	public static void main(String[] args) {
		SpringApplication.run(FarmerApplication.class, args);
	}

	public void bcryp(){
		BCryptPasswordEncoder bc = new BCryptPasswordEncoder(12);
		System.out.println(bc.encode("lk"));
	}
}
