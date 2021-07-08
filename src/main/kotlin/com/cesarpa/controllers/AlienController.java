package com.cesarpa.controllers;

import com.cesarpa.models.Alien;
import com.cesarpa.repositories.AlienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
public class AlienController {

    @Autowired
    AlienRepository alienRepository;

    @RequestMapping("/")
    public String home() {
        return "home.jsp";
    }

    @PostMapping("/alien")
    public Alien addAlien(@RequestBody Alien alien) {
        alienRepository.save(alien);
        return alien;
    }

    @GetMapping("/getAlien")
    public ModelAndView getAlien(@RequestParam Integer id) {
        ModelAndView mv = new ModelAndView("showAlien.jsp");
        mv.addObject(alienRepository.findById(id).orElse(new Alien()));
        return mv;
    }

    @RequestMapping(path = "/aliens", produces = {"application/json", "application/xml"})
    public List<Alien> getAliens() {
        return alienRepository.findAll();
    }

    @RequestMapping("/alien/{id}")
    public Optional<Alien> getAlienByPath(@PathVariable("id") Integer id) {
        return alienRepository.findById(id);
    }
}
