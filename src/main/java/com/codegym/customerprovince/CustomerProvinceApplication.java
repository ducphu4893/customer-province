package com.codegym.customerprovince;

import com.codegym.customerprovince.service.ProvinceService;
import com.codegym.customerprovince.service.UserService;
import com.codegym.customerprovince.service.impl.ProvinceServiceImpl;
import com.codegym.customerprovince.service.impl.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerProvinceApplication {
    @Bean
    public UserService userService(){
        return new UserServiceImpl();
    }

    @Bean
    public ProvinceService provinceService(){
        return new ProvinceServiceImpl();
    }

    public static void main(String[] args) {
        SpringApplication.run(CustomerProvinceApplication.class, args);
    }

}

