package com.dulal.spring_10v2movie;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired("/home")

    MovieRepo movieRepo;
    public String movieList(Model model){
        model.addAttribute("Movies", movieRepo.findAll());
        return "m_list";
    }

    @GetMapping("/add")
    public String movieForm(Model model){
        model.addAttribute("Movie", new Movie());


    }

    @PostMapping("/process")
    public  String processForm(@Valid Movie movie, BindingResult result)
    {
        if (result.hasErrors()){
            return "movieForm";
        }
    }


}
