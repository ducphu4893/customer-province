package com.codegym.customerprovince.controller;

import com.codegym.customerprovince.model.Province;
import com.codegym.customerprovince.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProvinceController {
    @Autowired
    private ProvinceService provinceService;

    @GetMapping("/provinces")
    public ModelAndView listProvinces(){
        Iterable<Province> provinces = provinceService.findAall();
        ModelAndView modelAndView = new ModelAndView("Province/list");
        modelAndView.addObject("provinces",provinces);
        return modelAndView;
    }

    @GetMapping("/create-province")
    public ModelAndView showCreatForm(){
        ModelAndView modelAndView = new ModelAndView("Province/create");
        modelAndView.addObject("province",new Province());
        return modelAndView;
    }

    @PostMapping("/create-province")
    public ModelAndView saveProvince(@ModelAttribute("province")Province province){
        provinceService.save(province);
        ModelAndView modelAndView = new ModelAndView("Province/create");
        modelAndView.addObject("province",province);
        return modelAndView;
    }

    @GetMapping("/edit-province/{id}")
    public ModelAndView showEditForm(@PathVariable int id){
        Province province = provinceService.findById(id);
        ModelAndView modelAndView = new ModelAndView("Province/edit");
        modelAndView.addObject("province",province);
        return modelAndView;
    }

    @PostMapping("/edit-province")
    public ModelAndView updateProvince(@ModelAttribute("province")Province province){
        provinceService.save(province);
        ModelAndView modelAndView = new ModelAndView("Province/edit");
        modelAndView.addObject("province", province);
        return modelAndView;
    }

    @GetMapping("/delete-province/{id}")
    public ModelAndView showDeleteProvince(@PathVariable int id){
        Province province = provinceService.findById(id);
        ModelAndView modelAndView = new ModelAndView("Province/delete");
        modelAndView.addObject("province",province);
        return modelAndView;
    }

    @PostMapping("delete-province")
    public String deleteProvince(@ModelAttribute("province")Province province){
        provinceService.remove(province.getId());
        return "redirect:provinces";
    }
}
