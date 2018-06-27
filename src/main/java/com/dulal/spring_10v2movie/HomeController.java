package com.dulal.spring_10v2movie;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired

    MovieRepo movieRepo;

    @RequestMapping("/")
    public String movieList(Model model){
        model.addAttribute("Movies", movieRepo.findAll());
        return "m_list";
    }

    @GetMapping("/add")
    public String movieForm(Model model){
        model.addAttribute("movie", new Movie());
        return "movieform";
    }

    @PostMapping("/process")
    public  String processForm(@Valid Movie movie, BindingResult result)
    { if (result.hasErrors()){
            return "movieform";
        }
        movieRepo.save(movie);
        return "redirect:/";
    }

    @RequestMapping("/viewmovie{m_id}")
  public String showMovie(@PathVariable("id") long m_id, Model model){
      model.addAttribute("movie", movieRepo.findById(m_id));
      return "view";

    }

    @RequestMapping("/update/{m_id}")
  public String updateMovie(@PathVariable("m_id") long m_id, Model model){
      model.addAttribute("movie", movieRepo.findById(m_id));
      return "movieform";

  }

  @RequestMapping("/delete/{m_id}")
  public String deleteMovie(@PathVariable("m_id")long m_id){
      movieRepo.deleteById(m_id);
      return "redirect:/";

  }


}
